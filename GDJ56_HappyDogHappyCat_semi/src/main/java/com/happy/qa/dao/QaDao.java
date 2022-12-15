package com.happy.qa.dao;

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

import com.happy.admission.dao.AdmissionDao;
import com.happy.admission.vo.AdmissionForm;
import com.happy.animal.model.vo.Animal;
import com.happy.qa.vo.QaComment;
import com.happy.qa.vo.QaForm;

public class QaDao {
	private Properties sql=new Properties();
	
	//경로지정 
	public QaDao() {
		String path=AdmissionDao.class
				.getResource("/sql/qa/qa_sql.properties")
				.getPath();
		try {
			sql.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int enrollQa(Connection conn, QaForm qa,int memberNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollQa"));
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, qa.getQaContents());
			pstmt.setString(3, String.valueOf(qa.getQaOpenYn()));
			pstmt.setInt(4, qa.getQaPassword());
			pstmt.setString(5, qa.getQaTitle());

			result=pstmt.executeUpdate();
			System.out.println(result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

	public List<QaForm> selectQaList(Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<QaForm> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectQaList"));
			pstmt.setInt(1, (cPage-1)*numPerpage+1);
			pstmt.setInt(2, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(getQa(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}

	private QaForm getQa(ResultSet rs) throws SQLException{
		return QaForm.builder()
				.qaBoardNo(rs.getInt("qa_board_no"))
				.memberNo(rs.getInt("member_no"))
				.qaTitle(rs.getString("qa_title"))
				.qaContents(rs.getString("qa_contents"))
				.qaWriteDate(rs.getDate("qa_writer_date"))
				.qaDeleteYn(rs.getString("qa_del_yn").charAt(0))
				.qaReply(rs.getString("qa_reply"))
				.qaOpenYn(rs.getString("qa_open_yn").charAt(0))
				.qaPassword(rs.getInt("qa_pw"))
				.build();
	
	}


	public int selectQaCount(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectQaCount"));
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	public QaForm QaView(Connection conn, int qaNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		QaForm q=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("qaView"));
			pstmt.setInt(1, qaNo);
			rs=pstmt.executeQuery();
			if(rs.next()) q=getQa(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return q;
	}

	public int enrollComment(Connection conn, QaComment qc) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("enrollComment"));
			pstmt.setInt(1, qc.getQaBoardNo());
			pstmt.setString(2, qc.getQaCommentWriteContent());
			result=pstmt.executeUpdate();
			System.out.println(result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	

}
