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

import com.happy.vol.model.vo.Agency;
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
			pstmt.setString(1, v.getVntRecName());
			pstmt.setString(2,v.getVntManagerName());
			pstmt.setDate(3,v.getVntRecPeriod());
			pstmt.setDate(4,v.getVntActPeriod());
			pstmt.setString(5, v.getVntActDay());
			pstmt.setString(6,v.getVntActContents());
			pstmt.setInt(7, v.getVntSetPerson());
			pstmt.setDate(8, v.getVntRecPeriodEnd());
			pstmt.setDate(9,v.getVntRecPeriodEnd());
			pstmt.setDate(10,v.getVntActPeriodEnd());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
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

}
