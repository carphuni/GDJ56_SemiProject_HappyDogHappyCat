package com.happy.support.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.happy.member.model.vo.Member;
import com.happy.support.model.service.SupportService;
import com.happy.support.model.vo.SupComment;
/**
 * Servlet implementation class SupportViewEndServlet
 */
@WebServlet("/supviewend.do")
public class SupportViewEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportViewEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String comment = request.getParameter("comment");
		int payAmount = Integer.parseInt(request.getParameter("amount"));
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		SupComment sc = SupComment.builder().supBoardNo(boardNo)
						.supCommentContents(comment)
						.supUserNo(memberNo)
						.supPayAmount(payAmount)
						.build();
		
		new SupportService().insertComment(sc);
		
		Member m = new SupportService().selectMember(memberNo);
		
		Map info = Map.of("sc",sc,"m",m);
		
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
