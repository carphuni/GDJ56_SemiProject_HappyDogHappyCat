<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section id="enroll">
      <form id="login-container" action="<%=request.getContextPath()%>/member/enrollEnd.do">
        <h1>회원 가입</h1>
        <div class="form-floating" style="display: flex;">
          <input
            type="text"
            class="form-control"
            id="floatingInput"
            placeholder="Id"
            name="memberId"
          />
          <label for="floatingInput">아이디</label>
          <button class="btn btn-dh">중복 확인</button>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingInput"
            placeholder="Password"
            name="memberPw"
          />
          <label for="floatingInput">비밀번호</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPassword"
            placeholder="PasswordCheck"
            name="memberPwCk"
          />
          <label for="floatingPassword">비밀번호 재확인</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="Name"
            name="memberName"
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
              name="memberYear"
            />
            <label for="floatingPassword">년(4자)</label>
          </div>
          <div class="form-floating">
            <input
              type="text"
              class="form-control"
              id="floatingPassword"
              placeholder="00"
              name="memberMonth"
            />
            <label for="floatingPassword">월</label>
          </div>
          <div class="form-floating">
            <input
              type="text"
              class="form-control"
              id="floatingPassword"
              placeholder="00"
              name="memberDay"
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
            name="memberEmail"
          />
          <label for="floatingPassword">이메일( happy@happy.com )</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="000-0000-0000"
            name="memberPhone"
          />
          <label for="floatingPassword">휴대전화( '-' 제외 )</label>
        </div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPassword"
            placeholder="Email@Email.com"
            name="memberAddress"
          />
          <label for="floatingPassword">주소</label>
        </div>
        <input type="submit" class="btn btn-dh" value="가입하기" />
      </form>
    </section>
<%@ include file="/views/common/footer.jsp" %>
   