package com.happy.volreview.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.volreview.model.service.VolReviewService;

/**
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/updatecomment.do")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply = request.getParameter("reply");
		String memberId= request.getParameter("memberId");
		int boardNo= Integer.parseInt(request.getParameter("boardNo"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int result= new VolReviewService().updateComment(reply, commentNo);
				
		String msg="";
		if(result>0) {
			msg=reply;
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
