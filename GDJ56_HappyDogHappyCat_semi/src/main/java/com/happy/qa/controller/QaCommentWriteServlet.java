package com.happy.qa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.qa.service.QaService;
import com.happy.qa.vo.QaComment;

/**
 * Servlet implementation class QaCommentWriteServlet
 */
@WebServlet("/qa/commentWrite.do")
public class QaCommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaCommentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int BoardNo=Integer.parseInt(request.getParameter("qaBoardNo"));//게시물번호 받아오기
		String comment=request.getParameter("content");//작성한 댓글 내용 받아오기 
		
		//빌더 사용해서 댓글 객체에 게시물번호, 내용 담기 
		QaComment qc=QaComment.builder()
					.qaBoardNo(BoardNo)
					.qaCommentWriteContent(comment)
					.build();
		
		//서비스의 enroll comment메소드 사용해서 댓글 객체를 보내기 
		int result=new QaService().enrollComment(qc);
		
		List<QaComment> list=new QaService().selectCommentList(BoardNo);
		
	
		
		//System.out.println(list);
		
		String msg="",loc="";
	      if(result==0) {
	         msg="댓글 등록 실패, 다시 작성해주세요!";
	         loc="/qa/qaView.do";
	      }else {
	         msg="댓글 등록 성공! :)";
	         loc="/";
	         
	      }
	  	  request.setAttribute("comments", list);
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
