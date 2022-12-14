package com.happy.adopt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.happy.adopt.model.service.AdoptService;

/**
 * Servlet implementation class AdoptPickServlet
 */
@WebServlet("/adopt/adoptpick.do")
public class AdoptPickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptPickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String color=request.getParameter("color");
		int aniNo=Integer.parseInt(request.getParameter("aniNo"));
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		//System.out.println(color);
		//System.out.println(aniNo);
		System.out.println(memberNo);
		
		
		String heart="";
		//response.setContentType("text/html;charset=utf-8");
		 if(color.equals("white")) { 
			 int result=new AdoptService().adoptAddPick(memberNo,aniNo);
			 if(result>0) {
					heart="❤️";
			 }else {
					heart="🤍";
				}
			 
			 
		 }else {
			 int result=new AdoptService().adoptDeletePick(memberNo,aniNo);
			 if(result>0) {
					heart="🤍";
			 }else {
					heart="❤️";
				}	 
		 }
		 
		 response.getWriter().append(heart);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
