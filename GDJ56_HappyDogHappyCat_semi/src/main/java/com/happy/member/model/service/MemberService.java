package com.happy.member.model.service;

import static com.happy.common.JDBCTemplate.*;

import java.sql.Connection;

import com.happy.member.model.dao.MemberDao;
import com.happy.member.model.vo.Member;

public class MemberService {
	MemberDao dao=new MemberDao();
	
	public Member memberLoginEnd(String memberId, String memberPw) {
		//로그인
		Connection conn=getConnection();
		Member loginMember=dao.memberLoginEnd(conn, memberId, memberPw);
		close(conn);
		return loginMember;
	}
	
	public int memberEnrollEnd(Member member) {
		//회원가입
		Connection conn=getConnection();
		int result=dao.memberEnrollEnd(conn, member);
		close(conn);
		return result;
	}
	

}
