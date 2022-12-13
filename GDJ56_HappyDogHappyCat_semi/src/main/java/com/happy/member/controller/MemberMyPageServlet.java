package com.happy.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happy.member.model.vo.Member;

/**
 * Servlet implementation class MemberMyPageServlet
 */
@WebServlet("/member/myPage.do")
public class MemberMyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberMyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//비밀번호 데이터 불러오기
		String memberPw=request.getParameter("memberPw");
		//로그인 정보 불러오기
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		//비밀번호 일치 시 마이페이지 출력
		if(loginMember!=null&&loginMember.getMemberPw().equals(memberPw)) {
			
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
