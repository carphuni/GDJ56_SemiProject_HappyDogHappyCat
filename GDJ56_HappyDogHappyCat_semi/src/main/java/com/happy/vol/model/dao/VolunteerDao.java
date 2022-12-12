package com.happy.vol.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.happy.vol.model.vo.Volunteer;
import static com.happy.common.JDBCTemplate.*;
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
	
	

}
