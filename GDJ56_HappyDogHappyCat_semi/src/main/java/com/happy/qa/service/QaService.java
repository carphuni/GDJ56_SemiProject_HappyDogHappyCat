package com.happy.qa.service;

import com.happy.animal.model.vo.Animal;
import com.happy.qa.dao.QaDao;
import com.happy.qa.vo.QaComment;
import com.happy.qa.vo.QaForm;
import com.happy.qa.vo.QaPhoto;
import com.happy.vol.model.vo.VolPhoto;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;


import java.sql.Connection;
import java.util.List;
import com.happy.qa.vo.QaForm;

public class QaService {
	
	private QaDao dao=new QaDao();

	public int enrollQa(QaForm qa,int memberNo,List<QaPhoto> fileList) {
		Connection conn=getConnection();
		int result=dao.enrollQa(conn,qa,memberNo,fileList);
		int result2=0;
		if(result>0) {
			int QaNo=dao.selectQaNo(conn);
			if(!fileList.isEmpty() || fileList != null) {
				
				for(QaPhoto qp : fileList) {
					result2+=dao.insertQaPhoto(conn,QaNo,qp);
				}
			}
			/*if(result2==fileList.size())commit(conn);
			else rollback(conn);*/
			close(conn);
		}else {
			rollback(conn);
		}
		return result;
	}

	public List<QaForm> selectQaList(String keyword,int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<QaForm> list=dao.selectQaList(keyword,conn,cPage,numPerpage);
		close(conn);
		return list;
	}
	
	public int selectQaCount() {
		Connection conn=getConnection();
		int result=dao.selectQaCount(conn);
		close(conn);
		return result;
	}

	public QaForm QaView(int qaNo,boolean readflag) {
		Connection conn=getConnection();
		QaForm q=dao.QaView(conn,qaNo);
		if(q!=null&&!readflag) {
			int result=dao.updateReadCount(conn,qaNo);
			if(result>0) {
				commit(conn);
				q.setQaReadCount(q.getQaReadCount()+1);
			}
			else rollback(conn);
		}
		close(conn);
		return q ;
	}

	public int enrollComment(QaComment qc) {
		Connection conn=getConnection();
		int result=dao.enrollComment(conn,qc);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}close(conn);
		return result;
	}

	public  List<QaComment> selectCommentList(int BoardNo) {
		Connection conn=getConnection();
		List<QaComment> list=dao.selectCommentList(conn,BoardNo);
		close(conn);
		return list;
	}

	public List<QaPhoto> selectQaPhoto(int qaNo) {
		Connection conn = getConnection();
		List<QaPhoto> qp = dao.selectQaPhoto(conn, qaNo);
		close(conn);
		return qp;
	}

	public int selectQaCount(String keyword) {
		Connection conn=getConnection();
		int result=dao.selectMemberCount(conn,keyword);
		close(conn);
		return result;
	}

	public List<QaForm> selectQaList(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<QaForm> list=dao.selectQaList(conn,cPage,numPerpage);
		close(conn);
		return list;
	}

	public QaForm selectQaForm(int qaBoardNo) {
		Connection conn=getConnection();
		QaForm q=dao.selectQaForm(conn,qaBoardNo);
		close(conn);
		return q;
	}

	public QaForm realView(int boardNo) {
		Connection conn=getConnection();
		QaForm q=dao.realView(conn,boardNo);
		close(conn);
		return q;
	}

	public List<QaForm> selectMyQa(int memberNo, int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<QaForm> list=dao.selectMyQa(conn,memberNo,cPage,numPerpage);
		close(conn);
		return list;
	}

	
	
	
	
	
	
	
}
