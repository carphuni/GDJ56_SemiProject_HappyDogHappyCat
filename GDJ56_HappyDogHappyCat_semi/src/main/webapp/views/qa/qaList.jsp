<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,
com.happy.qa.vo.QaForm" %>
<%
 List<QaForm> list=(List<QaForm>)request.getAttribute("qas");
%>
<%@include file="/views/common/header.jsp"%>
<section id="content">
    	<div style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
      		<img src="<%=request.getContextPath() %>/images/admission/dog1.png" alt="" style="margin-right: auto;">
      		<div id="text">
        		<h1 style="font-size: 30px; text-align: center;">Q&A</h1>
        		<p>궁금하신 점은 언제든지 문의주세요.<br>
          		<br>해피독해피캣은 전문상담가들을 통해<br>
          		<br>정확하고 신속한 답변을 드리겠습니다.
        		</p>
      		</div>
      		<img src="<%=request.getContextPath() %>/images/admission/dog2.png" alt="" style="margin-left: auto;">
    	</div>
    	<br>
    
    
  <!--자주묻는 질문-->
  	<div id="oftenQa1">
    	<div class="quest" id="q1" data-toggle="modal" data-target="#testModal1">
      		<p class="qq1">Q1.자주묻는 질문<br>입소 후 아이의 소식은<br>어떻게 알 수 있나요?</p>
    	</div>
    	<div class="quest" id="q2" data-toggle="modal" data-target="#testModal2">
      		<p class="qq1" >Q2.자주묻는 질문<br>입양가정은 어떤 기준으로 채택되나요?</p>
    	</div>
    	<div class="quest" id="q3" data-toggle="modal" data-target="#testModal3">
      		<p class="qq1" >Q3.자주묻는 질문<br>제보된 아이가 제 아이입니다.<br>어떻게 데려올 수 있나요?</p>
    	</div>
  	</div>
  	
  	<div id="oftenQa2">
    	<div class="quest1" id="q4" data-toggle="modal" data-target="#testModal4">
      		<p class="qq1" >Q4.자주묻는 질문<br>모든 과정에서 정말 무료가 맞나요?</p>
    	</div>
    	<div class="quest1" id="q5" data-toggle="modal" data-target="#testModal5">
      		<p class="qq1" >Q5.자주묻는 질문<br>입양한 아이를 키우는데 문제가<br> 생겼을 경우,어떤 도움을 받을 수 있나요?</p>
    	</div>
    	<div class="quest1" id="q6" data-toggle="modal" data-target="#testModal6"> 
      		<p class="qq1" >Q6.자주묻는 질문<br>회원탈퇴를 하고싶습니다.</p>
    	</div>
  	</div>
  	<br>
  	
  <!--모달창 -->
  	<div class="modal fade" id="testModal1" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLabel">Q1.입소 후 아이의 소식은 어떻게 알 수 있나요?</h4>
				</div>
				<div class="modal-body"><h5>입양이 아직 이루어 지지 않은 아이의 경우, 1:1 문의를 주시면 아이의 소식을 전해드립니다. <br>
				입양 된 아이는 입양후기 카테고리를 통해 아이의 근황을 확인 하실 수 있습니다.</h5></div>
		  	</div>
	  	</div>
     </div>

  	<div class="modal fade" id="testModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLabel">Q2.입양가정은 어떤 기준으로 채택되나요??</h4>
				</div>
				<div class="modal-body"><h5>반려동물을 키워본 경험이 있는 분들을 우선으로 채택하고 있습니다. 그 외에는 주거환경(주택,아파트 등), 
				동거인(1인 또는 다수보다는 2-3인 가족) 우선으로 채택합니다.</h5></div>
		  </div>
	  </div>
  </div>

  <div class="modal fade" id="testModal3" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title" id="exampleModalLabel">Q3.제보된 아이가 제 아이입니다.어떻게 데려올 수 있나요?</h4>
				</div>
				<div class="modal-body"><h5>해당 제보게시글 댓글창을 통해 제보자와 연락하시면 됩니다. </h5></div>
		  </div>
	  </div>
  </div>

  <div class="modal fade" id="testModal4" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">Q4.모든 과정에서 정말 무료가 맞나요?</h3>
				</div>
				<div class="modal-body"><h5>네. 모든 과정에서 무료입니다.</h5></div>
		  </div>
	  </div>
  </div>

  <div class="modal fade" id="testModal5" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">Q5.입양한 아이를 키우는데 문제가 생겼을 경우,어떤 도움을 받을 수 있나요?</h3>
				</div>
				<div class="modal-body"><h5>q&a 게시판으로 문의 주시면 최대 3일 이내로 답변을 드립니다.</h5></div>
		  </div>
	  </div>
  </div>

  <div class="modal fade" id="testModal6" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h3 class="modal-title" id="exampleModalLabel">Q6.회원탈퇴를 하고싶습니다.</h3>
				</div>
				<div class="modal-body"><h5>마이페이지>회원탈퇴를 누르시면 회원탈퇴가 가능합니다. 그러나 이전에 작성하신 게시물들은 자동삭제 처리 되지 않음을 알려드립니다.</h5></div>
		  </div>
	  </div>
  </div>
 
  <script>
    $('#q1').click(function(e){
      e.preventDefault();
      $('#testModal1').modal("show");
    });

    $('#q2').click(function(e){
      e.preventDefault();
      $('#testModal2').modal("show");
    });

    $('#q3').click(function(e){
      e.preventDefault();
      $('#testModal3').modal("show");
    });

    $('#q4').click(function(e){
      e.preventDefault();
      $('#testModal4').modal("show");
    });

    $('#q5').click(function(e){
      e.preventDefault();
      $('#testModal5').modal("show");
    });

    $('#q6').click(function(e){
      e.preventDefault();
      $('#testModal6').modal("show");
    });

  
  </script>

  <section class="post">
    <div id="board-search">
      <div class="container">
        <div class="search-window">
          <form action="<%=request.getContextPath()%>/searchQa.do">
            <div class="search-wrap">
              <label for="search" class="blind">내용 검색</label>
              <input id="search" type="search" name="searchKeyword" placeholder="제목으로 검색하기" value="">&nbsp;
              <button type="submit" class="btn btn-dark" id="searchbtn">검색</button> &nbsp;
              <!-- <button class="btn btn-dark">입양글쓰기</button> -->
            </div>
          </form>
        </div>
      </div>
    </div>

    <div id="board-list" >
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
          <tbody>
          <%if(list.isEmpty()){ %>
            <tr>
              <td colspan="5">조회된 Q&A 내역이 없습니다.</td>
            </tr>
            <%}else{
            	for(QaForm q: list){%>
            <tr>
            	<td><%=q.getQaBoardNo() %></td>
              <th>
                <%if(q.getQaPassword()!=0){%>
                 <a href="<%=request.getContextPath()%>/qa/qaPw.do?qaBoardNo=<%=q.getQaBoardNo()%>"><%=q.getQaTitle() %></a>
                🔒
                <% }else{%>
                	 <a href="<%=request.getContextPath()%>/qa/qaView.do?qaBoardNo=<%=q.getQaBoardNo()%>"><%=q.getQaTitle() %></a>
                <%} %>	 
              </th>
              <td><%=q.getMemberId()%></td>
              <td><%=q.getQaWriteDate() %></td>
              <td><%=q.getQaReadCount() %></td>
           </tr>
           <%}} %>
          </tbody>
        </table>
        <br>
        <button id="write" type="button" class="btn btn-lgbtn-link"
          onclick="location.assign('<%=request.getContextPath()%>/qa/qaWrite.do');">글쓰기&#128062;</button>
      </div>
    </div>
   <div id="pageBar">
        	<%=request.getAttribute("pageBar") %>
   </div>
  </section>
  </section>
  <style>
    .qq1{
      font-size: 15px;
    }
    #writeqa {
      text-align: right;
    }
    #oftenQa1 {
      width: 1000px;
      height: 150px;
      margin:auto;
      display: flex;
      border-radius: 10%;
      
    }

    #oftenQa2 {
      width: 1000px;
      height: 150px;
      margin:auto;
      display: flex;
      /*text-align: center;*/
    }

    .quest {
      width: 180px;
      height: 110px;
      
      margin: auto;
      /*text-align: center;*/
      display: inline-block;
      vertical-align: middle;
      border-radius: 10%;
      font-family: "Poor Story";
      text-align: center;
      border-style: inset;
      background-color: antiquewhite;

    }

    .quest1 {
      width: 180px;
      height: 110px;
      
      margin: auto;
      /*text-align: center;*/
      display: inline-block;
      vertical-align: middle;
      border-radius: 10%;
      font-family: "Poor Story";
      text-align: center;
      border-style: inset;
      background-color: antiquewhite;

    }

    #title {
      text-align: center;
      margin-top: 200px;
      font-size: 25px;
      /*font-family:"Poor Story"; */
    }

    #imgContainer {
      text-align: center;
    }

    #content div {
      text-align: center;
    }

    #content img {
      width: 200px;
      height: 250px;
      opacity: 0.5;
    }

    #text {
      font-family: "Poor Story";
      font-size: 20px;
      margin: 10px;
    }

    #write {
      bottom: 0;
      font-family: "Poor story";
      font-size: 20px;
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

    .board-table th,
    .board-table td {
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

    .board-table tbody th p {
      display: none;
    }

    .btn btn-dark {
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

    .btn-dark:hover,
    .btn-dark:focus {
      background: #373737;
      border-color: #373737;
      color: #fff;
    }

    .btn-dark {
      background: #555;
      color: #fff;
    }

    .btn-dark:hover,
    .btn-dark:focus {
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

    #content div {
      text-align: center;
    }

    #imgs img {
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