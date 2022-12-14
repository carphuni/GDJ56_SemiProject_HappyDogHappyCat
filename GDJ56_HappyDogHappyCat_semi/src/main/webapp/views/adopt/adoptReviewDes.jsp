<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@  page import="java.util.List, java.util.Arrays,com.happy.adopt.model.vo.AdtReviewBorad" %>
    <% AdtReviewBorad arb = (AdtReviewBorad)request.getAttribute("arb"); %>

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

            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt=""><br><br><br><br>
            <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt=""><br><br><br><br>
        </div>
        <div id="checklist">
            <div id="detailTitle"><br>
            </div>
        </div>
        <br><br>
        <div id="adp_btn">
        	<a href="<%=request.getContextPath()%>/adopt/adoptreview.do">
            <button type="button" class="btn btn-primary"><p>목록가기</p></button>
            </a>
            <br>
        </div>
        <br><br>
    </section>
    <%@ include file="/views/common/footer.jsp"%>
    
    
    <style>
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