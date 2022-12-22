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

		    
		    ( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
		  imageView = function imageView(att_zone, btn){

		    var attZone = document.getElementById(att_zone);
		    var btnAtt = document.getElementById(btn)
		    var sel_files = [];
		    // 이미지와 체크 박스를 감싸고 있는 div 속성
		    var div_style = 'display:inline-block;position:relative;'
		                  + 'width:150px;height:120px;margin:5px;border:1px solid #00f;z-index:1';
		    // 미리보기 이미지 속성
		    var img_style = 'width:100%;height:100%;z-index:none';
		    // 이미지안에 표시되는 체크박스의 속성
		    var chk_style = 'width:30px;height:30px;position:absolute;font-size:24px;'
		                  + 'right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00';
		  
		    btnAtt.onchange = function(e){
		      var files = e.target.files;
		      var fileArr = Array.prototype.slice.call(files)
		      
		      for(f of fileArr){
		        imageLoader(f);
		      }
		    }  
		    
		  
		    // 탐색기에서 드래그앤 드롭 사용
		    attZone.addEventListener('dragenter', function(e){      
		      e.preventDefault();
		      e.stopPropagation();
		    }, false)
		    
		    attZone.addEventListener('dragover', function(e){
		      e.preventDefault();
		      e.stopPropagation();
		      
		    }, false)
		  
		    attZone.addEventListener('drop', function(e){
		      var files = {};
		      e.preventDefault();
		      e.stopPropagation();
		      var dt = e.dataTransfer;
		      files = dt.files;
		      for(f of files){
		        imageLoader(f);
		      }
		      
		    }, false)
		  
		    
		    /*첨부된 이미리즐을 배열에 넣고 미리보기 */
		    imageLoader = function(file){
		      sel_files.push(file);
		      var reader = new FileReader();
		      reader.onload = function(ee){
		        let img = document.createElement('img')
		        img.setAttribute('style', img_style)
		        img.src = ee.target.result;
		        attZone.appendChild(makeDiv(img, file));
		        
		      }
		      
		      reader.readAsDataURL(file);
		   
		    }
		    
		    /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
		    makeDiv = function(img, file){
		     
		      
		      var div = document.createElement('div')
		      div.setAttribute('style', div_style)
		      
		      var btn = document.createElement('input')
		      btn.setAttribute('type', 'button')
		      btn.setAttribute('value', 'x')
		      btn.setAttribute('delFile', file.name);
		      btn.setAttribute('style', chk_style);
		      btn.onclick = function(ev){
		        var ele = ev.srcElement;
		        var delFile = ele.getAttribute('delFile');
		        for(var i=0 ;i<sel_files.length; i++){
		          if(delFile== sel_files[i].name){
		            sel_files.splice(i, 1);      
		          }
		        }
		        
		        dt = new DataTransfer();
		        for(f in sel_files) {
		          var file = sel_files[f];
		          dt.items.add(file);
		        }
		        btnAtt.files = dt.files;
		        var p = ele.parentNode;
		        attZone.removeChild(p)
		      }
		      div.appendChild(img)
		      div.appendChild(btn)
		      return div
		     
		    }
		  }
		    )('att_zone', 'btnAtt')

		    function readURL(input) {
		    $("#preview").css("display","flex");
		    if (input.files && input.files[0]) {
		        var reader = new FileReader();
		        reader.onload = function(e) {
		        document.getElementById('preview').src = e.target.result;
		        };
		        reader.readAsDataURL(input.files[0]);
		    } else {
		        document.getElementById('preview').src = "";
		    }
		    }
		    $(document).ready(function(){
			 
		   //썸머노트에 값넣기
		   $('#summernote').summernote('code', $("#summernote").html());
		 
		    //위와 같이 값을 먼저 넣어준 후 초기화를 시킨다. 그럼 아래와 같이 입력이 된다.
		    //초기화
		  $('#summernote').summernote({
		    height : 400, // set editor height
		    minHeight : null, // set minimum height of editor
		    maxHeight : null, // set maximum height of editor
		    focus : true,
		    lang : 'ko-KR' // 기본 메뉴언어 US->KR로 변경
		  });
		 
		  

		  //저장버튼 클릭
		  $(document).on('click', '#saveBtn', function () {
		      saveContent();
		    
		  });
		});

		  //데이터 저장
		  function saveContent() {
		    
		      //값 가져오기
		      var summernoteContent = $('#summernote').summernote('code');        //썸머노트(설명)
		      console.log("summernoteContent : " + summernoteContent);
		  
		  }	

		  	

	
		  
</script>



<script src="<%=request.getContextPath()%>/js/volwrite.js"></script>
<%@ include file="/views/common/footer.jsp" %>