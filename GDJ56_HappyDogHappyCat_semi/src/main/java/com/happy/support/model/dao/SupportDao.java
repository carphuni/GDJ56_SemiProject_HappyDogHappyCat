package com.happy.support.model.dao;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.member.model.dao.MemberDao.getMember;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.happy.member.model.vo.Member;
import com.happy.support.model.vo.SupComment;
import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;


public class SupportDao {
	
	private Properties sql= new Properties();
		
		public SupportDao() {
			String path=SupportDao.class.getResource("/sql/support/support_sql.properties").getPath();
			try {
				sql.load(new FileReader(path));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public int insertSupport(Connection conn, Support s) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("insertSupport"));
				pstmt.setString(1, s.getSupTitle());
				pstmt.setInt(2,s.getSupTargetAmount());
				pstmt.setString(3,s.getSupContents());
				pstmt.setInt(4, s.getSupAgencyNo());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
		}
	

		
		public int selectSupNo(Connection conn) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int supNo=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectSupNo"));
				rs=pstmt.executeQuery();
				if(rs.next()) supNo=rs.getInt("SUPNO");
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return supNo;
		}
		
		public int insertVolPhoto(Connection conn, int supNo, SupPhoto sp) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("insertSupPhoto"));
				pstmt.setInt(1, supNo);
				pstmt.setString(2, sp.getSupMainPhoto());
				pstmt.setString(3, sp.getSupPhotoOriName());
				pstmt.setString(4, sp.getSupPhotoRename());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
			
		}	
		
		public List<Support> selectSupportList(Connection conn, int cPage, int numPerpage){
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			List<Support> list=new ArrayList();
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectSupportList"));
				pstmt.setInt(1, (cPage-1)*numPerpage+1);
				pstmt.setInt(2, cPage*numPerpage);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					list.add(getSupport(rs));
				}	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return list;
		}

		
		
		public int selectSupportCount(Connection conn) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectSupportCount"));
				rs=pstmt.executeQuery();
				if(rs.next()) {
					result=rs.getInt(1);}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return result;
			
		}
		
		public Support selectSupport(Connection conn, int boardNo) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Support s = null;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectSupport"));
				pstmt.setInt(1, boardNo);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					s = getSupport(rs);
				}	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return s;
		}
		
		
		public SupPhoto selectSupPhoto(Connection conn, int supBoardNo) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			SupPhoto sp= null;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectSupPhoto"));
				pstmt.setInt(1, supBoardNo);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					sp=SupPhoto.builder().supFileNo(rs.getInt("SUP_FILE_NO"))
						.supBoardNo(rs.getInt("SUP_BOARD_NO"))
						.supMainPhoto(rs.getString("SUP_MAIN_PHOTO"))
						.supPhotoOriName(rs.getString("SUP_PHOTO_ORINAME"))
						.supPhotoRename(rs.getString("SUP_PHOTO_RENAME")).build();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return sp;
		}
		
		public List<SupPhoto> selectSupPhoto2(Connection conn, int supBoardNo) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			SupPhoto s= null;
			List<SupPhoto> sp = new ArrayList();
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectSupPhoto2"));
				pstmt.setInt(1, supBoardNo);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					s=SupPhoto.builder().supFileNo(rs.getInt("SUP_FILE_NO"))
						.supBoardNo(rs.getInt("SUP_BOARD_NO"))
						.supMainPhoto(rs.getString("SUP_MAIN_PHOTO"))
						.supPhotoOriName(rs.getString("SUP_PHOTO_ORINAME"))
						.supPhotoRename(rs.getString("SUP_PHOTO_RENAME")).build();
					sp.add(s);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return sp;
		}
		
		
		public int insertComment(Connection conn, SupComment sc) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("insertComment"));
				pstmt.setInt(1,sc.getSupBoardNo());
				pstmt.setString(2, sc.getSupCommentContents());
				pstmt.setInt(3, sc.getSupUserNo());
				pstmt.setInt(4,sc.getSupPayAmount());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;

		}
		
		
		public List<SupComment> selectComment(Connection conn, int supBoardNo) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			SupComment s= null;
			
			List<SupComment> sc = new ArrayList();
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectComment"));
				pstmt.setInt(1, supBoardNo);
				rs=pstmt.executeQuery();
				while(rs.next()) {
					s=SupComment.builder().supCommentNo(rs.getInt("SUP_COMMENT_NO"))
						.supBoardNo(rs.getInt("SUP_BOARD_NO"))
						.supCommentWriteDate(rs.getDate("SUP_COMMENT_WRITE_DATE"))
						.supCommentContents(rs.getString("SUP_COMMENT_CONTENTS"))
						.supCommentDeleteYn(rs.getString("SUP_COMMENT_DELETE_YN").charAt(0))
						.supUserNo(rs.getInt("SUP_USER_NO"))
						.supPayAmount(rs.getInt("SUP_PAY_AMOUNT")).
						build();
					sc.add(s);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return sc;
		}
		
		
		public Member selectMember(Connection conn, int memberNo) {
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			Member m = null;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("selectMember"));
				pstmt.setInt(1, memberNo);
				rs=pstmt.executeQuery();
				if(rs.next()) {
					m = getMember(rs);
				}	
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}return m;
		
		}
		
		public int updatePayAmount(Connection conn, SupComment sc) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("updatePayAmount"));
				pstmt.setInt(1, sc.getSupPayAmount());
				pstmt.setInt(2,sc.getSupBoardNo());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
			
		}
		
		
		
		private Support getSupport(ResultSet rs) throws SQLException{
			return Support.builder()
					.supBoardNo(rs.getInt("SUP_BOARD_NO"))
					.supTitle(rs.getString("SUP_TITLE"))
					.supTargetAmount(rs.getInt("SUP_TARGET_AMOUNT"))
					.supContents(rs.getString("SUP_CONTENTS"))
					.supApvYn(rs.getString("SUP_APV_YN").charAt(0))
					.supAgencyNo(rs.getInt("SUP_AGENCY_NO"))
					.build();
		}
}
