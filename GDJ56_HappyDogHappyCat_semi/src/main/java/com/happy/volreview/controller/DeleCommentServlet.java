package com.happy.volreview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.volreview.model.service.VolReviewService;
import com.happy.volreview.model.vo.VolComment;
import com.happy.volreview.model.vo.VolReview;
import com.happy.volreview.model.vo.VolReviewPhoto;

/**
 * Servlet implementation class DeleCommentServlet
 */
@WebServlet("/deletecomment.do")
public class DeleCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		
		int result = new VolReviewService().deleteComment(commentNo);
		VolReview vr = new VolReviewService().selectVolReview(boardNo);
		List<VolReviewPhoto> reviewPhoto = new VolReviewService().selectVolReviewPhoto2(boardNo);
		List<VolComment> comments = new VolReviewService().selectCommentList(boardNo);
		request.setAttribute("reviewPhoto", reviewPhoto);
		request.setAttribute("vr", vr);
	
		request.setAttribute("comments", comments);
		request.setAttribute("msg", result>0?"댓글이 삭제되었습니다":"삭제 실패");
		request.setAttribute("loc", "/volreviewview.do?boardNo="+boardNo);
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
