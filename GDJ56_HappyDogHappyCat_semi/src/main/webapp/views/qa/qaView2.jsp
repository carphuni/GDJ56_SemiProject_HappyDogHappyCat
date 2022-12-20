<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.happy.qa.vo.QaForm"%>
<%
	QaForm q=(QaForm)request.getAttribute("qas");
%>
<%@include file="/views/common/header.jsp"%>
  <div id="title">
            <h2><!--[<%=q.getQaBoardNo() %>]<%=q.getQaTitle() %> --></h2><br>
        </div>
        <br><br>
        
        <div id="imgs">
            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="" width="350" height="250">
        </div>
        <br><br>

        <div id="description">
            <table >
                <tr>
                    <th>내용</th>
                    <td><!--<%=q.getQaContents() %>--></td>
                    <th>작성날짜</th>
                    <td><!--<%=q.getQaWriteDate() %>--></td>
                </tr>
                <tr>
                    <th>답변</th>
                    <td><!--<%= q.getQaReply() %>--></td>           
                </tr>
                
           
            </table>
        </div>
<%@include file="/views/common/footer.jsp"%>        
       