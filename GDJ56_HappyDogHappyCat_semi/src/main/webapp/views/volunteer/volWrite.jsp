<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.happy.vol.model.vo.Agency" %>
<%@ include file="/views/common/header.jsp" %>
<%
	Agency a = (Agency)request.getAttribute("agency");
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/volWrite.css"/>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<section id="container1">
<form onsubmit="return checkForm();" action="<%=request.getContextPath() %>/vol/volWriteEnd.do?memberNo=<%=loginMember!=null?loginMember.getMemberNo():"" %>" 
    			method="post" enctype="multipart/form-data">
    <div class="board_wrap">
        <div class="board_title">
            <strong style="font-size: 25px;">자원봉사</strong>
        </div>
        <div class="board_write_wrap">
            <div class="board_write" >
            
                <div class="title" >
                    <dl>
                        <dt style="font-size:17px">제목</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" placeholder="40자 이하로 입력해주세요." name="volTitle" required /></dd>
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
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" name="managerName" placeholder="담당자 이름" required></dd>
             
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
                        <dd style="font-size:17px;margin-top:14px;"><input type="date" name="recruitPeriod1" required>&nbsp;-&nbsp;<input type="date" name="recruitPeriod2" required></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">모집인원</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type=number name="recruitNumber" placeholder="모집인원" required></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">봉사활동기간</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="date" name="activityPeriod1" required>&nbsp;-&nbsp;<input type="date" name="activityPeriod2" required></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">활동가능요일</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" name="activityDay" placeholder="활동가능요일" required></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea rows="10" cols="100" name="summernote" id="summernote"  required></textarea>
                </div>

                <div class="file" style="font-size:17px">
                    <b>* 대표이미지 설정</b>
                    <input type="file" name = "upFile" class="real-upload" accept="image/*" onchange="readURL(this);" required>
                    <img id="preview" style="display:none;"></div>
                </div>
                
                <div class="file2" style="font-size:17px">
                    <b>* 사진첨부</b>
                    <input type="file" id='btnAtt' accept="image/*" name="upload2" multiple/>
                </div>
                <div id='att_zone' 
                data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'></div>
              
            </div>
			
	       
            <div class="bt_wrap" >
                <input type="button" style="font-size:17px" id="saveBtn" class="on" value="등록" >
                <input type="button" style="font-size:17px" value="취소" onclick="location.replace('<%=request.getContextPath()%>/volview.do')">
            </div>
        </div>
    </form>
</section>

<script>

	
		$("#saveBtn").click(e=>{
			let form=new FormData();
			const sumnail=$("input[name=upFile]")[0].files;
			const files=$("input[name=upload2]")[0].files;
			
			let inputs=$("form input").not("input[class*=note]");
	/* 		console.log(inputs); */
			 var summernoteContent = $('#summernote').summernote('code');
			
			
			inputs.each((i,v)=>{
				/* console.log($(v).attr("name"),$(v).val()); */
				form.append("param"+i,$(v).val());
			});
			
			$.each(files,(i,v)=>{
				form.append("upfile"+i,v);
			});		
			
			$.each(sumnail,(i,v)=>{
				form.append("sumn"+i,v);
			});		
					
			
			input[name=upload2]		
			 form.append("content",summernoteContent);
		
			if(sumnail.length==1){
				 if(files.length!=0){
			 	$.ajax({
				url :"<%=request.getContextPath()%>/vol/volWriteEnd.do",
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
		const checkForm=()=>{
			const sum = $("input[name=upFile]");
			console.log(sum);
			console.log("hi");
			
			
		}
		
		 
	
	
</script>



<script src="<%=request.getContextPath()%>/js/volwrite.js"></script>
<%@ include file="/views/common/footer.jsp" %>