<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- Footer-->
    <footer id="footer">
      <div class="container">
        <div class="row">
          <!-- Footer Logo-->
          <div id="happy" class="col-lg-3 mb-5 mb-lg-0">
            <a id="logo" href=""
              ><img src="<%=request.getContextPath() %>/images/main/logo.png" class="" alt="..."
            /></a>
            <div id="logo-title">
              <a class="" href=""
                ><h1>
                  <span id="H1">H</span><span id="appyDog">appyDog</span>
                </h1>
                <h1>
                  <span id="H2">H</span><span id="appyCat">appyCat</span>
                </h1></a
              >
            </div>
          </div>
          <!-- Footer nav-->
          <div id="footer-nav" class="col-lg-9 mb-5 mb-lg-0">
            <div id="footer-item">
              <ul class="list-group list-group-flush">
                <li id="head" class="list-group-item">유기동물제보</li>
                <li class="list-group-item">
                  <a href="" class="">유기동물제보 목록</a>
                </li>
                <li class="list-group-item">
                  <a href="" class="">유기동물 제보하기</a>
                </li>
              </ul>
            </div>
            <div id="footer-item">
              <ul class="list-group list-group-flush">
                <li id="head" class="list-group-item">무료입소신청</li>
                <li class="list-group-item">
                  <a href="<%=request.getContextPath()%>/admission/admissionList.do" class="">입소신청 목록</a>
                </li>
                <li class="list-group-item">
                  <a href="<%=request.getContextPath()%>/admission/Procedure.do" class="">입소신청 절차</a>
                </li>
                <li class="list-group-item">
                  <a href="<%=request.getContextPath()%>/admission/writeAdmission.do" class="">입소 신청하기</a>
                </li>
              </ul>
            </div>
            <div id="footer-item">
              <ul class="list-group list-group-flush">
                <li id="head" class="list-group-item">무료입양신청</li>
                <li class="list-group-item">
                  <a href="" class="">입양신청 목록</a>
                </li>
                <li class="list-group-item">
                  <a href="" class="">입양신청 절차</a>
                </li>
                <li class="list-group-item">
                  <a href="" class="">입양후기</a>
                </li>
              </ul>
            </div>
            <div id="footer-item">
              <ul class="list-group list-group-flush">
                <li id="head" class="list-group-item">자원봉사&후원</li>
                <li class="list-group-item">
                  <a href="" class="">자원봉사 목록</a>
                </li>
                <li class="list-group-item">
                  <a href="" class="">자원봉사 등록하기</a>
                </li>
                <li class="list-group-item">
                  <a href="" class="">후원 목록</a>
                </li>
              </ul>
            </div>
            <div id="footer-item">
              <ul class="list-group list-group-flush">
                <li id="head" class="list-group-item">동물병원찾기</li>
              </ul>
            </div>
            <div id="footer-item">
              <ul class="list-group list-group-flush">
                <li id="head" class="list-group-item">Q&A</li>
                <li class="list-group-item">
                  <a href="<%=request.getContextPath()%>/qa/qaList.do" class="">자주묻는질문</a>
                </li>
                <li class="list-group-item">
                  <a href="<%=request.getContextPath()%>/qa/qaWrite.do">문의하기</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <!-- FooterLine -->
        <div id="basic-line" style="background-color: black"></div>
        <!-- FooterIcon -->
        <div id="footer-icon">
          <a class="btn btn-social mx-1" href="#!"
            ><i class="fab fa-fw fa-facebook-f"></i
          ></a>
          <a class="btn btn-social mx-1" href="#!"
            ><i class="fab fa-fw fa-twitter"></i
          ></a>
          <a class="btn btn-social mx-1" href="#!"
            ><i class="fab fa-fw fa-instagram"></i
          ></a>
          <a class="btn btn-social mx-1" href="#!"
            ><i class="fab fa-fw fa-solid fa-hashtag"></i
          ></a>
        </div>
      </div>
    </footer>
    <!-- Copyright Section-->
    <div class="copyright py-4 text-center text-white">
      <div class="container">
        <small>Copyright &copy; Your Website 2022</small>
      </div>
    </div>
  </body>

</html>
<!-- 부트스트랩 js-->
<script src="<%=request.getContextPath() %>/js/bootstrap.bundle.min.js"></script>
<!-- 추가적용 js -->
<script src="<%=request.getContextPath() %>/js/main.js"></script>

