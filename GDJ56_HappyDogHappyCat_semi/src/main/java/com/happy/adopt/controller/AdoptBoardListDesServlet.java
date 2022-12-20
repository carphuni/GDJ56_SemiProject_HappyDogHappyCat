package com.happy.adopt.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AdtBorad;

/**
 * Servlet implementation class AdoptBoardListDesServlet
 */
@WebServlet("/member/mypage/adoptboard.do")
public class AdoptBoardListDesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptBoardListDesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adtBoardNo=Integer.parseInt(request.getParameter("adtBoardNo"));
		//System.out.println(adtBoardNo);
		
		AdtBorad ab=new AdoptService().adoptBoardDes(adtBoardNo);
		//System.out.println(ab);
		
		List<AdtBorad> hopeDate =new AdoptService().hopeDateAll();
	      
	      String[] hopeDateArr = new String[hopeDate.size()];
			for(int i=0;i<hopeDateArr.length;i++) {
				hopeDateArr[i]= '"'+(hopeDate.get(i).getAdtVisitDate()).substring(0,10)+'"';
			}
			
			List list1 = new ArrayList();
			int k=1;
			for(int i=0;i<hopeDateArr.length;i++) {
				int count=1;
				for(int j=0;j<hopeDateArr.length;j++) {
					if(i!=j&&hopeDateArr[i].equals(hopeDateArr[j])) {
						count=count+1;
					}
				}
				if(count>=3) {
					list1.add(hopeDateArr[i]);
				}
			}
	    
		request.setAttribute("hopeDateArr", list1);
		
		request.setAttribute("ab", ab);
		request.getRequestDispatcher("/views/adopt/adoptBoardDes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
