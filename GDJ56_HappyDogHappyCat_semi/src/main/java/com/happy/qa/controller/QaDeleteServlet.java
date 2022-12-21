package com.happy.qa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.qa.service.QaService;

/**
 * Servlet implementation class QaDeleteServlet
 */
@WebServlet("/qa/deleteQa.do")
public class QaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int QaNo=Integer.parseInt(request.getParameter("qaBoardNo"));
		
		int result=new QaService().deleteQa(QaNo);
		
		System.out.println("삭제결과"+result);
		
		String msg="",loc="";
		if(result==0) {
			
			msg="Qa 삭제 실패,다시 등록해주세요!";
			loc="/qa/deleteQa.do";
		}else {
			//동물저장 성공시
			msg="Qa 삭제 완료!:)";
			loc="/qa/myPageList.do";
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
