package com.happy.adopt.controller;

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
import com.happy.adopt.model.service.AdoptService;
import com.happy.adopt.model.vo.AdoptPhoto;
import com.happy.adopt.model.vo.AdtReviewBorad;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class AdoptReviewWriteEnd
 */
@WebServlet("/adopt/adoptReviewwriteEnd.do")
public class AdoptReviewWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptReviewWriteEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * int memberNo=Integer.parseInt(request.getParameter("memberNo")); String
		 * title=request.getParameter("title"); String
		 * content=request.getParameter("summernote");
		 * 
		 * //System.out.println(content);
		 * 
		 * AdtReviewBorad arb=AdtReviewBorad.builder() .memberNo(memberNo)
		 * .adtTitle(title) .adtContents(content) .build();
		 * 
		 * int result=new AdoptService().adoptReviewWrite(arb);
		 * 
		 * 
		 * String msg="",loc=""; if(result>0) { msg="입양후기 글등록 성공"; }else {
		 * msg="입양후기 글등록 실패"; } loc="/adopt/adoptreview.do";
		 */
		
		/*
		 * request.setAttribute("msg", msg); request.setAttribute("loc", loc);
		 */
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			response.sendRedirect(request.getContextPath());
		}else {
			String path=request.getServletContext().getRealPath("/upload/adopt");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request,path,maxSize,encoding,dfr);
			
			Enumeration e=mr.getFileNames();	
			List<AdoptPhoto> fileList=new ArrayList();
			
			while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);
				//System.out.println(name);
					fileList.add(AdoptPhoto.builder()
						.adtPhotoOriName(oriName2)
						.adtPhotoRename(fileName2)
						.build());
			}
			
		
		
		int memberNo=Integer.parseInt(mr.getParameter("memberNo")); 
		String title=mr.getParameter("title"); 
		String content=mr.getParameter("content");
		
		AdtReviewBorad arb=AdtReviewBorad.builder() 
				.memberNo(memberNo)
				.adtTitle(title) 
				.adtContents(content) 
				.build();
		
		int result=new AdoptService().adoptReviewWrite(arb,fileList);
		
		String msg="", loc="";
		if(result>0) {
			msg="입양후기 글등록 성공";
			loc="/adopt/adoptreview.do";
		}else {
			msg="입양후기 글등록 실패";
			loc="/adopt/adoptreviewwrite.do";
		}
		
		Map<String,String> responseMsg=Map.of("msg",msg,"loc",loc);
		
		response.setContentType("application/json;charset=utf-8");
		new Gson().toJson(responseMsg,response.getWriter());
		
		//request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
		
		
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
