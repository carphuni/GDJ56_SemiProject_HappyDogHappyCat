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
import com.happy.qa.vo.QaPhoto;
import com.happy.vol.model.vo.VolPhoto;


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

	public int enrollQa(Connection conn, QaForm qa,int memberNo,List<QaPhoto> fileList) {
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
				QaForm f=getQa(rs);
				f.setMemberId(rs.getString("member_id"));
				list.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}

	private static QaForm getQa(ResultSet rs) throws SQLException{
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
				.qaReadCount(rs.getInt("qa_read_count"))
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

	public List<QaComment> selectCommentList(Connection conn,int BoardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<QaComment> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectCommentList"));
			pstmt.setInt(1,BoardNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				list.add(getQaComment(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}

	
	private QaComment getQaComment(ResultSet rs)throws SQLException {
		return QaComment.builder()
		.qaCommentNo(rs.getInt("qa_comment_no"))
		.qaBoardNo(rs.getInt("qa_board_no"))
		.qaCommentWriteDate(rs.getDate("qa_comment_write_date"))
		.qaCommentWriteContent(rs.getString("qa_comment_write_content"))
		.qaCommentDelYn(rs.getString("qa_comment_del_yn").charAt(0))
		.qaCommentModDate(rs.getDate("qa_comment_mod_date"))
		.build();
	}

	public int updateReadCount(Connection conn, int qaNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("updateReadCount"));
			pstmt.setInt(1, qaNo);
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

	public int insertQaPhoto(Connection conn, int qaNo, QaPhoto qp) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("insertQaPhoto"));
			pstmt.setInt(1, qaNo);
			pstmt.setString(2, qp.getQaPhotoOriName());
			pstmt.setString(3, qp.getQaPhotoReName());
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	public int selectQaNo(Connection conn) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int qaNo=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectqaNo"));
			rs=pstmt.executeQuery();
			if(rs.next()) qaNo=rs.getInt("QA_NO");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return qaNo;
	}

	public List<QaPhoto> selectQaPhoto(Connection conn, int qaNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		QaPhoto q = null;
		List<QaPhoto> qp= new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectQaPhoto"));
			pstmt.setInt(1, qaNo);
			rs=pstmt.executeQuery();
			while(rs.next()) {
					q=QaPhoto.builder()
					.photoNo(rs.getInt("qa_photo_no"))
					.qaPhotoOriName(rs.getString("qa_phto_oriname"))
					.qaPhotoReName(rs.getString("qa_photo_rename"))
					.build();
					
					qp.add(q);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return qp;
	}

	public List<QaForm> selectQaList(String keyword, Connection conn, int cPage, int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<QaForm> result=new ArrayList();
		String query=sql.getProperty("searchKeyword");

		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				result.add(QaDao.getQa(rs));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	public int selectMemberCount(Connection conn, String keyword) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		String query=sql.getProperty("searchCountKeyword");
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,"%"+keyword+"%");
			rs=pstmt.executeQuery();
			if(rs.next()) result=rs.getInt(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return result;
	}

	public QaForm selectQaForm(Connection conn, int qaBoardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		QaForm q=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectQaForm"));
			pstmt.setInt(1, qaBoardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) q=getQa(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return q;
	}

	public QaForm realView(Connection conn, int boardNo) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		QaForm q=null;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("realView"));
			pstmt.setInt(1, boardNo);
			rs=pstmt.executeQuery();
			if(rs.next()) q=getQa(rs);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return q;
	}

	public List<QaForm> selectMyQa(Connection conn, int memberNo, int cPage, int numPerpage) {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<QaForm> list=new ArrayList();
		try {
			pstmt=conn.prepareStatement(sql.getProperty("selectMyQa"));
			pstmt.setInt(1, memberNo);
			pstmt.setInt(2, (cPage-1)*numPerpage+1);
			pstmt.setInt(3, cPage*numPerpage);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				QaForm f=getQa(rs);
				f.setMemberId(rs.getString("member_id"));
				list.add(f);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}return list;
	}

	public int deleteQaPhoto(Connection conn, int qaNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteQaPhoto"));
			pstmt.setInt(1,qaNo);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}
	
	
	public int deleteQaForm(Connection conn, int qaNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("deleteQaForm"));
			pstmt.setInt(1,qaNo);
			result=pstmt.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

	public int modifyQa(Connection conn, QaForm qa, int qaNo) {
		PreparedStatement pstmt=null;
		int result=0;
		try {
			pstmt=conn.prepareStatement(sql.getProperty("modifyQa"));
			pstmt.setString(1,qa.getQaContents());
			pstmt.setString(2,String.valueOf( qa.getQaOpenYn()));
			pstmt.setInt(3, qa.getQaPassword());
			pstmt.setString(4, qa.getQaTitle());
			pstmt.setInt(5, qaNo);

			result=pstmt.executeUpdate();
			System.out.println(result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}return result;
	}

	

}
