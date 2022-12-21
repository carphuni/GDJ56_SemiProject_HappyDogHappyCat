<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/views/common/header.jsp" %>
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
	        <button class="btn btn-dh" onclick="location.assign('<%=request.getContextPath()%>/tip/tipWrite.do');">글쓰기</button>
      </div>
      <div id="cardRow">
        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>

        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>

        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>

        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div id="cardRow">
        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>

        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>

        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>

        <div id="card-content" class="card">
          <img
            src="<%=request.getContextPath() %>/images/main/sign01.jpg"
            class="card-img-top"
            alt="..."
          />
          <div class="card-body">
            <div id="card-title">
              <p class="card-catagory text-warning col-3" style="">[목격]</p>
              <p class="card-text">유기견 제보합니당 유기견 제보합니당</p>
            </div>
            <div>이동훈</div>
            <div>서울시 금천구 독산동</div>
            <div id="card-date">2022-08-19</div>
            <div id="card-heart">
              <div class="fs-6">
                <img
                  src="<%=request.getContextPath() %>/images/main/heart.svg"
                /><span>1</span>
              </div>
              <div class="ms-auto">
                <span class="fs-7">조회수</span><span class="">2</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </article>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>

  </div>
</section>
<%@ include file="/views/common/footer.jsp" %>
