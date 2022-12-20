package com.happy.volreview.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;
import com.happy.volreview.model.dao.VolReviewDao;
import com.happy.volreview.model.vo.VolComment;
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
	
	public VolReview selectVolReview(int boardNo, boolean readflag) {
		Connection conn = getConnection();
		VolReview vr = vrd.selectVolReview(conn, boardNo);
		if(vr!=null&&!readflag) {
			int result = vrd.updateReadCount(conn, boardNo);
			if(result>0) {
				commit(conn);
				vr.setVntReviewViews(vr.getVntReviewViews()+1);	
			}
			else rollback(conn);
		}
		close(conn);
		return vr;			
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
			int volNo=vrd.selectVolReviewNo(conn);
			for(VolReviewPhoto vrp : fileList) {
				result2+=vrd.insertVolReviewPhoto(conn,volNo,vrp);
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
	
	public int insertComment(String reply,String memberId, int boardNo ) {
		Connection conn = getConnection();
		int result = vrd.insertComment(conn, reply, memberId, boardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
		
	}
	
	public List<VolComment> selectCommentList(int boradNo){
		Connection conn =getConnection();
		List<VolComment> cList = vrd.selectCommentList(conn, boradNo);
		close(conn);
		return cList;
	
	}
	

	public List<VolReview> volReviewSearch(int cPage,int numPerpage, String keyword){
		Connection conn = getConnection();
		List<VolReview> vList = vrd.volReviewSearch(conn, cPage, numPerpage, keyword);
		close(conn);
		return vList;
	}
	
	public int volReviewSearchCount(String keyword) {
		Connection conn=getConnection();
		int result=vrd.volReviewSearchCount(conn, keyword);
		close(conn);
		return result;
		
	}
	
	public int deleteVolReview(int vntBoardNo) {
		Connection conn=getConnection();
		int result = vrd.deleteVolReview(conn, vntBoardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
		
	}
	

	public int updateVolReview(VolReview vr, List<VolReviewPhoto> fileList) {
		Connection conn=getConnection();
		int result= vrd.updateVolReview(conn, vr);
		int result2=0;
		if(result>0) {
			for(VolReviewPhoto vp : fileList) {
				result2+=vrd.insertVolReviewPhoto(conn,vr.getVntBoardNo(),vp);
			}	
			if(result2==fileList.size())commit(conn);
		}else {
			rollback(conn);
		}close(conn);
		return result2;
	
	}
	public int deleteReviewPhoto(int boardNo) {
		Connection conn = getConnection();
		int result = vrd.deleteReviewPhoto(conn, boardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		return result;
		
		
		
	}
		
}
	
	

