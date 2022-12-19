package com.happy.member.model.dao;

import static com.happy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.happy.member.model.vo.Member;

public class MemberDao {
	Properties sql=new Properties();
	
	public MemberDao() {
		//기본생성자에 sql문 properties 불러오기
		String path=MemberDao.class.getResource("/sql/member/member_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Member getMember(ResultSet rs) throws SQLException {
		//쿼리문 결과 Member형 리턴
		return Member.builder()
				.memberNo(rs.getInt("member_no"))
				.memberId(rs.getString("member_id"))
				.memberPw(rs.getString("member_pw"))
				.memberName(rs.getString("member_name"))
				.memberPhone(rs.getString("member_phone"))
				.memberEmail(rs.getString("member_email"))
				.memberAddress(rs.getString("member_address"))
				.memberDelYn(rs.getString("member_del_yn"))
				.memberLikeType(rs.getString("member_like_type"))
				.memberLikeSize(rs.getString("member_like_size"))
				.memberLikeColor(rs.getString("member_like_color"))
				.memberLikeChar(rs.getString("member_like_char"))
				.memberBirthDate(rs.getDate("member_birth_date"))
				.memberDelDate(rs.getDate("member_del_date"))
				.memberEnrollDate(rs.getDate("member_enroll_date"))
				.build();
	}
	
	public Member memberLoginEnd(Connection conn, String memberId, String memberPw) {
		//로그인
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member loginMember=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("memberLoginEnd"));
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				loginMember=getMember(rs);
				};
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return loginMember;
	}
	
	public int memberEnrollEnd(Connection conn, Member member) {
		//회원가입
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("memberEnrollEnd"));
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setDate(4, member.getMemberBirthDate());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddress());
			pstmt.setString(7, member.getMemberPhone());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public Member duplicateId(Connection conn, String inputId) {
		//아이디 중복 체크
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Member member=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("duplicateId"));
			pstmt.setString(1, inputId);
			rs=pstmt.executeQuery();
			if(rs.next()) member=getMember(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return member;
	}

	public int memberUpdateAll(Connection conn, Member member) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("memberUpdateAll"));
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberEmail());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberAddress());
			pstmt.setInt(5, member.getMemberNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int  memberUpdatePwEnd(Connection conn, Member loginMember, String memberPw) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("memberUpdatePwEnd"));
			pstmt.setString(1, memberPw);
			pstmt.setInt(2, loginMember.getMemberNo());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
}
