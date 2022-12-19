package com.happy.qa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.admission.service.AdmissionService;
import com.happy.animal.model.vo.Animal;
import com.happy.qa.service.QaService;
import com.happy.qa.vo.QaForm;
import com.happy.qa.vo.QaPhoto;
import com.happy.qa.vo.QaComment;

/**
 * Servlet implementation class QaViewServlet
 */
@WebServlet("/qa/qaView.do")
public class QaViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int QaNo=Integer.parseInt(request.getParameter("qaBoardNo"));
		
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
		
		
		
		
		
		QaForm qa=new QaService().QaView(QaNo,readflag);
		
		List<QaComment> list =new QaService().selectCommentList(QaNo);
		
		request.setAttribute("qas",qa);
		request.setAttribute("comments", list);
		
		List<QaPhoto> qp=new QaService().selectQaPhoto(QaNo);
		
		request.setAttribute("qaPhoto", qp);
		System.out.println(qp);
		
		request.getRequestDispatcher("/views/qa/qaView.jsp")
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
