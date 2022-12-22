package com.happy.qa.controller;

import java.io.IOException;
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
 * Servlet implementation class QaModifyServlet
 */
@WebServlet("/qa/modify.do")
public class QaModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qaNo=Integer.parseInt(request.getParameter("qaBoardNo"));
		
		Cookie[] cookies=request.getCookies();
		String QaRead="";
		boolean readflag=false;
		if(cookies!=null) {
			for(Cookie c : cookies) {
				String name=c.getName();//key값
				String value=c.getValue();//value값
				if(name.equals("QaRead")) {
					QaRead=value;
					if(value.contains("|"+qaNo+"|")) {
						readflag=true;
					}
					break;
				}
			}
		}
		
		if(!readflag) {
			//쿠키에 현재 게시글번호 저장
			Cookie c=new Cookie("QaRead",(QaRead+"|"+qaNo+"|"));
			c.setMaxAge(60*60*24);
			response.addCookie(c);
		}
		
		
		
		QaForm q=new QaService().selectMyQaView(qaNo,readflag);
		List<QaPhoto> qp=new QaService().selectQaPhoto(qaNo);
		List<QaComment> list =new QaService().selectCommentList(qaNo);
		
		request.setAttribute("qas", q);
		request.setAttribute("qaPhoto", qp);
		request.setAttribute("", list);
		
		System.out.println("불러온 큐에이"+q);
		System.out.println("불러온 큐에이 포토"+qp);
		
		request.getRequestDispatcher("/views/qa/qaModify.jsp")
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
