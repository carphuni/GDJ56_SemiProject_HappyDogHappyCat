package com.happy.volreview.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.volreview.model.service.VolReviewService;
import com.happy.volreview.model.vo.VolReview;

/**
 * Servlet implementation class VolReviewSearchServlet
 */
@WebServlet("/volreviewsearch.do")
public class VolReviewSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolReviewSearchServlet() {
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
		List<VolReview> list = new VolReviewService().volReviewSearch(cPage, numPerpage,keyword);
		String pageBar="";
		int totalData = new VolReviewService().volReviewSearchCount(keyword);
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
		
		request.setAttribute("volReview", list);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/volreview/reviewList.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
