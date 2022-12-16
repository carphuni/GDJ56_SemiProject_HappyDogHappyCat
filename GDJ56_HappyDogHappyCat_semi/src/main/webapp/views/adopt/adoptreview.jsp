<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>
<%@  page import="java.util.List, java.util.Arrays,com.happy.adopt.model.vo.AdtReviewBorad" %>
    <% List<AdtReviewBorad> rList = (List<AdtReviewBorad>)request.getAttribute("rList"); %>

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
        <section class="post">
              <div id="board-search">
                  <div class="container">
                      <div class="search-window">
                          <form action="">
                              <div class="search-wrap">
                                  <label for="search" class="blind">내용 검색</label>
                                  <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">&nbsp;
                                  <button type="submit" class="btn btn-dark">검색</button> &nbsp;
                                  <!-- <button class="btn btn-dark">입양글쓰기</button> -->
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
              <div id="board-list">
                  <div class="container">
                      <table class="board-table">
                          <thead>
                          <tr>
                              <th scope="col" class="th-num">번호</th>
                              <th scope="col" class="th-title">제목</th>
                              <th scope="col" class="th-title">작성자</th>
                              <th scope="col" class="th-date">등록일</th>
                              <th scope="col" class="th-date">조회수</th>
                          </tr>
                          </thead>
                          <tbody>
                          <%if(rList.isEmpty()){%>
                        	  <tr>
	                              <td colspan="5">조회된 후기가 없습니다.</td>
                          <%}else{ %>
                          	<% for(int i=0;i<rList.size();i++){ %>
                          		<tr>
                                <td><%=rList.get(i).getAdtBoardNo() %></td>
                                <th>
                                  <a href="<%=request.getContextPath()%>/adopt/adoptreviewdes.do?AdtBoardNo=<%=rList.get(i).getAdtBoardNo() %>"><%=rList.get(i).getAdtTitle()==null?"후기입니다.":rList.get(i).getAdtTitle() %></a>
                                </th>
                                <td><%=rList.get(i).getMemberId() %></td>
                                <td><%=(rList.get(i).getAdtWriteDate()).substring(0,10) %></td>
                                <td><%=rList.get(i).getAdtViews() %></td>
                            </tr>
                          	<%}%>
                          <%}%>
                            
                          </tbody>
                      </table>
                      <br>
                      <a href="<%=request.getContextPath()%>/adopt/adoptreviewwrite.do";>
                  		<button id="apt_write" class="btn btn-dark">입양후기쓰기</button>
                  		</a>
                  		<%=request.getAttribute("pageBar") %>
                  <%-- <div class="page_wrap">
                    <div class="page_nation">
                       <%=request.getAttribute("pageBar") %>
                    </div>
                  </div>   --%>
              </div>
             </div>
          </section>   
    </section>
    <style>
        .page_nation {
            display:inline-block;
        }
        .page_nation .none {
            display:none;
        }
        .page_nation a {
            display:block;
            margin:0 3px;
            float:left;
            border:1px solid #e6e6e6;
            width:28px;
            height:28px;
            line-height:28px;
            text-align:center;
            background-color:#fff;
            font-size:13px;
            color:#999999;
            text-decoration:none;
        }
        .page_nation .arrow {
            border:1px solid #ccc;
        }

        .page_nation .prev {
            background:#f8f8f8 url('./images/page_prev.png') no-repeat center center;
            margin-right:7px;
        }
        .page_nation .next {
            background:#f8f8f8 url('./images/page_next.png') no-repeat center center;
            margin-left:7px;
        }
        .page_nation a.active {
            background-color:#42454c;
            color:#fff;
            border:1px solid #42454c;
        }
        .page_wrap {
        text-align:center;
       margin: auto;
        font-size:0;
        }
        #apt_write{
            float: right;
        }
        table {
            border-collapse: collapse;
            border-spacing: 0;
        }
        section.post {
        padding: 80px 0;
        }
        #board-search .search-window {
        padding: 15px 0;
        background-color: #f9f7f9;
        }
        #board-search .search-window .search-wrap {
        display: flex;
            position: relative;
        /*   padding-right: 124px; */
        margin: 0 auto;
        width: 80%;
        max-width: 564px;
        }
        #board-search .search-window .search-wrap input {
        height: 40px;
        width: 100%;
        font-size: 14px;
        padding: 7px 14px;
        border: 1px solid #ccc;
        }
        #board-search .search-window .search-wrap input:focus {
        border-color: #333;
        outline: 0;
        border-width: 1px;
        }
        #board-search .search-window .search-wrap .btn {
        /* position: absolute; */
        right: 0;
        top: 0;
        bottom: 0;
        width: 108px;
        padding: 0;
        font-size: 16px;
        }

        .board-table {
        font-size: 13px;
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
        }

        .board-table a {
        color: #333;
        display: inline-block;
        line-height: 1.4;
        word-break: break-all;
        vertical-align: middle;
        }
        .board-table a:hover {
        text-decoration: underline;
        }
        .board-table th {
        text-align: center;
        }

        .board-table .th-num {
        width: 100px;
        text-align: center;
        }

        .board-table .th-date {
        width: 200px;
        }

        .board-table th, .board-table td {
        padding: 14px 0;
        }

        .board-table tbody td {
        border-top: 1px solid #e7e7e7;
        text-align: center;
        }

        .board-table tbody th {
        padding-left: 28px;
        padding-right: 14px;
        border-top: 1px solid #e7e7e7;
        text-align: left;
        }

        .board-table tbody th p{
        display: none;
        }

        .btn {
        display: inline-block;
        padding: 0 30px;
        font-size: 15px;
        font-weight: 400;
        background: transparent;
        text-align: center;
        white-space: nowrap;
        vertical-align: middle;
        -ms-touch-action: manipulation;
        touch-action: manipulation;
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
        border: 1px solid transparent;
        text-transform: uppercase;
        -webkit-border-radius: 0;
        -moz-border-radius: 0;
        border-radius: 0;
        -webkit-transition: all 0.3s;
        -moz-transition: all 0.3s;
        -ms-transition: all 0.3s;
        -o-transition: all 0.3s;
        transition: all 0.3s;
        }

        .btn-dark {
        background: #555;
        color: #fff;
        }

        .btn-dark:hover, .btn-dark:focus {
        background: #373737;
        border-color: #373737;
        color: #fff;
        }

        .btn-dark {
        background: #555;
        color: #fff;
        }

        .btn-dark:hover, .btn-dark:focus {
        background: #373737;
        border-color: #373737;
        color: #fff;
        }

        /* reset */

        * {
        list-style: none;
        text-decoration: none;
        padding: 0;
        margin: 0;
        box-sizing: border-box;
        }
        .clearfix:after {
        content: '';
        display: block;
        clear: both;
        }
        .container {
        width: 1100px;
        margin: 0 auto;
        }
        .blind {
        position: absolute;
        overflow: hidden;
        clip: rect(0 0 0 0);
        margin: -1px;
        width: 1px;
        height: 1px;
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
</body>
<%@ include file="/views/common/footer.jsp"%>