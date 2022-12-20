package com.happy.support.controller;

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
import com.happy.support.model.service.SupportService;
import com.happy.support.model.vo.SupPhoto;
import com.happy.support.model.vo.Support;
import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.Agency;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class SupUpdateEndServlet
 */
@WebServlet("/supupdateend.do")
public class SupUpdateEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupUpdateEndServlet() {
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
			int boardNo = Integer.parseInt(mr.getParameter("param0"));
			int test=new SupportService().deleteSupPhoto(boardNo);
			
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
			int memberNo = Integer.parseInt(mr.getParameter("memberNo"));
			Agency a = new VolunteerService().selectAgency2(memberNo);
			String title = mr.getParameter("param1");
			int money = Integer.parseInt(mr.getParameter("param2"));
			String contents = mr.getParameter("content");
			Support s = Support.builder().supTitle(title).supBoardNo(boardNo)
						.supContents(contents).supTargetAmount(money)
						.supAgencyNo(a.getAgencyNo())
						.build();
			System.out.println(s);
			int result = new SupportService().updateSup(s, fileList);
			String msg="", loc="";
			if(result>0) {
				msg="게시물 수정이 완료되었습니다";
				loc="/suplist.do";
			}else {
				msg="게시글 수정이 실패했습니다. 다시 시도해주세요";
				loc="/updatesup.do?memberNo="+memberNo+"&&boardNo="+boardNo;
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
