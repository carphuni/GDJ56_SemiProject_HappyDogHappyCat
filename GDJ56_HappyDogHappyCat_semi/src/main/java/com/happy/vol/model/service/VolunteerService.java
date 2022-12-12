package com.happy.vol.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.happy.vol.model.dao.VolunteerDao;
import com.happy.vol.model.vo.Volunteer;
public class VolunteerService {
	
	private VolunteerDao vd = new VolunteerDao();
	
	
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
	
	
	public int insertVolunteer(Volunteer v) {
		Connection conn=getConnection();
		int result=vd.insertVolunteer(conn, v);
		if(result>0) commit(conn);
		close(conn);
		return result;
		
	}
	
	

}
