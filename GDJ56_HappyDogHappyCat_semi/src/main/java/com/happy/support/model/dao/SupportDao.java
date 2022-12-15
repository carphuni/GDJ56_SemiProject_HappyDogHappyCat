package com.happy.support.model.dao;

import static com.happy.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.happy.support.model.vo.Support;


public class SupportDao {
	
	private Properties sql= new Properties();
		
		public SupportDao() {
			String path=SupportDao.class.getResource("/sql/support/support_sql.properties").getPath();
			try {
				sql.load(new FileReader(path));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public int insertSupport(Connection conn, Support s) {
			PreparedStatement pstmt=null;
			int result=0;
			try {
				pstmt=conn.prepareStatement(sql.getProperty("insertSupport"));
				pstmt.setString(1, s.getSupTitle());
				pstmt.setInt(2,s.getSupTargetAmount());
				pstmt.setString(3,s.getSupContents());
				result=pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}return result;
		}
	

}
