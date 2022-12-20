package com.happy.vol.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;

/**
 * Servlet implementation class UpdateVolServlet
 */
@WebServlet("/updatevol.do")
public class UpdateVolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		Volunteer v = new VolunteerService().selectVolunteer(boardNo);
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		Agency a = new VolunteerService().selectAgency2(memberNo);
		VolPhoto vp = new VolunteerService().selectVolPhoto(boardNo);
		List<VolPhoto> vp2 = new VolunteerService().selectVolPhoto2(boardNo);
		request.setAttribute("agency", a);
		request.setAttribute("v",v);
		request.setAttribute("vp", vp);
		request.setAttribute("vp2", vp2);
		request.setAttribute("boardNo", boardNo);
		
		request.getRequestDispatcher("/views/volunteer/volUpdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
