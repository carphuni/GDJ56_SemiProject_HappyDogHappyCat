<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List,
com.happy.qa.vo.QaForm" %>
<%
int qaBoardNo =(int)request.getAttribute("qaBoardNo");
%>
<%@include file="/views/common/header.jsp"%>
	<div style="border: solid 1px black; text-align:center; height:300px;" >
		<div style="margin-top:80px;">
			<form action="<%=request.getContextPath() %>/qa/qaPwEnd.do?qaBoardNo=<%=qaBoardNo%>" method="post">
			<p>비밀번호를 입력하세요.</p>
			<input type="text" name="qaPassNum" id="qaPassNum">
			<input type="submit" value="입력">
			</form>
		</div>
	</div>

<%@include file="/views/common/footer.jsp"%>
<script>
	






</script>