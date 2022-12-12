package com.happy.adopt.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import static com.happy.common.JDBCTemplate.*;
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
              .build();
  }
} 
