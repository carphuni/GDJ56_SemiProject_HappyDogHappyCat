package com.happy.tip.model.dao;

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

import com.happy.tip.model.vo.TipBoard;
import com.happy.tip.model.vo.TipPhoto;
import com.happy.vol.model.dao.VolunteerDao;

public class TipDao {
private Properties sql= new Properties();
	
	public TipDao() {
		String path=VolunteerDao.class.getResource("/sql/tip/tip_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private TipBoard getTipBoard(ResultSet rs) throws SQLException{
		return TipBoard.builder()
				.tipBoardNo(rs.getInt("tip_board_no"))
				.memberNo(rs.getInt("member_no"))
				.tipCategory(rs.getString("tip_category"))
				.tipContents(rs.getString("tip_contents"))
				.tipLat(rs.getDouble("tip_lat"))
				.tipLon(rs.getDouble("tip_lon"))
				.tipResultYn(rs.getString("tip_result_yn").charAt(0))
				.tipTitle(rs.getString("tip_title"))
				.tipViews(rs.getInt("tip_views"))
				.tipWriteDate(rs.getDate("tip_write_date"))
				.build();
	}
	
	private TipPhoto getTipPhoto(ResultSet rs) throws SQLException{
		return TipPhoto.builder()
				.tipPhotoNo(rs.getInt("tip_photo_no"))
				.tipBoardNo(rs.getInt("tip_board_no"))
				.tipPhotoOriname(rs.getString("tip_photo_orname"))
				.tipPhotoRename(rs.getString("tip_photo_rename"))
				.build();
		
	}
	
	public int insertTipBoard(Connection conn, TipBoard tb) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertTipBoard"));
			pstmt.setInt(1, tb.getMemberNo());
			pstmt.setString(2, tb.getTipCategory());
			pstmt.setString(3, tb.getTipTitle());
			pstmt.setString(4, tb.getTipContents());
			pstmt.setDouble(5, tb.getTipLat());
			pstmt.setDouble(6, tb.getTipLon());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int selectTipBoardNo(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int tbNo=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectTipBoardNo"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				tbNo=rs.getInt("tbno");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return tbNo;
	}
	
	public int insertTipPhoto(Connection conn, int tbNo, TipPhoto tp) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertTipPhoto"));
			pstmt.setInt(1, tbNo);
			pstmt.setString(2, tp.getTipPhotoOriname());
			pstmt.setString(3, tp.getTipPhotoRename());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<TipBoard> selectTipBoardList(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<TipBoard> tipBoardList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectTipBoardList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				TipBoard tb=getTipBoard(rs);
				tb.setMemberId("member_id");
				tipBoardList.add(tb);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return tipBoardList;
	}
	
	public int tipBoardListCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int tipBoardListCount=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("tipBoardListCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				tipBoardListCount=rs.getInt("cnt");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return tipBoardListCount;
	}
	
	public List<TipPhoto> selectTipPhoto(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<TipPhoto> photos=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectTipPhoto"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				photos.add(getTipPhoto(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return photos;
	}
	
	
	
}
