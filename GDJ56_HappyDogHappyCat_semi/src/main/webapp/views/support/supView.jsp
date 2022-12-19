<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.happy.vol.model.vo.Volunteer,com.happy.support.model.vo.SupPhoto,com.happy.support.model.vo.Support,com.happy.vol.model.vo.Agency,java.util.List" %>   
<%
	List<SupPhoto> sp = (List<SupPhoto>)request.getAttribute("photo");
	Agency agency = (Agency)request.getAttribute("agency");
	Support s = (Support)request.getAttribute("info");
%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/supview.css"/>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<div id="container">
    <img src="<%=request.getContextPath()%>/images/sup/01-aa-give-title-new02.png">
</div>

<div id="container2">
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
  <b>950,000원</b>
  <p><%=s.getSupTargetAmount() %>원 목표</p>

</div>
<div class="bt_wrap" >
    <a style="font-size:17px" href="" class="on"><img src="<%=request.getContextPath()%>/images/sup/heart-fill.svg">&nbsp;응원 7</a>
    <a style="font-size:17px;width:200px;cursor:pointer;" id="show" >기부하기</a>
    <a style="font-size:17px;"href="">목록</a>
</div>

<div class="background">
  <div class="window">
    <div class="popup">
      <div class="sel_money">
        <b style="font-size:25px;">기부금 결제</b>
        <p>응원 댓글 쓰기</p>
        <input type="text">
      </div>
      <a style="font-size:17px;width:200px;cursor:pointer;" onclick="requestPay()">결제하기</button>
      <a style="font-size:17px;cursor:pointer;" id="close">닫기</button>
    </div>
  </div>
</div>

<script>
	function show () {
	  document.querySelector(".background").className = "background show";
	}

	function close () { 
	  document.querySelector(".background").className = "background";
	}

	document.querySelector("#show").addEventListener('click', show);
	document.querySelector("#close").addEventListener('click', close);

	
 	function requestPay(){
		IMP.init("imp28146203");
		IMP.request_pay({
			pg : "html5_inicis",
			pay_method : "card",
			amount : 1000,
			buyer_email : 'bycpm4@daum.net'
			}, function(rsp){
				
				if(rsp.success){
					
					alert("결제성공");
					
				}else{
					
					alert(rsp.error_msg);
				}
			});
	}
		 		
			
	</script>
<script src="<%=request.getContextPath()%>/js/volView2.js"></script>
<%@ include file="/views/common/footer.jsp" %>