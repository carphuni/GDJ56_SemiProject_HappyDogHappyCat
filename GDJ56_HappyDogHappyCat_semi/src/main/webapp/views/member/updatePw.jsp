<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section id="enroll">
      <form id="login-container" action="<%=request.getContextPath()%>/member/memberUpdatePwEnd.do" onsubmit="return updatePw();">
        <h1>비밀번호 수정</h1>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPwNow"
            placeholder="Password"
            name="memberPwNow"
          />
          <label for="floatingInput">현재 비밀번호</label>
        </div>
        <input type="password" name="loginMemberPw" value="<%=loginMember.getMemberPw()%>" hidden>
        <div id="pwNowResult"></div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPw"
            placeholder="Password"
            name="memberPw"
          />
          <label for="floatingInput">변경할 비밀번호</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPwCk"
            placeholder="PasswordCheck"
            name="memberPwCk"
          />
          <label for="floatingPassword">비밀번호 재확인</label>
        </div>
        <div id="pwResult"></div>
        <input type="submit" class="btn btn-dh" value="수정하기"/>
        <input type="button" class="btn btn-light" value="취소하기" onclick="winBack();"/>
      </form>
    </section>
<%@ include file="/views/common/footer.jsp" %>
   