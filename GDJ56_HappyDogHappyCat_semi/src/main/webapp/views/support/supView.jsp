<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.happy.vol.model.vo.Volunteer,com.happy.support.model.vo.SupPhoto,com.happy.support.model.vo.SupComment,com.happy.support.model.vo.Support,com.happy.vol.model.vo.Agency,java.util.List" %>   
<%
	List<SupPhoto> sp = (List<SupPhoto>)request.getAttribute("photo");
	Agency agency = (Agency)request.getAttribute("agency");
	Support s = (Support)request.getAttribute("info");
	int boardNo = (int)request.getAttribute("boardNo");
	List<SupComment> comments = (List<SupComment>)request.getAttribute("comment");
	List<Member> member = (List<Member>)request.getAttribute("member");

%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/supview.css"/>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<style>

  .sel_money{
    text-align: center;
    margin-top:5%;
  }

  .sel_money>p{
    margin-top:10%;

  }

  .popup>a {
        position:relative;
        bottom:-15%;
        margin-left: 5px;
        display:inline-block;
        min-width: 80px;
        /* margin-left: -40%; */
        padding: 10px;
        border: 1px solid #000;
        border-radius: 2px;
        font-size: 1.4rem;
        color:black;
        
         }

  .sel_money>input {
    width: 300px;
    height: 32px;
    font-size: 15px;
    border: 0;
    border-radius: 15px;
    outline: none;
    padding-left: 10px;
    background-color: rgb(233, 233, 233);
  }
  
    .bt_wrap {
             /* padding:20px; */
             margin-top: 20px;
             text-align: center;
             font-size: 0;
             margin-left:18%
         } .bt_wrap a {
             display: inline-block;
             min-width: 80px;
             /* margin-left: -40%; */
             padding: 10px;
             border: 1px solid #000;
             border-radius: 2px;
             font-size: 1.4rem;
             color:black;
         }
         
         .bt_wrap a:first-child {
             margin-left: 0;
             background-color: rgb(207, 207, 207);
             color:white;
             
         }

         .bt_wrap a:last-child{
          min-width: 80px;
          float:right;
          margin-right:17%;
         }
</style>
<div id="container">
    <img src="<%=request.getContextPath()%>/images/sup/01-aa-give-title-new02.png">
<% if(loginMember!=null&&loginMember.getMemberNo()==agency.getMemberNo()||loginMember!=null&&loginMember.getMemberId().equals("admin")){ %>
<div style="margin-top:5px;" class="bt_wrap" >
  <a style="font-size:17px;margin-right:-65%;"href="<%=request.getContextPath()%>/updatesup.do?boardNo=<%=boardNo%>&&memberNo=<%=loginMember!=null?loginMember.getMemberNo():"" %>">수정</a>
  <a style="font-size:17px;margin-right:20%"href="<%=request.getContextPath()%>/deletesup.do?boardNo=<%=boardNo%>">삭제</a>
</div>
<%} %>
</div>

<div id="container2" style="margin-left:-50px;">
    <div>
        <b><%=s.getSupTitle() %></b>
    </div>
</div>

<div class="slider-2">
    
    <div class="side-btns">
       <div><span><i class="fas fa-caret-left"></i></i></span></div>
       <div><span><i class="fas fa-caret-right"></i></span></div>
   </div>
   
   <div class="slides">
       <%for(int i=0;i<sp.size();i++){ %>
       <div <%=i==0?"class='active'":"" %>><img src="<%=request.getContextPath()%>/upload/support/<%=sp.get(i).getSupPhotoRename() %>" width="500" height="600"></div>
       <%} %>
   </div>
   
     <div class="page-nav">
   <%for(int i=0;i<sp.size();i++){ %>
       <div <%=i==0?"class='active'":"" %>></div>
    <%} %>
   </div>
</div>

<div class="cont">
<%=s.getSupContents() %>
</div>
<div class="money">
<%int amount=0;
for(int i=0;i<comments.size();i++){
	amount += comments.get(i).getSupPayAmount();
}%>
  <b id="amount"><%=amount %>원</b>

  <p><%=s.getSupTargetAmount() %>원 목표</p>

</div>
<div class="bt_wrap" >
    
    	<% if(loginMember==null){%> 
    	<a id="likeBtn" style="font-size:17px;cursor: pointer;" class="on" onclick="log()";><img src="<%=request.getContextPath()%>/images/sup/heart.svg">&nbsp;&nbsp;응원&nbsp;<%=s.getSupLikeCount() %></a>	
    		<a style="font-size:17px;width:200px;cursor:pointer;" onclick="log()"; >기부하기</a>
		<%}else{ 
			if((int)request.getAttribute("check")==0){
		%>			
	<a id="likeBtn" style="font-size:17px;cursor: pointer;" class="on"><img src="<%=request.getContextPath()%>/images/sup/heart.svg" >&nbsp;&nbsp;응원&nbsp;<%=s.getSupLikeCount() %></a>	
    		<%}else{ %>
    		<a id="likeBtn" style="font-size:17px;cursor: pointer;" class="on"><img src="<%=request.getContextPath()%>/images/sup/heart-fill.svg" >&nbsp;&nbsp;응원&nbsp;<%=s.getSupLikeCount() %></a>	
    		<%} %>
    <a style="font-size:17px;width:200px;cursor:pointer;" id="show" >기부하기</a>
    <%} %>
    <a style="font-size:17px;"href="<%=request.getContextPath()%>/suplist.do">목록</a>
</div>
<br><br><br>
  
 
	     <div id="reply" style=" text-align: left; width: 600px; margin: auto; word-break:break-all;word-wrap:break-word;">
        <div id="comment_box1" style="cursor: pointer;">
        	<h3>댓글(<%=comments.size() %>)</h3>
        </div>
        <div id="comment_lists">
	     <%--    <form action="<%=request.getContextPath()%>/adopt/adoptwrite";> --%>
	        <!--     <textarea name="textarea1" id="textarea2" cols="90" rows="3" placeholder="댓글을 입력해주세요."></textarea>
	            <button id="reply-btn" type="button" class="btn btn-outline-secondary" style="float: right;">등록</button>
	         </form>   -->
	        <br><br>
	        <div style="border-top: solid rgba(0, 0, 0, 0.614);">
	        </div>
	     
	        	<div id="commentcontainer">
	        	<%for(int i=0;i<comments.size();i++){ %>
	        		<div style="border-bottom: solid rgba(0, 0, 0, 0.482);">
	            		<p name="memid"><b><%=member.get(i).getMemberId()%></b>&nbsp;&nbsp;<b><%=comments.get(i).getSupPayAmount() %>원</b><small style="margin-left:150px;"><%= comments.get(i).getSupCommentWriteDate() %></small></p>
	            		<p name="contents"><%=comments.get(i).getSupCommentContents() %></p>
	        		</div>
	        	<%} %>
	        	
	        
	    
        </div>
    </div>
	    
        </div>
    </div>

<div class="background">
  <div class="window">
    <div class="popup">
      <div class="sel_money">
        <b style="font-size:25px;">기부금 결제</b>
        <p>결제 금액</p>
        <input type="text" id="pay" >
        <p>응원 댓글 쓰기</p>
        <input type="text" id="comment">
      </div>
      <a style="font-size:17px;width:200px;cursor:pointer;" onclick="requestPay()">결제하기</button>
      <a style="font-size:17px;cursor:pointer;" id="close">닫기</button>
    </div>
  </div>
</div>

<script>

	const log = () =>{
		alert("로그인 후 이용하세요.");
	}

	function show () {
	  document.querySelector(".background").className = "background show";
	}

	function close () { 
	  document.querySelector(".background").className = "background";
	}
	if(<%=loginMember!=null%>){
	document.querySelector("#show").addEventListener('click', show);
	document.querySelector("#close").addEventListener('click', close);
	}
	

 	function requestPay(){

		if($("#comment").val().trim()==''){
			alert("댓글을 입력해주세요")
		}
		else{
		IMP.init("imp28146203");
		IMP.request_pay({
			pg : "html5_inicis",
			name : "후원하기",
			pay_method : "card",
			amount : $("#pay").val(),
			 buyer_name : "<%=loginMember!=null?loginMember.getMemberName():""%>",
			buyer_email : "<%=loginMember!=null?loginMember.getMemberEmail():""%>"
		}, function(rsp){
				
				if(rsp.success){
					
				<%-- 	jQuery.ajax({
						url : "<%=request.getContextPath()%>/supview.do",
						method : "POST",
						headers : {"Content-Type" : "application/json"},
						data : {
							amount : rsp.amount,
							comment : "$('#comment').val()"
						}	
					}); --%>
					alert("결제가 완료되었습니다.");
					$.ajax({
						url : "<%=request.getContextPath()%>/supviewend.do",
						type : "post",
						data : {
								amount : $("#pay").val(),
								comment : $('#comment').val(),
								agencyNo : <%=agency.getAgencyNo()%>,
								boardNo : <%=boardNo%>
							 <%=loginMember!=null?",memberNo:"+loginMember.getMemberNo():""%>
								},
						success:data=>{
						
							close(); 
							 $("#comment").val('');
							$("#pay").val('');
							if(<%=comments.size()%>==0){
								location.reload();
							}
							else{
							const temp=$("#commentcontainer>div").first().clone();
							var date = new Date();
						    var year = date.getFullYear();
						    var month = ("0" + (1 + date.getMonth())).slice(-2);
						    var day = ("0" + date.getDate()).slice(-2);

							temp.find("p[name=memid]").html("<b>"+data.m.memberId+"</b>&nbsp;&nbsp;<b>"+data.sc.supPayAmount +"원</b><small style='margin-left:150px'>"+ year + "-" + month + "-" + day+"</small>");
							temp.find("p[name=contents]").html(data.sc.supCommentContents);
							
						   
							$("#commentcontainer").prepend(temp);
							$("#comment_box1").html("<h3>댓글("+<%=comments.size()+1%>+")</h3>");}
							/* location.reload(); */
							$("#amount").html((<%=amount%>+data.sc.supPayAmount)+"원");
							
						},error : function(request, status, error) {
						   	 alert("code : " + request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + error);
					    }
					});
					
				}else{
					
					alert(rsp.error_msg);
				}
			});
		
		}	
	};
	
	
	$(document).ready(function(){
	    $("#likeBtn").click(function(){
			$.ajax({
				url: "<%= request.getContextPath() %>/like.do",
				type : "post",
				data:  {boardNo : <%=boardNo%>
					<%=loginMember!=null?",memberNo:"+loginMember.getMemberNo():""%>
					}, //사용자 입력값전달
				success: function(data){
						/* alert(data.s.supLikeCount); */
						
						if(data.check==1){
						$("#likeBtn").html("<img src='<%=request.getContextPath()%>/images/sup/heart.svg'>&nbsp;&nbsp;응원&nbsp;"+data.s.supLikeCount);
						}else{
							$("#likeBtn").html("<img src='<%=request.getContextPath()%>/images/sup/heart-fill.svg'>&nbsp;&nbsp;응원&nbsp;"+data.s.supLikeCount);
						}
		
				},
				error: function(xhr, textStatus, errorThrown){
					console.log("ajax 요청 실패!");
					console.log(xhr, textStatus, errorThrown);
				}
			});
	    });
	});		
	</script>
<script src="<%=request.getContextPath()%>/js/volView2.js"></script>
<%@ include file="/views/common/footer.jsp" %>