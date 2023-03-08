# **HappyDogHappyCat Project**

## **📗 목차**

<br>

* 📋 [개요](#📋-포트폴리오-개요)
* 👨🏻‍💻 [기능 구현](#⚙️-기능-구현)
  * [전체적인 페이지 Front UI 구현](#1-전체적인-페이지-front-ui-구현)
  * [회원가입 페이지](#2-회원가입-페이지)
  * [로그인 로그아웃](#3-로그인-로그아웃)
  * [마이 페이지](#4-마이-페이지)
  * [제보 페이지 조회](#5-제보-페이지-조회)
 

<br>

## **📋 포트폴리오 개요**

<img width="100%" alt="마이 페이지" src="./ReadMeImg/마이 페이지.png" />

> <br>
>
> **프로젝트 :**  HappyDogHappyCat - 유기동물보호 사이트
>
> **분류 :** GDJ56 Semi Project
>
> **제작 기간 :** 2022.12.09 ~ 2022.12.23 (2주)
>
> **인원 :** 4명
>
> **주요 기능 :** 
> 1) 유기동물 발견,보호 및 실종 시 제보
> 2) 보호 중인 동물이나 개인 사정으로 인한 동물 입소
> 3) 센터에서 보호 중인 동물 무료 입양
> 4) 동물과 관련된 기관들의 자원 봉사 열람 및 신청
> 5) 주변 동물 병원 찾기
> 6) 동물 관련 후원 프로그램에 후원
>
> **개발환경 및 라이브러리 :**
> * 구현언어 :JDK 11, HTML, JavaScript, jQuery, Bootstrap, Ajax, JAVASpringBoot
> * WAS : Tomcat 9.0
> * DB 서버 : Oracle DB
> * 형상관리 : Git
>
> <br>

<br>
<br>

## **⚙️ 기능 구현**

### **1. 전체적인 페이지 Front UI 구현**

<img width="100%" alt="Front UI" src="./ReadMeImg/Front UI.gif" />

- Header, Footer, 메인페이지를 Html, css, js, BootStrap 사용하여 구현

<br>

### **2. 회원가입 페이지**

<img width="100%" alt="회원가입 페이지" src="./ReadMeImg/마이 페이지.png" />

- 회원가입 입력 목록 정규화 및 Ajax를 사용하여 아이디 중복 검사
- 잘못 입력 시 입력창 하단 메세지 출력

<br>

### **3. 로그인 로그아웃**

<img width="100%" alt="로그인 로그아웃" src="./ReadMeImg/맛집 저장.gif" />

- 로그인 성공 시 세션에 정보 저장, 입력된 정보가 없다면 로그인 실패
- 로그아웃 시 세션 삭제

<br>

<img width="100%" alt="맛집 상세페이지" src="./ReadMeImg/맛집 상세페이지.gif" />

<br>

### **4. 마이 페이지**

<img width="100%" alt="마이 페이지" src="./ReadMeImg/맛집 조회.gif" />

- 회원 정보 출력하여 확인 및 수정할 회원 정보 수정
- 기관에 등록되어있다면 기관 등록 기능

### **5. 제보 페이지 조회**

<img width="100%" alt="제보 페이지" src="./ReadMeImg/맛집 조회.gif" />

- 유기동물제보 탭 클릭 시 현재 제보된 게시물 조회
