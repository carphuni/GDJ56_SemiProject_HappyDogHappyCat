package com.happy.support.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.support.model.service.SupportService;
import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;

/**
 * Servlet implementation class SupportViewServlet
 */
@WebServlet("/supview.do")
public class SupportViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int AgencyNo = Integer.parseInt(request.getParameter("agencyNo"));
		Support s = new SupportService().selectSupport(boardNo);
		Agency a = new VolunteerService().selectAgency(AgencyNo);
		
		List<SupPhoto> sp = new SupportService().selectSupPhoto2(boardNo);
		
		request.setAttribute("photo", sp);
		request.setAttribute("agency",a);
		request.setAttribute("info", s);
		request.getRequestDispatcher("/views/support/supView.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
