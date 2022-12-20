package com.happy.volreview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.volreview.model.service.VolReviewService;
import com.happy.volreview.model.vo.VolReview;
import com.happy.volreview.model.vo.VolReviewPhoto;

/**
 * Servlet implementation class UpdateVolReviewServlet
 */
@WebServlet("/updatevolreview.do")
public class UpdateVolReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVolReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		VolReview vr = new VolReviewService().selectVolReview(boardNo);
		List<VolReviewPhoto> vrp = new VolReviewService().selectVolReviewPhoto2(boardNo);
		request.setAttribute("boardNo",boardNo);
		request.setAttribute("vr", vr);
		request.setAttribute("vrp", vrp);
		request.getRequestDispatcher("/views/volreview/reviewUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
