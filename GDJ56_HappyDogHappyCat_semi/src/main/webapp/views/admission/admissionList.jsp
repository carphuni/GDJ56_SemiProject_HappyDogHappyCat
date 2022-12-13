<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,
com.happy.animal.model.vo.Animal
,com.happy.admission.vo.AdmissionForm" %>
<%
	List<AdmissionForm> list=(List<AdmissionForm>)request.getAttribute("admissions");
%>
<%@include file="/views/common/header.jsp"%>
<section id="content">
        <div id="imgs" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
            <img src="<%=request.getContextPath() %>/images/admission/dog1.png" alt="" style="margin-right: auto;">
            <div id="text" >
                <br>
                <h1 style="font-size: 30px; text-align: center;">입소신청</h1>
                 <p style="font-size: 20px; text-align: center;">더이상 거짓된 보호소들에 속지 마세요.<br> 
                    <br>해피독해피캣은 꼼꼼한 입소절차를 통해<br>
                    <br>아이들을 안전하게 보호하겠습니다.<br>
                   </p>
            </div>
            <img src="<%=request.getContextPath() %>/images/admission/dog2.png" alt="" style="margin-left: auto;">
        </div>
        <section class="post">
              <div id="board-search">
                  <div class="container">
                      <div class="search-window">
                          <form action="">
                              <div class="search-wrap">
                                  <label for="search" class="blind">내용 검색</label>
                                  <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">&nbsp;
                                  <button type="submit" class="btn btn-dark" id="searchbtn">검색</button> &nbsp;
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
                              <th scope="col" class="th-look">조회수</th>
                          </tr>
                          </thead>
                          <%if(list.isEmpty()){ %>
                          <tbody>
                            <tr>
                                <td colspan="5">조회된 입소 신청내역이 없습니다.</td>
                            </tr>
                            <%}else{
                            	for(AdmissionForm a: list){%>
                            <tr>
                                <td><%=a.getAdmissionNo() %></td>
                                <th>
                                  <a href="">신청합니다:) </a>
                                </th>
                                <td>작성자</td>
                                <td><%=a.getWriteDate()%></td>
                                <td>조회수</td>
                            </tr>
                            <%}%>
                          </tbody>
                          <%} %>
                      </table>
                      <br>
                      <button type="button" id="write" class="btn btn-lgbtn-link" 
                     onclick="location.assign('<%=request.getContextPath()%>/admission/writeAdmission.do');">글쓰기&#128062;</button>
                  </div>
              </div>
          </section>
    </section>
    <style>
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
        font-family: "Poor story";
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
        font-size: 15px;
        width: 100%;
        border-top: 1px solid #ccc;
        border-bottom: 1px solid #ccc;
        font-family: "Poor story";
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

        .btn btn-dark{
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
        #write{
          float: right;
            font-family: "Poor story";
            font-size: 20px;
     }
     #text{
        font-family: "Poor story";
     }
    </style>
<%@include file="/views/common/footer.jsp"%>