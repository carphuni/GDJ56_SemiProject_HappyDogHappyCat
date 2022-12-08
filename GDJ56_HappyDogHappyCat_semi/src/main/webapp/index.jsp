<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/views/common/header.jsp" %>
<div id="load"></div>
<div id="basicDiv">
  <!-- MainDiv -->
  <div id="mainDiv" style="display: block">
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
            src="<%=request.getContextPath() %>/images/main/banner01.jpg"
            class="d-block w-100"
            alt="..."
          />
        </div>
        <div class="carousel-item">
          <img
            src="<%=request.getContextPath() %>/images/main/banner02.jpg"
            class="d-block w-100"
            alt="..."
          />
        </div>
        <div class="carousel-item">
          <img
            src="<%=request.getContextPath() %>/images/main/banner03.jpg"
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
            <a href=""
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
            <a href=""
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
  </div>

  <!-- LoginDiv -->
  <div id="LoginDiv" style="display: none">
    <!-- Login -->
    <section id="login">
      <div id="login-container">
        <h1>ID 로그인</h1>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingInput"
            placeholder="Name"
          />
          <label for="floatingInput">아이디</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPassword"
            placeholder="Password"
          />
          <label for="floatingPassword">비밀번호</label>
        </div>
        <input type="submit" class="btn btn-dh" value="로그인" />
        <div id="find">
          <a href="" class="col-3">비밀번호 찾기</a>
          <div id="line" class="col-1"></div>
          <a href="" class="col-3">아이디 찾기</a>
          <div id="line" class="col-1"></div>
          <a href="" class="col-3">회원가입</a>
        </div>
      </div>
    </section>
  </div>

  <!-- EnterMyPageDiv -->
  <div id="enterMyPageDiv" style="display: none">
    <!-- EnterMyPage -->
    <section id="enterMyPage">
      <div id="login-container">
        <h1>마이페이지</h1>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingInput"
            placeholder="Password"
          />
          <label for="floatingInput">비밀번호 확인</label>
        </div>
        <input type="submit" class="btn btn-dh" value="다음" />
      </div>
    </section>
  </div>

  <!-- EnrollDiv -->
  <div id="enrollDiv" style="display: none">
    <!-- Enroll -->
    <section id="enroll">
      <div id="login-container">
        <h1>회원 가입</h1>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingInput"
            placeholder="Id"
          />
          <label for="floatingInput">아이디</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingInput"
            placeholder="Password"
          />
          <label for="floatingInput">비밀번호</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPassword"
            placeholder="PasswordCheck"
          />
          <label for="floatingPassword">비밀번호 재확인</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="Name"
          />
          <label for="floatingPassword">이름</label>
        </div>
        <div id="birth">
          <div class="form-floating">
            <input
              type="text"
              class="form-control"
              id="floatingPassword"
              placeholder="0000"
            />
            <label for="floatingPassword">년(4자)</label>
          </div>
          <div class="form-floating">
            <input
              type="text"
              class="form-control"
              id="floatingPassword"
              placeholder="00"
            />
            <label for="floatingPassword">월</label>
          </div>
          <div class="form-floating">
            <input
              type="text"
              class="form-control"
              id="floatingPassword"
              placeholder="00"
            />
            <label for="floatingPassword">일</label>
          </div>
        </div>
        <div class="form-floating">
          <input
            type="email"
            class="form-control"
            id="floatingPassword"
            placeholder="Email.Email.com"
          />
          <label for="floatingPassword">이메일</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="000-0000-0000"
          />
          <label for="floatingPassword">휴대전화</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="Email@Email.com"
          />
          <label for="floatingPassword">주소</label>
        </div>
        <input type="submit" class="btn btn-dh" value="가입하기" />
      </div>
    </section>
  </div>

  <!-- FindId -->
  <div id="findIdDiv" style="display: none">
    <!-- FindId -->
    <section id="findId">
      <div id="login-container">
        <h1>아이디찾기</h1>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingInput"
            placeholder="Id"
          />
          <label for="floatingInput">아이디</label>
        </div>
        <div class="form-floating">
          <input
            type="email"
            class="form-control"
            id="floatingInput"
            placeholder="Email@Email.com"
          />
          <label for="floatingInput">이메일</label>
        </div>
        <input
          type="submit"
          class="btn btn-dh"
          value="등록된 이메일로 인증번호 받기"
        />
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="000000"
          />
          <label for="floatingPassword">인증번호 6자리</label>
        </div>
        <input type="submit" class="btn btn-dh" value="다음" />
      </div>
    </section>
  </div>

  <!-- FindPassword -->
  <div id="findPasswordDiv" style="display: none">
    <!-- FindPassword -->
    <section id="findPassword">
      <div id="login-container">
        <h1>비밀번호 찾기</h1>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingInput"
            placeholder="Id"
          />
          <label for="floatingInput">아이디</label>
        </div>
        <input
          type="submit"
          class="btn btn-dh"
          value="등록된 이메일로 인증번호 받기"
        />
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="000000"
          />
          <label for="floatingPassword">인증번호 6자리</label>
        </div>
        <input type="submit" class="btn btn-dh" value="다음" />
      </div>
    </section>
  </div>
</div>
<%@ include file="/views/common/footer.jsp" %>
