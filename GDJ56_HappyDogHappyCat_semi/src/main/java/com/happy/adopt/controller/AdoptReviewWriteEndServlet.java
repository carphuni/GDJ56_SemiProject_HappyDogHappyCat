package com.happy.adopt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AdtReviewBorad;

/**
 * Servlet implementation class AdoptReviewWriteEnd
 */
@WebServlet("/adopt/adoptReviewwriteEnd.do")
public class AdoptReviewWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptReviewWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		String title=request.getParameter("title");
		String content=request.getParameter("summernote");
		
		//System.out.println(content);
		
		AdtReviewBorad arb=AdtReviewBorad.builder()
				.memberNo(memberNo)
				.adtTitle(title)
				.adtContents(content)
				.build();
		
		int result=new AdoptService().adoptReviewWrite(arb);
		
		
		String msg="",loc="";
		if(result>0) {
			msg="입양후기 글등록 성공";
		}else {
			msg="입양후기 글등록 실패";			
		}
		loc="/adopt/adoptreview.do";
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
