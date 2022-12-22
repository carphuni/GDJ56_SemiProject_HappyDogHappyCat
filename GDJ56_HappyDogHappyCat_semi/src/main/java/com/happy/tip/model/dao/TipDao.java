package com.happy.tip.model.dao;

import static com.happy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			pstmt.setInt(1, tp.getTipBoardNo());
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
	
	
	
}
