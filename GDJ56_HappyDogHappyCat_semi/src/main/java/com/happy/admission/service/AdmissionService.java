package com.happy.admission.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;
import static com.happy.common.JDBCTemplate.close;

import java.sql.Connection;

import com.happy.admission.dao.AdmissionDao;
import com.happy.animal.model.vo.Animal;

public class AdmissionService {
	
	private AdmissionDao dao=new AdmissionDao();
	
	public int enrollAdmission(Animal ani,String hopeDate) {
		Connection conn=getConnection();
		int result=dao.enrollAdmission(conn,ani,hopeDate);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}

}
