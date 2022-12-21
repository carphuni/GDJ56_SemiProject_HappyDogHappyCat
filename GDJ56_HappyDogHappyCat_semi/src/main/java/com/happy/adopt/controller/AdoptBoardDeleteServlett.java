package com.happy.adopt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;

/**
 * Servlet implementation class AdoptBoardDeleteServlett
 */
@WebServlet("/member/mypage/adoptBoardDelete")
public class AdoptBoardDeleteServlett extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptBoardDeleteServlett() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adBoardNo=Integer.parseInt(request.getParameter("adBoardNo"));
		//System.out.println(adBoardNo);
		
		int result = new AdoptService().adoptBoardDelete(adBoardNo);
		
		String msg="",loc="";
		if(result>0) {
			msg="삭제 성공";
			loc="/member/mypage/adoptboardList.do";
		}else {
			msg="삭제 실패";
			loc="/member/mypage/adoptboard.do?adtBoardNo="+adBoardNo;
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
