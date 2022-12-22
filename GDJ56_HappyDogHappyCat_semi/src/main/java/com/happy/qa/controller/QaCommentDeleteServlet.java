package com.happy.qa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.qa.service.QaService;

/**
 * Servlet implementation class QaCommentDeleteServlet
 */
@WebServlet("/qa/commentDelete.do")
public class QaCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int commentNo=Integer.parseInt(request.getParameter("commentNo"));
		System.out.println(commentNo);
		
		int result=new QaService().deleteComment(commentNo);
		System.out.println(result);
		
		String msg="",loc="";
		if(result==0) {
			
			msg="댓글 삭제 실패!";
			loc="/qa/qaList.do";
		}else {
			//동물저장 성공시
			msg="댓글 삭제 완료!";
			loc="/qa/qaList.do";
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
