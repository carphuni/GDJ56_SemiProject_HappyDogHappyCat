package com.happy.support.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.happy.support.model.service.SupportService;
import com.happy.support.model.vo.Support;

/**
 * Servlet implementation class LikeServlet
 */
@WebServlet("/like.do")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int count = new SupportService().selectSupPickCount(boardNo, memberNo);
		if(count==0) {
		new SupportService().insertLike(boardNo, memberNo);}
		int check = new SupportService().selectSupPick(boardNo, memberNo);
		if(check==0) {
			new SupportService().updateLike(boardNo);
			new SupportService().updateLikeCheck(boardNo, memberNo);
			
		}else{
			new SupportService().cancelLike(boardNo);
			new SupportService().updateLikeCheckCancel(boardNo, memberNo);
		}

		Support s = new SupportService().selectSupport(boardNo);
		System.out.println(s);
		Map info = Map.of("check",check,"s",s);
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(info,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
