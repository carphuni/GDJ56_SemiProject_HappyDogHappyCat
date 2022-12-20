package com.happy.volreview.model.dao;

import static com.happy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.happy.volreview.model.vo.VolReview;

public class VolReviewDao {

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
				list.add(getVolunteer(rs));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}
	
	private VolReview getVolReview(ResultSet rs) throws SQLException{
		return VolReview.builder().vntBoardNo(rs.getInt("VNT_BOARD_NO"))
				.memberNo(rs.getInt("MEMBER_NO")).vntTitle()
		
		
		
	}
}
