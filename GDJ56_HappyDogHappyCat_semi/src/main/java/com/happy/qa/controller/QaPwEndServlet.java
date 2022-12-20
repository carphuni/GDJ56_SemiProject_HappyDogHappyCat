package com.happy.qa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.qa.service.QaService;
import com.happy.qa.vo.QaComment;
import com.happy.qa.vo.QaForm;
import com.happy.qa.vo.QaPhoto;

/**
 * Servlet implementation class QaPwEndServlet
 */
@WebServlet("/qa/qaPwEnd.do")
public class QaPwEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaPwEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시물 번호 가져오기 
		int QaNo=Integer.parseInt(request.getParameter("qaBoardNo"));
		System.out.println("게시물번호"+QaNo);
		
		
		Cookie[] cookies=request.getCookies();
		String QaRead="";
		boolean readflag=false;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name=c.getName();//key값
				String value=c.getValue();//value값
				if(name.equals("QaRead")) {
					QaRead=value;
					if(value.contains("|"+QaNo+"|")) {
						readflag=true;
					}
					break;
				}
			}
		}
		
		if(!readflag) {
			//쿠키에 현재 게시글번호 저장
			Cookie c=new Cookie("QaRead",(QaRead+"|"+QaNo+"|"));
			c.setMaxAge(60*60*24);
			response.addCookie(c);
		}
		
		QaForm qa=new QaService().selectQaForm(QaNo);
		
		
		//입력한 비밀번호 가져오기 
		int password=Integer.parseInt(request.getParameter("qaPassNum"));
		System.out.println("입력한 비밀번호"+password);
		
		//게시물에 설정된 비밀번호 가져오기 
		int realPw=qa.getQaPassword();
		System.out.println("진짜 비밀번호"+realPw);
		
		
		
		//게시물에 해당하는 qaform 가져오기 
		QaForm q=new QaService().QaView(QaNo,readflag);
		System.out.println(q);
		
		List<QaComment> list =new QaService().selectCommentList(QaNo);
		System.out.println(list);
		
		request.setAttribute("qas", q);
		request.setAttribute("comments", list);
		
		List<QaPhoto> qp=new QaService().selectQaPhoto(QaNo);
		
		request.setAttribute("qaPhoto", qp);
		System.out.println(qp);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		if(password==realPw) {
			request.getRequestDispatcher("/views/qa/qaView.jsp")
			.forward(request, response);
		}else {
			out.println("<script>alert('비밀번호 불일치:( 목록으로 돌아갑니다.'); location.href='http://localhost:9090/GDJ56_HappyDogHappyCat_semi/qa/qaList.do';</script>");
			out.flush();
			response.sendRedirect(request.getContextPath());
			
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
