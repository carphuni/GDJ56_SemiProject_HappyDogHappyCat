<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/myPage.css" />
<%@ include file="/views/common/header.jsp" %>
<%
	String memberPhone=loginMember.getMemberPhone();
	StringBuffer buf = new StringBuffer(memberPhone);
	buf.insert(3, "-");
	buf.insert(8, "-");
	
	StringBuffer buf2=null;
	if(loginAgency!=null){
		String agencyPhone=loginAgency.getAgencyPhone();
		buf2 = new StringBuffer(agencyPhone);
		if(buf2.length()<10){
			buf2.insert(2, "-"); 
			buf2.insert(6, "-"); 
		}else{
			buf2.insert(3, "-"); 
			buf2.insert(7, "-"); 
		}
	}
%> 
 <!-- myPage -->
 <section>
    <div id="myPage-container">
    	<div>
	        <h2>기본 정보</h2>
	        <div>
		        <h1><%=loginMember.getMemberName() %><button class="btn btn-dh" style="margin-top: 12px" onclick="location.assign('<%=request.getContextPath()%>/member/memberUpdateAll.do')">내 정보 수정</button></h1>
	        </div>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-id-badge"></i><span><%=loginMember.getMemberId() %></span>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-lock"></i><span>비밀번호</span>
          <button class="btn btn-dh" onclick="location.assign('<%=request.getContextPath()%>/member/memberUpdateAll.do')">비밀번호 수정</button>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-mobile-screen-button"></i><span><%=buf%></span>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-envelope"></i><span><%=loginMember.getMemberEmail() %></span>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-house"></i><span><%=loginMember.getMemberAddress() %></span>
        </div>
        <div id="basic-line"></div>
        
    </div>
    
    <div id="myPage-container">
        <h2>기관 정보</h2>
        <div id="basic-line"></div>
        <%if(loginAgency==null){ %>
	        <div>
	        	<i class="fa-solid fa-building"></i><span>기관등록</span>
				<button class="btn btn-dh" onclick="location.assign('<%=request.getContextPath()%>/agency/enrollAgency.do')">등록하기</button>
	        </div>
        <%}else{ %>
	        <div>
	        	<i class="fa-solid fa-building"></i><span><%=loginAgency.getAgencyName() %></span>
				<button class="btn btn-dh">수정</button>
	        </div>
	        <div id="basic-line"></div>
	        <div>
	          <i class="fa-solid fa-location-dot"></i><span><%=loginAgency.getAgencyAddress() %></span>
	          <button class="btn btn-dh">수정</button>
	        </div>
	        <div id="basic-line"></div>
	        <div>
	          <i class="fa-solid fa-phone"></i><span><%=buf2 %></span>
	          <button class="btn btn-dh">수정</button>
	        </div>
        <%} %>
	        <div id="basic-line"></div>
        
    </div>
    
    <div id="myPage-container">
      <h2>작성 내역</h2>
      <div id="board-search"> 
            <div class="search-window">
                <form action="">
                    <div class="search-wrap">
                        <label for="search" class="blind">내용 검색</label>
                        <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">&nbsp;
                        <button type="submit" class="btn btn-dark">검색</button> &nbsp;
                    </div>
                </form>
            </div>
      </div>
      <div id="board-list">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="col-1">분류</th>
                    <th scope="col" class="col-8">제목</th>
                    <th scope="col" class="col-1">승인여부</th>
                    <th scope="col" class="col-2">작성시간</th>
                </tr>
                </thead>
                <tbody>
                  <tr>
                      <td>입양</td>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td>승인</td>
                      <td>2022.11.29</td>
                  </tr>
                  <tr>
                      <td>입소</td>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td></td>
                      <td>2022.11.29</td>
                  </tr>
                  <tr>
                      <td>입양</td>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td>승인</td>
                      <td>2022.11.29</td>
                  </tr>
                  <tr>
                      <td>제보</td>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td></td>
                      <td>2022.11.29</td>
                  </tr>
                  
                  <tr>
                      <td>입양</td>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td>승인</td>
                      <td>2022.11.29</td>
                  </tr>
                </tbody>
            </table>
            <div id="pageBar"></div>
        </div>
    </div>

    <div id="myPage-container">
      <h2>문의 내역</h2>
      <div id="board-search"> 
            <div class="search-window">
                <form action="">
                    <div class="search-wrap">
                        <label for="search" class="blind">내용 검색</label>
                        <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">&nbsp;
                        <button type="submit" class="btn btn-dark">검색</button> &nbsp;
                    </div>
                </form>
            </div>
      </div>
      <div id="board-list">
            <table class="board-table">
                <thead>
                <tr>
                    <th scope="col" class="col-9">제목</th>
                    <th scope="col" class="col-1">답변여부</th>
                    <th scope="col" class="col-2">작성시간</th>
                </tr>
                </thead>
                <tbody>
                  <tr>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td>답변완료</td>
                      <td>2022.11.29</td>
                  </tr>
                  <tr>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td></td>
                      <td>2022.11.29</td>
                  </tr>
                  <tr>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td></td>
                      <td>2022.11.29</td>
                  </tr>
                  <tr>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td></td>
                      <td>2022.11.29</td>
                  </tr>
                  
                  <tr>
                      <th>
                        <a href="">입양후기5</a>
                      </th>
                      <td>답변완료</td>
                      <td>2022.11.29</td>
                  </tr>
                </tbody>
            </table>
            <div id="pageBar"></div>
        </div>
    </div>
</section>
<%@ include file="/views/common/footer.jsp" %>
   