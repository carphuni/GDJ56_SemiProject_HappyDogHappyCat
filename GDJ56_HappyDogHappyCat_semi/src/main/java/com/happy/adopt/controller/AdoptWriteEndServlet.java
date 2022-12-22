package com.happy.adopt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.*;
/**
 * Servlet implementation class AdoptWriteEndServlet
 */
@WebServlet("/adopt/adoptwriteEnd.do")
public class AdoptWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int memberNo=Integer.parseInt(request.getParameter("memberNo"));
		String roommate=request.getParameter("roommate");
		String allergy=request.getParameter("allergy");
		String money=request.getParameter("money");
		String exp=request.getParameter("exp");
		String live=request.getParameter("live");
		String content=request.getParameter("summernote");
		String aptHopedate=request.getParameter("aptHopedate");
		int aniNo=Integer.parseInt(request.getParameter("aniNo"));
		//System.out.println("d"+aniNo);
		AdtBorad ab=AdtBorad.builder()
				.adtRoommate(roommate)
				.adtAllergy(allergy)
				.adtMoney(money)
				.adtExper(exp)
				.adtLive(live)
				.adtContents(content)
				.memberNo(memberNo)
				.adtVisitDate(aptHopedate)
				.aniNo(aniNo)
				.build();
		
		int result=new AdoptService().adoptWrite(ab);
		
		String msg="",loc="";
		if(result>0) {
			msg="방문이 확정되었습니다.입력하신날짜에 방문해주세요";
			loc="/adopt/adoptmain.do";
		}else {
			msg="입양하기 글등록 실패";
			loc="/adopt/adoptdes.do?aniNo="+aniNo;
		}
		
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
