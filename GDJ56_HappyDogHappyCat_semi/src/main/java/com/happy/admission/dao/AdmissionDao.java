package com.happy.admission.dao;

import static com.happy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.happy.animal.model.vo.Animal;


public class AdmissionDao {
	private Properties sql=new Properties();
	
	public AdmissionDao() {
		String path=AdmissionDao.class
				.getResource("/sql/admission/admission_sql.properties")
				.getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int enrollAdmission(Connection conn, Animal ani,String hopeDate) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollAdmission"));
			pstmt.setString(1, ani.getAniName());
			pstmt.setString(2, ani.getAniType());
			pstmt.setString(3, ani.getAniKind());
			pstmt.setString(4, ani.getAniSize());
			pstmt.setString(5, String.valueOf(ani.getAniGender()));
			pstmt.setInt(6, ani.getAniAge());
			pstmt.setString(7, String.join(",", ani.getVcnStat()));
			pstmt.setString(8, String.valueOf(ani.getAniNeuYn()));
			pstmt.setString(9, ani.getAniChar());
			pstmt.setString(10,ani.getAniColor());
			pstmt.setString(11,ani.getAniSpecial());
			pstmt.setString(12,ani.getAniReason());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

}
