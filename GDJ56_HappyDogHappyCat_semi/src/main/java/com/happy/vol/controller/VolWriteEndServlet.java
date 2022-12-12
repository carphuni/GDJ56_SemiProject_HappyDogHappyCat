package com.happy.vol.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.vol.model.vo.Volunteer;
/**
 * Servlet implementation class VolWriteEndServlet
 */
@WebServlet("/vol/volWriteEnd.do")
public class VolWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String title= request.getParameter("volTitle");
		String managerName = request.getParameter("managerName");
		DateFormat dateFormat = new SimpleDateFormat ("yyyy.MM.dd"); 
		String rp=request.getParameter("recruitPeriod1");
		Date recPeriod = dateFormat.parse(rp);
		String rp2=request.getParameter("recruitPeriod2");
		Date recPeriod2 = dateFormat.parse(rp2);
		String ap=request.getParameter("activityPeriod1");
		Date actPeriod=dateFormat.parse(ap);
		String ap2=request.getParameter("activityPeriod2");
		Date actPeriod2=dateFormat.parse(ap2);
		String actDay= request.getParameter("activityDay");
		String contents = request.getParameter("content");
		int setPerson = Integer.parseInt(request.getParameter("recruitNumber"));
		
		Volunteer v = Volunteer.builder().vntRecName(title)
					.vntManagerName(managerName)
					.vntRecPeriod(recPeriod)
					.vntActPeriod(actPeriod)
					.vntActPeriodEnd(actPeriod2)
					.vntActDay(actDay)
					.vntActContents(contents)
					.vntSetPerson(setPerson)
					.build();
	}catch(ParseException e) {
		e.printStackTrace();
	}
					
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
