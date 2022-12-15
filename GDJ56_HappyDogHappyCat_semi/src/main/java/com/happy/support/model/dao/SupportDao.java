package com.happy.support.model.dao;

import static com.happy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.vo.Volunteer;


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
		
		
		private Support getSupport(ResultSet rs) throws SQLException{
			return Support.builder()
					.supBoardNo(rs.getInt("SUP_BOARD_NO"))
					.supTitle(rs.getString("SUP_TITLE"))
					.supTargetAmount(rs.getInt("SUP_TARGET_AMOUNT"))
					.supContents(rs.getString("SUP_CONTENTS"))
					.supApvYn(rs.getString("VNT_REC_PERIOD").charAt(0))
					.supAgencyNo(rs.getInt("SUP_AGENCY_NO"))
					.build();
		}
}
