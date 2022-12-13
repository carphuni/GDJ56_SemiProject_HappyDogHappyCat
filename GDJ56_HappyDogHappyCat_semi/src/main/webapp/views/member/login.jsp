<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/views/common/header.jsp" %>
<section id="login">
  <form
    action="<%=request.getContextPath() %>/member/loginEnd.do"
    id="login-container"
  >
    <h1>ID 로그인</h1>
    <div class="form-floating">
      <input
        type="text"
        class="form-control"
        id="floatingInput"
        placeholder="Name"
        name="memberId"
        value="<%=saveId!=null?saveId:""%>"
      />
      <label for="floatingInput">아이디</label>
    </div>
    <div class="form-floating">
      <input
        type="password"
        class="form-control"
        id="floatingPassword"
        placeholder="Password"
        name="memberPw"
      />
      <label for="floatingPassword">비밀번호</label>
    </div>
    <div class="form-check">
      <input
        class="form-check-input"
        type="checkbox"
        value=""
        id="flexCheckDefault"
        name="saveId"
        <%=saveId!=null?"checked":""%>
      />
      <label class="form-check-label" for="flexCheckDefault">
        아이디 저장
      </label>
    </div>
    <input type="submit" class="btn btn-dh" value="로그인" />
    <div id="find">
      <a href="" class="col-3">비밀번호 찾기</a>
      <div id="line" class="col-1"></div>
      <a href="" class="col-3">아이디 찾기</a>
      <div id="line" class="col-1"></div>
      <a href="" class="col-3">회원가입</a>
    </div>
  </form>
</section>
<%@ include file="/views/common/footer.jsp" %>
