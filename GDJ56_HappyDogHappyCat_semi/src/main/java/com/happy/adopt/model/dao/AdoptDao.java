package com.happy.adopt.model.dao;

import static com.happy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.happy.adopt.model.vo.AdoptPhoto;
import com.happy.adopt.model.vo.AdtBorad;
import com.happy.adopt.model.vo.AdtReviewBorad;
import com.happy.adopt.model.vo.AdtReviewComment;
import com.happy.adopt.model.vo.AnimalPick;
import com.happy.animal.model.vo.Animal;
import com.happy.common.JDBCTemplate;

public class AdoptDao {
	
	private Properties sql=new Properties();
	
	public AdoptDao() {
		try {
			String path=JDBCTemplate.class.getResource("/sql/adopt/adoptsql.properties").getPath();
			sql.load(new FileReader(path));
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<Animal> adoptMainAniAll(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Animal> AniList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptMainAll"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				AniList.add(getAnimal(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return AniList;
		
	}
	
	public int adoptMainAniAllCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptMainAniAllCount"));
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
	
	public Animal adoptDesAni(Connection conn,int aniNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Animal ani=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptDesAni"));
			pstmt.setInt(1, aniNo);
			rs=pstmt.executeQuery();
			if(rs.next()) ani=getAnimal(rs);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return ani;
	}
	
	public int adoptWrite(Connection conn,AdtBorad ab) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptWrite"));
			pstmt.setInt(1, ab.getMemberNo());
			pstmt.setString(2, ab.getAdtContents());
			pstmt.setString(3, ab.getAdtRoommate());
			pstmt.setString(4, ab.getAdtExper());
			pstmt.setString(5, ab.getAdtMoney());
			pstmt.setString(6, ab.getAdtLive());
			pstmt.setString(7, ab.getAdtAllergy());
			pstmt.setString(8, ab.getAdtVisitDate());
			pstmt.setInt(9, ab.getAniNo());
			
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adoptReviewWrite(Connection conn,AdtReviewBorad arb) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptReviewWrite"));
			pstmt.setInt(1, arb.getMemberNo());
			pstmt.setString(2, arb.getAdtTitle());
			pstmt.setString(3, arb.getAdtContents());	
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<AdtReviewBorad> adoptReviewAll(Connection conn,int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AdtReviewBorad> rList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptReviewAll"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				rList.add(getAdtReviewBorad(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return rList;
	}
	
	public int adoptReviewAllCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptReviewAllCount"));
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
	
	public AdtReviewBorad adoptReviewDes(Connection conn,int adpBoardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		AdtReviewBorad arb=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptReviewDes"));
			pstmt.setInt(1, adpBoardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				arb=AdtReviewBorad.builder()
	              .adtBoardNo(rs.getInt("ADT_BOARD_NO"))
	              .memberNo(rs.getInt("MEMBER_NO"))
	              .adtTitle(rs.getString("ADT_TITLE"))
	              .adtContents(rs.getString("ADT_CONTENTS"))
	              .adtViews(rs.getInt("ADT_VIEWS"))
	              .adtWriteDate(rs.getString("ADT_WRITE_DATE"))
	              .build();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return arb;
	}
	
	public int adoptAddPick(Connection conn,int memberNo,int aniNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptAddPick"));
			pstmt.setInt(1, aniNo);
			pstmt.setInt(2, memberNo);	
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adoptDeletePick(Connection conn,int memberNo,int aniNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptDeletePick"));
			pstmt.setInt(1, aniNo);
			pstmt.setInt(2, memberNo);		
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public List<AnimalPick> adoptPickAll(Connection conn,int memberNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AnimalPick> pList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptPickAll"));
			pstmt.setInt(1, memberNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				pList.add(getAnimalPick(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return pList;
	}
	
	
	public static AnimalPick getAnimalPick(ResultSet rs) throws SQLException{
        return AnimalPick.builder()
              .aniNo(rs.getInt("ANI_NO"))
              .memberNo(rs.getInt("MEMBER_NO"))
              .build();
  }
	
	public int updateReviewReadCount(Connection conn, int adpBoardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateReviewReadCount"));
			pstmt.setInt(1, adpBoardNo);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int updateReadCount(Connection conn, int aniNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateReadCount"));
			pstmt.setInt(1, aniNo);
			result=pstmt.executeUpdate();
		}catch (Exception e) {
			
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int adoptComment(Connection conn,String reply,String memberId,int reviewBoardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptComment"));
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
	
	public List<AdtReviewComment> adoptReviewCommentAll(Connection conn,int adpBoardNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AdtReviewComment> cList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adoptReviewCommentAll"));
			pstmt.setInt(1, adpBoardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cList.add(getAdtReviewComment(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return cList;
	}
	
	public int selectReviewNo(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int reviewNo=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectReviewNo"));
			rs=pstmt.executeQuery();
			if(rs.next()) reviewNo=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return reviewNo;
	}
	
	public int insertAptPhoto(Connection conn, int reviewBoardNo, AdoptPhoto ap) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertAptPhoto"));
			pstmt.setInt(1, reviewBoardNo);
			pstmt.setString(2, ap.getAdtPhotoOriName());
			pstmt.setString(3, ap.getAdtPhotoRename());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}	
	
	public List<AdoptPhoto> adtPhotoAll(Connection conn,int adpBoardNo){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<AdoptPhoto> photoList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("adtPhotoAll"));
			pstmt.setInt(1, adpBoardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				photoList.add(getAdoptPhoto(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return photoList;
	}
		
	public static AdoptPhoto getAdoptPhoto(ResultSet rs) throws SQLException{
        return AdoptPhoto.builder()
              .fileNo(rs.getInt("ADT_PHOTO_NO"))
              .adtBoardNo(rs.getInt("ADT_BOARD_NO"))
              .adtPhotoOriName(rs.getString("ADT_REVIEW_PHOTO_ORINAME"))
              .adtPhotoRename(rs.getString("ADT_REVIEW_PHOTO_RENAME"))
              .build();
  }
	
	public static AdtReviewComment getAdtReviewComment(ResultSet rs) throws SQLException{
        return AdtReviewComment.builder()
              .commentNo(rs.getInt("COMMENT_NO"))
              .memberId(rs.getString("MEMBER_ID"))
              .commentWriteDate(rs.getString("COMMENT_WRITE_DATE"))
              .commentContents(rs.getString("COMMENT_CONTENTS"))
              .commentDeleteYn(rs.getString("COMMENT_DELETE_YN").charAt(0))
              .commentModifyDate(rs.getString("COMMENT_MODIFY_DATE"))
              .adtReviewBoardNo(rs.getInt("ADT_REVIEWBOARD_NO"))
              .build();
  }
	
	public static AdtReviewBorad getAdtReviewBorad(ResultSet rs) throws SQLException{
        return AdtReviewBorad.builder()
              .adtBoardNo(rs.getInt("ADT_BOARD_NO"))
              .memberNo(rs.getInt("MEMBER_NO"))
              .adtTitle(rs.getString("ADT_TITLE"))
              .adtContents(rs.getString("ADT_CONTENTS"))
              .adtViews(rs.getInt("ADT_VIEWS"))
              .memberId(rs.getString("MEMBER_ID"))
              .adtWriteDate(rs.getString("ADT_WRITE_DATE"))
              .build();
  }
	
	public static Animal getAnimal(ResultSet rs) throws SQLException{
        return Animal.builder()
              .aniNo(rs.getInt("ANI_NO"))
              .aniName(rs.getString("ANI_NAME"))
              .aniType(rs.getString("ANI_TYPE"))
              .aniKind(rs.getString("ANI_KIND"))
              .aniGender(rs.getString("ANI_GENDER").charAt(0))
              .aniAge(rs.getInt("ANI_AGE"))
              .aniNeuYn(rs.getString("ANI_NEU_YN").charAt(0))
              .aniAdoptYn(rs.getString("ANI_ADOPT_YN").charAt(0))
              .aniSize(rs.getString("ANI_SIZE"))
              .aniColor(rs.getString("ANI_COLOR"))
              .aniChar(rs.getString("ANI_CHAR").split(","))
              .aniSpecial(rs.getString("ANI_SPECIAL"))
              .aniReason(rs.getString("ANI_REASON"))
              .madDog(rs.getString("MADDOG").charAt(0))
              .covid(rs.getString("COVID").charAt(0))
              .kennel(rs.getString("KENNEL").charAt(0))
              .influ(rs.getString("INFLU").charAt(0))
              .antibody(rs.getString("ANTIBODY").charAt(0))
              .totalvac(rs.getString("TOTALVAC").charAt(0))
              .adtViews(rs.getInt("ANI_VIEWS"))
              .build();
  }
} 
