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
import com.happy.admission.vo.AnimalPhoto;
import com.happy.animal.model.vo.Animal;
import com.happy.qa.vo.QaPhoto;



public class AdmissionService {
	
	private AdmissionDao dao=new AdmissionDao();
	
	//동물,입소 데이터 보내는 서비스 
	public int enrollAnimal(Animal ani, String hopeDate,int memberNo,List<AnimalPhoto> fileList) {
		Connection conn=getConnection();
		int result=dao.enrollAnimal(conn,ani,fileList);
		int result2=0;
		int result3=0;
		if(result>0) {
			int aniNo=dao.selectAniNo(conn);
			result3=dao.enrollAdmission(conn, aniNo, hopeDate, memberNo);
			if(!fileList.isEmpty()|| fileList !=null) {
				
				for(AnimalPhoto ap : fileList) {
					result2+=dao.insertAniPhoto(conn, aniNo, ap);
				}
				
			}
			
			close(conn);		
		}else{
			rollback(conn);
		} 
		return result;
		
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

	public List<AnimalPhoto> selectAnimalPhoto(int admissionNo) {
		Connection conn = getConnection();
		List<AnimalPhoto> ap = dao.selectAnimalPhoto(conn,admissionNo);
		close(conn);
		return ap;
	}


	

}
