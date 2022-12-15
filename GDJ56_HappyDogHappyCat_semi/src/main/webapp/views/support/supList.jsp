<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/suplist.css"/>

<section id="content">
  <div style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
      <img src="<%=request.getContextPath()%>/images/vol/dog1.png" alt="" style="margin-right: auto;">
      <div id="text" style="margin-top:2%;">
          <h1>후원하기</h1>
           <p>도움이 필요한 동물보호소의 후원을<br>
              상시로 공고하고 있습니다.<br>
              자세한 안내는 게시물을<br>
              참고해주세요.</p>
      </div>
      <img src="<%=request.getContextPath()%>/images/vol/dog2.png" style="margin-left: auto;">
  </div>


 <br><br>
        <div id="post" style="flex-wrap:wrap; width:80%;">
       <%--  <% for(int i=0;i<aniList.size();i++){ %> --%>
            <div id="dog-des" style="margin-bottom:0;">
                <img id="adp_img" src="<%=request.getContextPath()%>/images/vol/루피.png" alt="" style="width:250px; height:250px;">
                <div style="word-break:break-all;word-wrap:break-word; width:250px;"><br>
                <p >133마리의 아이들에게 보금자리를 마련해주세요.
                    33마리의 아이들에게 보금자리를
                </p>
                 <b>마석 유기견묘 보호소</b></p>
                </div>
                <div style="margin-top: auto;">
                     <progress value="20" max="100"></progress><br>
					<div style="margin-left: 53%;">2,000,000원</div>
                   
                </div>
               <%--   <%} %> --%>
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
   
     <a href="<%=request.getContextPath()%>/supwrite.do" class="myButton">글쓰기</a>
</section>



<%@ include file="/views/common/footer.jsp" %>