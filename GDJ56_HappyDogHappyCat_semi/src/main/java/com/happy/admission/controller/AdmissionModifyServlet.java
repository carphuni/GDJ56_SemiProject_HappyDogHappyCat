package com.happy.admission.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.admission.service.AdmissionService;
import com.happy.admission.vo.AdmissionForm;
import com.happy.admission.vo.AnimalPhoto;
import com.happy.animal.model.vo.Animal;

/**
 * Servlet implementation class AdmissionModifyServlet
 */
@WebServlet("/admission/modifyAd.do")
public class AdmissionModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int aniNo=Integer.parseInt(request.getParameter("aniNo"));
		int admissionNo=Integer.parseInt(request.getParameter("admissionNo"));
		
		Animal ani=new AdmissionService().admissionMyPageView(admissionNo);
		AdmissionForm af=new AdmissionService().selectAdmission(admissionNo);
		List<AnimalPhoto> aniPhoto=new AdmissionService().selectAnimalPhoto(aniNo);
		
		request.setAttribute("ani",ani);
		request.setAttribute("aniPhoto", aniPhoto);
		request.setAttribute("admissionForm", af);
		
		System.out.println("받아온 동물"+ani);
		System.out.println("받아온 사진"+aniPhoto);
		System.out.println("받아온 입소정보"+af);
		
		request.getRequestDispatcher("/views/admission/admissionModify.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
