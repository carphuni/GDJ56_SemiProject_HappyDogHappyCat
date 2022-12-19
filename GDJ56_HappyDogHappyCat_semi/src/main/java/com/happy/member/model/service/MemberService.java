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
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public Member duplicateId(String inputId) {
		//아이디 중복확인
		Connection conn=getConnection();
		Member member=dao.duplicateId(conn, inputId);
		close(conn);
		return member;
	}
	
	public int memberUpdateAll(Member member) {
		//마이페이지 내 정보 수정
		Connection conn=getConnection();
		int result=dao.memberUpdateAll(conn, member);
		if(result>0)commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}

}
