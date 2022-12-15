package com.happy.admission.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;
import static com.happy.common.JDBCTemplate.close;

import java.sql.Connection;
import java.util.List;

import com.happy.admission.dao.AdmissionDao;
import com.happy.admission.vo.AdmissionForm;
import com.happy.animal.model.vo.Animal;



public class AdmissionService {
	
	private AdmissionDao dao=new AdmissionDao();
	
	//동물,입소 데이터 보내는 서비스 
	public int enrollAnimal(Animal ani, String hopeDate,int memberNo) {
		Connection conn=getConnection();
		int result=dao.enrollAnimal(conn,ani);
		int result2=0;
		if(result>0) {
			int aniNo=dao.selectAniNo(conn);
			
			result2=dao.enrollAdmission(conn, aniNo, hopeDate,memberNo);
					
			if(result2>0)commit(conn);
			else rollback(conn);
		} 
		close(conn);
		return result2;
		
	}

	//입소목록 조회해주는 서비스 
	public List<AdmissionForm> selectAdmissionList(int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<AdmissionForm> list=dao.selectAdmissionList(conn,cPage, numPerpage);
		close(conn);
		return list;
	}

	//페이지바 만드는 서비스
	public int selectAdmissionCount() {
		Connection conn=getConnection();
		int result=dao.selectAdmissionCount(conn);
		close(conn);
		return result;
	}
	//입소동물 상세보기 
	public Animal admissionView(int admissionNo) {
		Connection conn=getConnection();
		Animal ani=dao.admissionView(conn,admissionNo);
		close(conn);
		return ani;
	}


	

}
