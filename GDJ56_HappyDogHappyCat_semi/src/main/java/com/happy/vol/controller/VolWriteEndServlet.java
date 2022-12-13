package com.happy.vol.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.happy.vol.model.service.VolunteerService;
import com.happy.vol.model.vo.VolPhoto;
import com.happy.vol.model.vo.Volunteer;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
/**
 * Servlet implementation class VolWriteEndServlet
 */
@WebServlet("/vol/volWriteEnd.do")
public class VolWriteEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VolWriteEndServlet() {
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
			
			String fileName=mr.getFilesystemName("upFile");
			String oriName=mr.getOriginalFileName("upFile");
			
			VolPhoto vp = VolPhoto.builder()
						.vntPhotoOriName(oriName)
						.vntPhotoRename(fileName)
						.build();
				
			
		
		String title= mr.getParameter("volTitle");
		String managerName = mr.getParameter("managerName");
		String rp=mr.getParameter("recruitPeriod1");
		java.sql.Date recPeriod = java.sql.Date.valueOf(rp);
		String rp2=mr.getParameter("recruitPeriod2");
		java.sql.Date recPeriod2 = java.sql.Date.valueOf(rp2);
		String ap=mr.getParameter("activityPeriod1");
		java.sql.Date actPeriod = java.sql.Date.valueOf(ap);
		String ap2=mr.getParameter("activityPeriod2");
		java.sql.Date actPeriod2 = java.sql.Date.valueOf(ap2);
		String actDay= mr.getParameter("activityDay");
		String contents = mr.getParameter("summernote");
		int setPerson = Integer.parseInt(mr.getParameter("recruitNumber"));
		System.out.println(contents);
		Volunteer v = Volunteer.builder().vntRecName(title)
					.vntManagerName(managerName)
					.vntRecPeriod(recPeriod)
					.vntActPeriod(actPeriod)
					.vntRecPeriodEnd(recPeriod2)
					.vntActPeriodEnd(actPeriod2)
					.vntActDay(actDay)
					.vntActContents(contents)
					.vntSetPerson(setPerson)
					.build();			
	
		
		int result= new VolunteerService().insertVolunteer(v,vp);
		String msg="", loc="";
		if(result>0) {
			msg="게시물 등록이 완료되었습니다";
			loc="/volview.do";
		}else {
			msg="게시글 등록이 실패했습니다. 다시 시도해주세요";
			loc="/volwrite.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
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
