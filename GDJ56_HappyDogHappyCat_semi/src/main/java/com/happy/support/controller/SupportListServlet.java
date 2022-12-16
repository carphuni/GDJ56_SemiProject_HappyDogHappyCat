package com.happy.support.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.support.model.service.SupportService;
import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;


/**
 * Servlet implementation class SupportListServlet
 */
@WebServlet("/suplist.do")
public class SupportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cPage;
		int numPerpage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch(NumberFormatException e) {
			cPage=1;
		}
		
		numPerpage=8;
		List<Agency> agency = new VolunteerService().selectAgency3();
		List<Support> list = new SupportService().selectSupportList(cPage, numPerpage);
		List<Agency> list2=new ArrayList();
		List<SupPhoto> list3 = new ArrayList();
		
		SupPhoto sp = null;
		for(int i=0;i<list.size();i++) {
			int agencyNo = list.get(i).getSupAgencyNo();
			int boardNo=list.get(i).getSupBoardNo();
			Agency a = new VolunteerService().selectAgency(agencyNo);
			sp = new SupportService().selectSupPhoto(boardNo);
			list2.add(a);
			list3.add(sp);
			System.out.println(agencyNo);
		}
		
	
		String pageBar="";
		int totalData = new SupportService().selectSupportCount();
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		
		int pageBarSize = 10;
		
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
		request.setAttribute("ag", agency);
		request.setAttribute("support", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("agency", list2);
		request.setAttribute("supPhoto", list3);
		
		request.getRequestDispatcher("/views/support/supList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
