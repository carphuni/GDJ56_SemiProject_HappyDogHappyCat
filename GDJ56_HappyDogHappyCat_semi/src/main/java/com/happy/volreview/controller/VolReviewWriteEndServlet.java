package com.happy.volreview.controller;

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
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.volreview.model.service.VolReviewService;
import com.happy.volreview.model.vo.VolReview;
import com.happy.volreview.model.vo.VolReviewPhoto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class VolReviewWriteEndServlet
 */
@WebServlet("/reviewwriteend.do")
public class VolReviewWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolReviewWriteEndServlet() {
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
			String path=request.getServletContext().getRealPath("/upload/volreview");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request, 
					path,maxSize,encoding,dfr);
			

			
			Enumeration e=mr.getFileNames();	
			List<VolReviewPhoto> fileList=new ArrayList();
			
			
//			fileList.add(vp);
			while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);

					fileList.add(VolReviewPhoto.builder().vntPhotoOriName(oriName2)
							.vntPhotoRename(fileName2).build());
				
				System.out.println(fileList);
			}
			
			
		
		int memberNo = Integer.parseInt(mr.getParameter("memberNo"));
		
		String title= mr.getParameter("title");
		String contents=mr.getParameter("content");	
		System.out.println(title);
		System.out.println(contents);
//		System.out.println(v);
		VolReview vr = VolReview.builder().memberNo(memberNo)
						.vntTitle(title).vntContents(contents).build();
		int result= new VolReviewService().insertVolReview(vr,fileList);
		
		
		String msg="", loc="";
		if(result>0) {
			msg="게시물 등록이 완료되었습니다";
			loc="/reviewlist.do";
		}else {
			msg="게시글 등록이 실패했습니다. 다시 시도해주세요";
			loc="/volreviewwrite.do";
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
