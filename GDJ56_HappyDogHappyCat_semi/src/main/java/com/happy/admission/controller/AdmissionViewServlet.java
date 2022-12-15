package com.happy.admission.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.admission.service.AdmissionService;
import com.happy.animal.model.vo.Animal;

/**
 * Servlet implementation class AdmissionViewServlet
 */
@WebServlet("/admission/admissionView.do")
public class AdmissionViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admissionNo=Integer.parseInt(request.getParameter("admissionNo"));
		
		Animal ani=new AdmissionService().admissionView(admissionNo);
		
		request.setAttribute("ani",ani);
		
		RequestDispatcher rd=request.getRequestDispatcher("/views/admission/admissionView.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
