<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.happy.qa.vo.QaForm"%>
<%
	QaForm q=(QaForm)request.getAttribute("qas");
%>
<%@include file="/views/common/header.jsp"%>
  <div id="title">
            <h2>[<%=q.getQaBoardNo() %>]<%=q.getQaTitle() %></h2><br>
        </div>
        <br><br>
        
        <div id="imgs">
            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="" width="350" height="250">
        </div>
        <br><br>

        <div id="description">
            <table >
                <tr>
                    <th>문의 내용</th>
                    <td><%=q.getQaContents() %></td>
                    <th>작성날짜</th>
                    <td><%=q.getQaWriteDate() %></td>
                </tr>
                <tr>
                    <th>답변</th>
                    <td><%=q.getQaReply() %></td>           
                </tr>
                
           
            </table>
        </div>
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
<%@include file="/views/common/footer.jsp"%>        
       