package com.happy.vol.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Volunteer;

/**
 * Servlet implementation class EnrollVolServlet
 */
@WebServlet("/enroll.do")
public class EnrollVolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollVolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		int count = new VolunteerService().selectEnrPerson(boardNo, memberNo);
		int flag = 0;
		if(count==0) {
			new VolunteerService().insertEnr(boardNo, memberNo);
		}
		int check = new VolunteerService().selectEnrCheck(boardNo, memberNo);
		Volunteer vol = new VolunteerService().selectVolunteer(boardNo);
		
		if(check==0){
			if(vol.getVntEnrPerson()<vol.getVntSetPerson()) {
			new VolunteerService().updateVntEnr(boardNo);
			new VolunteerService().updateEnrCheck(boardNo, memberNo);
			}			
		}else {
			new VolunteerService().cancelVntEnr(boardNo);
			new VolunteerService().updateEnrCheckCancel(boardNo, memberNo);
			
		}
		Volunteer v = new VolunteerService().selectVolunteer(boardNo); 
		if(vol.getVntEnrPerson()==v.getVntEnrPerson()) flag++;
		
		Map info = Map.of("check",check,"v",v,"flag",flag);
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
