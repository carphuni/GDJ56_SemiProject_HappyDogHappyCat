package com.happy.qa.service;

import com.happy.animal.model.vo.Animal;
import com.happy.qa.dao.QaDao;
import com.happy.qa.vo.QaComment;
import com.happy.qa.vo.QaForm;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;
import com.happy.qa.vo.QaForm;

public class QaService {
	
	private QaDao dao=new QaDao();

	public int enrollQa(QaForm qa,int memberNo) {
		Connection conn=getConnection();
		int result=dao.enrollQa(conn,qa,memberNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}close(conn);
		return result;
	}

	public List<QaForm> selectQaList(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<QaForm> list=dao.selectQaList(conn,cPage,numPerpage);
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

	
	
	
	
	
	
	
}
