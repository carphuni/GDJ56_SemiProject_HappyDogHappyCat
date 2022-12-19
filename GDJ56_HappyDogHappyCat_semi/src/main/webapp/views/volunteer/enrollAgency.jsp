<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
 <!-- enrollAgency -->
    <form id="login-container">
        <h1>시설 등록</h1>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingAgencyName" placeholder="Id" name="agencyName">
            <label for="floatingInput">시설 이름</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control" id="floatingAgencyAddress" placeholder="Password" name="agencyAddress">
            <label for="floatingInput">시설 주소</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingAgencyPhone" placeholder="PasswordCheck" name="agencyPhone" maxlength=10>
          <label for="floatingPassword">시설 연락처</label>
        </div>
        <input type="button" class="btn btn-dh" value="등록하기" onclick="enrollAgencyEnd();">
        <input type="button" class="btn btn-light" value="취소하기">  
    </form>
<%@ include file="/views/common/footer.jsp" %>
