package com.happy.adopt.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.happy.adopt.model.dao.AdoptDao;
import com.happy.adopt.model.vo.AdoptPhoto;
import com.happy.adopt.model.vo.AdtBorad;
import com.happy.adopt.model.vo.AdtReviewBorad;
import com.happy.adopt.model.vo.AdtReviewComment;
import com.happy.adopt.model.vo.AnimalPick;
import com.happy.animal.model.vo.Animal;
import com.happy.vol.model.vo.VolPhoto;

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
	
	public Animal adoptDesAni(int aniNo,boolean readflag) {
		Connection conn=getConnection();
		Animal ani=dao.adoptDesAni(conn,aniNo);
		if(ani!=null&&!readflag) { 
			int result=dao.updateReadCount(conn,aniNo);
			if(result>0) {
				commit(conn);
				ani.setAdtViews(ani.getAdtViews()+1);
			}
			else rollback(conn);
		}
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
	
	public int adoptReviewWrite(AdtReviewBorad arb, List<AdoptPhoto> fileList) {
		Connection conn=getConnection();
		int result=dao.adoptReviewWrite(conn,arb);
		int result2=0;
		if(result>0) {
			int reviewBoardNo=dao.selectReviewNo(conn);
			for(AdoptPhoto ap : fileList) {
				result2+=dao.insertAptPhoto(conn,reviewBoardNo,ap);
			}
			if(result2==fileList.size())commit(conn);
			else rollback(conn);
			close(conn);
		}
		return result2;
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
	
	public AdtReviewBorad adoptReviewDes(int adpBoardNo,boolean readflag){
		Connection conn=getConnection();
		AdtReviewBorad arb=dao.adoptReviewDes(conn,adpBoardNo);
		if(arb!=null&&!readflag) { 
			int result=dao.updateReviewReadCount(conn,adpBoardNo);
			if(result>0) {
				commit(conn);
				arb.setAdtViews(arb.getAdtViews()+1);
			}
			else rollback(conn);
		}
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
	
	public List<AnimalPick> adoptPickAll(int memberNo){
		Connection conn=getConnection();
		List<AnimalPick> pList =dao.adoptPickAll(conn,memberNo);
		close(conn);	
		return pList;
	}
	
	public int adoptComment(String reply,String memberId,int reviewBoardNo) {
		Connection conn=getConnection();
		int result=dao.adoptComment(conn,reply,memberId,reviewBoardNo);
		if(result>0) commit(conn);
		else rollback(conn);
		close(conn);
		return result;
	}
	
	public List<AdtReviewComment> adoptReviewCommentAll(int adpBoardNo){
		Connection conn=getConnection();
		List<AdtReviewComment> cList =dao.adoptReviewCommentAll(conn,adpBoardNo);
		close(conn);	
		return cList;
	}
	
	public List<AdoptPhoto> adtPhotoAll(int adpBoardNo){
		Connection conn=getConnection();
		List<AdoptPhoto> photoList =dao.adtPhotoAll(conn,adpBoardNo);
		close(conn);	
		return photoList;
	}
	
	public List<AdtReviewBorad> adoptReviewSearch(int cPage, int numPerpage,String keyword){
		Connection conn=getConnection();
		List<AdtReviewBorad> rList =dao.adoptReviewSearch(conn,cPage,numPerpage,keyword);
		close(conn);	
		return rList;
	}
	
	public int adoptReviewSearchCount(String keyword){
		Connection conn=getConnection();
		int result=dao.adoptReviewSearchCount(conn,keyword);
		close(conn);
		return result;
	}
	
	public List<Animal> adoptMainSearch(int cPage, int numPerpage,String keyword){
		Connection conn=getConnection();
		List<Animal> aniList =dao.adoptMainSearch(conn,cPage,numPerpage,keyword);
		close(conn);	
		return aniList;
	}
	
	public int adoptMainSearchCount(String keyword){
		Connection conn=getConnection();
		int result=dao.adoptMainSearchCount(conn,keyword);
		close(conn);
		return result;
	}
	
	public List<AdtBorad> hopeDateAll(){
		Connection conn=getConnection();
		List<AdtBorad> hopeDate =dao.hopeDateAll(conn);
		close(conn);	
		return hopeDate;
	}
	
	public List<AdtBorad> adoptBoardList(int cPage, int numPerpage,int memberNo){
		Connection conn=getConnection();
		List<AdtBorad> adtBoardList =dao.adoptBoardList(conn,cPage,numPerpage,memberNo);
		close(conn);	
		return adtBoardList;
	}
	
	public int adoptBoardListCount(int memberNo){
		Connection conn=getConnection();
		int result=dao.adoptBoardListCount(conn,memberNo);
		close(conn);
		return result;
	}
	
	public AdtBorad adoptBoardDes(int adtBoardNo){
		Connection conn=getConnection();
		AdtBorad ab =dao.adoptBoardDes(conn,adtBoardNo);
		close(conn);	
		return ab;
	}
	
	
	 public int adoptBoardUpdate(AdtBorad ab){ 
		 Connection conn=getConnection();
		 int result =dao.adoptBoardUpdate(conn,ab); 
		 if(result>0) commit(conn);
		 else rollback(conn); 
		 close(conn); 
		 return result; 
		}
	  
	 public int adoptBoardDelete(int adtBoardNo){ 
		 Connection conn=getConnection();
		 int result =dao.adoptBoardDelete(conn,adtBoardNo); 
		 if(result>0) commit(conn);
		 else rollback(conn); 
		 close(conn); 
		 return result; 
	}
	 
	 /*public int adoptReviewBoardUpdate(int adtBoardNo){ Connection
	 * conn=getConnection(); int result
	 * =dao.adoptReviewBoardUpdate(conn,adtBoardNo); if(result>0) commit(conn); else
	 * rollback(conn); close(conn); return result; }
	 * 
	 * public int adoptReviewBoardDelete(int adtBoardNo){ Connection
	 * conn=getConnection(); int result
	 * =dao.adoptReviewBoardDelete(conn,adtBoardNo); if(result>0) commit(conn); else
	 * rollback(conn); close(conn); return result; }
	 */
}
