<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/myPage.css" />
<%@ include file="/views/common/header.jsp" %>
<%
	String memberPhone=loginMember.getMemberPhone();
	StringBuffer buf = new StringBuffer(memberPhone);
	buf.insert(3, "-");
	buf.insert(8, "-");
%>
 <!-- myPage -->
 <section>
    <div id="myPage-container">
        <h2>기본 정보</h2>
        <h1><%=loginMember.getMemberName() %></h1>
        <div>
        	<i class="fa-solid fa-signature"></i><span>이름</span>
			<button class="btn btn-dh">수정</button>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-id-badge"></i><span><%=loginMember.getMemberId() %></span>
          <button class="btn btn-dh">수정</button>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-lock"></i><span>비밀번호</span>
          <button class="btn btn-dh">수정</button>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-mobile-screen-button"></i><span><%=buf%></span>
          <button class="btn btn-dh">수정</button>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-envelope"></i><span><%=loginMember.getMemberEmail() %></span>
          <button class="btn btn-dh">수정</button>
        </div>
        <div id="basic-line"></div>
        <div>
          <i class="fa-solid fa-house"></i><span><%=loginMember.getMemberAddress() %></span>
          <button class="btn btn-dh">수정</button>
        </div>
        
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
   