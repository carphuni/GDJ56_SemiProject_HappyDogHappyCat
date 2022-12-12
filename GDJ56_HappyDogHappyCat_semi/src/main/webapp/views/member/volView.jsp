<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <div class="s2">
    <table width="1000" border="0" cellpadding="0" cellspacing="0">
        <tbody><tr>
        <td width="100">1</td>
        <td width="200 align="center"><img src="<%=request.getContextPath()%>/images/vol/chun.png" alt="" width="200" height="200" border="0"></a></td>
        <td width="1700">
        
          <table width="556" border="0" cellpadding="0" cellspacing="0">
          <tbody><tr><td style="cursor:pointer;" height="25"><b><span class="fontredbold">유기견 입양센터 봉사활동</a></span></font></b></td></tr>
        </td>
        </tr>
       
          <tr>
            <td>유기견 입양센터에서 유기견들을 위한 봉사활동 부탁드립니다. * 봉사 업무 내용 1. 실내외 견사, 운동장 청소
                2. 배식 , 물갈아 주기, 설거지 3. 켄넬 씻기 , 빨래 4. 산책....</td>

          </tr>
            <table border="0">
                <tbody>
                    <tr>
                        <hr>
                      <td width="100">단&nbsp;체&nbsp;명 &nbsp;:</td>
                      <td width="120">미미보호소</td>
                      <td width="100">지&nbsp;&nbsp;&nbsp;&nbsp;역 :</td>
                      <td width="120">울산시</td>
                      <td width="100">연락처 : </td>
                      <td width="280">010-1234-5678</td>
                </tr>
                <tr>
                      <td>모집기간 :</td>
                      <td>상시모집</td>
                      <td>봉사기간 :</td>
                      <td colspan="3">2022-09-06 ~ 2022-12-05</span></td>
                </tr>
                <tr>
                      <td><span class="fontgray">등&nbsp;록&nbsp;일 &nbsp;: </span></td>
                      <td><span class="fontgray">2022.11.25</span></td>
                      <td><span class="fontgray">조&nbsp;회&nbsp;수 :</span></td>
                      <td colspan="3">250</td>
                </tr>
                </tbody></table>
          </tr>
        </table>
        <hr style="border:dotted gray 1px">
    </div>
    <div class="s2"></div>

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
    <div class="page_wrap">
      <div class="page_nation">
         <a class="arrow prev" href="#"></a>
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
         <a class="arrow next" href="#"></a>
      </div>
   </div>
    

    <div id="register">
       <br><br><br><a href="#" class="myButton">글쓰기</a>
     </div>
            
</div>
</section>
<%@ include file="/views/common/footer.jsp" %>