package com.happy.support.model.service;

import static com.happy.common.JDBCTemplate.close;
import static com.happy.common.JDBCTemplate.commit;
import static com.happy.common.JDBCTemplate.getConnection;
import static com.happy.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.happy.support.model.dao.SupportDao;
import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.vo.VolPhoto;


public class SupportService {
	
	private SupportDao sd = new SupportDao();
	
	public int insertSupport(Support s,List<SupPhoto> fileList) {
		Connection conn=getConnection();
		int result=sd.insertSupport(conn, s);
		int result2=0;
		if(result>0) {
			int supNo=sd.selectSupNo(conn);
			for(SupPhoto sp : fileList) {
				result2+=sd.insertVolPhoto(conn,supNo,sp);
			}
			if(result2==fileList.size())commit(conn);
			else rollback(conn);
			close(conn);
		}
		return result2;
	}

}
