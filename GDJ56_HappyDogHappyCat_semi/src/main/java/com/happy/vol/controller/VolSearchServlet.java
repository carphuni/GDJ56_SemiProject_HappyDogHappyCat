package com.happy.vol.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;

/**
 * Servlet implementation class VolSearchServlet
 */
@WebServlet("/volsearch.do")
public class VolSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keyword=request.getParameter("search");
		
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch (Exception e) {
			cPage=1;
		} 
		
		int numPerpage=5;
		List<Volunteer> list = new VolunteerService().volSearch(cPage, numPerpage, keyword);
		List<Agency> agency = new VolunteerService().selectAgency3();
		List<Agency> list2=new ArrayList();
		List<VolPhoto> list3 = new ArrayList();

		VolPhoto vp = null;
		for(int i=0;i<list.size();i++) {
			int agencyNo = list.get(i).getVntAgencyNo();
			int boardNo=list.get(i).getVntBoardNo();
			Agency a = new VolunteerService().selectAgency(agencyNo);
			vp = new VolunteerService().selectVolPhoto(boardNo);
			list2.add(a);
			list3.add(vp);
		}
		
		
		
		int totalData = new VolunteerService().volSearchCount(keyword);
		
		String pageBar="";
		int pageBarSize=5;
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
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
		System.out.println(keyword);
		request.setAttribute("ag", agency);
		request.setAttribute("volunteer", list);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("agency", list2);
		request.setAttribute("volPhoto", list3);
		request.getRequestDispatcher("/views/volunteer/volView.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
