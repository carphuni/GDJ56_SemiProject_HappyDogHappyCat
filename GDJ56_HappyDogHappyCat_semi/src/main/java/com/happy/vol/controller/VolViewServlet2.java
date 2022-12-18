package com.happy.vol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;

/**
 * Servlet implementation class VolViewServlet2
 */
@WebServlet("/volView2.do")
public class VolViewServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolViewServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	int boardNo = Integer.parseInt(request.getParameter("boardNo"));
	int AgencyNo = Integer.parseInt(request.getParameter("agencyNo"));
	
	Agency a = new VolunteerService().selectAgency(AgencyNo);
		
		List<VolPhoto> vp = new VolunteerService().selectVolPhoto2(boardNo);
		
		Cookie[] cookies=request.getCookies();
		String boardRead="";
		boolean readflag=false;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name=c.getName();//key값
				String value=c.getValue();//value값
				if(name.equals("boardRead")) {
					boardRead=value;
					if(value.contains("|"+boardNo+"|")) {
						readflag=true;
					}
					break;
				}
			}
		}
		
		if(!readflag) {
			//쿠키에 현재 게시글번호 저장
			Cookie c=new Cookie("boardRead",(boardRead+"|"+boardNo+"|"));
			c.setMaxAge(60*60*24);
			response.addCookie(c);
		}
		
		Volunteer v = new VolunteerService().selectVolunteer(boardNo, readflag);
		
		request.setAttribute("volunteer", v);
		
		request.setAttribute("photo", vp);
		request.setAttribute("info", v);
		request.setAttribute("agency", a);

		request.getRequestDispatcher("/views/volunteer/volView2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
