package com.happy.admission.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class AdmissionMyPageViewServlet
 */
@WebServlet("/admission/myPageView.do")
public class AdmissionMyPageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionMyPageViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int admissionNo=Integer.parseInt(request.getParameter("admissionNo"));
		int aniNo=Integer.parseInt(request.getParameter("aniNo"));
		
		Animal ani=new AdmissionService().admissionMyPageView(admissionNo);
		
		List<AnimalPhoto> aniPhoto=new AdmissionService().selectAnimalPhoto(aniNo);
		AdmissionForm af=new AdmissionService().selectAdmission(admissionNo);
		
		
		request.setAttribute("ani",ani);
		
		request.setAttribute("admissionNo",admissionNo);
		
		request.setAttribute("aniPhoto", aniPhoto);
		
		request.setAttribute("admissionForm", af);
		System.out.println("받아온 동물"+ani);
		System.out.println("받아온 사진"+aniPhoto);
		System.out.println("받아온 입소정보"+af);
		
		request.getRequestDispatcher("/views/admission/admissionMypageView.jsp")
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
