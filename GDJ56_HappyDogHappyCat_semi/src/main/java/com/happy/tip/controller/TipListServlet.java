package com.happy.tip.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happy.member.model.vo.Member;
import com.happy.tip.model.service.TipService;
import com.happy.tip.model.vo.TipBoard;
import com.happy.tip.model.vo.TipPhoto;

/**
 * Servlet implementation class TipListServlet
 */
@WebServlet("/tip/tipList.do")
public class TipListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    Member m=(Member)session.getAttribute("loginMember");
	    

		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		}catch (Exception e) {
			cPage=1;
		} 
		
		int numPerpage=12;
		
		List<TipBoard> tipBoardList=new TipService().selectTipBoardList(cPage,numPerpage);
		
		int totalData=new TipService().tipBoardListCount();
		
		String pageBar="";
		int pageBarSize=5;
		int totalPage=(int)Math.ceil((double)totalData/numPerpage);
		int pageNo=((cPage-1)/pageBarSize)*pageBarSize+1;
	    int pageEnd=pageNo+pageBarSize-1;
		
	    if(pageNo==1) {
	         pageBar+="<span>[이전]</span>";
	      }else {
	         pageBar+="<a href='"+request.getContextPath()+"/tip/tipList.do?cPage="+(pageNo-1)+"'>[이전]</a>";
	      }
	      
	      while(!(pageNo>pageEnd||pageNo>totalPage)) { 
	         if(cPage==pageNo) {
	            pageBar+="<span>"+pageNo+"</span>";
	         }else {
	            pageBar+="<a href='"+request.getContextPath()+"/tip/tipList.do?cPage="+pageNo+"'>"+pageNo+"</a>";
	         }
	         pageNo++;
	      }
	      if(pageNo>totalPage) {
	         pageBar+="<span>[다음]</span>";
	      }else {
	         pageBar+="<a href='"+request.getContextPath()+"/tip/tipList.do?cPage="+pageNo+"'>[다음]</a>";
	      }
	    
	      List<TipPhoto> photos=new TipService().selectTipPhoto();
	      
	    request.setAttribute("tipBoardList",tipBoardList); 
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("tipPhoto", photos);
		request.getRequestDispatcher("/views/tip/tipList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
