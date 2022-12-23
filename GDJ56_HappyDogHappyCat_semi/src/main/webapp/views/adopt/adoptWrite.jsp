<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<% int aniNo=Integer.parseInt(request.getParameter("aniNo")); 
	%>
<%--  <% console.log(request.getAttribute("hopeDateArr")); %> --%> 

<link type="text/css" href="https://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css"rel="stylesheet">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
    
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    

<section id="content">
<div id="imgs" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
            <img src="<%=request.getContextPath() %>/images/adopt/Q.jfif" alt="" style="margin-right: auto;">
            <div id="text" >
                <br><br>
                <h1>입양하기</h1>
                 <p><br>보호중인 파양동물들과 유기된 동물들을<br>
                    상시로 공고하고 있습니다.<br>
                    자세한 안내는 입양안내를 참고해주세요.</p>
            </div>
            <img src="<%=request.getContextPath() %>/images/adopt/S.jfif" alt="" style="margin-left: auto;">
        </div>
        </section>
<section id="reviewwrite">
    <div class="board_wrap">
        <div class="board_title">
            <strong>입양하기</strong>
        </div>
        <form action="<%=request.getContextPath() %>/adopt/adoptwriteEnd.do" method="post" onsubmit="return checkForm();">
        <div class="board_write_wrap">
            <div class="board_write">
                <div class="title">
                    <dl>
                        <dt>제목</dt>
                        <dd><input type="text" value= "입양 신청합니다." readonly></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt>작성자</dt>
                        <dd><input type="text" value="<%=loginMember.getMemberId() %>" readonly></dd>
                        <input type="text" value= "<%=loginMember.getMemberNo() %>" name="memberNo" hidden>
                        <input type="text" value=<%=aniNo %> name="aniNo" hidden>
                    </dl>
                    <dl>
                        <dt>동거인여부</dt>
                        <dd><input type="text" id="roommate_" name="roommate" placeholder="있음(인원수)/없음" required></dd>
                    </dl>
                </div> 
                <div class="info">
                	<dl>
                        <dt style="width:200px;">알러지여부</dt>
                        <dd><input type="text" name="allergy" id="allergy_" size="50" placeholder="알러지여부" required></dd>
                    </dl>
                    <dl>
                        <dt style="width:120px;">경제활동여부</dt>
                        <dd><input type="text" name="money" id="money_" placeholder="경제활동여부" required></dd>
                    </dl>
                    
                </div>  
				
                <div class="info">
                	<dl>
                        <dt style="width:200px;">동물양육경험</dt>
                        <dd><input type="text" name="exp" id="exp_" size="50" placeholder="동물양육경험유무" required></dd>
                    </dl>
                    
                    <dl>
                        <dt>주거형태</dt>
                        <dd><input type="text" name="live" id="live_" placeholder="주택,아파트 등등" required></dd>
                    </dl>
                </div>   
                <div class="info">
                	<dl>
                        <dt style="width:200px;">방문희망날짜</dt>
                        <dd><input type="text" name="aptHopedate" id="hopedate" required></dd>
                        <!-- <dd><input type="date" name="aptHopedate" id="hopedate" required></dd> -->
                    </dl>
				</div>
                <div class="cont">
                    <textarea rows="10" cols="100" name="summernote" id="summernote" placeholder="내용 입력" required></textarea>
                </div>

                </div>
              
            </div>
            <div class="bt_wrap">
            	<input type="submit" class="on" value="등록">
            	<input type="reset" value="취소">
                <!-- <a href="view.html" class="on">등록</a>
                <a href="list.html">취소</a>  -->
            </div>
            </div>
</form>        
        
    </div>
</section>
<style>
		#content div{
            text-align: center;
        }
        #imgs img{
            width: 200px;
            height: 250px;
            opacity: 0.5; 
        }
        
        body{
            font-family: 'Poor Story';
            width: 100%;
            height: 100%;
            overflow-x: hidden;
        }

    
        *{
             margin: 0;
             padding: 0;
         }
         
         #reviewwrite html {
             font-size: 5px;
         }
         
         #reviewwrite ul, li {
             list-style: none;
         }
         
         a {
             text-decoration: none;
             color: inherit;
         }
         
         #reviewwrite .board_wrap {
             width: 1000px;
             margin: 100px auto;
         }
         
         #reviewwrite .board_title {
             margin-bottom: 30px;
         }
         
         #reviewwrite .board_title strong {
             font-size: 2rem;
         }
         
         #reviewwrite.board_title p {
             margin-top: 5px;
             font-size: 1.0rem;
         }
         
         #reviewwrite .bt_wrap {
             margin-top: 30px;
             text-align: center;
             font-size: 0;
         }
         
         #reviewwrite .bt_wrap input {
             display: inline-block;
             min-width: 80px;
             margin-left: 10px;
             padding: 10px;
             border: 1px solid #000;
             border-radius: 2px;
             font-size: 1.4rem;
         }
         
         #reviewwrite .bt_wrap input:first-child {
             margin-left: 0;
         }
         
         #reviewwrite .bt_wrap input.on {
             background: gray;
             color: #fff;
         }
         
      
         #reviewwrite .board_write {
             border-top: 2px solid #000;
             
         }
         
         #reviewwrite .board_write .title,
         .board_write .info {
             padding: 15px;
         }
         
         #reviewwrite .board_write .info {
             border-top: 1px solid #000;
             border-bottom: 1px solid #000;
             font-size: 0;
         }
         
        #reviewwrite .board_write .title dl {
             font-size: 0;
         }
         
         
         #reviewwrite .board_write .info dl {
             display: inline-block;
             width: 50%;
             vertical-align: middle;
         }
         
        #reviewwrite .board_write .title dt,
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

    #reviewwrite img {
      width: 30px;
      height: 30px;
    }

    #reviewwrite .real-upload {
      display: none;
    }

    #reviewwrite .image-preview {
      display: none;
      width: 200px;
      height: 200px;
      background-color:white;
      gap: 20px;
    }
     </style>


<script>

jQuery(function($){
     
    $("#hopedate").datepicker({
        changeMonth:true,
        changeYear:true,
        yearRange:"2022:2099",
        showOn:"both",
        buttonImage:"<%=request.getContextPath()%>/images/adopt/calendar.gif",
        buttonImageOnly:true,
        dateFormat: 'yy-mm-dd',
        showOtherMonths: true,
        selectOtherMonths: true,
        showMonthAfterYear: true,
        dayNamesMin: ['일','월', '화', '수', '목', '금', '토'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        monthNames: ['년 1월','년 2월','년 3월','년 4월','년 5월','년 6월','년 7월','년 8월','년 9월','년 10월','년 11월','년 12월'],
        nextText: '다음 달',
        prevText: '이전 달',
        maxDate: "+5m",
        beforeShowDay: disableAllTheseDays,
        /* onChangeMonthYear: function(year,month,inst){
        	beforeShowDay: disableAllTheseDays;
        } */
       
    });
    $('#hopedate').datepicker('setDate', 'today');
    
});
 
	var disabledDays =  <%=request.getAttribute("hopeDateArr")%>;  
	 
	function disableAllTheseDays(date) {
		if (date < new Date()){
			return [false];
		}
		
	    var m = date.getMonth()+1, d = date.getDate(), y = date.getFullYear();
	    console.log(m,d,y);
	    if(m<10) m="0"+m;
	    if(d<10) d="0"+d;
	    for (i = 0; i < disabledDays.length; i++) {
	    	
	        if($.inArray(y + '-' + m + '-' + d,disabledDays) != -1) {
	        	
	            return [false];
	        }
	    
	    }
	    return [true];
	    
	    /* $("다음 달").click(e=>{
	    	for (i = 0; i < disabledDays.length; i++) {
		    	
		        if($.inArray(y + '-' +(m) + '-' + d,disabledDays) != -1) {
		            return [false];
		        }
		    
		    }
		    return [true];
	    }); */
	    
	} 

    $(document).ready(function() {
    $('#summernote').summernote({
        tablesize :2,
        height:500
    });
    });
	
    /* $(function(){
        var dtToday = new Date();

        var month = dtToday.getMonth() + 1;
        var day = dtToday.getDate();
        var year = dtToday.getFullYear();
        if(month < 10)
            month = '0' + month.toString();
        if(day < 10)
         day = '0' + day.toString();
        var minDate = year + '-' + month + '-' + day;
       
        var maxDate = (year+1) + '-' + month + '-' + day;
            
        $('#hopedate').attr('min', minDate).attr('max',maxDate);
    }); */
    
    const checkForm=()=>{
        const roommate=$("#roommate_").val().trim();
        const allergy=$("#allergy_").val().trim();
        const money=$("#money_").val().trim();
        const exp=$("#exp_").val().trim();
        const live=$("#live_").val().trim();
        
        if(roommate.length<2 && allergy.length<2 && money.length<2 && exp.length<2 && live.length<2){
           alert("2글자 이상 입력하세요");
           return false;
        }

     }
    </script>
<%@ include file="/views/common/footer.jsp"%>