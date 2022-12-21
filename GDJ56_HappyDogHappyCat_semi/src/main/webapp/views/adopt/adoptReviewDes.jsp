<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@  page import="java.util.List, java.util.Arrays,com.happy.adopt.model.vo.AdtReviewBorad,com.happy.adopt.model.vo.AdtReviewComment,
				com.happy.adopt.model.vo.AdoptPhoto" %>
    <% AdtReviewBorad arb = (AdtReviewBorad)request.getAttribute("arb"); 
    List<AdtReviewComment> comments = (List<AdtReviewComment>)request.getAttribute("comments");
    List<AdoptPhoto> adtPhoto =(List<AdoptPhoto>)request.getAttribute("adtPhoto");%>

<body>
    <section id="content">
        <div id="imgs" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
            <img src="<%=request.getContextPath() %>/images/adopt/Q.jfif" alt="" style="margin-right: auto;">
            <div id="text" >
                <br><br>
                <h1>입양후기</h1>
                <p>보호중인 파양동물들과 유기된 동물들을<br> 
                    상시로 공고하고 있습니다.<br>
                    입양후 보호자와 행복하게 지내는<br>
                    아이들을 볼 수 있습니다.</p>
            </div>
            <img src="<%=request.getContextPath() %>/images/adopt/S.jfif" alt="" style="margin-left: auto;">
        </div>
        <br><br>
        <%if(loginMember!=null&&(loginMember.getMemberNo()==arb.getMemberNo()||loginMember.getMemberId().equals("admin"))){%>
        	<div style="float:right; width:200px;">
	        	<button onclick="location.assign('<%=request.getContextPath() %>/member/mypage/adoptReviewUpdate.do?adbReviewBoardNo=<%=arb.getAdtBoardNo()%>');">수정</button>
	        	<button onclick="location.assign('<%=request.getContextPath() %>/member/mypage/adoptReviewDelete.do?adbReviewBoardNo=<%=arb.getAdtBoardNo()%>');">삭제</button>
        	</div>
        <%}%>
        <div id="title">
            <h2>[<%=arb.getAdtTitle() %>]</h2><br>
        </div>
        <br><br>
        
        <div style="text-align: center; width: 600px; margin: auto; word-break:break-all;word-wrap:break-word;">
            <p><%=arb.getAdtContents() %></p>
        </div>

        <br><br><br><br>
        <div id="detail">
            <div id="detailTitle"><br>
                <h2>HAPPY DOG HAPPY CAT</h2>
                <br>
            </div>
			<%if(adtPhoto.isEmpty()){ %>
			<p>이미지가 없습니다</p><br><br>
			<%}else{ %>
				<%for(int i=0;i<adtPhoto.size();i++){ %>
					<img src="<%=request.getContextPath() %>/upload/adopt/<%=adtPhoto.get(i).getAdtPhotoRename() %>" alt=""><br><br><br><br>
				<%} %>
			<%} %>
            <%-- <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt=""><br><br><br><br>
            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt=""><br><br><br><br> --%>
        </div>
        
        <div id="checklist">
            <div id="detailTitle"><br>
            </div>
        </div>
        </section>
        
        <div id="reply" style=" text-align: left; width: 600px; margin: auto; word-break:break-all;word-wrap:break-word;">
        <div id="comment_box1" style="cursor: pointer;">
        	<h3>댓글창보기(<%=comments.size() %>)</h3>
        </div>
        <div id="comment_lists">
	        <%-- <form action="<%=request.getContextPath()%>/adopt/adoptwrite";> --%>
	            <textarea name="textarea1" id="textarea2" cols="90" rows="3" placeholder="댓글을 입력해주세요."></textarea>
	            <button id="reply-btn" type="button" class="btn btn-outline-secondary" style="float: right;">등록</button>
	        <!-- </form> -->
	        <br><br>
	        <div style="border-top: solid rgba(0, 0, 0, 0.614);">
	        </div>
	        <%if(comments.isEmpty()){ %>
	        	<div style="border-bottom: solid rgba(0, 0, 0, 0.482);">
	            	<p>댓글이 없습니다.</p>
	        	</div>
	        <%}else{ %>
	        	<%for(int i=0;i<comments.size();i++){ %>
	        		<div style="border-bottom: solid rgba(0, 0, 0, 0.482);">
	            		<p><b><%=comments.get(i).getMemberId() %></b> <small><%= comments.get(i).getCommentWriteDate().substring(0,10) %></small></p>
	            		<p><%=comments.get(i).getCommentContents() %></p>
	        		</div>
	        	<%} %>
	        <%} %>
	    
        </div>
    </div>
    <br>
        <div id="adp_btn">
        	<a href="<%=request.getContextPath()%>/adopt/adoptreview.do">
            <button type="button" class="btn btn-primary"><p>목록가기</p></button>
            </a>
            <br>
        </div>
        <br><br>
    
    <%@ include file="/views/common/footer.jsp"%>
    <script>
    $("#comment_box1 h3").click(e=> {  
        $("#comment_lists").slideToggle(); 
    });
    
    $("#textarea2").focus(e=>{
		if(<%=loginMember==null%>){
			$("#textarea2").blur();
			alert('로그인 후 이용할 수 있습니다.');
		}
 		else{
			$("#reply-btn").click(e=>{
				const reply=$("#textarea2").val();
				console.log(reply);
				$.ajax({
					url:"<%=request.getContextPath()%>/adopt/adoptreviewcomment.do",
					type:"get",
					data:{reply:reply,memberId:"<%=loginMember!=null?loginMember.getMemberId():0%>" ,reviewBoardNo:"<%=arb.getAdtBoardNo()%>"},
					success:data=>{
						console.log(data);
					
						alert("댓글 등록 성공!")
						location.assign("<%=request.getContextPath()%>/adopt/adoptreviewdes.do?AdtBoardNo=<%=arb.getAdtBoardNo()%>");
					}
		    	});
			});
			}
		
	}); 
</script>
    
    <style>
    div#comment_lists{
        display:none;
    }
    textarea{
    	box-sizing: border-box; 
    	border: solid 2px gray;
    	border-radius: 5px; 
    	resize: none;
    	outline-color: #FE6B8B;
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
    #content div{
            text-align: center;
        }
        #imgs img{
            width: 200px;
            height: 250px;
            opacity: 0.5; 
        }

</style>