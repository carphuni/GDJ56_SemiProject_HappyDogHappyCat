<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.happy.member.model.vo.*" %>
<% Member loginMember=(Member)session.getAttribute("loginMember"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Insert title here</title>
<!-- 제이쿼리 -->
    <script src="<%=request.getContextPath() %>/js/jquery-3.6.1.min.js"></script>
    <!-- 추가 적용 css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" />
    <link
      rel="stylesheet"
      href="<%=request.getContextPath() %>/css/login.css"
    />
    <link
      rel="stylesheet"
      href="<%=request.getContextPath() %>/css/headerFooter.css"
    />
    <!-- 부트스트랩 css -->
    <link
      rel="stylesheet"
      href="<%=request.getContextPath() %>/css/bootstrap.css"
    />
    <!-- Font Awesome icons (free version)-->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
      integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- Font Poor Stroy -->
    <link
      href="https://fonts.googleapis.com/css2?family=Poor+Story&display=swap"
      rel="stylesheet"
    />
</head>
<body>
	<!-- UpdateName -->
    <form id="login-container">
        <h1>이름 수정</h1>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingName" placeholder="Name" value="<%=loginMember.getMemberName() %>" disabled>
          <label for="floatingName">현재 이름</label>
        </div>
        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInputName" placeholder="Name">
          <label for="floatingInputName">변경할 이름</label>
        </div>
        <input type="button" class="btn btn-dh" value="가입하기" onclick="updateMemberNameEnd();">
        <input type="button" class="btn btn-light" value="취소하기" onclick="">
    </form>
</body>
</html>