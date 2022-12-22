package com.happy.qa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happy.admission.service.AdmissionService;
import com.happy.member.model.vo.Member;
import com.happy.qa.service.QaService;
import com.happy.qa.vo.QaForm;

/**
 * Servlet implementation class QaMyPageListServlet
 */
@WebServlet("/qa/myPageList.do")
public class QaMyPageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaMyPageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Member m=(Member)session.getAttribute("loginMember");
		
		int memberNo=m.getMemberNo();
		
		//페이징
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
			
		List<QaForm> list=new QaService().selectMyQa(memberNo,cPage, numPerpage);
		
		request.setAttribute("qas", list);
		
		System.out.println(list);
		
		request.setAttribute("pageBar", pageBar);
		
		request.getRequestDispatcher("/views/qa/qaMypageList.jsp")
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
