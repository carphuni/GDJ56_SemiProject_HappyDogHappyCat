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
		//클라이언트가 입력하여 보낸 데이터를 가져와
		//Animal에 빌더를 사용해 저장
		request.setCharacterEncoding("utf-8");
		String animalName=request.getParameter("aniName");
		String animalType=request.getParameter("aniType");
		String animalKind=request.getParameter("aniKind");
		String animalSize=request.getParameter("aniSize");
		char animalGender=request.getParameter("gender").charAt(0);
		int animalAge=Integer.parseInt(request.getParameter("aniAge"));
		String[] vcnStat=request.getParameterValues("vcnStat");
		char animalNeuYN=request.getParameter("neu").charAt(0);
		String character=request.getParameter("character");
		String furColor=request.getParameter("furColor");
		String phone=request.getParameter("phone");
		String aniSpecial=request.getParameter("aniSpecial");
		String aniReason=request.getParameter("aniReason");
		
		Animal ani=Animal.builder()
				.aniName(animalName)
				.aniType(animalType)
				.aniKind(animalKind)
				.aniSize(animalSize)
				.aniGender(animalGender)
				.aniAge(animalAge)
				.vcnStat(vcnStat)
				.aniNeuYn(animalNeuYN)
				.aniChar(character)
				.aniColor(furColor)
				.aniSpecial(aniSpecial)
				.aniReason(aniReason)
				.build();
		//클라이언트에게 입력받은 입소희망일을 AdmissionForm에 저장 
		String hopeDate=request.getParameter("hopeDate");
		
		//ani를 서비스의 메소드를 빌려 보냄 . 
		//서비스의 메소드를 빌려 입소희망일 보내기 
		int result=new AdmissionService().enrollAdmission(ani,hopeDate);
		
		
		
		
		
		String msg="",loc="";
		if(result>0) {
			msg="입소신청 완료:)";
			loc="/";
		}else {
			msg="입소신청 실패,다시 신청해주세요!";
			loc="/";
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
