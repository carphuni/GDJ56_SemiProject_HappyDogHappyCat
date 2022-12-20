package com.happy.volreview.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.happy.vol.model.vo.VolPhoto;
import com.happy.volreview.model.dao.VolReviewDao;
import com.happy.volreview.model.vo.VolReview;
import com.happy.volreview.model.vo.VolReviewPhoto;

public class VolReviewService {
	
	private VolReviewDao vrd = new VolReviewDao();
	
	public List<VolReview> selectVolunteerList(int cPage, int numPerpage){
		Connection conn=getConnection();
		List<VolReview> list = vrd.selectVolReviewList(conn, cPage, numPerpage);
		close(conn);
		return list;
	}
	
	public int selectVolReviewCount() {
		Connection conn=getConnection();
		int result=vrd.selectVolReviewCount(conn);
		close(conn);
		return result;
	}
	
	public VolReview selectVolReview(int boardNo) {
		Connection conn = getConnection();
		VolReview vr = vrd.selectVolReview(conn, boardNo);
		close(conn);
		return vr;
		
		
	}
	
	public int insertVolReview(VolReview vr, List<VolReviewPhoto> fileList) {
		Connection conn=getConnection();
		int result=vrd.insertVolReview(conn, vr);
		int result2=0;
		if(result>0) {
			for(VolReviewPhoto vrp : fileList) {
				result2+=vrd.insertVolReviewPhoto(conn,vr.getVntBoardNo(),vrp);
			}
			if(result2==fileList.size())commit(conn);
			else rollback(conn);
			close(conn);
		}else {
			rollback(conn);
		}
		return result2;
	}
		
	public VolReviewPhoto selectVolReviewPhoto(int boardNo) {
		Connection conn = getConnection();
		VolReviewPhoto vrp = vrd.selectVolReviewPhoto(conn, boardNo);
		close(conn);
		return vrp;
	}
	
	
	
	public List<VolReviewPhoto> selectVolReviewPhoto2(int boardNo) {
		Connection conn = getConnection();
		List<VolReviewPhoto> vrp = vrd.selectVolReviewPhoto2(conn, boardNo);
		close(conn);
		return vrp;
	}	
	
	
	
	
		
}
	
	

