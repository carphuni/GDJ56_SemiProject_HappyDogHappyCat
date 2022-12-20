<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.happy.admission.vo.AdmissionForm,
com.happy.animal.model.vo.Animal" %>
<%@include file="/views/common/header.jsp"%>
<body>
<section id="content">
	<div style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
    	<img src="<%=request.getContextPath() %>/images/admission/dog1.png" alt="" style="margin-right: auto;" class="dogimg">
            <div id="text" >
            <br>
            	<h1 style="font-size: 30px; text-align: center;">입소신청</h1>
                <p style="font-size: 20px; text-align: center;">더이상 거짓된 보호소들에 속지 마세요.<br>
                    <br>해피독해피캣은 꼼꼼한 입소절차를 통해<br>
                   	<br>아이들을 안전하게 보호하겠습니다.</p>
            </div>
        <img src="<%=request.getContextPath() %>/images/admission/dog2.png" alt="" style="margin-left: auto;" class="dogimg">
    </div>

    <form action="<%=request.getContextPath() %>/admission/writeAdmissionEnd.do" 
        method="post" enctype="multipart/form-data">
    <input type="text" name="memberNo" value="<%=loginMember.getMemberNo()%>" hidden>
    <div class="board_wrap">
        <div class="board_title">
            <strong>입소신청</strong>
        </div>
        <div class="board_write_wrap">
            <div class="board_write">
            	 <div class="info">
                    <dl>
                        <dt id="aniType">동물이름</dt>
                        <dd><input type="text" placeholder="동물이름 입력" id="inputType" name="aniName"></dd>
                    </dl>
                     <dl>
                        <dt style="font-size:18px;">동물종류</dt>
                         <dd>강아지<input type="radio" id="inputType" name="aniType" value="강아지"></dd>
                         <dd>고양이<input type="radio" id="inputType" name="aniType" value="고양이"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt id="aniType">품종</dt>
                        <dd><input type="text" placeholder="품종 입력" id="inputType" name="aniKind"></dd>
                    </dl>
                     <dl>
                        <dt style="font-size:18px;">크기</dt>
                        <dd><input type="text"  style="width:210px; height:30px" name="aniSize"
                        placeholder="소형/중형/대형 중 입력"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:18px;">성별</dt>
                        <dd>남<input type="radio" name="gender" value="M"></dd>
                        <dd>여<input type="radio" name="gender" value="F"></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:18px;">나이</dt>
                        <dd><input type="text" name="aniAge" placeholder="나이입력" style="width:130px; height:30px"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:18px;">접종 여부</dt>
                        <dd><input type="checkbox" name="vcnStat1" id="vcn1" value="Y" >광견병</dd>
                        <dd><input type="checkbox" name="vcnStat2" id="vcn2" value="Y" >코로나장염</dd>
                        <dd><input type="checkbox" name="vcnStat3" id="vcn3" value="Y">켄넬코프</dd><br>
                        <dd><input type="checkbox" name="vcnStat4" id="vcn4" value="Y">인플루엔자</dd>
                        <dd><input type="checkbox" name="vcnStat5" id="vcn5" value="Y">항체가검사</dd>
                        <dd><input type="checkbox" name="vcnStat6" id="vcn6" value="Y">종합백신</dd>
                    </dl>
                    <dl>
                        <dt style="font-size:18px;">중성화 여부</dt>
                        <dd>O<input type="radio" name="neu" value="Y"></dd>
                        <dd>X<input type="radio" name="neu" value="N"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:18px;">성격</dt>
                        <dd><input type="checkbox" name="character" id="character1" value="활발함" >활발함</dd>
                        <dd><input type="checkbox" name="character" id="character2" value="자신감" >자신감</dd>
                        <dd><input type="checkbox" name="character" id="character3" value="부끄럼" >부끄럼</dd>
                        <dd><input type="checkbox" name="character" id="character4" value="독립적" >독립적</dd>
                        <dd><input type="checkbox" name="character" id="character5" value="적응력" >적응력</dd>
                    </dl>
                    <dl>
                        <dt style="font-size:18px;">특이사항</dt>
                        <dd><input type="text" name="aniSpecial" placeholder="특이사항 작성" style="width:250px; height:30px"></dd>
                    </dl>
                </div>
                <div class="info">
                	<dl>
                        <dt style="font-size:18px;">털색</dt>
                        <dd><input type="text" name="furColor" style="width:250px; height:25px" placeholder="검정/흰색/회색/갈색/기타"></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:18px;">입소희망일</dt>
                        <dd><input type="date" name="hopeDate" value="date" style="width:130px; height:30px"></dd>
                    </dl>
                </div>
                <h4 style="font-size:18px;">보호소로 오게된 이유(입소사유)</h4>
                <div class="cont">
                    <textarea rows="10" cols="100" name="summernote" id="summernote" placeholder="내용 입력"></textarea>
                </div>

              
                
                <div class="file2">
                    <b>📸 대표사진첨부</b>
                    <input type="file" name="upFile" id='btnAtt' accept="image/*"  multiple/>
                </div>
                <div id='att_zone' 
                data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'>
                </div>
                
                 <div class="file2">
                    <b>📸 사진첨부</b>
                    <input type="file" name="upload2" id='btnAtt' accept="image/*"  multiple/>
                </div>
                <div id='att_zone' 
                data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'>
                </div>
           
           
            </div>

            <div class="bt_wrap">
                <input type="button" value="등록" class="on" id="enroll" >
				<input type="button" value="취소" onclick="location.replace('<%=request.getContextPath()%>/admission/admissionList.do')">
            </div>
        </div>
    </div>
</form>
</section>
	<style>
		
		#aniType{
			font-size:18px;
		}
		
		#inputTitle{
	  		width:800px;
	  		height:30px;
	  	}
      	body{
          	font-family: 'Poor Story';
          	width: 100%;
          	height: 100%;
          	overflow-x: hidden;
      	}
    
    
      * {
           margin: 0;
           padding: 0;
       }
       
     
       
       ul, li {
           list-style: none;
       }
       
       a {
           text-decoration: none;
           color: inherit;
       }
       
       .board_wrap {
           width: 1000px;
           margin: 50px auto;
       }
       
       .board_title {
           margin-bottom: 30px;
       }
       
       .board_title strong {
           font-size: 2rem;
       }
       
       .board_title p {
           margin-top: 5px;
           font-size: 1.4rem;
       }
       
       .bt_wrap {
           margin-top: 30px;
           text-align: center;
           font-size: 0;
       }
       
       .bt_wrap input {
           display: inline-block;
           min-width: 80px;
           margin-left: 10px;
           padding: 10px;
           border: 1px solid #000;
           border-radius: 2px;
           font-size: 1.4rem;
       }
       
       .bt_wrap a:first-child {
           margin-left: 0;
       }
       
       .bt_wrap input#on {
           background: gray;
           color: #fff;
       }
       
    
       .board_write {
           border-top: 2px solid #000;
           
       }
       
       .board_write .title,
       .board_write .info {
           padding: 10px;
           
       }
       
       .board_write .info {
           border-top: 1px solid #000;
           border-bottom: 1px solid #000;
           font-size: 0;
       }
       
       .board_write .title dl {
           font-size: 0;
       }
       
       
       .board_write .info dl {
           display: inline-block;
           width: 50%;
           vertical-align: middle;
       }
       
       .board_write .title dt,
       .board_write .title dd,
       .board_write .info dt,
       .board_write .info dd {
           display: inline-block;
           vertical-align: middle;
           font-size: 1.4rem;
       }
       
       .file{
          border-bottom : 1px solid #555;
           font-size: 1.4rem;
           padding : 15px;
           
       }
    
       .file2{
          font-size: 1.4rem;
           padding : 15px;
       }
    
       .file input{
          padding:20px;
       }
    
       .file2 input{
          padding:20px;
       }
       .board_write .title dt,
       .board_write .info dt {
           width: 100px;
       }
       
       .board_write .title dd {
           width: calc(100% - 100px);
       }
       
       .board_write .title input[type="text"],
       .board_write .info input[type="text"],
       .board_write .info input[type="number"] 
       .board_write .info input[type="date"]{
           padding: 5px;
           box-sizing: border-box;
       }
       
       .board_write .title input[type="text"] {
           width:80%;
       }
       
       .board_write .cont {
           border-bottom: 1px solid #000;
       }
       
       .board_write .cont textarea {
           display: block;
           width: 100%;
           height: 700px;
           padding: 15px;
           box-sizing: border-box;
           border: 0;
           resize: vertical;
       }
       #att_zone{
          width: 660px;
          min-height:150px;
          padding:10px;
          border:1px dotted #00f;
      } 
      #att_zone:empty:before{
          content : attr(data-placeholder);
          color : #999;
          font-size:.9em;
      }
      li {
        list-style: none;
      }
      .real-upload {
        display: none;
      }
      .image-preview {
        display: none;
        width: 200px;
        height: 200px;
        background-color:white;
        gap: 20px;
      }
      .dogimg{
        width: 200px;
        height: 250px;
        opacity: 0.5; 
      }
</style>

<script>
	$("#enroll").click(e=>{
		
		let form=new FormData();
		
		const sumnail=$("input[name=upFile]")[0].files;
		const files=$("input[name=upload2]")[0].files;
		
		//썸네일
		$.each(sumnail,(i,v)=>{
			form.append("upFile"+i,v);
		});
		
		//일반사진 
		$.each(files,(i,v)=>{
			form.append("upload2"+i,v);
		});
		var memberNo=$("input[name=memberNo]").val();
		//동물정보 
		var aniName= $("input[name=aniName]").val();
		var aniType=$("input[name=aniType]:checked").val();
		var aniKind=$("input[name=aniKind]").val();
		var aniSize=$("input[name=aniSize]").val();
		var gender=$("input[name=gender]:checked").val();
		var aniAge=$("input[name=aniAge]").val();
		var vcnStat1=$("#vcn1").val();
		console.log(vcnStat1);
		var vcnStat2=$("#vcn2").val();
		var vcnStat3=$("#vcn3").val();
		var vcnStat4=$("#vcn4").val();
		var vcnStat5=$("#vcn5").val();
		var vcnStat6=$("#vcn6").val();
		var neu=$("input[name=neu]:checked").val();
		var character=$("input[name=character]:checked").val();
		var aniSpecial=$("input[name=aniSpecial]").val();
		var furColor=$("input[name=furColor]").val();
		var hopeDate=$("input[name=hopeDate]").val();
		var aniReason=$('#summernote').summernote('code');
		
		 form.append("aniName",aniName);
		 form.append("aniType",aniType);
		 form.append("aniKind",aniKind);
		 form.append("aniSize",aniSize);
		 form.append("gender",gender);
		 form.append("aniAge",aniAge);
		 form.append("vcnStat1",vcnStat1);
		 form.append("vcnStat2",vcnStat2);
		 form.append("vcnStat3",vcnStat3);
		 form.append("vcnStat4",vcnStat4);
		 form.append("vcnStat5",vcnStat5);
		 form.append("vcnStat6",vcnStat6);
		 form.append("neu",neu);
		 form.append("character",character);
		 form.append("aniSpecial",aniSpecial);
		 form.append("furColor",furColor);
		 form.append("hopeDate",hopeDate);
		 form.append("aniReason",aniReason);
		 form.append("memberNo",memberNo);
		 if(sumnail.length==1){
			 if(files.length>=3){
		 	$.ajax({
			url :"<%=request.getContextPath()%>/admission/writeAdmissionEnd.do",
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
	//				alert("파일업로드 성공");
	//				$("#upload2").val("");
	//				},error:(r,m,e)=>{
	//					alert("업로드 실패 다시시도하세요!");
	//				}
		 	}
				 });}
		 else{alert("사진을 3장 이상 첨부해주세요.")}
		 
	}else{
		alert("대표이미지는 1장으로 설정해야 합니다.");
	}
	});
		
	
	

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
    		      if(files.length<=3){
    		      for(f of fileArr){
    		        imageLoader(f);
    		      }}else{alert("사진첨부는 3개까지만 가능합니다.")}
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
    		        if(document.getElementsByTagName("img").length<3){
    		        alert("사진첨부는 3개이상 가능합니다.");
    		      } 
    		      
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
    
    
  
</script>
</body>
<%@include file="/views/common/footer.jsp"%>