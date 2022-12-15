package com.happy.qa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.qa.service.QaService;
import com.happy.qa.vo.QaForm;

/**
 * Servlet implementation class QaWriteEndServlet
 */
@WebServlet("/qa/qaWriteEnd.do")
public class QaWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String qaTitle=request.getParameter("qaTitle");
		String qaContents=request.getParameter("summernote");
		char openYn=request.getParameter("openYn").charAt(0);
		int qaPassword=Integer.parseInt(request.getParameter("passWord"));
		
		QaForm qa=QaForm.builder()
				.qaTitle(qaTitle)
				.qaContents(qaContents)
				.qaOpenYn(openYn)
				.qaPassword(qaPassword)
				.build();
		
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		int result=new QaService().enrollQa(qa,memberNo);
		
		String msg="",loc="";
		if(result==0) {
			//qa 등록 실패시
			msg="문의글 등록 실패, 다시 작성해주세요!";
			loc="/qa/qaWrite.do";
		}else {
			//qa 등록 성공시2
			msg="문의글 등록 성공! :)";
			loc="/qa/qaList.do";
			
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
