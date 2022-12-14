<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.happy.vol.model.vo.Volunteer,com.happy.vol.model.vo.Agency,com.happy.vol.model.vo.VolPhoto" %>
<%
	List<Volunteer> list = (List<Volunteer>)request.getAttribute("volunteer");
	 List<Agency> list2 = (List<Agency>)request.getAttribute("agency");
	 List<VolPhoto> list3 = (List<VolPhoto>)request.getAttribute("volPhoto");
	
%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/volView.css"/>

 <section id="content">
     <div style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
         <img src="<%=request.getContextPath()%>/images/vol/dog1.png" alt="" style="margin-right: auto;">
         <div id="text" style="margin-top:2%;">
             <h1>자원봉사</h1>
              <p>도움이 필요한 동물보호소의 자원봉사 모집을<br>
                 상시로 공고하고 있습니다.<br>
                 자세한 안내는 게시물을<br>
                 참고해주세요.</p>
         </div>
         <img src="<%=request.getContextPath()%>/images/vol/dog1.png" style="margin-left: auto;">
     </div>
 </section>


<section>
<div id="s1">
<% for(int i=0;i<list.size();i++){ %>
	<form action="<%=request.getContextPath()%>/volView2.do" method="post">
    <div class="s2">
    <table width="1000" border="0" cellpadding="0" cellspacing="0">
        <tbody>
	        <tr>
	        <td width="100"><%=list.get(i).getVntBoardNo() %></td><input type="hidden" name="boardNo" value="<%=list.get(i).getVntBoardNo() %>">
	        <td width="200" align="center"><img src="<%=request.getContextPath()%>/upload/volunteer/<%=list3.get(i).getVntPhotoRename() %>" alt="" width="200" height="200" border="0"></td>
	        <td width="1700">
        
          <table width="556" border="0" cellpadding="0" cellspacing="0">
          <tbody><tr><td <%-- style="cursor:pointer;" height="25" onclick="location.assign('<%=request.getContextPath()%>/volView2.do')" --%>><input style="background-color:transparent;border: none;
          font-weight: bold;" type="submit" value="<%=list.get(i).getVntRecName() %>"><b><span class="fontredbold"></a></span></font></b></td></tr>
       	  <input type="hidden" name="volViewTitle" value="<%=list.get(i).getVntRecName() %>">
        </td>
        </tr>
       
          <tr>
            <td><%=list.get(i).getVntActContents()%></td>

          </tr>
            <table border="0">
                <tbody>
                    <tr>
                        <hr>
                      <td width="100">단&nbsp;체&nbsp;명 &nbsp;:</td>
                      <td width="120"><%=list2.get(i).getAgencyName() %></td>
                      <input type="hidden" name="volAgencyName" value="<%=list2.get(i).getAgencyName() %>">
                      <td width="100">지&nbsp;&nbsp;&nbsp;&nbsp;역 :</td>
                      <td width="120"><%=list2.get(i).getAgencyAddress() %></td>
                      <input type="hidden" name="volAgencyAddress" value="<%=list2.get(i).getAgencyAddress() %>">
                      <td width="100">연락처 : </td>
                      <td width="280"><%=list2.get(i).getAgencyPhone() %></td>
                      <input type="hidden" name="volAgencyPhone" value="<%=list2.get(i).getAgencyPhone() %>">
                </tr>
                <tr>
                      <td>모집기간 :</td>
                      <td colspan="3"><%=list.get(i).getVntRecPeriod()%> ~ <%=list.get(i).getVntRecPeriodEnd() %></td>
                      <input type="hidden" name="rec" value="<%=list.get(i).getVntRecPeriod()%>">
                      <input type="hidden" name="recend" value="<%=list.get(i).getVntRecPeriodEnd()%>">
                      <input type="hidden" name="setperson" value="<%=list.get(i).getVntSetPerson()%>">
                      <td>봉사기간 :</td>
                      <td colspan="3"><%=list.get(i).getVntActPeriod() %> ~ <%=list.get(i).getVntActPeriodEnd()%></td>
                      <input type="hidden" name="act" value="<%=list.get(i).getVntActPeriod()%>">
                      <input type="hidden" name="actend" value="<%=list.get(i).getVntActPeriodEnd()%>">
                      <input type="hidden" name="day" value="<%=list.get(i).getVntActDay()%>">
                      <input type="hidden" name="contents" value="<%=list.get(i).getVntActContents()%>">
                </tr>
                <tr>
                      <td width="100">등&nbsp;록&nbsp;일 &nbsp;</td>
                      <td width="120"><span class="fontgray"><%=list.get(i).getVntActWriteDate() %></span></td>
                      <td width="100"><span class="fontgray">담&nbsp;당&nbsp;자 &nbsp;: </span></td>
                      <td width="120"><%=list.get(i).getVntManagerName() %></td>
                       <input type="hidden" name="manager" value="<%=list.get(i).getVntManagerName() %>">
                      <td width="100">조&nbsp;회&nbsp;수 :</td>
                      <td width="120"><%=list.get(i).getVntActViews() %></td>
                </tr>
                </tbody></table>
          </tr>
        </table>
        <hr style="border:dotted gray 1px">
         <%} %>
    </div>
   

    <div id="board-search">
      <div class="container">
          <div class="search-window">
              <form action="">
                  <div class="search-wrap">
                      <label for="search" class="blind"></label>
                      <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">&nbsp;
                      <button type="submit" class="btn btn-dark">검색</button> &nbsp;
                      <!-- <button class="btn btn-dark">입양글쓰기</button> -->
                  </div>
              </form>
          </div>
      </div>
  </div>
  <%=request.getAttribute("pageBar") %>
    <div class="page_wrap">
      <div class="page_nation">
      	
<!--          <a class="arrow prev" href="#"></a>
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
     
       <% for(int i=0;i<list2.size();i++){ 
    	int memberNo =list2.get(i).getMemberNo();
		if((loginMember!=null&&loginMember.getMemberId().equals("admin"))||loginMember!=null&&loginMember.getMemberNo()==memberNo){%> 
    <div id="register" style="margin-right:-200px;">
       <br><br><br><a href="<%=request.getContextPath()%>/volwrite.do?memberNo=<%=loginMember!=null?loginMember.getMemberNo():"" %>" class="myButton">글쓰기</a>
     </div>
      <%}break;} %>   
</div>
</section>
</form>
<%@ include file="/views/common/footer.jsp" %>