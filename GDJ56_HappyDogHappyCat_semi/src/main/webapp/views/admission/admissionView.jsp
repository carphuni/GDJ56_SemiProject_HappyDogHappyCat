<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.happy.animal.model.vo.Animal,
java.util.List,
com.happy.admission.vo.AnimalPhoto" %>
<%
	Animal ani=(Animal)request.getAttribute("ani");
	List<AnimalPhoto> ap=(List<AnimalPhoto>)request.getAttribute("aniPhoto");
%>
<%@ include file="/views/common/header.jsp"%>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script>
  Kakao.init('b5705da8bbf6d5f007956cd8575caa16'); // 사용하려는 앱의 JavaScript 키 입력
</script>
    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->

<style>
	#content div{
            text-align: center;
        }
        #imgsbar img{
            width: 200px;
            height: 250px;
            opacity: 0.5; 
        }
    div#title{
        text-align: center;
        border-bottom: 2px solid rgb(194, 192, 192);
        width: 1000px;
        margin: 0 auto;
    }
    div#imgs{
        text-align: center;
    }
    div#description>table, td, th{
        margin:auto;
        border : 1px solid rgb(215, 211, 211);
        border-collapse : collapse;
    }
    div#description>table th{
        background-color: rgba(220, 220, 220, 0.612);
    }
    div#description>table{
        width: 800px;
        height: 200px;
        text-align: center;
    }
    div#detail{
        text-align: center;
    }
    div#detailTitle{
        text-align: center;
        border-top: 2px solid rgb(194, 192, 192);
        width: 700px;
        margin: 0 auto;
    }
    div#detailTitle h2{
        color: rgb(59, 120, 235);
    }
    div#detail img{
        width: 350px;
        height: 250px;
    }
    div#adp_btn{
        text-align: center;
    }
    div#adp_btn button{
        width: 350px;
        height: 60px;
    }
    div#adp_btn p{
        font-weight: 6px;
        letter-spacing: 5px;
        font-size: large;
        margin: auto;
    }
	.sideBanner {
        position: absolute;
        width: 140px;
        height: 140px;
        top: 50px;
        right: 20px;
        border-radius: 80px;
        border: solid 2px rgb(215, 211, 211);
    }
    #sideBanner-inner{
        text-align: center;
    }
    #pick{
        cursor: pointer;
    }
    #btnlistdiv{
            width:900px; 
            height:100px; 
            margin: auto;
        }
        #btnlist{
            width: 80px;
            height: 38px;
            float: right;
            cursor: pointer;
        }
</style>

    <section id="content">
	    <div id="imgsbar" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
	            <img src="<%=request.getContextPath() %>/images/admission/dog1.png" alt="" style="margin-right: auto;">
	            <div id="text" >
	                <br>
	                 <h1 style="font-size: 30px; text-align: center;">입소신청</h1>
                 		<p style="font-size: 20px; text-align: center;">더이상 거짓된 보호소들에 속지 마세요.<br> 
                    <br>해피독해피캣은 꼼꼼한 입소절차를 통해<br>
                    <br>아이들을 안전하게 보호하겠습니다.<br>
                    </p>
	            </div>
	            <img src="<%=request.getContextPath() %>/images/admission/dog2.png" alt="" style="margin-left: auto;">
	     </div>
	     <br><br>
        <div id="title">
            <h2>입소신청[<%=ani.getAniType() %>]<%=ani.getAniKind() %> <%=ani.getAniName() %> </h2><br>
        </div>
        <br><br>
        
        <%for(int i=0;i<ap.size();i++){ %>
        <%if(ap.get(i).getMainPhoto()!=null){ %>    
        <div id="imgs">
            <img src="<%=request.getContextPath() %>/upload/admission/<%=ap.get(i).getAdPhotoReName() %>" alt="" width="350" height="400">
        </div>
       	 <%}
        }%>
        
        <br><br>

        <div id="description">
            <table >
                <tr>
                    <th>견종</th>
                    <td><%=ani.getAniKind() %></td>
                    <th>나이</th>
                    <td><%=ani.getAniAge() %>살</td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td><%= ani.getAniGender() == 'M' ? "남":"여"%></td>
                    <th>중성화여부</th>
                    <td><%=ani.getAniNeuYn() == 'Y' ? "O":"X"%></td>
                </tr>
                <tr>
                    <th>기본 예방접종 유무</th>
                    <td colspan="3">
                        <input type="checkbox" value="광견병" <%=ani.getMadDog() == 'Y' ? "checked":""%> onclick="return false;">광견병
                        <input type="checkbox" value="코로나장염" <%=ani.getCovid() == 'Y' ? "checked":""%> onclick="return false;">코로나장염
                        <input type="checkbox" value="켄넬코프" <%=ani.getKennel() == 'Y' ? "checked":""%> onclick="return false;">켄넬코프
                        <input type="checkbox" value="인플루엔자" <%=ani.getInflu() == 'Y' ? "checked":""%>  onclick="return false;">인플루엔자
                        <input type="checkbox" value="항체가검사" <%=ani.getAntibody() == 'Y' ? "checked":""%> onclick="return false;">항체가검사
                        <input type="checkbox" value="종합백신" <%=ani.getTotalvac() == 'Y' ? "checked":""%> onclick="return false;">종합백신
                    </td>
                </tr>
                <tr>
                    <th>특이사항</th>
                    <td colspan="3">
                        <%=ani.getAniSpecial() %>
                    </td>
                </tr>
                <tr>
                    <th>보호소로 오게 된 이유</th>
                    <td colspan="3">
                        <%=ani.getAniReason() %>
                    </td>
                </tr>
            </table>
            <br>
        <%for(int i=0;i<ap.size();i++){ %>
        	<%if(ap.get(i).getMainPhoto()==null){ %>    
        	<div id="imgs">
            	<img src="<%=request.getContextPath() %>/upload/admission/<%=ap.get(i).getAdPhotoReName() %>" alt="" width="350" height="400">
        	</div>
        	<%}
        }%>
        </div>
        <br><br><br><br>
        
        <div id="btnlistdiv">
        	<a href="<%=request.getContextPath()%>/admission/admissionList.do";>
                <button id="btnlist" type="button" class="btn btn-secondary btn-sm"><p>글목록</p></button>
       		</a>
        </div>
	    <br>
	    
<script>
	//카카오톡 공유하기
	function shareMessage() {
    Kakao.Link.sendDefault({
      objectType: 'feed',
      content: {
        title: 'HAPPYDOG HAPPYCAT',
        description: '사지말고 입양하세요',
        imageUrl:
          'https://ifh.cc/g/Ar5Jwk.png',
        link: {
          webUrl: '웹 링크',
        },
      },
      buttons: [
        {
          title: '자세히보기',  
          link: {
            /* webUrl: 'http://localhost:9090/happy/views/adopt/adoptDes.jsp', */
        	  webUrl: 'http://localhost:9090/GDJ56_HappyDogHappyCat_semi/adopt/adoptdes.do?aniNo=<%=ani.getAniNo()%>',
          },
        },
      ],
    })
  }
	

	
	 $("#pick").click(e=>{
		if(<%=loginMember==null%>){
	    	alert('로그인이 필요한 서비스입니다.');
	    }
		
		if(<%=loginMember!=null%>){
	    	if($(e.target).html()=='🤍'){
		        $("#pick").html("❤️"); 
		    }
	    	else{
		        $("#pick").html("🤍");
		    }
		}
	});
	
	<%-- const clickpick=(e)=>{
	    console.log($(e.target).html());
	    if(<%=loginMember==null%>){
	    	alert('로그인이 필요한 서비스입니다.');
	    }
	    if(<%=loginMember!=null%>){
	    	if($(e.target).html()=='🤍'){
		        /* $("#pick").html("❤️"); */
		        $.get("<%=request.getContextPath()%>/adopt/adoptpick.do?memberNo=<%=loginMember.getMemberNo()%>",
		        		data=>{
		        			$("#pick").html("❤️");  
			               });
		    }else{
		        $("#pick").html("🤍");
		    }
	    }
	    
	} --%>
	
	// 기본 위치(top)값
	var floatPosition = parseInt($(".sideBanner").css('bottom'));
	
	// scroll 인식
	$(window).scroll(function() {
	
	// 현재 스크롤 위치
	var currentTop = $(window).scrollTop();
	var newPosition = currentTop + floatPosition + "px";
	
	//이동 애니메이션
	$(".sideBanner").stop().animate({
	        "top" : newPosition
	    }, 500);
	}).scroll();
	
    const checkList=()=>{
    	//const title="checkList";
    	popup=open("<%=request.getContextPath()%>/adopt/adoptdespopup.do",title,"width=650 height=500 top=50, left=500");
    }
    
    const apt_form=()=>{
    	const ckck=document.getElementById("ckck").checked;
    	if(!ckck){
    		alert('체크리스트를 확인하고 오세요');
    	}else{
    		location.assign("<%=request.getContextPath() %>/adopt/adoptwrite.do?aniNo=<%=ani.getAniNo()%>");
    	}
    }
    
</script>

<%@ include file="/views/common/footer.jsp"%>