package com.happy.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.happy.member.model.service.MemberService;
import com.happy.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginEndServlet
 */
@WebServlet("/member/loginEnd.do")
public class MemberLoginEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 가져오기
		String memberId=request.getParameter("memberId");
		String memberPw=request.getParameter("memberPw");
		
		//아이디 비밀번호가 일치하는 로그인 데이터 가져오기
		Member loginMember=new MemberService().memberLoginEnd(memberId, memberPw);
		
		//아이디 저장
		String saveId=request.getParameter("saveId");
		if(saveId!=null) {
			//아이디 체크했을 때
			Cookie c=new Cookie("saveId", memberId);
			c.setMaxAge(60*60*24*7);//7일동안 쿠키 저장
			response.addCookie(c);
		}else {
			//아이디 체크를 풀었을 때
			Cookie c=new Cookie("saveId", memberId);
			c.setMaxAge(0);//쿠키 삭제
			response.addCookie(c);
		}
		
		//로그인 아이디 세션 저장
		if(loginMember!=null) {
			//로그인 성공시
			HttpSession session=request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect(request.getContextPath());
		}else {
			//로그인 실패시
			request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다");
			request.setAttribute("loc", "/");
			request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
