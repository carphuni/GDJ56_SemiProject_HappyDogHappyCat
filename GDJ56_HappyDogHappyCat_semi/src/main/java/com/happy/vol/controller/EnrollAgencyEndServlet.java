package com.happy.vol.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.happy.member.model.vo.Member;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;

/**
 * Servlet implementation class EnrollAgencyEndServlet
 */
@WebServlet("/agency/enrollAgencyEnd.do")
public class EnrollAgencyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollAgencyEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//기관 가입 입력 데이터 가져오기
		String agencyName=request.getParameter("agencyName");
		String agencyAddress=request.getParameter("agencyAddress");
		String agencyPhone=request.getParameter("agencyPhone");
		//로그인 유저 번호 가져오기
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		int memberNo=loginMember.getMemberNo();
		//vo에 저장
		Agency agency=Agency.builder()
					.agencyName(agencyName)
					.agencyAddress(agencyAddress)
					.agencyPhone(agencyPhone)
					.build();
		//기관 DB에 저장 후 결과 반환
		int result=new VolunteerService().enrollAgencyEnd(agency, memberNo);
		
		String msg;
		String loc;
		
		if(result>0) {
			msg="기관등록에 성공하셨습니다";
			loc="/views/member/myPage";
		}else {
			msg="기관등록에 실패하셨습니다";
			loc="/views/volunteer/enrollAgency";
		}
		
		Map<String,String> responseMsg=Map.of("msg",msg,"loc",loc);
		
		new Gson().toJson(responseMsg,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
