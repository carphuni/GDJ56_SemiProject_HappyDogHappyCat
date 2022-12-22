package com.happy.tip.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.happy.tip.model.service.TipService;
import com.happy.tip.model.vo.TipBoard;
import com.happy.tip.model.vo.TipPhoto;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class TipWriteEndServlet
 */
@WebServlet("/tip/tipWriteEnd.do")
public class TipWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect(request.getContextPath());
		}else {
			String path=request.getServletContext().getRealPath("/upload/tip");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request, 
					path,maxSize,encoding,dfr);
			

			
			Enumeration e=mr.getFileNames();	
			List<TipPhoto> fileList=new ArrayList();
			
			
			while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);
				fileList.add(TipPhoto.builder()
							.tipPhotoOriname(oriName2)
							.tipPhotoRename(fileName2)
							.build());
				
				System.out.println(fileList);
			}
			
			
		
		int memberNo=Integer.parseInt(mr.getParameter("memberNo"));
		String category=mr.getParameter("category");//카테고리
		String title= mr.getParameter("param0");//제목
		String contents = mr.getParameter("content");//내용
		double lat = Double.parseDouble(mr.getParameter("param7"));//위도
		double lon = Double.parseDouble(mr.getParameter("param8"));//경도
		TipBoard tb= TipBoard.builder()
					.memberNo(memberNo)
					.tipCategory(category)
					.tipTitle(title)
					.tipContents(contents)
					.tipLat(lat)
					.tipLon(lon)
					.build();		
	
		System.out.println(tb);
		int result= new TipService().tipWriteEnd(tb,fileList);
		
		
		String msg, loc;
		if(result>0) {
			msg="게시물 등록이 완료되었습니다";
			loc="/tip/tipList.do";
		}else {
			msg="게시글 등록이 실패했습니다. 다시 시도해주세요";
			loc="/tip/tipWrite.do";
		}

		Map<String,String> responseMsg=Map.of("msg",msg,"loc",loc);
		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(responseMsg,response.getWriter());
		
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
