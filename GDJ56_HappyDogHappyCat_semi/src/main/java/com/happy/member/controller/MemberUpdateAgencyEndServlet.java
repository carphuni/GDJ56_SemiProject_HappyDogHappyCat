package com.happy.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happy.member.model.service.MemberService;
import com.happy.member.model.vo.Member;
import com.happy.vol.model.vo.Agency;

/**
 * Servlet implementation class MemberUpdateAgencyEndServlet
 */
@WebServlet("/member/memberUpdateAgencyEnd.do")
public class MemberUpdateAgencyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateAgencyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기관 수정 값 받아오기
		String agencyName=request.getParameter("agencyName");
		String agencyAddress=request.getParameter("agencyAddress");
		String agencyPhone=request.getParameter("agencyPhone");
		
		//로그인된 멤버 세션값으로 멤버 넘버 추출
		HttpSession session=request.getSession();
		Agency loginAgency=(Agency)session.getAttribute("loginAgency");
		int memberNo=loginAgency.getMemberNo();
		
		//받은 데이터 값 vo에 저장
		Agency agency=Agency.builder()
						.agencyName(agencyName)
						.agencyAddress(agencyAddress)
						.agencyPhone(agencyPhone)
						.build();
		//DB에 기관 업데이트 후 결과 값 받아오기
		int result=new MemberService().memberUpdateAgency(agency, memberNo);
//		결과값에 따라 메세지와 돌아갈 경로
		String msg;
		String loc;
		if(result>0) {
			//변경 성공시
			msg="성공적으로 기관정보를 수정했습니다";
			loc="/member/myPage.do";
			loginAgency.setAgencyName(agencyName);
			loginAgency.setAgencyAddress(agencyAddress);
			loginAgency.setAgencyPhone(agencyPhone);
			session.setAttribute("loginAgency", loginAgency);
		}else {
			//변경 실패시
			msg="기관 정보 수정에 실패하셨습니다.";
			loc="/member/memberUpdateAgency.do";
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
