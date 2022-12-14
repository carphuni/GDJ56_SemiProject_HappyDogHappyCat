package com.happy.vol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.vol.model.service.VolunteerService;
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
		String title = request.getParameter("volViewTitle");
		String agencyName = request.getParameter("volAgencyName");
		String address= request.getParameter("volAgencyAddress");
		String manager = request.getParameter("manager");
		String phone = request.getParameter("volAgencyPhone");
		String rec = request.getParameter("rec");
		System.out.println(title);
		java.sql.Date recPeriod = java.sql.Date.valueOf(rec);
		String recEnd = request.getParameter("recend");
		java.sql.Date recPeriodEnd = java.sql.Date.valueOf(recEnd);
		int setPerson = Integer.parseInt(request.getParameter("setperson"));
		String act = request.getParameter("act");
		java.sql.Date actPeriod = java.sql.Date.valueOf(act);
		String actEnd = request.getParameter("actend");
		java.sql.Date actPeriodEnd = java.sql.Date.valueOf(actEnd);
		String day = request.getParameter("day");
		String contents = request.getParameter("contents");
		
		List<VolPhoto> vp = new VolunteerService().selectVolPhoto2(boardNo);
		
		
		Volunteer v = Volunteer.builder().vntRecName(title)
				.vntManagerName(manager)
				.vntRecPeriod(recPeriod)
				.vntActPeriod(actPeriod)
				.vntRecPeriodEnd(recPeriodEnd)
				.vntActPeriodEnd(actPeriodEnd)
				.vntActDay(day)
				.vntActContents(contents)
				.vntSetPerson(setPerson)
				.build();			
		request.setAttribute("info", v);
		request.setAttribute("agency", agencyName);
		request.setAttribute("address", address);
		request.setAttribute("phone", phone);
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
