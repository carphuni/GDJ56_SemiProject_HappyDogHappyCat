package com.happy.adopt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AdoptPhoto;
import com.happy.adopt.model.vo.AdtReviewBorad;

/**
 * Servlet implementation class AdoptReviewUpdateServlet
 */
@WebServlet("/member/mypage/adoptReviewUpdate.do")
public class AdoptReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int adbReviewBoardNo=Integer.parseInt(request.getParameter("adbReviewBoardNo"));
		
		AdtReviewBorad arb=new AdoptService().adoptReviewUpdateView(adbReviewBoardNo);
		List<AdoptPhoto> aphoto= new AdoptService().adtPhotoAll(adbReviewBoardNo);
		//System.out.println(arb);
		request.setAttribute("aReviewb", arb);
		request.setAttribute("aphoto", aphoto);
		request.getRequestDispatcher("/views/adopt/adoptreviewUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
