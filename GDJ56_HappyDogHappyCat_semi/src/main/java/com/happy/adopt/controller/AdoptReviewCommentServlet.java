package com.happy.adopt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;

/**
 * Servlet implementation class AdoptReviewCommentServlet
 */
@WebServlet("/adopt/adoptreviewcomment.do")
public class AdoptReviewCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptReviewCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply= request.getParameter("reply");
		String memberId= request.getParameter("memberId");
		int reviewBoardNo= Integer.parseInt(request.getParameter("reviewBoardNo"));
		//System.out.println(reply+" "+memberId+" "+reviewBoardNo);
		
		int result=new AdoptService().adoptComment(reply,memberId,reviewBoardNo);
		
		String msg="";
		if(result>0) {
			msg="성공";
		}else {
			msg="실패";
		}
		
		response.getWriter().append(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
