package com.happy.adopt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AdtReviewBorad;

/**
 * Servlet implementation class AdoptReviewDesServlet
 */
@WebServlet("/adopt/adoptreviewdes.do")
public class AdoptReviewDesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptReviewDesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adpBoardNo=Integer.parseInt(request.getParameter("AdtBoardNo")) ;
		
		//System.out.println(adpBoardNo);
		
		//System.out.println(arb);
		
		Cookie[] cookies=request.getCookies();
		String reviewRead="";
		boolean readflag=false;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name=c.getName();
				String value=c.getValue(); 
				if(name.equals("reviewRead")) {
					reviewRead=value;
					if(value.contains("|"+adpBoardNo+"|")) {
						readflag=true;
					}
					break;
				}
			}
		}
		
		if(!readflag) {
			Cookie c=new Cookie("reviewRead",(reviewRead+"|"+adpBoardNo+"|"));
			c.setMaxAge(60*60*24);
			response.addCookie(c);
		}
		
		AdtReviewBorad arb=new AdoptService().adoptReviewDes(adpBoardNo,readflag);
		
		request.setAttribute("arb", arb);
		request.getRequestDispatcher("/views/adopt/adoptReviewDes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
