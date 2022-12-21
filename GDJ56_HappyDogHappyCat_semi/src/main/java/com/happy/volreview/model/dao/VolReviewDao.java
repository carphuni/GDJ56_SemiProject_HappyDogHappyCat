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

import com.happy.adopt.model.vo.AdtReviewComment;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.vo.Volunteer;
import com.happy.volreview.model.vo.VolComment;
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
	
	public int selectVolReviewNo(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int volNo=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolReviewNo"));
			rs=pstmt.executeQuery();
			if(rs.next()) volNo=rs.getInt("volno");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return volNo;
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
				vr = getVolReview2(rs);
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
	
	public int updateReadCount(Connection conn, int vntBoardNo ) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateReadCount"));
			pstmt.setInt(1, vntBoardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	
	
	
	
	public int insertComment(Connection conn, String reply, String memberId, int reviewBoardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertComment"));
			pstmt.setString(1, memberId);
			pstmt.setString(2, reply);
			pstmt.setInt(3, reviewBoardNo);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
			
	}
	
	public List<VolComment> selectCommentList(Connection conn, int boardNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<VolComment> cList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectCommentList"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cList.add(getVolComment(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return cList;
	}
	
	public List<VolReview> volReviewSearch(Connection conn,int cPage, int numPerpage,String keyword){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<VolReview> vList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("volReviewSearch"));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			pstmt.setInt(3, (cPage-1)*numPerpage+1);
			pstmt.setInt(4, cPage*numPerpage);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				vList.add(getVolReview2(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return vList;
	}
	
	public List<VolReview> myPageVolReviewList(Connection conn,int cPage, int numPerpage,	int memberNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<VolReview> sList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("myPageVolReviewList"));
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				sList.add(getVolReview2(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return sList;
	}
	
	public int myPageVolReviewCount(Connection conn, int memberNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("myPageVolReviewCount"));
			pstmt.setInt(1, memberNo);
			rs=pstmt.executeQuery();
			if(rs.next()) count=rs.getInt(1); 	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return count;
		
		
		
		
	}
	
	
	
	
	
	
	
	public int volReviewSearchCount(Connection conn,String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("volReviewSearchCount"));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) count=rs.getInt(1); 	
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return count;
	}
	
	public int deleteVolReview(Connection conn, int vntBoardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteVolReview"));
			pstmt.setInt(1, vntBoardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
		
	}
	
	public int updateVolReview(Connection conn, VolReview vr) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateVolReview"));
			pstmt.setString(1, vr.getVntTitle());
			pstmt.setString(2, vr.getVntContents());
			pstmt.setInt(3, vr.getVntBoardNo());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	
	}
	
	public int deleteReviewPhoto(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteReviewPhoto"));
			pstmt.setInt(1, boardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	private VolComment getVolComment(ResultSet rs) throws SQLException{
		return VolComment.builder().vntCommentNo(rs.getInt("VNT_COMMENT_NO"))
				.memberId(rs.getString("MEMBER_ID")).vntCommentWrite(rs.getDate("VNT_COMMENT_WRITE_DATE"))
				.vntCommentContents(rs.getString("VNT_COMMENT_CONTENTS"))
				.vntCommentDeleteYn(rs.getString("VNT_COMMENT_DELETE_YN").charAt(0))
				.vntCommentModifyDate(rs.getDate("VNT_COMMENT_MODIFY_DATE"))
				.vntBoardNo(rs.getInt("VNT_BOARD_NO")).build();
		
	}
	

	private VolReview getVolReview(ResultSet rs) throws SQLException{
		return VolReview.builder().vntBoardNo(rs.getInt("VNT_BOARD_NO"))
				.memberNo(rs.getInt("MEMBER_NO")).vntTitle(rs.getString("VNT_TITLE"))
				.vntContents(rs.getString("VNT_CONTENTS")).vntReviewViews(rs.getInt("VNT_REVIEW_VIEWS"))
				.vntReviewWriteDate(rs.getDate("VNT_REVIEW_WRITE_DATE")).memberId(rs.getString("MEMBER_ID")).build();
		
	}
	
	private VolReview getVolReview2(ResultSet rs) throws SQLException{
		return VolReview.builder().vntBoardNo(rs.getInt("VNT_BOARD_NO"))
				.memberNo(rs.getInt("MEMBER_NO")).vntTitle(rs.getString("VNT_TITLE"))
				.vntContents(rs.getString("VNT_CONTENTS")).vntReviewViews(rs.getInt("VNT_REVIEW_VIEWS"))
				.vntReviewWriteDate(rs.getDate("VNT_REVIEW_WRITE_DATE")).build();
		
	}
}
