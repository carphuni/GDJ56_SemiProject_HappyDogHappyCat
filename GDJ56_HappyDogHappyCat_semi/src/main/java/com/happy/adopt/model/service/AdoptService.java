package com.happy.adopt.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.happy.adopt.model.dao.AdoptDao;
import com.happy.adopt.model.vo.AdtBorad;
import com.happy.adopt.model.vo.AdtReviewBorad;
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
	
	public int adoptWrite(AdtBorad ab) {
		Connection conn=getConnection();
		int result=dao.adoptWrite(conn,ab);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int adoptReviewWrite(AdtReviewBorad arb) {
		Connection conn=getConnection();
		int result=dao.adoptReviewWrite(conn,arb);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public List<AdtReviewBorad> adoptReviewAll(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<AdtReviewBorad> rList =dao.adoptReviewAll(conn,cPage,numPerpage);
		close(conn);	
		return rList;
	}
	
	public int adoptReviewAllCount(){
		Connection conn=getConnection();
		int result=dao.adoptReviewAllCount(conn);
		close(conn);
		return result;
	}
	
	public AdtReviewBorad adoptReviewDes(int adpBoardNo){
		Connection conn=getConnection();
		AdtReviewBorad arb=dao.adoptReviewDes(conn,adpBoardNo);
		close(conn);
		return arb;
	}
	
	public int adoptAddPick(int memberNo,int aniNo) {
		Connection conn=getConnection();
		int result=dao.adoptAddPick(conn,memberNo,aniNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public int adoptDeletePick(int memberNo,int aniNo) {
		Connection conn=getConnection();
		int result=dao.adoptDeletePick(conn,memberNo,aniNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	

}
