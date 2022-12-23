<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/views/common/header.jsp" %>
<%@ page import="com.happy.tip.model.vo.*" %>
<%@ page import="java.util.List" %>
<% List<TipBoard> tb=(List<TipBoard>)request.getAttribute("tipBoardList");%>
<% List<TipPhoto> tp=(List<TipPhoto>)request.getAttribute("tipPhoto");%>
<div
  id="imgs"
  style="
    width: 100%;
    height: 250px;
    background-color: rgba(211, 211, 211, 0.516);
    display: flex;
    margin-bottom: 50px;
  "
>
  <img
    src="<%=request.getContextPath() %>/images/adopt/Q.jfif"
    alt=""
    style="margin-right: auto"
  />
  <div id="text">
    <br />
    <p></p>
    <h1>입양하기</h1>
    <p>
      <br />보호중인 파양동물들과 유기된 동물들을<br />
      상시로 공고하고 있습니다.<br />
      자세한 안내는 입양안내를 참고해주세요.
    </p>
  </div>
  <img
    src="<%=request.getContextPath() %>/images/adopt/S.jfif"
    alt=""
    style="margin-left: auto"
  />
</div>

<!-- Main -->
<section id="main">
  <div class="container-md">
    <!-- Card -->
    <article id="card">
      <h1>유기 동물 제보</h1>
      <div id="button-container">
	      <div>
	        <button class="btn btn-dh">전체</button>
	        <button class="btn btn-dh">보호</button>
	        <button class="btn btn-dh">목격</button>
	        <button class="btn btn-dh">실종</button>
	        <button class="btn btn-dh">완료</button>
	      </div>
	        <button class="btn btn-dh" onclick="tipWrite(<%=loginMember==null?0:1%>);">글쓰기</button>
      </div>
      <div id="cardRow" style="flex-wrap:wrap;">
      	<%for(int i=0;i<tb.size();i++){ %>
	        <div id="card-content" class="card">
	            	<%for(int j=0;j<tp.size();j++){ %>
		            	<%if(tb.get(i).getTipBoardNo()==tp.get(j).getTipBoardNo()){ %>
				          <img
				            src="
		            		<%=request.getContextPath() %>/upload/tip/<%=tp.get(j).getTipPhotoRename() %>
				            "
				            class="card-img-top"
				            alt="..."
				            style="width: 200px;height: 200px;"
				          />
		            	<%break;
		            	}%>
	            	<%} %>
	          <div class="card-body">
	            <div id="card-title">
	              <p class="card-catagory col-3 
	              	<%if(tb.get(i).getTipCategory().equals("목격")){%>
	              		text-warning
	              	<%}else if(tb.get(i).getTipCategory().equals("보호")){%>
	              		text-primary
	              	<%}else if(tb.get(i).getTipCategory().equals("실종")){%>
	              		text-danger
	              	<%}%>
	              ">
	              [<%=tb.get(i).getTipCategory() %>]
	              </p>
	              <p class="card-text"><%=tb.get(i).getTipTitle() %></p>
	            </div>
	            <div><%=tb.get(i).getMemberId() %></div>
	            <div>서울시 금천구 독산동</div>
	            <div id="card-date"><%=tb.get(i).getTipWriteDate() %></div>
	            <div id="card-heart">
	              <div class="fs-6">
	                <img
	                  src="<%=request.getContextPath() %>/images/main/heart.svg"
	                /><span>0</span>
	              </div>
	              <div class="ms-auto">
	                <span class="fs-7">조회수</span><span class=""><%=tb.get(i).getTipViews() %></span>
	              </div>
	            </div>
	          </div>
	        </div>
        <%} %>

       
      </div>
      <div id="pageBar" style="display: flex;justify-content: center"><%=request.getAttribute("pageBar") %></div>
    </article>

  </div>
</section>
<script src="<%=request.getContextPath()%>/js/tipList.js"></script>
<%@ include file="/views/common/footer.jsp" %>
