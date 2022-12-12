package com.happy.vol.model.service;

import static com.happy.common.JDBCTemplate.*;

import java.sql.Connection;

import com.happy.vol.model.dao.VolunteerDao;
import com.happy.vol.model.vo.Volunteer;
public class VolunteerService {
	
	private VolunteerDao vd = new VolunteerDao();
	
	
	public int insertVolunteer(Volunteer v) {
		Connection conn=getConnection();
		int result=vd.insertVolunteer(conn, v);
		if(result>0) commit(conn);
		close(conn);
		return result;
		
	}
	
	

}
