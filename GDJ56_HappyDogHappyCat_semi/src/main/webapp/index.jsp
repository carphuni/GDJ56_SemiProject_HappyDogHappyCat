<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/views/common/header.jsp" %>
 <!-- Carousel -->
    <div
      id="carouselExampleIndicators"
      class="carousel slide"
      data-bs-ride="true"
    >
      <div class="carousel-indicators">
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="0"
          class="active"
          aria-current="true"
          aria-label="Slide 1"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="1"
          aria-label="Slide 2"
        ></button>
        <button
          type="button"
          data-bs-target="#carouselExampleIndicators"
          data-bs-slide-to="2"
          aria-label="Slide 3"
        ></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img
            src="<%=request.getContextPath() %>/images/main/banner04.png"
            class="d-block w-100"
            alt="..."
          />
        </div>
        <div class="carousel-item">
          <img
            src="<%=request.getContextPath() %>/images/main/banner05.png"
            class="d-block w-100"
            alt="..."
          />
        </div>
        <div class="carousel-item">
          <img
            src="<%=request.getContextPath() %>/images/main/banner06.png"
            class="d-block w-100"
            alt="..."
          />
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carouselExampleIndicators"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>

    <!-- Main -->
    <section id="main">
      <div class="container-md">
        <!-- Menu -->
        <article id="menu">
          <div class="dh-menu-image">
            <a href=""
              ><img
                src="<%=request.getContextPath() %>/images/main/menu01-1.jpg"
                class="img-thumbnail"
                alt="..."
              />
              <div id="menu-title">
                <p>유기동물제보</p>
              </div>
            </a>
          </div>
          <div class="dh-menu-image">
            <a href=""
              ><img
                src="<%=request.getContextPath() %>/images/main/menu02-1.jpg"
                class="img-thumbnail"
                alt="..."
              />
              <div id="menu-title">
                <p>무료입소신청</p>
              </div>
            </a>
          </div>
          <div class="dh-menu-image">
            <a href="<%=request.getContextPath() %>/adopt/adoptmain.do"
              ><img
                src="<%=request.getContextPath() %>/images/main/menu03-1.jpg"
                class="img-thumbnail"
                alt="..."
              />
              <div id="menu-title">
                <p>무료입양신청</p>
              </div>
            </a>
          </div>
          <div class="dh-menu-image">
            <a href=
              ><img
                src="<%=request.getContextPath() %>/images/main/menu04-1.jpg"
                class="img-thumbnail"
                alt="..."
              />
              <div id="menu-title">
                <p>자원봉사&후원</p>
              </div>
            </a>
          </div>
        </article>

        <!-- Line -->
        <div id="basic-line"></div>

        <!-- Card -->
        <article id="card">
          <h1>최근 보호 동물</h1>
          <div id="cardRow-1">
            <div id="cardRow">
              <div id="card-content" class="card">
                <img
                  src="<%=request.getContextPath() %>/images/main/sign01.jpg"
                  class="card-img-top"
                  alt="..."
                />
                <div class="card-body">
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
          </div>
          <div id="cardRow-2">
            <div id="cardRow">
              <div id="card-content" class="card">
                <img
                  src="<%=request.getContextPath() %>/images/main/sign01.jpg"
                  class="card-img-top"
                  alt="..."
                />
                <div class="card-body">
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
                  <p class="card-text">[강아지] 웰시코기 궁딩이 무료입양</p>
                  <div class="d-flex">
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
          </div>
        </article>
      </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>
