package com.happy.adopt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;

/**
 * Servlet implementation class AdoptReviewDeleteServlet
 */
@WebServlet("/member/mypage/adoptReviewDelete.do")
public class AdoptReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adbReviewBoardNo=Integer.parseInt(request.getParameter("adbReviewBoardNo"));
		
		int result=new AdoptService().adtReviewDelete(adbReviewBoardNo);
		
		String msg="",loc="";
		if(result>0) {
			msg="삭제 성공";
			loc="/adopt/adoptreview.do";
		}else {
			msg="삭제 실패";
			loc="/adopt/adoptreviewdes.do?AdtBoardNo="+adbReviewBoardNo;
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
