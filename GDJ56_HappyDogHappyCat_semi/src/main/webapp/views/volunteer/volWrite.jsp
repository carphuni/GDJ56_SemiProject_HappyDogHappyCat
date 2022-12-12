<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/volWrite.css"/>

<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

<section id="container1">
<form action="<%=request.getContextPath() %>/volview.do" 
    			method="post" enctype="multipart/form-data">
    <div class="board_wrap">
        <div class="board_title">
            <strong style="font-size: 25px;">자원봉사</strong>
        </div>
        <div class="board_write_wrap">
            <div class="board_write" >
            
                <div class="title" >
                    <dl>
                        <dt style="font-size:17px">제목</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" placeholder="제목 입력" name=volTitle required /></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">시설이름</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="hidden" name=agencyName value="" placeholder="단체 및 시설이름 입력"></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">주소</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="hidden" name=agencyAddress value="" placeholder="주소입력"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">담당자 이름</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" name="managerName" placeholder="담당자 이름" required></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">시설 연락처</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="hidden" name=agencyPhone placeholder="시설 연락처"></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">모집기간</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="date" name="recruitPeriod1" required>&nbsp;-&nbsp;<input type="date" name="recruitPeriod2" required></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">모집인원</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type=number name="recruitNumber" placeholder="모집인원" required></dd>
                    </dl>
                </div>
                <div class="info">
                    <dl>
                        <dt style="font-size:17px">봉사활동기간</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="date" name="activityPeriod1" required>&nbsp;-&nbsp;<input type="date" name="activityPeriod2" required></dd>
                    </dl>
                    <dl>
                        <dt style="font-size:17px">활동가능요일</dt>
                        <dd style="font-size:17px;margin-top:14px;"><input type="text" name=activityDay placeholder="활동가능요일" required></dd>
                    </dl>
                </div>
                <div class="cont">
                    <textarea rows="10" cols="100" name="summernote" id="summernote" placeholder="내용 입력"></textarea>
                </div>

                <div class="file" style="font-size:17px">
                    <b>* 대표이미지 설정</b>
                    <input type="file" class="real-upload" accept="image/*" onchange="readURL(this);">
                    <img id="preview" style="display:none;"></div>
                </div>
                
                <div class="file2" style="font-size:17px">
                    <b>* 사진첨부</b>
                    <input type="file" id='btnAtt' accept="image/*" required multiple/>
                </div>
                <div id='att_zone' 
                data-placeholder='파일을 첨부 하려면 파일 선택 버튼을 클릭하거나 파일을 드래그앤드롭 하세요'></div>
              
            </div>
			
	       
            <div class="bt_wrap" >
                <input type="submit" style="font-size:17px" class="on" value="등록">
                <input type="button" style="font-size:17px" value="취소" onclick="location.replace('<%=request.getContextPath()%>/volview.do')">
            </div>
        </div>
    </form>
</section>

<script src="<%=request.getContextPath()%>/js/volwrite.js"></script>
<%@ include file="/views/common/footer.jsp" %>