package com.happy.support.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.vo.VolPhoto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class SupportWriteEndServlet
 */
@WebServlet("/supWriteEnd.do")
public class SupportWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupportWriteEndServlet() {
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
			String path=request.getServletContext().getRealPath("/upload/support");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request, 
					path,maxSize,encoding,dfr);
			

			
			Enumeration e=mr.getFileNames();	
			List<SupPhoto> fileList=new ArrayList();
			while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);
				if(name.equals("sumn0")) {
					fileList.add(SupPhoto.builder()
							.supMainPhoto(oriName2)
						.supPhotoOriName(oriName2)
						.supPhotoRename(fileName2)
						.build());
				}else {
					fileList.add(SupPhoto.builder().supPhotoOriName(oriName2).supPhotoRename(fileName2).build());
				}
			}
			
			String title = mr.getParameter("param0");
			int money = Integer.parseInt(mr.getParameter("param1"));
			String contents = mr.getParameter("content");
			Support s = Support.builder().supTitle(title)
						.supContents(contents).supTargetAmount(money)
						.build();
		
			int result = new SupporeService().insertSupport
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
