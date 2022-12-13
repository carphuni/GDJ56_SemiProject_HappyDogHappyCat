<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.happy.vol.model.vo.Volunteer" %>
<%@ include file="/views/common/header.jsp" %>
<%
	Volunteer v = (Volunteer)request.getAttribute("info");
	String agency = (String)request.getAttribute("agency");
	String address = (String)request.getAttribute("address");
	String phone = (String)request.getAttribute("phone");
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/volView2.css"/>

<div id="container">
    <img src="<%=request.getContextPath()%>/images/vol/01-aa-give-title-new01.jpg">

</div>
<div id="container2">
    <table style="width: 70%;" >
        <tbody><tr>
            <td style="width: 18.2668%; background-color:lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="font-size: 14px;">
                    <span style="color: rgb(255, 255, 255);">제목</span></span>
                     <span style="font-size: 13px;"><br></span>
                </div>
            </td>
            <td colspan="3" style="width: 31.7989%; text-align: center;">
                <div id="title" style="text-align: left;"><%=v.getVntRecName() %></div></td>
        </tr>
            <tr>
            <td style="width: 18.2668%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="font-size: 14px;">
                    <span style="color: rgb(255, 255, 255);">시설이름</span></span>
                    <span style="font-size: 13px;"><br></span>
                </div>
            </td>
            <td style="width: 31.7989%; text-align: center;">
                 <div style="text-align: center;"><%=agency %></div></td>
            <td style="width: 16.82%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="font-size: 14px;">
                    <span style="color: rgb(255, 255, 255);">주소</span></span>
                    <span style="font-size: 13px;"><br></span>
                </div>
            </td>
            <td style="width: 33.1143%; text-align: center;">
                <div style="text-align: center;"><%=address %></div>
            </td>
        </tr>
        <tr>
            <td style="width: 18.2668%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="font-size: 14px;">
                    <span style="color: rgb(255, 255, 255);">담당자 이름</span></span>
                    <span style="font-size: 13px;"><br></span>
                </div>
            </td>
            <td style="width: 31.7989%; text-align: center;">
                <div style="text-align: center;"><%=v.getVntManagerName() %></div>
            </td>
            <td style="width: 16.82%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="font-size: 14px;">
                    <span style="color: rgb(255, 255, 255);">시설연락처</span></span>
                    <span style="font-size: 13px;"><br></span>
                </div>
            </td>
            <td style="width: 33.1143%; text-align: center;">
                <div style="text-align: center;"><%=phone %></div>
            </td>
        </tr>
        <tr>
            <td style="width: 18.2668%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="font-size: 14px;">
                    <span style="color: rgb(255, 255, 255);">모집기간</span></span>
                    <span style="font-size: 13px;"><br></span>
                </div>
            </td>
            <td style="width: 31.7989%; text-align: center;">
                <div style="text-align: center;"><%=v.getVntRecPeriod() %> ~ <%=v.getVntRecPeriodEnd() %></div>
            </td>
            <td style="width: 16.82%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="font-size: 14px;">
                    <span style="color: rgb(255, 255, 255);">모집인원</span></span>
                    <span style="font-size: 13px;"><br></span>
                </div>
            </td>
            <td style="width: 33.1143%; text-align: center;">
                <div style="text-align: center;"><%=v.getVntSetPerson() %></div>
            </td>
        </tr>
        <tr>
            <td style="width: 18.2668%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="color: rgb(255, 255, 255); font-size: 14px;">봉사활동기간</span>
                </div>
            </td>
            <td style="width: 31.7989%; text-align: center;">
                <div style="text-align: center;"><%=v.getVntActPeriod() %> ~ <%=v.getVntActPeriodEnd() %></div>
            </td>
            <td style="width: 16.82%; background-color: lightgray; text-align: center;">
                <div style="text-align: center;">
                    <span style="color: rgb(255, 255, 255); font-size: 14px;">활동가능요일</span>
                </div>
            </td>
            <td style="width: 33.1143%; text-align: center;">
                <div style="text-align: center;"><%=v.getVntActDay() %></div>
            </td>
        </tr>
    </tbody>
    </table>
</div>
    <div class="slider-2">
    
    <div class="side-btns">
       <div><span><i class="fas fa-caret-left"></i></i></span></div>
       <div><span><i class="fas fa-caret-right"></i></span></div>
   </div>
   
   <div class="slides">
       <div class="active"><img src="<%=request.getContextPath()%>/images/vol/루피.png" width="500" height="600"></div>
       <div><img src="<%=request.getContextPath()%>/images/vol/루피.png" width="500" height="600"></div>
       <div><img src="<%=request.getContextPath()%>/images/vol/루피.png" width="500" height="600"></div>
       <div><img src="<%=request.getContextPath()%>/images/vol/루피.png" width="500" height="600"></div>
   </div>
   
   <div class="page-nav">
       <div class="active"></div>
       <div></div>
       <div></div>
       <div></div>
   </div>
</div>
<div class="cont">
<%=v.getVntActContents() %>
</div>
<div class="bt_wrap" >
  <a style="font-size:17px;width:200px" href="" >신청하기</a>
  <a style="font-size:17px;"href="">목록</a>
</div>
         
</div>

<script src="<%=request.getContextPath()%>/js/volView2.js"></script>
<%@ include file="/views/common/footer.jsp" %>