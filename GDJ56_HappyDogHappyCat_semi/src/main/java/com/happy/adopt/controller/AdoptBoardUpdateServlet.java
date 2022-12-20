package com.happy.adopt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AdtBorad;

/**
 * Servlet implementation class AdoptBoardUpdateServlet
 */
@WebServlet("/member/mypage/adoptBoardUpdate")
public class AdoptBoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptBoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int adtBoardNo=Integer.parseInt(request.getParameter("adtBoardNo"));
		String roommate=request.getParameter("roommate");
		String allergy=request.getParameter("allergy");
		String money=request.getParameter("money");
		String exp=request.getParameter("exp");
		String live=request.getParameter("live");
		String aptHopedate=request.getParameter("aptHopedate");
		String content=request.getParameter("summernote");
		
		AdtBorad ab=AdtBorad.builder()
					.adtRoommate(roommate)
					.adtAllergy(allergy)
					.adtMoney(money)
					.adtExper(exp)
					.adtLive(live)
					.adtVisitDate(aptHopedate)
					.adtContents(content)
					.adtBoardNo(adtBoardNo)
					.build();
		
		int result = new AdoptService().adoptBoardUpdate(ab);
		
		String msg="",loc="";
		if(result>0) {
			msg="수정 성공";
			loc="/member/mypage/adoptboard.do?adtBoardNo="+adtBoardNo;
		}else {
			msg="수정 실패";
			loc="/member/mypage/adoptboard.do?adtBoardNo="+adtBoardNo;
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
