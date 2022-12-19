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

/**
 * Servlet implementation class MemberUpdatePasswordEndServlet
 */
@WebServlet("/member/memberUpdatePwEnd.do")
public class MemberUpdatePasswordEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdatePasswordEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberPw=request.getParameter("memberPw");
		
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		
		//멤버 넘버가 일치하는 멤버의 비밀번호 변경후 결과값 리턴
		int result=new MemberService().memberUpdatePwEnd(loginMember, memberPw);
		
		//결과값에 따라 메세지와 돌아갈 경로
		String msg;
		String loc;
		if(result>0) {
			//변경 성공시
			msg="성공적으로 비밀번호를 수정했습니다. 다시 로그인하세요";
			session.invalidate();
			loc="/member/login.do";
		}else {
			//변경 실패시
			msg="비밀번호 수정에 실패하셨습니다.";
			loc="/member/memberUpdatePw.do";
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
