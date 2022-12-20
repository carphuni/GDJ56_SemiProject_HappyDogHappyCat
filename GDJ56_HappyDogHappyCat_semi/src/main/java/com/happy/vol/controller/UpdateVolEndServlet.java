package com.happy.vol.controller;

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
import com.happy.vol.model.vo.Agency;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UpdateVolEndServlet
 */
@WebServlet("/volupdateend.do")
public class UpdateVolEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVolEndServlet() {
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
			String path=request.getServletContext().getRealPath("/upload/volunteer");
			int maxSize=1024*1024*10;
			String encoding="UTF-8";
			DefaultFileRenamePolicy dfr=new DefaultFileRenamePolicy();
			MultipartRequest mr=new MultipartRequest(request, 
					path,maxSize,encoding,dfr);
			

			
			Enumeration e=mr.getFileNames();	
			List<VolPhoto> fileList=new ArrayList();
			int boardNo = Integer.parseInt(mr.getParameter("param0"));
			int test=new VolunteerService().deleteVolPhoto(boardNo);
			System.out.println(test);
			
//			fileList.add(vp);
			while(e.hasMoreElements()) {
				String name=(String)e.nextElement();
				String fileName2 = mr.getFilesystemName(name);
				String oriName2 = mr.getOriginalFileName(name);
				if(name.equals("sumn0")) {
					fileList.add(VolPhoto.builder()
							.mainPhoto(oriName2)
						.vntPhotoOriName(oriName2)
						.vntPhotoRename(fileName2)
						.build());
				}else {
					fileList.add(VolPhoto.builder().vntPhotoOriName(oriName2).vntPhotoRename(fileName2).build());
				}
				System.out.println(fileList);
			}
			
		
		
		
		int memberNo = Integer.parseInt(mr.getParameter("memberNo"));
		Agency a = new VolunteerService().selectAgency2(memberNo);
		String title= mr.getParameter("param1");
		String managerName = mr.getParameter("param4");
		String rp=mr.getParameter("param6");
		java.sql.Date recPeriod = java.sql.Date.valueOf(rp);
		String rp2=mr.getParameter("param7");
		java.sql.Date recPeriod2 = java.sql.Date.valueOf(rp2);
		String ap=mr.getParameter("param9");
		java.sql.Date actPeriod = java.sql.Date.valueOf(ap);
		String ap2=mr.getParameter("param10");
		java.sql.Date actPeriod2 = java.sql.Date.valueOf(ap2);
		String actDay= mr.getParameter("param11");
		String contents = mr.getParameter("content");
		int setPerson = Integer.parseInt(mr.getParameter("param8"));
		Volunteer v = Volunteer.builder().vntBoardNo(boardNo)
					.vntRecName(title)
					.vntAgencyNo(a.getAgencyNo())
					.vntManagerName(managerName)
					.vntRecPeriod(recPeriod)
					.vntActPeriod(actPeriod)
					.vntRecPeriodEnd(recPeriod2)
					.vntActPeriodEnd(actPeriod2)
					.vntActDay(actDay)
					.vntActContents(contents)
					.vntSetPerson(setPerson)
					.build();
//		System.out.println(fileList);
//		System.out.println(v);
		int result = new VolunteerService().updateVol(v,fileList);
	
		String msg="", loc="";
		if(result>0) {
			msg="게시물 수정이 완료되었습니다";
			loc="/volview.do?memberNo="+memberNo+"&&boardNo="+boardNo+"&&agencyNo="+a.getAgencyNo();
		}else {
			msg="게시글 수정이 실패했습니다. 다시 시도해주세요";
			loc="/updatevol.do?memberNo="+memberNo+"&&boardNo="+boardNo;
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
