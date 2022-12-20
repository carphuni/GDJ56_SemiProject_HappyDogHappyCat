package com.happy.volreview.model.dao;

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

import com.happy.vol.model.vo.VolPhoto;
import com.happy.volreview.model.vo.VolReview;
import com.happy.volreview.model.vo.VolReviewPhoto;

public class VolReviewDao {

	private Properties sql= new Properties();
	
	public VolReviewDao() {
		String path = VolReviewDao.class.getResource("/sql/volreview/volreview_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public List<VolReview> selectVolReviewList(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<VolReview> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolReviewList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(getVolReview(rs));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	public int selectVolReviewCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolReviewCount"));
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
	
	public VolReview selectVolReview(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		VolReview vr = null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolReview"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vr = getVolReview(rs);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return vr;
	}
	
	public int insertVolReview(Connection conn, VolReview vr) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertVolReview"));
			pstmt.setInt(1, vr.getMemberNo());
			pstmt.setString(2, vr.getVntTitle());
			pstmt.setString(3, vr.getVntContents());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
		
		
	public int insertVolReviewPhoto(Connection conn, int boardNo, VolReviewPhoto vrp) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertVolReviewPhoto"));
			pstmt.setInt(1, boardNo);
			pstmt.setString(2, vrp.getMainPhoto());
			pstmt.setString(3, vrp.getVntPhotoOriName());
			pstmt.setString(4, vrp.getVntPhotoRename());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}	
		
	public VolReviewPhoto selectVolReviewPhoto(Connection conn, int boardNo) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		VolReviewPhoto vrp= null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolReviewPhoto"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vrp=VolReviewPhoto.builder().fileNo(rs.getInt("FILE_NO"))
					.vntBoardNo(rs.getInt("VNT_BOARD_NO"))
					.mainPhoto(rs.getString("MAIN_PHOTO"))
					.vntPhotoOriName(rs.getString("VNT_PHOTO_ORINAME"))
					.vntPhotoRename(rs.getString("VNT_PHOTO_RENAME")).build();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return vrp;
	}
	
public List<VolReviewPhoto> selectVolReviewPhoto2(Connection conn, int boardNo) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		VolReviewPhoto v = null;
		List<VolReviewPhoto> vrp= new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolReviewPhoto2"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				v=VolReviewPhoto.builder().fileNo(rs.getInt("FILE_NO"))
					.vntBoardNo(rs.getInt("VNT_BOARD_NO"))
					.mainPhoto(rs.getString("MAIN_PHOTO"))
					.vntPhotoOriName(rs.getString("VNT_PHOTO_ORINAME"))
					.vntPhotoRename(rs.getString("VNT_PHOTO_RENAME")).build();
				vrp.add(v);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return vrp;
	}
	
	
	
	
	
	
	
	private VolReview getVolReview(ResultSet rs) throws SQLException{
		return VolReview.builder().vntBoardNo(rs.getInt("VNT_BOARD_NO"))
				.memberNo(rs.getInt("MEMBER_NO")).vntTitle(rs.getString("VNT_TITLE"))
				.vntContents(rs.getString("VNT_CONTENTS")).vntReviewViews(rs.getInt("VNT_REVIEW_VIEWS"))
				.vntReviewWriteDate(rs.getDate("VNT_REVIEW_WRITE_DATE")).memberId(rs.getString("MEMBER_ID")).build();
		
	}
}
