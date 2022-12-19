<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section id="enroll">
      <form id="login-container" action="<%=request.getContextPath()%>/member/memberUpdateAllEnd.do" >
        <h1>회원 정보 수정</h1>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingName"
            placeholder="Name"
            name="memberName"
            value="<%=loginMember.getMemberName() %>"
          />
          <label for="floatingPassword">이름</label>
        </div>
        <div id="nameResult"></div>
        <div class="form-floating">
          <input
            type="email"
            class="form-control"
            id="floatingEmail"
            placeholder="Email.Email.com"
            name="memberEmail"
            value="<%=loginMember.getMemberEmail() %>"
          />
          <label for="floatingPassword">이메일 ( happy@happy.com )</label>
        </div>
        <div id="emailResult"></div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingPhone"
            placeholder="000-0000-0000"
            name="memberPhone"
            value="<%=loginMember.getMemberPhone() %>"
            maxlength=11
          />
          <label for="floatingPassword">휴대전화 ( '-' 제외 )</label>
        </div>
        <div id="phoneResult"></div>
        <div class="form-floating">
          <input
            type="text"
            class="form-control"
            id="floatingAddress"
            placeholder="주소"
            name="memberAddress"
            value="<%=loginMember.getMemberAddress() %>"
          />
          <label for="floatingPassword">주소</label>
        </div>
        <div id="addressResult"></div>
        <input type="submit" class="btn btn-dh" value="수정하기"/>
        <input type="button" class="btn btn-light" value="취소하기" onclick="winBack();"/>
      </form>
    </section>
<%@ include file="/views/common/footer.jsp" %>
   