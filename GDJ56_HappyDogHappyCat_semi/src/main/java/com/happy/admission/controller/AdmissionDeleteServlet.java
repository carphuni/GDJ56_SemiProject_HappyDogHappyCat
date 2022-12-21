package com.happy.admission.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.happy.admission.service.AdmissionService;
import com.happy.admission.vo.AdmissionForm;
import com.happy.animal.model.vo.Animal;

/**
 * Servlet implementation class AdmissionDeleteServlet
 */
@WebServlet("/admission/deleteAd.do")
public class AdmissionDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int aniNo=Integer.parseInt(request.getParameter("aniNo"));
		int admissionNo=Integer.parseInt(request.getParameter("admissionNo"));
		
		
		
		System.out.println("받아온 동물 번호"+aniNo);
		System.out.println("받아온 입소 번호"+admissionNo);
		
		int result=new AdmissionService().deleteAnimal(aniNo,admissionNo);
		//int result2=new AdmissionService().deleteAf(admissionNo);
		System.out.println(result);
		
		String msg="",loc="";
		if(result==0) {
			//동물저장 실패시
			msg="입소 삭제 실패,다시 신청해주세요!";
			loc="/admission/myPageView.do";
		}else {
			//동물저장 성공시
			msg="입소 삭제 완료!:)";
			loc="/admission/mypageList.do";
		}
	      request.setAttribute("msg", msg);
	      request.setAttribute("loc", loc);
	      request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
