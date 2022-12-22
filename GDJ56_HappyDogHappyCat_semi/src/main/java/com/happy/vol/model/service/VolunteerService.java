package com.happy.vol.model.service;

import static com.happy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import org.eclipse.jdt.core.compiler.CharOperation;

import com.happy.vol.model.dao.VolunteerDao;
import com.happy.vol.model.vo.Agency;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;
public class VolunteerService {
	
	private VolunteerDao vd = new VolunteerDao();
	
	public Agency selectAgency(int agencyNo) {
		Connection conn=getConnection();
		Agency a = vd.selectAgency(conn, agencyNo);
		close(conn);
		return a;
	}
	
	
	public Agency selectAgency2(int memberNo) {
		Connection conn=getConnection();
		Agency a = vd.selectAgency2(conn, memberNo);
		close(conn);
		return a;
	}
	
	
	public VolPhoto selectVolPhoto(int vntBoardNo) {
		Connection conn = getConnection();
		VolPhoto vp = vd.selectVolPhoto(conn, vntBoardNo);
		close(conn);
		return vp;
	}
	
	public Volunteer selectVolunteer(int boardNo, boolean readflag) {
		Connection conn = getConnection();
		Volunteer v = vd.selectVolunteer(conn, boardNo);
		if(v!=null&&!readflag) {
			int result = vd.updateReadCount(conn, boardNo);
			if(result>0) {
				commit(conn);
				v.setVntActViews(v.getVntActViews()+1);	
			}
			else rollback(conn);
		}
		close(conn);
		return v;
	}
	
	public Volunteer selectVolunteer(int boardNo) {
		Connection conn = getConnection();
		Volunteer v = vd.selectVolunteer(conn, boardNo);
		close(conn);
		return v;
	}
	
	
	
	
	public List<VolPhoto> selectVolPhoto2(int vntBoardNo) {
		Connection conn = getConnection();
		List<VolPhoto> vp = vd.selectVolPhoto2(conn, vntBoardNo);
		close(conn);
		return vp;
	}
	
	
	public List<Volunteer> selectVolunteerList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Volunteer> list = vd.selectVolunteerList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	
	
	
	public int selectVolunteerCount() {
		Connection conn=getConnection();
		int result=vd.selectVolunteerCount(conn);
		close(conn);
		return result;
	}
	
	
	public int insertVolunteer(Volunteer v,List<VolPhoto> fileList) {
		Connection conn=getConnection();
		int result=vd.insertVolunteer(conn, v);
		int result2=0;
		if(result>0) {
			int volNo=vd.selectVolNo(conn);
			for(VolPhoto vp : fileList) {
				result2+=vd.insertVolPhoto(conn,volNo,vp);
			}
			if(result2==fileList.size())commit(conn);
			else rollback(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result2;
	}
	
	
	public int updateVol(Volunteer v,List<VolPhoto> fileList) {
		Connection conn=getConnection();
		int result= vd.updateVol(conn, v);
		int result2=0;
		if(result>0) {
			for(VolPhoto vp : fileList) {
				result2+=vd.insertVolPhoto(conn,v.getVntBoardNo(),vp);
			}	
			if(result2==fileList.size())commit(conn);
		}else {
			rollback(conn);
		}close(conn);
		return result2;
	
	}
	
	
	public int deleteVolPhoto(int boardNo) {
		Connection conn = getConnection();
		int result = vd.deleteVolPhoto(conn, boardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
		
		
		
	}
	
	public int updateVolPhoto(VolPhoto v, int boardNo) {
		Connection conn = getConnection();
		int result = vd.updateVolPhoto(conn, v, boardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
		
	}
	
	
	
	
	
	
	
	public int insertVolPhoto(int volNo,VolPhoto vp) {
		Connection conn=getConnection();
		int result = vd.insertVolPhoto(conn, volNo, vp);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int selectVolNo(){
		Connection conn=getConnection();
		int volNo = vd.selectVolNo(conn);
		close(conn);
		return volNo;
	}
	
	public List<Volunteer> volSearch(int cPage,int numPerpage, String keyword){
		Connection conn = getConnection();
		List<Volunteer> vList = vd.volSearch(conn, cPage, numPerpage, keyword);
		close(conn);
		return vList;
	}
	
	
	public List<Volunteer> myPageVolunteerList(int cPage,int numPerpage,int agencyNo){
		Connection conn = getConnection();
		List<Volunteer> vList = vd.myPageVolunteerList(conn, cPage, numPerpage, agencyNo);
		close(conn);
		return vList;
		
		
	}
	
	public int myPageVolunteerCount(int agencyNo) {
		Connection conn=getConnection();
		int result=vd.myPageVolunteerCount(conn, agencyNo);
		close(conn);
		return result;
		
	}
	
	public int volSearchCount(String keyword) {
		Connection conn=getConnection();
		int result=vd.volSearchCount(conn, keyword);
		close(conn);
		return result;
		
	}
	
	public int deleteVolunteer(int vntBoardNo) {
		Connection conn=getConnection();
		int result = vd.deleteVolunteer(conn, vntBoardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	

	
	
	public int updateVntEnr(int vntBoardNo) {
		Connection conn = getConnection();
		int result = vd.updateEnr(conn, vntBoardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	
	public int cancelVntEnr(int vntBoardNo) {
		Connection conn = getConnection();
		int result = vd.cancelEnr(conn, vntBoardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	
	public int insertEnr(int vntBoardNo, int memberNo) {
		Connection conn = getConnection();
		int result = vd.insertEnr(conn, vntBoardNo, memberNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	
	public int selectEnrCheck(int vntBoardNo, int memberNo ) {
		Connection conn = getConnection();
		int sp = vd.selectEnrCheck(conn, vntBoardNo, memberNo);
		close(conn);
		return sp;
	}
	
	public int selectEnrPerson(int vntBoardNo, int memberNo) {
		Connection conn = getConnection();
		int result = vd.selectEnrPerson(conn, vntBoardNo, memberNo);
		close(conn);
		return result;
		
	}
	
	
	public int updateEnrCheck(int vntBoardNo, int memberNo) {
		Connection conn = getConnection();
		int result = vd.updateEnrCheck(conn, vntBoardNo, memberNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int updateEnrCheckCancel(int vntBoardNo, int memberNo) {
		Connection conn = getConnection();
		int result = vd.updateEnrCheckCancel(conn, vntBoardNo, memberNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	//기관 가입
	public int enrollAgencyEnd(Agency agency, int memberNo) {
		Connection conn=getConnection();
		int result = vd.enrollAgencyEnd(conn, agency, memberNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	

	public List<Agency> selectAgency3(){
		Connection conn=getConnection();
		List<Agency> list = vd.selectAgency3(conn);
		close(conn);
		return list;
		
	}
}			
			
			
		
		
	
	

