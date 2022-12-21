package com.happy.adopt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happy.admission.service.AdmissionService;
import com.happy.admission.vo.AnimalPhoto;
import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AnimalPick;
import com.happy.animal.model.vo.Animal;
import com.happy.member.model.vo.Member;

/**
 * Servlet implementation class AdoptDesServlet
 */
@WebServlet("/adopt/adoptdes.do")
public class AdoptDesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptDesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aniNo=Integer.parseInt(request.getParameter("aniNo"));
		
		//System.out.println(aniNo);
		
		//System.out.println(ani);	
		
		 HttpSession session =request.getSession(); 
		 Member m=(Member)session.getAttribute("loginMember");	 
		 if(m!=null) {
			 List<AnimalPick> pick = new AdoptService().adoptPickAll(m.getMemberNo());
			 //System.out.println(pick);
			 request.setAttribute("pick", pick);
		 }else {
			 List<AnimalPick> pick = null;
			 //System.out.println(pick);
			 request.setAttribute("pick", pick);
		 }
		 
		 Cookie[] cookies=request.getCookies();
			String reviewRead="";
			boolean readflag=false;
			if(cookies!=null) {
				for(Cookie c : cookies) {
					String name=c.getName();
					String value=c.getValue(); 
					if(name.equals("reviewRead")) {
						reviewRead=value;
						if(value.contains("|"+aniNo+"|")) {
							readflag=true;
						}
						break;
					}
				}
			}
			
			if(!readflag) {
				Cookie c=new Cookie("reviewRead",(reviewRead+"|"+aniNo+"|"));
				c.setMaxAge(60*60*24);
				response.addCookie(c);
			}
			
			Animal ani = new AdoptService().adoptDesAni(aniNo,readflag);
			
			List<AnimalPhoto> aniPhoto=new AdmissionService().selectAnimalPhoto(aniNo);
			//System.out.println(aniPhoto);
		
		request.setAttribute("aniPhoto", aniPhoto);
		request.setAttribute("ani", ani);
		request.getRequestDispatcher("/views/adopt/adoptDes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
