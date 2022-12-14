<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.happy.member.model.vo.*" %>
<% Member loginMember=(Member)session.getAttribute("loginMember"); %>
<% Cookie[] cookies=request.getCookies();
	String saveId=null;
	if(cookies!=null){
		for(Cookie c : cookies){
			if(c.getName().equals("saveId")){
				saveId=c.getValue();
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>메인 페이지</title>
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
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
   <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
  </head>

  <body>
    <!-- Header -->
    <header id="header">
      <!-- Logo -->
      <div id="happy">
        <a id="logo" href="<%=request.getContextPath()%>"
          ><img
            src="<%=request.getContextPath() %>/images/main/logo.png"
            class=""
            alt="로고"
        /></a>
        <div id="logo-title">
          <a class="" href="<%=request.getContextPath()%>"
            ><h1><span id="H1">H</span><span id="appyDog">appyDog</span></h1>
            <h1><span id="H2">H</span><span id="appyCat">appyCat</span></h1></a
          >
        </div>
      </div>
      <!-- Login-->
      <div id="login">
      	<%if(loginMember!=null){ %>
      	  <a href="<%=request.getContextPath()%>/member/logout.do">로그아웃</a>
      	<%}else{ %>
      	  <a href="<%=request.getContextPath()%>/member/login.do">로그인</a>
      	<%} %>
      	<%if(loginMember==null){ %>
	        <div id="line"></div>
	        <a href="<%=request.getContextPath()%>/member/enroll.do">회원가입</a>
        <%} %>
        <div id="line"></div>
        <a href="<%=request.getContextPath()%>/member/enterMyPage.do">마이페이지</a>
      </div>
    </header>

    <!-- Nav -->
    <nav id="nav" class="sticky-top">
      <ul class="nav">
        <li class="nav-item dropdown">
          <a
            class="nav-link"
            data-bs-toggle=""
            href="#"
            role="button"
            aria-expanded="false"
            >유기동물제보</a
          >
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">유기동물제보 목록</a></li>
            <li><a class="dropdown-item" href="#">유기동물 제보하기</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a
            class="nav-link"
            data-bs-toggle=""
            href="#"
            role="button"
            aria-expanded="false"
            >무료입소신청</a
          >
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/admission/admissionList.do">입소신청 목록</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/admission/Procedure.do">입소신청 절차</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/admission/writeAdmission.do">입소 신청하기</a></li>
          </ul>
        </li>

        <li class="nav-item dropdown">
          <a
            class="nav-link"
            data-bs-toggle=""
            href="<%=request.getContextPath() %>/adopt/adoptmain.do"
            role="button"
            aria-expanded="false"
            >무료입양신청</a
          >
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=request.getContextPath() %>/adopt/adoptmain.do">입양신청 목록</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath() %>/adopt/adoptinform.do">입양신청 절차</a></li>
            <li><a class="dropdown-item" href="<%=request.getContextPath() %>/adopt/adoptreview.do">입양후기</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a
            class="nav-link"
            data-bs-toggle=""
            href="#"
            role="button"
            aria-expanded="false"
            >자원봉사&후원</a
          >
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/volview.do">자원봉사 목록</a></li>
            <li><a class="dropdown-item" href="#">자원봉사후기</a></li>
            <li><a class="dropdown-item" href="#">후원 목록</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a
            class="nav-link"
            data-bs-toggle=""
            href="#"
            role="button"
            aria-expanded="false"
            >동물병원찾기</a
          >
        </li>
        <li class="nav-item dropdown">
          <a
            class="nav-link"
            data-bs-toggle=""
            href="#"
            role="button"
            aria-expanded="false"
            >Q&A</a
          >
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="">자주묻는질문</a></li>
            <li><a class="dropdown-item" href="">문의하기</a></li>
          </ul>
        </li>
      </ul>
    </nav>
  </body>
</html>
