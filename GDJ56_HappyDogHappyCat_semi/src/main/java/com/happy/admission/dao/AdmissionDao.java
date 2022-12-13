package com.happy.admission.dao;

import static com.happy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.happy.admission.vo.AdmissionForm;
import com.happy.animal.model.vo.Animal;


public class AdmissionDao {
	private Properties sql=new Properties();
	
	//경로지정 
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
	
	//동물 데이터 저장 
	public int enrollAnimal(Connection conn, Animal ani) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollAnimal"));
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
			System.out.println(result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	//동물번호
	public int selectAniNo(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int aniNo=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectAniNo"));
			rs=pstmt.executeQuery();
			aniNo=rs.getInt("no");
			System.out.println(aniNo);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return aniNo;
	
	}
	
	//입소데이터 저장 
	public int enrollAdmission(Connection conn,int aniNo, String hopeDate) {
		PreparedStatement pstmt=null;
		int result=0;
		AdmissionForm ad=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollAdmission"));
			pstmt.setInt(1, aniNo);
			pstmt.setString(2, hopeDate);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

	

}


