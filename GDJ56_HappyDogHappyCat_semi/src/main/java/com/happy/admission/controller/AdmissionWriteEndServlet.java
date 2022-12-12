package com.happy.admission.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.admission.service.AdmissionService;
import com.happy.admission.vo.AdmissionForm;
import com.happy.animal.model.vo.Animal;

/**
 * Servlet implementation class AdmissionWriteEndServlet
 */
@WebServlet("/admission/writeAdmissionEnd.do")
public class AdmissionWriteEndServlet extends HttpServlet {
	private static final long serialVesionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//클라이언트가 보낸 데이터를 가져와
		//admissionFirm에 저장하는 기능 
		request.setCharacterEncoding("utf-8");
		String animalName=request.getParameter("aniName");
		String animalType=request.getParameter("aniType");
		String animalKind=request.getParameter("aniKind");
		String animalSize=request.getParameter("aniSize");
		char animalGender=request.getParameter("gender").charAt(0);
		int animalAge=Integer.parseInt(request.getParameter("aniAge"));
		String[] vcnStat=request.getParameterValues("vcnStat");
		String animalNeuYN=request.getParameter("neu");
		String animalSick=request.getParameter("sick");
		String character=request.getParameter("character");
		String furColor=request.getParameter("furColor");
		String hopeDate=request.getParameter("hopeDate");
		String phone=request.getParameter("phone");
		String aniSpecial=request.getParameter("aniSpecial");
		
		Animal ani=Animal.builder()
				.aniName(animalName)
				.aniType(animalType)
				.aniKind(animalKind)
				.aniSize(animalSize)
				.aniGender(animalGender)
				.aniAge(animalAge)
				
				.build();
		
		
		int result=new AdmissionService().enrollAdmission();
		String msg="",loc="";
		if(result>0) {
			msg="입소신청 완료!";
			loc="/admission/.do";
		}else {
			msg="항목들을 완성해주세요!";
			loc="";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp")
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
