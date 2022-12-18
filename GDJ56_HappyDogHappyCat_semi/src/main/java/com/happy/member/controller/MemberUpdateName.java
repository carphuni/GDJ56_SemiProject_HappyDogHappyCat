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
@WebServlet("/member/memberUpdateNameEnd.do")
public class MemberUpdateName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//변경할 이름 요청값
		String reName=request.getParameter("floatingInputName");
		
		//세션의 로그인된 멤버의 pk가져오기
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		int memberNo=loginMember.getMemberNo();
		
		//변경할 이름으로 DB업데이트 결과값
		int result=new MemberService().memberUpdateName(memberNo, reName);
//		결과값에 따라 메세지와 돌아갈 경로
		String msg;
		String loc;
		if(result>0) {
			//변경 성공시
			msg="성공적으로 이름을 수정했습니다";
			loc="/views/member/myPage.jsp";
			loginMember.setMemberName(reName);
			session.setAttribute("loginMember", loginMember);
//			/member/myPage.do
		}else {
			//변경 실패시
			msg="이름 수정에 실패하셨습니다.";
			loc="/views/member/updateMemberName.jsp";
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
