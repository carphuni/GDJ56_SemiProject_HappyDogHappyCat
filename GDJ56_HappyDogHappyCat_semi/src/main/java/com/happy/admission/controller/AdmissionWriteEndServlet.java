package com.happy.admission.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.admission.service.AdmissionService;

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
		request.setCharacterEncoding("utf-8");
		
		
		
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
