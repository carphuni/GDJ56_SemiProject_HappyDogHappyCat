<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ include file="/views/common/header.jsp" %>
<link
  rel="stylesheet"
  type="text/css"
  href="<%=request.getContextPath()%>/css/volWrite.css"
/>
<script src="/js/summernote/summernote-lite.js"></script>
<script src="/js/summernote/lang/summernote-ko-KR.js"></script>

<link rel="stylesheet" href="/css/summernote/summernote-lite.css" />

<section id="container1">
  <form
    action="<%=request.getContextPath() %>/vol/volWriteEnd.do"
    method="post"
    enctype="multipart/form-data"
  >
    <%if(loginMember!=null){ %>
    <input
      type="hidden"
      name="memberNo"
      value="<%=loginMember.getMemberNo()%>"
    />
    <%} %>
    <div class="board_wrap">
      <div class="board_title">
        <strong style="font-size: 25px">유기 동물 제보</strong>
      </div>
      <div class="board_write_wrap">
        <div class="board_write">
          <div
            class="title"
            style="display: flex; justify-content: space-between"
          >
            <dl class="col-4">
              <dt style="font-size: 17px">카테고리</dt>
              <dd style="font-size: 17px; margin-top: 14px">
                <select
                  class="form-select form-select-sm"
                  aria-label=".form-select-sm example"
                  required
                >
                  <option selected>선택</option>
                  <option value="목격">목격</option>
                  <option value="보호">보호</option>
                  <option value="실종">실종</option>
                  <option value="완료">완료</option>
                </select>
              </dd>
            </dl>
            <dl class="col-8" style="margin-left: 30px">
              <dt style="font-size: 17px">제목</dt>
              <dd style="font-size: 17px; margin-top: 14px">
                <input
                  type="text"
                  placeholder="40자 이하로 입력해주세요."
                  name="volTitle"
                  required
                />
              </dd>
            </dl>
          </div>

          <div class="cont">
            <textarea
              rows="10"
              cols="100"
              name="summernote"
              id="summernote"
              required
            ></textarea>
          </div>
        </div>

        <div class="file2" style="font-size: 17px">
          <b>* 사진첨부</b>
          <input
            type="file"
            id="btnAtt"
            accept="image/*"
            name="upload2"
            multiple
          />
        </div>
        <div id="att_zone" data-placeholder=""></div>
        <div style="font-size: 17px">
          <b>* 발견한 장소</b>
          <div id="map" style="width:350px;height:350px;"></div>
          <input type="hidden" name="lat">
          <input type="hidden" name="lon">
        </div>
        
      </div>

      <div class="bt_wrap">
        <input
          type="button"
          style="font-size: 17px"
          id="saveBtn"
          class="on"
          value="등록"
        />
        <input
          type="button"
          style="font-size: 17px"
          value="취소"
          onclick="location.replace('<%=request.getContextPath()%>/volview.do')"
        />
      </div>
    </div>
  </form>
</section>
<script src="<%=request.getContextPath() %>/js/tipWrite.js"></script>
<p style="margin-top:-12px">
    <em class="link">
        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
    </em>
</p>
<div id="map1" style="width:100%;height:350px;"></div>

<%@ include file="/views/common/footer.jsp" %>
