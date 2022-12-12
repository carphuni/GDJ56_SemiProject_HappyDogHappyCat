package com.happy.member.model.service;

import static com.happy.common.JDBCTemplate.*;

import java.sql.Connection;

import com.happy.member.model.dao.MemberDao;
import com.happy.member.model.vo.Member;

public class MemberService {
	MemberDao dao=new MemberDao();
	
	public Member memberLoginEnd(String memberId, String memberPw) {
		Connection conn=getConnection();
		Member loginMember=dao.memberLoginEnd(conn, memberId, memberPw);
		close(conn);
		return loginMember;
	}
	

}
