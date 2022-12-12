package com.happy.adopt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;
import com.happy.animal.model.vo.Animal;
import com.happy.animal.model.vo.VcnStat;

/**
 * Servlet implementation class AdoptMainListServlet
 */
@WebServlet("/adopt/adoptmain.do")
public class AdoptMainListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptMainListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch (Exception e) {
			cPage=1;
		} 
		
		int numPerpage=12;
		
		List<Animal> aniList = new AdoptService().adoptMainAniAll(cPage,numPerpage);
		
		int totalData=new AdoptService().adoptMainAniAllCount();
		
		//System.out.println(totalData);
		//System.out.println(aniList);
		
		String pageBar="";
		int pageBarSize=5;
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
	    int pageEnd=pageNo+pageBarSize-1;
		
	    if(pageNo==1) {
	         pageBar+="<span>[이전]</span>";
	      }else {
	         pageBar+="<a href='"+request.getContextPath()+"/adopt/adoptmain.do?cPage="+(pageNo-1)+"'>[이전]</a>";
	      }
	      
	      while(!(pageNo>pageEnd||pageNo>totalPage)) { //pageNo가 pageEnd보다 크지 않거나 totaopalPage보다 크지 않을때
	         if(cPage==pageNo) {
	            //보고있는 페이지
	            pageBar+="<span>"+pageNo+"</span>";
	         }else {
	            pageBar+="<a href='"+request.getContextPath()+"/adopt/adoptmain.do?cPage="+pageNo+"'>"+pageNo+"</a>";
	         }
	         pageNo++;
	      }
	      if(pageNo>totalPage) {
	         pageBar+="<span>[다음]</span>";
	      }else {
	         pageBar+="<a href='"+request.getContextPath()+"/adopt/adoptmain.do?cPage="+pageNo+"'>[다음]</a>";
	      }
		
		request.setAttribute("aniList", aniList);
		request.setAttribute("pageBar", pageBar);
		request.getRequestDispatcher("/views/adopt/adoptMain.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
