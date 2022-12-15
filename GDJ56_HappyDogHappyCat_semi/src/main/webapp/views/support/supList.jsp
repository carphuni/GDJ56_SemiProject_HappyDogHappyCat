<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List, com.happy.support.model.vo.Support,com.happy.support.model.vo.SupPhoto,com.happy.vol.model.vo.Agency" %>
<%
	List<Support> list = (List<Support>)request.getAttribute("support");
	List<Agency> list2 = (List<Agency>)request.getAttribute("agency");
	List<SupPhoto> list3 = (List<SupPhoto>)request.getAttribute("supPhoto");
	List<Agency> a = (List<Agency>)request.getAttribute("ag");
%>         
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/suplist.css"/>

<section id="content">
  <div style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
      <img src="<%=request.getContextPath()%>/images/vol/dog1.png" alt="" style="margin-right: auto;">
      <div id="text" style="margin-top:2%;">
          <h1>후원하기</h1>
           <p>도움이 필요한 동물보호소의 후원을<br>
              상시로 공고하고 있습니다.<br>
              자세한 안내는 게시물을<br>
              참고해주세요.</p>
      </div>
      <img src="<%=request.getContextPath()%>/images/vol/dog2.png" style="margin-left: auto;">
  </div>


 <br><br>
        <div id="post" style="flex-wrap:wrap; width:80%;">
       
       <% for(int i=0;i<list.size();i++){ %> 
      
            <div id="dog-des" style="margin-bottom:0;cursor:pointer;" onclick="location.assign('<%=request.getContextPath()%>/supview.do?boardNo=<%=list.get(i).getSupBoardNo()%>&&agencyNo=<%=list2.get(i).getAgencyNo()%>')">
                <img id="adp_img" src="<%=request.getContextPath()%>/upload/support/<%=list3.get(i).getSupPhotoRename() %>" alt="" style="width:250px; height:250px;">
                <div style="word-break:break-all;word-wrap:break-word; width:250px;"><br>
                <p ><%=list.get(i).getSupTitle() %>
                </p>
                 <b><%=list2.get(i).getAgencyName() %></b></p>
                </div>
                <div style="margin-top: auto;">
                     <progress value="20" max="100"></progress><br>
					<div style="margin-left: 53%;"><%=list.get(i).getSupTargetAmount() %></div>
					<br><br>
                   
                </div>
            </div>
            
            <%} %> 
          </div>
          <br><br>
          <div style="text-align:center;padding:50px;">
      <%=request.getAttribute("pageBar") %>
      </div>
      <% for(int i=0;i<a.size();i++){ 
			if(loginMember!=null&&loginMember.getMemberNo()==a.get(i).getMemberNo()){%>  
      <div style="margin-top:100px;"><a href="<%=request.getContextPath()%>/supwrite.do?memberNo=<%=loginMember!=null?loginMember.getMemberNo():"" %>" class="myButton">글쓰기</a></div>
       <%}} %>
      <div class="page_wrap">
        <div class="page_nation">
           
          <!--  <a class="arrow prev" href="#"></a>
           <a href="#" class="active">1</a>
           <a href="#">2</a>
           <a href="#">3</a>
           <a href="#">4</a>
           <a href="#">5</a>
           <a href="#">6</a>
           <a href="#">7</a>
           <a href="#">8</a>
           <a href="#">9</a>
           <a href="#">10</a>
           <a class="arrow next" href="#"></a> -->
        </div>
     </div>
   
     
</section>



<%@ include file="/views/common/footer.jsp" %>