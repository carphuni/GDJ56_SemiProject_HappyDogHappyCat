package com.happy.admission.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.admission.service.AdmissionService;
import com.happy.admission.vo.AdmissionForm;

/**
 * Servlet implementation class AdmissionMypageListServlet
 */
@WebServlet("/admission/mypageList.do")
public class AdmissionMypageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdmissionMypageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Admission테이블에 있는 전체데이터를 가져와 
		//화면에 전달하는 기능 
		int cPage;
		int numPerpage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
				cPage=1;
		}
		numPerpage=10;		
				
		String pageBar="";
		int totalData=new AdmissionService().selectAdmissionCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		
		int pageBarSize=5;
		
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
		int pageEnd=pageNo+pageBarSize-1;
				
				
		if(pageNo==1) {
			pageBar+="<span>[이전]</span>";
		}else {
			pageBar+="<a href='"+request.getRequestURL()+"?cPage="+(pageNo-1)+"'>[이전]</a>";
		}
		while(!(pageNo>pageEnd||pageNo>totalPage)) {
			if(pageNo==cPage) {
				pageBar+="<span>"+pageNo+"</span>";
			}else {
				pageBar+="<a href='"+request.getRequestURL()+"?cPage="+(pageNo)+"'>"+pageNo+"</a>";
				}
				pageNo++;
			}
			if(pageNo>totalPage) {
					pageBar+="<span>[다음]</span>";
			}else {
				pageBar+="<a href='"+request.getRequestURL()+"?cPage="+(pageNo)+"'>[다음]</a>";
			}
		
			
		int MemberNo=Integer.parseInt(request.getParameter("memberNo"));
		
		List<AdmissionForm> list=new AdmissionService().selectMyAdmission(MemberNo,cPage, numPerpage);
		
		request.setAttribute("admissions", list);
		System.out.println(list);
		
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/admission/admissionMypageList.jsp")
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
