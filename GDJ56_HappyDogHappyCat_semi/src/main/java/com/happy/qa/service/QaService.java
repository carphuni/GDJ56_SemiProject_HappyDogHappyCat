package com.happy.qa.service;

import com.happy.qa.dao.QaDao;
import com.happy.qa.vo.QaForm;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

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

	
	
	
	
	
	
	
}
