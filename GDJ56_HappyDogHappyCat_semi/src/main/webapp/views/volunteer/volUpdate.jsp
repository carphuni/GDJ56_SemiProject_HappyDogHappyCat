<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List,com.happy.vol.model.vo.Agency,com.happy.vol.model.vo.Volunteer,com.happy.vol.model.vo.VolPhoto" %>
<%@ include file="/views/common/header.jsp" %>
<%
	int boardNo = (int)request.getAttribute("boardNo");
	Agency a = (Agency)request.getAttribute("agency");
	Volunteer v = (Volunteer)request.getAttribute("v");
	VolPhoto vp= (VolPhoto)request.getAttribute("vp");
	List<VolPhoto> vp2= (List<VolPhoto>)request.getAttribute("vp2");
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/volWrite.css"/>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<section id="container1">
<form action="<%=request.getContextPath() %>/vol/volWriteEnd.do"
    			method="post" enctype="multipart/form-data">
    			<%if(loginMember!=null){ %>
    			<input type="hidden" name="memberNo" value="<%=loginMember.getMemberNo()%>">
    			<input type="hidden" name="boardNo" value="<%=boardNo %>">
    			<%} %>
    <div class="board_wrap">
        <div class="board_title">
            <strong style="font-size: 25px;">자원봉사</strong>
        </div>
        <div class="board_write_wrap">
            <div class="board_write" >
            
                <div class="title" >
                    <dl>
                        <dt style="font-size:17px">제목</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" placeholder="40자 이하로 입력해주세요." name="volTitle" value="<%=v.getVntRecName() %>" /></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">시설이름</dt>
                        <dd style="font-size:17px;margin-top:14px;"><%=a.getAgencyName() %>
                        <input type="hidden" name="agencyName" value="<%=a.getAgencyName() %>" placeholder="단체 및 시설이름 입력"></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">주소</dt>
                        <dd style="font-size:17px;margin-top:14px;"><%=a.getAgencyAddress() %>
                        <input type="hidden" name="agencyAddress" value="<%=a.getAgencyAddress() %>" placeholder="주소입력"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">담당자 이름</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" name="managerName" placeholder="담당자 이름" value="<%=v.getVntManagerName()%>"></dd>
             
                    </dl>
                    <dl>
                        <dt style="font-size:17px">시설 연락처</dt>
                        <dd style="font-size:17px;margin-top:14px;"><%=a.getAgencyPhone() %>
                        <input type="hidden" name="agencyPhone" value="<%=a.getAgencyPhone() %>" placeholder="시설 연락처"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">모집기간</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="date" name="recruitPeriod1" value="<%=v.getVntRecPeriod()%>">&nbsp;-&nbsp;<input type="date" name="recruitPeriod2" value=<%=v.getVntRecPeriodEnd() %>></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">모집인원</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type=number name="recruitNumber" placeholder="모집인원" value="<%=v.getVntSetPerson() %>"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">봉사활동기간</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="date" name="activityPeriod1" value="<%=v.getVntActPeriod()%>">&nbsp;-&nbsp;<input type="date" name="activityPeriod2" value="<%=v.getVntActPeriodEnd()%>"></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">활동가능요일</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" name="activityDay" placeholder="활동가능요일" value="<%=v.getVntActDay()%>"></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea rows="10" cols="100" name="summernote" id="summernote" placeholder="내용 입력"><%=v.getVntActContents() %></textarea>
                </div>
                <div class="file" style="font-size:17px">
                    <b>* 대표이미지 설정</b>
                    <input type="file" name = "upFile" class="real-upload" accept="image/*" onchange="readURL(this);" >
                    <img src="<%=request.getContextPath()%>/upload/volunteer/<%=vp.getVntPhotoRename()%>" id="preview" style="display:flex;" ></div>
                </div>
                
                <div class="file2" style="font-size:17px">
                    <b>* 사진첨부</b>
                    <input type="file" id='btnAtt' accept="image/*" name="upload2" onclick="dele()" multiple/>
                </div>
                
                <div id='att_zone' 
                data-placeholder=''>
                
                <%for(int i=0;i<vp2.size();i++){ %>
                <div id="del1" style="display:inline-block;position:relative;width:150px;height:120px;margin:5px;border:1px solid #00f;z-index:1">
                 <img id = "del2" style="width:100%;height:100%;z-index:none" src="<%=request.getContextPath()%>/upload/volunteer/<%=vp2.get(i).getVntPhotoRename()%>"> 
                 <input type="button" id="del3" value="x"  onclick="dele()" style="width:30px;height:30px;position:absolute;font-size:24px;right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00">
                 </div>
                 <%} %>
                </div>
               
              
            </div>
			
	       
            <div class="bt_wrap" >
                <input type="button" style="font-size:17px" id="saveBtn" class="on" value="등록" >
                <input type="button" style="font-size:17px" value="취소" onclick="location.replace('<%=request.getContextPath()%>/volupdateend.do')">
            </div>
        </div>
    </form>
</section>

<script>

	$(function(){
	    var dtToday = new Date();
	
	    var month = dtToday.getMonth() + 1;
	    var day = dtToday.getDate();
	    var year = dtToday.getFullYear();
	    if(month < 10)
	        month = '0' + month.toString();
	    if(day < 10)
	     day = '0' + day.toString();
	    var maxDate = year + '-' + month + '-' + day;
	    $('input[type=date]').attr('min', maxDate);  
	});
	
	
	
		$("#saveBtn").click(e=>{

			/* if(fn_invalidate()){
				
			} */
			let form=new FormData();
			const sumnail=$("input[name=upFile]")[0].files;
			const files=$("input[name=upload2]")[0].files;
			
			let inputs=$("form input").not("input[class*=note]").not("input[name=memberNo]");
	 		/* console.log(inputs);  */
			 var summernoteContent = $('#summernote').summernote('code');
			 var memberNo = $("input[name=memberNo]").val();
			 var boardNo = $("input[name=boardNo]").val();
			inputs.each((i,v)=>{
				/* console.log($(v).attr("name"),$(v).val()); */
				form.append("param"+i,$(v).val());
			});
			console.log(boardNo);
			$.each(files,(i,v)=>{
				form.append("upfile"+i,v);
			});		
			
			$.each(sumnail,(i,v)=>{
				form.append("sumn"+i,v);
			});		
					
			
			 form.append("content",summernoteContent);
			 form.append("memberNo",memberNo);
			form.append("boardNo",boardNo)
			 	
			if(sumnail.length==1){
				 if(files.length!=0){
			 	$.ajax({
				url :"<%=request.getContextPath()%>/volupdateend.do",
				data : form,
				type : "post",
				contentType:false,
				processData:false,
				success : e=>{
					/* console.log(e.msg);	 */
					/* console.log(e.loc); */
					var loc2 = e.loc;
					alert(e.msg);
					location.replace('<%=request.getContextPath()%>'+loc2);
// 					alert("파일업로드 성공");
// 					$("#upload2").val("");
// 					},error:(r,m,e)=>{
// 						alert("업로드 실패 다시시도하세요!");
// 					}
			 	}
					 });}
			 else{alert("사진을 1장 이상 첨부해주세요.")}
			 
		}else{
			alert("대표이미지를 설정해야 합니다.");
		}
	});
		
	   const dele = () =>{
		  $("#att_zone").empty();
	   }
		
	
		$(document).ready(function() {
		    $('#summernote').summernote({
		        tablesize :2,
		        height:500
		        
		    });
			    });

		   

		  	

	
		  
</script>



<script src="<%=request.getContextPath()%>/js/volwrite.js"></script>
<%@ include file="/views/common/footer.jsp" %>