package com.happy.vol.model.dao;

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

import com.happy.adopt.model.vo.AdtReviewBorad;
import com.happy.vol.model.vo.Agency;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;
public class VolunteerDao {
	
	private Properties sql= new Properties();
	
	public VolunteerDao() {
		String path=VolunteerDao.class.getResource("/sql/volunteer/volunteer_sql.properties").getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Agency selectAgency(Connection conn, int agencyNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Agency a= null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAgency"));
			pstmt.setInt(1, agencyNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				a=Agency.builder().agencyNo(rs.getInt("AGENCY_NO"))
				.memberNo(rs.getInt("MEMBER_NO"))
				.agencyName(rs.getString("AGENCY_NAME"))
				.agencyAddress(rs.getString("AGENCY_ADDRESS"))
				.agencyPhone(rs.getString("AGENCY_PHONE")).build();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return a;
	}
	
	public Agency selectAgency2(Connection conn, int memberNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Agency a= null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAgency2"));
			pstmt.setInt(1, memberNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				a=Agency.builder().agencyNo(rs.getInt("AGENCY_NO"))
				.memberNo(rs.getInt("MEMBER_NO"))
				.agencyName(rs.getString("AGENCY_NAME"))
				.agencyAddress(rs.getString("AGENCY_ADDRESS"))
				.agencyPhone(rs.getString("AGENCY_PHONE")).build();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return a;
	}
	
	public VolPhoto selectVolPhoto(Connection conn, int vntBoardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		VolPhoto vp= null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolPhoto"));
			pstmt.setInt(1, vntBoardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vp=VolPhoto.builder().fileNo(rs.getInt("FILE_NO"))
					.vntBoardNo(rs.getInt("VNT_BOARD_NO"))
					.mainPhoto(rs.getString("VNT_BOARD_NO"))
					.vntPhotoOriName(rs.getString("VNT_PHOTO_ORINAME"))
					.vntPhotoRename(rs.getString("VNT_PHOTO_RENAME")).build();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return vp;
	}
	
	
	public List<VolPhoto> selectVolPhoto2(Connection conn, int vntBoardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		VolPhoto v = null;
		List<VolPhoto> vp= new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolPhoto2"));
			pstmt.setInt(1, vntBoardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				v=VolPhoto.builder().fileNo(rs.getInt("FILE_NO"))
					.vntBoardNo(rs.getInt("VNT_BOARD_NO"))
					.mainPhoto(rs.getString("VNT_BOARD_NO"))
					.vntPhotoOriName(rs.getString("VNT_PHOTO_ORINAME"))
					.vntPhotoRename(rs.getString("VNT_PHOTO_RENAME")).build();
					vp.add(v);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return vp;
	}
	
	
	
	
	public List<Volunteer> selectVolunteerList(Connection conn, int cPage, int numPerpage){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Volunteer> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolunteerList"));
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
	
	public Volunteer selectVolunteer(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Volunteer v = null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolunteer"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				v = getVolunteer(rs);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return v;
	}
		
		public int selectVolunteerCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolunteerCount"));
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
	
	public int insertVolunteer(Connection conn, Volunteer v) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertVolunteer"));
			pstmt.setInt(1, v.getVntAgencyNo());
			pstmt.setString(2, v.getVntRecName());
			pstmt.setString(3,v.getVntManagerName());
			pstmt.setDate(4,v.getVntRecPeriod());
			pstmt.setDate(5,v.getVntActPeriod());
			pstmt.setString(6, v.getVntActDay());
			pstmt.setString(7,v.getVntActContents());
			pstmt.setInt(8, v.getVntSetPerson());
			pstmt.setDate(9, v.getVntRecPeriodEnd());
			pstmt.setDate(10,v.getVntRecPeriodEnd());
			pstmt.setDate(11,v.getVntActPeriodEnd());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	public int insertVolPhoto(Connection conn, int volNo, VolPhoto vp) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertVolPhoto"));
			pstmt.setInt(1, volNo);
			pstmt.setString(2, vp.getMainPhoto());
			pstmt.setString(3, vp.getVntPhotoOriName());
			pstmt.setString(4, vp.getVntPhotoRename());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}	
		
	
	
	public List<Volunteer> volSearch(Connection conn,int cPage, int numPerpage,String keyword){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Volunteer> vList=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("volSearch"));
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			pstmt.setInt(3, (cPage-1)*numPerpage+1);
			pstmt.setInt(4, cPage*numPerpage);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				vList.add(getVolunteer(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return vList;
	}
	
	
	public int volSearchCount(Connection conn,String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("volSearchCount"));
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
	
		
	private Volunteer getVolunteer(ResultSet rs) throws SQLException{
		return Volunteer.builder()
				.vntBoardNo(rs.getInt("VNT_BOARD_NO"))
				.vntAgencyNo(rs.getInt("VNT_AGENCY_NO"))
				.vntRecName(rs.getString("VNT_REC_NAME"))
				.vntManagerName(rs.getString("VNT_MANAGE_NAME"))
				.vntRecPeriod(rs.getDate("VNT_REC_PERIOD"))
				.vntRecPeriodEnd(rs.getDate("VNT_REC_PERIOD_END"))
				.vntActPeriod(rs.getDate("VNT_ACT_PERIOD"))
				.vntActPeriodEnd(rs.getDate("VNT_ACT_PERIOD_END"))
				.vntActDay(rs.getString("VNT_ACT_DAY"))
				.vntActWriteDate(rs.getDate("VNT_ACT_WRITE_DATE"))
				.vntActContents(rs.getString("VNT_ACT_CONTENTS"))
				.vntActViews(rs.getInt("VNT_ACT_VIEWS"))
				.vntSetPerson(rs.getInt("VNT_SET_PERSON"))
				.vntEnrPerson(rs.getInt("VNT_ENR_PERSON"))
				.vntActDline(rs.getDate("VNT_ACT_DLINE"))
				.build();
	}
	
	public int selectVolNo(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int volNo=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectVolNo"));
			rs=pstmt.executeQuery();
			if(rs.next()) volNo=rs.getInt("volno");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return volNo;
	}

	
	public int deleteVolunteer(Connection conn, int vntBoardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteVolunteer"));
			pstmt.setInt(1, vntBoardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
		
	}
	
	public int updateVol(Connection conn, Volunteer v) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateVol"));
			pstmt.setString(1, v.getVntRecName());
			pstmt.setString(2, v.getVntManagerName());
			pstmt.setDate(3, v.getVntRecPeriod());
			pstmt.setDate(4, v.getVntActPeriod());
			pstmt.setString(5,v.getVntActDay());
			pstmt.setString(6, v.getVntActContents());
			pstmt.setInt(7, v.getVntSetPerson());
			pstmt.setDate(8, v.getVntRecPeriodEnd());
			pstmt.setDate(9, v.getVntActPeriodEnd());
			pstmt.setInt(10, v.getVntBoardNo());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
		
	}
	
	public int updateVolPhoto(Connection conn, VolPhoto vp, int boardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateVolPhoto"));
			pstmt.setString(1,vp.getVntPhotoRename());
			pstmt.setInt(2, boardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;}
	
	
	public int updateVolPhoto2(Connection conn, VolPhoto vp, int boardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateVolPhoto"));
			pstmt.setString(1,vp.getVntPhotoRename());
			pstmt.setInt(2, boardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;}
	
	public int deleteVolPhoto(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteVolPhoto"));
			pstmt.setInt(1, boardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	public int updateEnr(Connection conn, int vntBoardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateEnr"));
			pstmt.setInt(1, vntBoardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public int cancelEnr(Connection conn, int vntBoardNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("cancelEnr"));
			pstmt.setInt(1, vntBoardNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public int updateEnrCheck(Connection conn,int vntBoardNo, int memberNo ) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateEnrCheck"));
			pstmt.setInt(1, vntBoardNo);
			pstmt.setInt(2, memberNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public int updateEnrCheckCancel(Connection conn,int vntBoardNo, int memberNo ) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateEnrCheckCancel"));
			pstmt.setInt(1, vntBoardNo);
			pstmt.setInt(2, memberNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}
	
	public int selectEnrCheck(Connection conn,int vntBoardNo, int memberNo ) {
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectEnrCheck"));
			pstmt.setInt(1, vntBoardNo);
			pstmt.setInt(2, memberNo);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
				
	}
	
	public int selectEnrPerson(Connection conn,int vntBoardNo, int memberNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectEnrPerson"));
			pstmt.setInt(1, vntBoardNo);
			pstmt.setInt(2, memberNo);
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
	
	public int insertEnr(Connection conn, int vntBoardNo, int memberNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertEnr"));
			pstmt.setInt(1, vntBoardNo);
			pstmt.setInt(2, memberNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
		
	}	
	
	//기관 가입
	public int enrollAgencyEnd(Connection conn, Agency agency, int memberNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollAgencyEnd"));
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, agency.getAgencyName());
			pstmt.setString(3, agency.getAgencyAddress());
			pstmt.setString(4, agency.getAgencyPhone());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	

	public List<Agency> selectAgency3(Connection conn){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List list= new ArrayList();
		Agency a = null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAgency3"));
			rs=pstmt.executeQuery();
			while(rs.next()) {
				a=Agency.builder().agencyNo(rs.getInt("AGENCY_NO"))
				.memberNo(rs.getInt("MEMBER_NO"))
				.agencyName(rs.getString("AGENCY_NAME"))
				.agencyAddress(rs.getString("AGENCY_ADDRESS"))
				.agencyPhone(rs.getString("AGENCY_PHONE")).build();
				list.add(a);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
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
}
