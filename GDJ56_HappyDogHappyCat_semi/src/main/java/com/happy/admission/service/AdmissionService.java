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
				
				for(int i=0;i<fileList.size();i++) {
					if(i==0) fileList.get(i).setMainPhoto("Y");
					result2+=dao.insertAniPhoto(conn, aniNo, fileList.get(i));
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

	public List<AdmissionForm> selectMyAdmission(int  memberNo,int cPage, int numPerpage) {
		Connection conn=getConnection();
		List<AdmissionForm> list=dao.selectMyAdmission(conn,cPage, numPerpage, memberNo);
		close(conn);
		return list;
	}

	public AdmissionForm selectAdmission(int admissionNo) {
		Connection conn=getConnection();
		AdmissionForm af=dao.selectAdmission(conn,admissionNo);
		close(conn);
		return af;
	}

	public Animal admissionMyPageView(int admissionNo) {
		Connection conn=getConnection();
		Animal ani=dao.admissionMyPageView(conn,admissionNo);
		close(conn);
		return ani;
	
	}

	public int deleteAnimal(int aniNo,int admissionNo) {
		Connection conn=getConnection();
		int result1=dao.deleteAnimalPhoto(conn,aniNo);
		int result2=0;
		int result3=0;
		System.out.println("ㅎ2"+result1);
		if(result1>0) {
			result2=dao.deleteAdmission(conn,admissionNo);
			System.out.println("ㅎ22"+result2);	
			if(result2>0) {
				result3=dao.deleteAnimal(conn, aniNo);
				System.out.println("ㅎ23"+result3);		
			}
		}
		close(conn);
		return result3;
	}

	
	


	

}
