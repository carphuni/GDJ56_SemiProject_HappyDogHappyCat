package com.happy.adopt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;

/**
 * Servlet implementation class ReviewCoDeleteServlet
 */
@WebServlet("/adopt/adoptReviewCommentDelete.do")
public class ReviewCoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCoDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int coNo=Integer.parseInt(request.getParameter("coNo"));
		
		//System.out.println(coNo);
		
		int result=new AdoptService().deleteComment(coNo);
		
		String msg="";
			 if(result>0) {
				 msg="댓글 삭제 성공";
			 }else {
				 msg="댓글 삭제 실패";
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
