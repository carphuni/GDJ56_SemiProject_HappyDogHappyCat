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
		//System.out.println(animalGender);
		int animalAge=Integer.parseInt(request.getParameter("aniAge"));
		char vcnStat1=request.getParameter("vcnStat1")==null?'N':'Y';
		//System.out.println(vcnStat1);
		char vcnStat2=request.getParameter("vcnStat2")==null?'N':'Y';
		//System.out.println(vcnStat2);
		char vcnStat3=request.getParameter("vcnStat3")==null?'N':'Y';
		char vcnStat4=request.getParameter("vcnStat4")==null?'N':'Y';
		char vcnStat5=request.getParameter("vcnStat5")==null?'N':'Y';;
		char vcnStat6=request.getParameter("vcnStat6")==null?'N':'Y';;
		char animalNeuYN=request.getParameter("neu").charAt(0);
		//System.out.println(animalNeuYN);
		String[] character=request.getParameterValues("character");
		String furColor=request.getParameter("furColor");
		String aniSpecial=request.getParameter("aniSpecial");
		String aniReason=request.getParameter("summernote");
		Animal ani=Animal.builder()
				.aniName(animalName)
				.aniType(animalType)
				.aniKind(animalKind)
				.aniSize(animalSize)
				.aniGender(animalGender)
				.aniAge(animalAge)
				.madDog(vcnStat1)
				.covid(vcnStat2)
				.kennel(vcnStat3)
				.influ(vcnStat4)
				.antibody(vcnStat5)
				.totalvac(vcnStat6)
				.aniNeuYn(animalNeuYN)
				.aniChar(character)
				.aniColor(furColor)
				.aniSpecial(aniSpecial)
				.aniReason(aniReason)
				.build();
		
		System.out.println(ani);
		//클라이언트에게 입력받은 입소희망일을 AdmissionForm에 저장 
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		//System.out.println("ㅎ2"+memberNo);
		String hopeDate=request.getParameter("hopeDate");
		
		//서비스를 빌려 동물, 희망입소일자를 보내기 
		int result=new AdmissionService().enrollAnimal(ani,hopeDate,memberNo);
		
		String msg="",loc="";
		if(result==0) {
			//동물저장 실패시
			msg="입소신청 실패,다시 신청해주세요!";
			loc="/admission/writeAdmission.do";
		}else {
			//동물저장 성공시
			msg="입소신청 완료!:)";
			loc="/admission/admissionList.do";
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
