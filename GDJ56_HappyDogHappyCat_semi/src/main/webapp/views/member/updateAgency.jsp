<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<section id="enroll">
      <form id="login-container" action="<%=request.getContextPath()%>/member/memberUpdateAgencyEnd.do" onsubmit="return updateAgency();">
        <h1>기관 정보 수정</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingAgencyName" placeholder="Id" name="agencyName" value="<%=loginAgency.getAgencyName()%>">
            <label for="floatingInput">시설 이름</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingAgencyAddress" placeholder="Password" name="agencyAddress" value="<%=loginAgency.getAgencyAddress()%>">
            <label for="floatingInput">시설 주소</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingAgencyPhone" placeholder="PasswordCheck" name="agencyPhone" value="<%=loginAgency.getAgencyPhone()%>" maxlength=10>
          <label for="floatingPassword">시설 연락처</label>
        </div>
        <input type="submit" class="btn btn-dh" value="수정하기">
        <input type="button" class="btn btn-light" value="취소하기" onclick="winBack();"> 
      </form>
    </section>
<%@ include file="/views/common/footer.jsp" %>
   