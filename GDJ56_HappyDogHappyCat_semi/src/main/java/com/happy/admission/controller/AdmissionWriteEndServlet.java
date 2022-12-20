package com.happy.admission.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.happy.admission.service.AdmissionService;
import com.happy.admission.vo.AdmissionForm;
import com.happy.admission.vo.AnimalPhoto;
import com.happy.animal.model.vo.Animal;
import com.happy.qa.vo.QaPhoto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		if(!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect(request.getContextPath());
		}else {
			String path=request.getServletContext().getRealPath("/upload/admission");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request, 
					path,maxSize,encoding,dfr);
		

			Enumeration e=mr.getFileNames();	
			List<AnimalPhoto> fileList=new ArrayList();
			
		while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);
				if(name.equals("upFile")) {
					fileList.add(AnimalPhoto.builder()
							.mainPhoto(oriName2)
							.adPhotoOriName(oriName2)
							.adPhotoReName(fileName2)
							.build());
				}else {
					fileList.add(AnimalPhoto.builder().adPhotoReName(fileName2)
							.adPhotoOriName(oriName2).build());		
				}
				System.out.println(fileList);
		}
		
		//클라이언트가 입력하여 보낸 데이터를 가져와
		//Animal에 빌더를 사용해 저장
		
		String animalName=mr.getParameter("aniName");
		String animalType=mr.getParameter("aniType");
		String animalKind=mr.getParameter("aniKind");
		String animalSize=mr.getParameter("aniSize");
		char animalGender=mr.getParameter("gender").charAt(0);
		//System.out.println(animalGender);
		int animalAge=Integer.parseInt(mr.getParameter("aniAge"));
		char vcnStat1=mr.getParameter("vcnStat1")==null?'N':'Y';
		//System.out.println(vcnStat1);
		char vcnStat2=mr.getParameter("vcnStat2")==null?'N':'Y';
		//System.out.println(vcnStat2);
		char vcnStat3=mr.getParameter("vcnStat3")==null?'N':'Y';
		char vcnStat4=mr.getParameter("vcnStat4")==null?'N':'Y';
		char vcnStat5=mr.getParameter("vcnStat5")==null?'N':'Y';;
		char vcnStat6=mr.getParameter("vcnStat6")==null?'N':'Y';;
		char animalNeuYN=mr.getParameter("neu").charAt(0);
		//System.out.println(animalNeuYN);
		String[] character=mr.getParameterValues("character");
		String furColor=mr.getParameter("furColor");
		String aniSpecial=mr.getParameter("aniSpecial");
		String aniReason=mr.getParameter("aniReason");
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
		
		
		//클라이언트에게 입력받은 입소희망일을 AdmissionForm에 저장 
		int memberNo=Integer.parseInt(mr.getParameter("memberNo"));
		//System.out.println("ㅎ2"+memberNo);
		String hopeDate=mr.getParameter("hopeDate");
		
		//서비스를 빌려 동물, 희망입소일자를 보내기 
		int result=new AdmissionService().enrollAnimal(ani,hopeDate,memberNo,fileList);
		
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

		Map<String,String> responseMsg=Map.of("msg",msg,"loc",loc);
		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(responseMsg,response.getWriter());
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
