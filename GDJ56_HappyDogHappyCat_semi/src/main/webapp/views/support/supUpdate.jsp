<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List,com.happy.vol.model.vo.Agency,com.happy.support.model.vo.SupPhoto,com.happy.support.model.vo.Support" %>
<%
	Agency a = (Agency)request.getAttribute("agency");
	Support s = (Support)request.getAttribute("s");
	SupPhoto sp = (SupPhoto)request.getAttribute("sp");
	List<SupPhoto> sp2 = (List<SupPhoto>)request.getAttribute("sp2");
%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/supwrite.css"/>

<section id="container1">
<form action="<%=request.getContextPath() %>/supWriteEnd.do"
	method="post" enctype="multipart/form-data">
	<%if(loginMember!=null){ %>
	<input type="hidden" name="memberNo" value="<%=loginMember.getMemberNo()%>">
    <%} %>
    <div class="board_wrap">
        <div class="board_title">
            <strong style="font-size: 25px;">후원하기</strong>
        </div>
        <div class="board_write_wrap">
            <div class="board_write" >
                <div class="title" >
                    <dl>
                        <dt style="font-size:17px">제목</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" placeholder="제목 입력" value="<%=s.getSupTitle()%>"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">시설이름</dt>
                        <dd style="font-size:17px;margin-top:14px;"><%=a.getAgencyName() %></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">목표금액</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" placeholder="숫자 입력 ex)5000000" value="<%=s.getSupTargetAmount()%>"></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea rows="10" cols="100" name="summernote" id="summernote" placeholder="내용 입력"><%=s.getSupContents() %></textarea>
                </div>

                <div class="file" style="font-size:17px">
                    <b>* 대표이미지 설정</b>
                    <input type="file" name = "upFile" class="real-upload" accept="image/*" onchange="readURL(this);">
                    <img src="<%=request.getContextPath()%>/upload/support/<%=sp.getSupPhotoRename()%>" id="preview" style="display:flex;"></div>
                </div>
                
                <div class="file2" style="font-size:17px">
                    <b>* 사진첨부</b>
                    <input type="file" id='btnAtt' accept="image/*" name="upload2" onclick="dele()" multiple/>
                </div>
                <div id='att_zone' 
                data-placeholder=''>
                 <%for(int i=0;i<sp2.size();i++){ %>
                <div id="del1" style="display:inline-block;position:relative;width:150px;height:120px;margin:5px;border:1px solid #00f;z-index:1">
                 <img id = "del2" style="width:100%;height:100%;z-index:none" src="<%=request.getContextPath()%>/upload/volunteer/<%=sp2.get(i).getSupPhotoRename()%>"> 
                 <input type="button" id="del3" value="x"  onclick="dele()" style="width:30px;height:30px;position:absolute;font-size:24px;right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00">
                 </div>
                 <%} %>
                
                </div>
              
            </div>

            <div class="bt_wrap" >
                <input type="button" style="font-size:17px" id="saveBtn" class="on" value="등록">
                <input type="button" style="font-size:17px" value="취소" onclick="location.replace('<%=request.getContextPath()%>/suplist.do')">
            </div>
        </div>
    </form>
</section>

<script>
$("#saveBtn").click(e=>{
			/* if(fn_invalidate()){
				
			} */
			let form=new FormData();
			const sumnail=$("input[name=upFile]")[0].files;
			const files=$("input[name=upload2]")[0].files;
			
			let inputs=$("form input").not("input[class*=note]").not("input[name=memberNo]");
	/* 		console.log(inputs); */
			 var summernoteContent = $('#summernote').summernote('code');
			 var memberNo = $("input[name=memberNo]").val();
			
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
					
			
			 form.append("memberNo",memberNo);
			 form.append("content",summernoteContent);
		
			if(sumnail.length==1){
				 if(files.length!=0){
			 	$.ajax({
				url :"<%=request.getContextPath()%>/supWriteEnd.do",
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

</script>




<script src="<%=request.getContextPath()%>/js/supwrite.js"></script>
<%@ include file="/views/common/footer.jsp" %>