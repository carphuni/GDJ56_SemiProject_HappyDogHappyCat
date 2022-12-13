package com.happy.adopt.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.happy.adopt.model.dao.AdoptDao;
import com.happy.animal.model.vo.Animal;

public class AdoptService {
	
	private AdoptDao dao=new AdoptDao();
	
	public List<Animal> adoptMainAniAll(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<Animal> aniList =dao.adoptMainAniAll(conn,cPage,numPerpage);
		close(conn);	
		return aniList;
	}
	
	public int adoptMainAniAllCount() {
		Connection conn=getConnection();
		int result=dao.adoptMainAniAllCount(conn);
		close(conn);
		return result;
	}
	
	public Animal adoptDesAni(int aniNo) {
		Connection conn=getConnection();
		Animal ani=dao.adoptDesAni(conn,aniNo);
		close(conn);
		return ani;
	}
	
	
}
