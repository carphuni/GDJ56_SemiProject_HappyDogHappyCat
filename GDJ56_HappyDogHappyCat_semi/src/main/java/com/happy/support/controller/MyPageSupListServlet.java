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
import com.happy.support.model.vo.SupComment;
import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;

/**
 * Servlet implementation class MyPageSupListServlet
 */
@WebServlet("/member/mypage/supboardList.do")
public class MyPageSupListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageSupListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int agencyNo = Integer.parseInt(request.getParameter("agencyNo"));
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch (Exception e) {
			cPage=1;
		} 
		
		int numPerpage=8;
		List<Agency> agency = new VolunteerService().selectAgency3();
		List<Support> list = new SupportService().myPageSupportList(cPage, numPerpage,agencyNo);
		List<Agency> list2=new ArrayList();
		List<SupPhoto> list3 = new ArrayList();
		List<List<SupComment>> comments = new ArrayList<>();
		SupPhoto sp = null;
		for(int i=0;i<list.size();i++) {
			int agencyNo2 = list.get(i).getSupAgencyNo();
			int boardNo=list.get(i).getSupBoardNo();
			Agency a = new VolunteerService().selectAgency(agencyNo2);
			List<SupComment > sc = new SupportService().selectSupportComment(boardNo);
			sp = new SupportService().selectSupPhoto(boardNo);
			list2.add(a);
			list3.add(sp);
			comments.add(sc);
		}
		String pageBar="";
		int totalData = new SupportService().myPageSupportCount(agencyNo);
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
				pageBar+="<a href='"+request.getRequestURL()+"?cPage="+(pageNo)+"&&agencyNo="+agencyNo+"'>"+pageNo+"</a>";
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
		request.setAttribute("comments", comments);
		
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
