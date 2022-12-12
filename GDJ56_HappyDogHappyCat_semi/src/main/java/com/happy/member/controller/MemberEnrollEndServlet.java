package com.happy.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.happy.member.model.service.MemberService;
import com.happy.member.model.vo.Member;

/**
 * Servlet implementation class MemberEnrollEndServlet
 */
@WebServlet("/member/enrollEnd.do")
public class MemberEnrollEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEnrollEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 받아오기
		String memberId=request.getParameter("memberId");
		String memberPw=request.getParameter("memberPw");
		String memberName=request.getParameter("memberName");
		String memberYear=request.getParameter("memberYear");
		String memberMonth=request.getParameter("memberMonth");
		String memberDay=request.getParameter("memberDay");
		String memberEmail=request.getParameter("memberEmail");
		String memberPhone=request.getParameter("memberPhone");
		String memberAddress=request.getParameter("memberAddress");
		String date=memberYear+"-"+memberMonth+"-"+memberDay;
		Date memberBirth=Date.valueOf(date);
		System.out.println(memberBirth);
		
		//Member형에 저장
		Member member=Member.builder()
						.memberId(memberId)
						.memberPw(memberPw)
						.memberName(memberName)
						.memberBirthDate(memberBirth)
						.memberEmail(memberEmail)
						.memberPhone(memberPhone)
						.memberAddress(memberAddress)
						.build();
		
		
		//DB에 저장 후 결과 값 리턴
		int result=new MemberService().memberEnrollEnd(member);
		
		String msg;
		String loc;
		if(result==0) {
			//회원가입 실패시
			msg="회원가입 실패";
			loc="/member/enroll.do";
		}else {
			//회원가입 성공시
			msg="회원가입 성공";
			loc="/";
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
