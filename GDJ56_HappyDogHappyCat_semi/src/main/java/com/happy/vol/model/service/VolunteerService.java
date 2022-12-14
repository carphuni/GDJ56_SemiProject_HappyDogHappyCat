package com.happy.vol.model.service;

import static com.happy.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

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
			close(conn);
		}
		return result2;
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
	
}			
			
			
		
		
	
	

