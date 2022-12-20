<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/myPage.css" />
<%@ include file="/views/common/header.jsp" %> <% String
memberPhone=loginMember.getMemberPhone(); StringBuffer buf = new
StringBuffer(memberPhone); buf.insert(3, "-"); buf.insert(8, "-"); StringBuffer
buf2=null; if(loginAgency!=null){ String
agencyPhone=loginAgency.getAgencyPhone(); buf2 = new StringBuffer(agencyPhone);
if(buf2.length()<10){ buf2.insert(2, "-"); buf2.insert(6, "-"); }else{
buf2.insert(3, "-"); buf2.insert(7, "-"); } } %>
<!-- myPage -->
<section>
  <div id="myPage-container">
    <div>
      <h2>기본 정보</h2>
      <div>
        <h1>
          <%=loginMember.getMemberName() %><button
            class="btn btn-dh"
            style="margin-top: 12px"
            onclick="location.assign('<%=request.getContextPath()%>/member/memberUpdateAll.do')"
          >
            내 정보 수정
          </button>
        </h1>
      </div>
    </div>
    <div id="basic-line"></div>
    <div>
      <i class="fa-solid fa-id-badge"></i
      ><span><%=loginMember.getMemberId() %></span>
    </div>
    <div id="basic-line"></div>
    <div>
      <i class="fa-solid fa-lock"></i><span>비밀번호</span>
      <button
        class="btn btn-dh"
        onclick="location.assign('<%=request.getContextPath()%>/member/memberUpdatePw.do')"
      >
        비밀번호 수정
      </button>
    </div>
    <div id="basic-line"></div>
    <div>
      <i class="fa-solid fa-mobile-screen-button"></i><span><%=buf%></span>
    </div>
    <div id="basic-line"></div>
    <div>
      <i class="fa-solid fa-envelope"></i
      ><span><%=loginMember.getMemberEmail() %></span>
    </div>
    <div id="basic-line"></div>
    <div>
      <i class="fa-solid fa-house"></i
      ><span><%=loginMember.getMemberAddress() %></span>
    </div>
    <div id="basic-line"></div>
  </div>

  <div id="myPage-container">
    <h2>
      기관 정보<%if(loginAgency!=null){%><button
        class="btn btn-dh"
        onclick="location.assign('<%=request.getContextPath()%>/member/memberUpdateAgency.do')"
      >
        기관 정보 수정</button
      ><%} %>
    </h2>
    <div id="basic-line"></div>
    <%if(loginAgency==null){ %>
    <div>
      <i class="fa-solid fa-building"></i><span>기관등록</span>
      <button
        class="btn btn-dh"
        onclick="location.assign('<%=request.getContextPath()%>/agency/enrollAgency.do')"
      >
        등록하기
      </button>
    </div>
    <%}else{ %>
    <div>
      <i class="fa-solid fa-building"></i
      ><span><%=loginAgency.getAgencyName() %></span>
    </div>
    <div id="basic-line"></div>
    <div>
      <i class="fa-solid fa-location-dot"></i
      ><span><%=loginAgency.getAgencyAddress() %></span>
    </div>
    <div id="basic-line"></div>
    <div><i class="fa-solid fa-phone"></i><span><%=buf2 %></span></div>
    <%} %>
    <div id="basic-line"></div>
  </div>

  <div id="myPage-container">
    <h2>작성 내역</h2>
    <div
      class="btn-group col-12"
      role="group"
      aria-label="Basic outlined example"
    >
      <button type="button" class="btn col-2" onclick="location.assign('')">
        제 보
      </button>
      <button type="button" class="btn col-2" onclick="location.assign('')">
        입 소
      </button>
      <button type="button" class="btn col-2" onclick="location.assign('<%=request.getContextPath() %>/member/mypage/adoptboardList.do');">
        입 양
      </button>
      <button type="button" class="btn col-2" onclick="location.assign()">
        입양 후기
      </button>
      <button type="button" class="btn col-2" onclick="location.assign('')">
        자원 봉사
      </button>
      <button type="button" class="btn col-2" onclick="location.assign()">
        자원봉사 후기
      </button>
      <button type="button" class="btn col-2" onclick="location.assign()">
        문의 내역
      </button>
       
      
    </div>
  </div>
</section>
<%@ include file="/views/common/footer.jsp" %>
