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
	
	public int enrollAnimal(Animal ani, String hopeDate) {
		Connection conn=getConnection();
		int result=dao.enrollAnimal(conn,ani);
		int result2=0;
		if(result>0) {
			int aniNo=dao.selectAniNo(conn);
			
			result2=dao.enrollAdmission(conn, aniNo, hopeDate);
					
			if(result2>0)commit(conn);
			else rollback(conn);
		} 
		close(conn);
		return result2;
		
	}


	

}
