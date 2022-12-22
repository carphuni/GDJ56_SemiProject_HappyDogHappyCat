package com.happy.qa.controller;

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
import com.happy.admission.vo.AnimalPhoto;
import com.happy.qa.service.QaService;
import com.happy.qa.vo.QaForm;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class QaModifyEndServlet
 */
@WebServlet("/qa/ModifyEnd.do")
public class QaModifyEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QaModifyEndServlet() {
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
			String path=request.getServletContext().getRealPath("/upload/qa");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request, 
					path,maxSize,encoding,dfr);
			
		Enumeration e=mr.getFileNames();	
		List<AnimalPhoto> fileList=new ArrayList();
			
		while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);
				
					fileList.add(AnimalPhoto.builder().adPhotoReName(fileName2)
							.adPhotoOriName(oriName2).build());		
				}
				System.out.println(fileList);
		
		String qaTitle=mr.getParameter("qaTitle");
		System.out.println("제목"+qaTitle);
		String qaContents=mr.getParameter("qaContents");
		System.out.println("내용"+qaContents);
		char openYn=mr.getParameter("qaOpenYn").charAt(0);
		System.out.println("공개여부"+openYn);
		System.out.println("공개여부비밀번호"+mr.getParameter("qaPassword"));
		int qaPassword=0;
		if(!mr.getParameter("qaPassword").equals("") && mr.getParameter("qaPassword") != null) {
			System.out.println("88비밀번호"+mr.getParameter("qaPassword"));
			qaPassword=Integer.parseInt(mr.getParameter("qaPassword"));
			System.out.println("90비밀번호"+qaPassword);
		}else {
			System.out.println("92비밀번호"+mr.getParameter("qaPassword"));
			qaPassword=0;
			System.out.println("94비밀번호"+qaPassword);
		}
		
		int memberNo=Integer.parseInt(mr.getParameter("memberNo"));
		System.out.println("회원번호"+memberNo);
		
		QaForm qa=QaForm.builder()
				.qaTitle(qaTitle)
				.qaContents(qaContents)
				.qaOpenYn(openYn)
				.qaPassword(qaPassword)
				
				.build();
		
		
		
		int qaNo=Integer.parseInt(mr.getParameter("qaNo"));
		int result=new QaService().modifyQa(qa,memberNo,qaNo);
		System.out.println("수정결과"+result);
		
		
		String msg="",loc="";
		if(result==0) {
			//qa 등록 실패시
			msg="문의글 수정 실패, 다시 작성해주세요!";
			loc="/qa/ModifyEnd.do";
		}else {
			//qa 등록 성공시2
			msg="문의글 수정 성공! :)";
			loc="/qa/myPageList.do";
			
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
