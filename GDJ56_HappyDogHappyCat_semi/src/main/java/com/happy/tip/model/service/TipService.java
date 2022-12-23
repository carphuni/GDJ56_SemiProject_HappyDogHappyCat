package com.happy.tip.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.happy.tip.model.dao.TipDao;
import com.happy.tip.model.vo.TipBoard;
import com.happy.tip.model.vo.TipPhoto;
import com.happy.vol.model.vo.Agency;

public class TipService {
	private TipDao dao = new TipDao();
		
		public int tipWriteEnd(TipBoard tb , List<TipPhoto> fileList) {
			Connection conn=getConnection();
			int result = dao.insertTipBoard(conn, tb);
			int result2=0;
			if(result>0) {
				int tbNo=dao.selectTipBoardNo(conn);
				if(tbNo!=0) {
					for(TipPhoto tp : fileList) {
						result2+=dao.insertTipPhoto(conn, tbNo, tp);
					}
					if(result2==fileList.size())commit(conn);
					else rollback(conn);
				}
			}else rollback(conn);
			close(conn);
			return result2;
		}
		
		public List<TipBoard> selectTipBoardList(int cPage, int numPerpage){
			Connection conn=getConnection();
			List<TipBoard> tipBoardList = dao.selectTipBoardList(conn, cPage, numPerpage);
			close(conn);
			return tipBoardList;
		}
		
		public int tipBoardListCount() {
			Connection conn=getConnection();
			int tipBoardListCount = dao.tipBoardListCount(conn);
			close(conn);
			return tipBoardListCount;
		}
		
		public List<TipPhoto> selectTipPhoto(){
			Connection conn=getConnection();
			List<TipPhoto> photos = dao.selectTipPhoto(conn);
			close(conn);
			return photos;
		}
		
}
