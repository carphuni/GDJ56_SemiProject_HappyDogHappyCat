package com.happy.volreview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.volreview.model.service.VolReviewService;
import com.happy.volreview.model.vo.VolComment;
import com.happy.volreview.model.vo.VolReview;
import com.happy.volreview.model.vo.VolReviewPhoto;

/**
 * Servlet implementation class VolReviewVIewServlet
 */
@WebServlet("/volreviewview.do")
public class VolReviewVIewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolReviewVIewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Cookie[] cookies=request.getCookies();
		String reviewRead="";
		boolean readflag=false;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name=c.getName();
				String value=c.getValue(); 
				if(name.equals("reviewRead")) {
					reviewRead=value;
					if(value.contains("|"+boardNo+"|")) {
						readflag=true;
					}
					break;
				}
			}
		}
		
		if(!readflag) {
			Cookie c=new Cookie("reviewRead",(reviewRead+"|"+boardNo+"|"));
			c.setMaxAge(60*60*24);
			response.addCookie(c);
		}
		
		VolReview vr = new VolReviewService().selectVolReview(boardNo, readflag);
		List<VolReviewPhoto> reviewPhoto = new VolReviewService().selectVolReviewPhoto2(boardNo);
		List<VolComment> comments = new VolReviewService().selectCommentList(boardNo);
		request.setAttribute("reviewPhoto", reviewPhoto);
		request.setAttribute("vr", vr);
		request.setAttribute("comments", comments);
		
		request.getRequestDispatcher("/views/volreview/reviewView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
