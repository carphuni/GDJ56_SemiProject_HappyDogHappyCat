<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page import="java.util.List, java.util.Arrays,com.happy.animal.model.vo.Animal" %>
    <% List<Animal> aniList = (List<Animal>)request.getAttribute("aniList"); %>
<!DOCTYPE html>
<style>
    #post{
        margin-right: 150px;
        margin-left: 150px;
        display: flex;
        justify-content: space-evenly;
    }
    #content div{
        text-align: center;
    }
    #imgs img{
        width: 200px;
        height: 250px;
        opacity: 0.5; 
    }
    #board-search .search-window {
        padding: 15px 0;
        background-color: #f9f7f9;
        }
        #board-search .search-window .search-wrap {
        display: flex;
            position: relative;
        /*   padding-right: 124px; */
        margin: 0 auto;
        width: 80%;
        max-width: 564px;
        }
        #board-search .search-window .search-wrap input {
        height: 40px;
        width: 100%;
        font-size: 14px;
        padding: 7px 14px;
        border: 1px solid #ccc;
        }
        #board-search .search-window .search-wrap input:focus {
        border-color: #333;
        outline: 0;
        border-width: 1px;
        }
        #board-search .search-window .search-wrap .btn {
        /* position: absolute; */
        right: 0;
        top: 0;
        bottom: 0;
        width: 108px;
        padding: 0;
        font-size: 16px;
        }
        .container {
        
        margin: 0 auto;
        }
</style>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <section id="content">
        <div id="imgs" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
            <img src="<%=request.getContextPath() %>/images/adopt/Q.jfif" alt="" style="margin-right: auto;">
            <div id="text" >
                <br>
                <h1>입양하기</h1>
                 <p>보호중인 파양동물들과 유기된 동물들을<br>
                    상시로 공고하고 있습니다.<br>
                    자세한 안내는 입양안내를<br>
                    참고해주세요.</p>
            </div>
            <img src="<%=request.getContextPath() %>/images/adopt/S.jfif" alt="" style="margin-left: auto;">
        </div>
        <div id="board-search">
            <div class="container">
                <div class="search-window">
                    <form action="">
                        <div class="search-wrap">
                            <label for="search" class="blind">내용검색</label>
                            <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">&nbsp;
                            <button type="submit" class="btn btn-dark">검색</button> &nbsp;
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <br><br>
        <% for(int i=0;i<aniList.size();i++){ %>
        	<div id="post">
            <div id="dog-des" style="margin-bottom:0;">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
        <%} %>
        
		<div id="post">
            <div id="dog-des" style="margin-bottom:0;">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
        </div>
        <br><br> 
<%--         <div id="post">
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
        </div>
        <br><br> --%>
<%--         <div id="post">
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
            <div id="dog-des">
                <img id="adp_img" src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="">
                <p>[강아지] 웰시코기 궁딩이 무료입양</p>
                <div style="margin-top: auto;">
                    <p style="float: left;">♡</p>
                    <p style="float: right;">조회수 3</p>
                </div>
            </div>
        </div> --%>
    </section>
</body>
</html>