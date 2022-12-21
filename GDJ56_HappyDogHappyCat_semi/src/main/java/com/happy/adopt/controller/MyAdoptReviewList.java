package com.happy.adopt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AdtBorad;
import com.happy.adopt.model.vo.AdtReviewBorad;
import com.happy.member.model.vo.Member;

/**
 * Servlet implementation class AdoptReviewList
 */
@WebServlet("/member/mypage/adoptReviewList.do")
public class MyAdoptReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAdoptReviewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    Member m=(Member)session.getAttribute("loginMember");
		if(m!=null) { 

			int cPage;
			try {
				cPage=Integer.parseInt(request.getParameter("cPage"));
			}catch (Exception e) {
				cPage=1;
			} 
			
			int numPerpage=5;
			
			List<AdtReviewBorad> rList=new AdoptService().adoptMyReviewAll(cPage,numPerpage,m.getMemberNo());
			
			int totalData=new AdoptService().adoptMyReviewAllCount(m.getMemberNo());
			
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
		         pageBar+="<a href='"+request.getContextPath()+"/member/mypage/adoptReviewList.do?cPage="+(pageNo-1)+"'>[이전]</a>";
		      }
		      
		      while(!(pageNo>pageEnd||pageNo>totalPage)) { 
		         if(cPage==pageNo) {
		            pageBar+="<span>"+pageNo+"</span>";
		         }else {
		            pageBar+="<a href='"+request.getContextPath()+"/member/mypage/adoptReviewList.do?cPage="+pageNo+"'>"+pageNo+"</a>";
		         }
		         pageNo++;
		      }
		      if(pageNo>totalPage) {
		         pageBar+="<span>[다음]</span>";
		      }else {
		         pageBar+="<a href='"+request.getContextPath()+"/member/mypage/adoptReviewList.do?cPage="+pageNo+"'>[다음]</a>";
		      }
		      System.out.println(rList);
		      
		    request.setAttribute("rList",rList); 
			request.setAttribute("pageBar", pageBar);
			request.getRequestDispatcher("/views/adopt/adoptreview.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
