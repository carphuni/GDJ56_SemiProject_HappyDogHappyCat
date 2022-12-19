package com.happy.member.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.happy.member.model.service.MemberService;
import com.happy.member.model.vo.Member;

/**
 * Servlet implementation class MemberUpdateName
 */
@WebServlet("/member/memberUpdateAllEnd.do")
public class MemberUpdateAllEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateAllEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//변경할 이름 요청값
		String reName=request.getParameter("memberName");
		String reEmail=request.getParameter("memberEmail");
		String rePhone=request.getParameter("memberPhone");
		String reAddress=request.getParameter("memberAddress");
		
		//세션의 로그인된 멤버의 pk가져오기
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		int memberNo=loginMember.getMemberNo();
		
		//
		Member member=Member.builder()
		.memberName(reName)
		.memberAddress(reAddress)
		.memberPhone(rePhone)
		.memberNo(memberNo)
		.memberEmail(reEmail)
		.build();
		
		
		//변경할 이름으로 DB업데이트 결과값
		int result=new MemberService().memberUpdateAll(member);
//		결과값에 따라 메세지와 돌아갈 경로
		String msg;
		String loc;
		if(result>0) {
			//변경 성공시
			msg="성공적으로 이름을 수정했습니다";
			loc="/member/myPage.do";
			loginMember.setMemberName(reName);
			loginMember.setMemberAddress(reAddress);
			loginMember.setMemberEmail(reEmail);
			loginMember.setMemberPhone(rePhone);
			session.setAttribute("loginMember", loginMember);
		}else {
			//변경 실패시
			msg="이름 수정에 실패하셨습니다.";
			loc="/member/memberUpdateAll.do";
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
