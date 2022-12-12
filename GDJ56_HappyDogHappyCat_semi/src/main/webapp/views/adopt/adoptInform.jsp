<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="./js/jquery-3.6.1.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>입양안내</title>

	<style>
        #adp_btn{
    		border-radius: 20px;
   		}
        div#adp_btn{
        text-align: center;
        }
        div#adp_btn button{
            width: 350px;
            height: 60px;
        }
        div#adp_btn p{
            font-weight: 6px;
            letter-spacing: 5px;
            font-size: large;
            margin: auto;
        }
        div#graycontainer div{
            width: 300px;
            height: 45px;
            border-bottom: solid 2px rgba(33, 31, 31, 0.482);
            display: inline-block;
        }
        div#pp{
            text-align: center;
        }
        div#gray{
            text-align: center;
        }
        div#graycontainer{
            width: 550px;
            height: 190px;
            background-color: rgba(220, 220, 220, 0.575);
            display: inline-block;
            border-radius: 70px;
        }
        div#ptext{
            display: inline-flex;
        }
        div#pTag{   
            margin-left: 120px;
        }
        div#pTags p{
            font-size: 27px;
        }
        div#title{
            text-align: center;
            border-bottom: 2px solid rgb(194, 192, 192);
            width: 1000px;
            margin: 0 auto;
        }
        #content div{
            text-align: center;
        }
        #imgs img{
            width: 200px;
            height: 250px;
            opacity: 0.5; 
        }
    </style>
</head>
<body>
	    <section id="content">
        <div id="imgs" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
            <img src="<%=request.getContextPath() %>/images/Q.jfif" alt="" style="margin-right: auto;">
            <div id="text" >
                <br><br>    
                <h2>입양안내</h2>
                <br>
                 <p>보호중인 파양동물들과 유기된 동물들을<br>   
                    상시로 공고하고 있습니다.</p>
            </div>
            <img src="<%=request.getContextPath() %>/images/S.jfif" alt="" style="margin-left: auto;">
        </div>
        <br><br>
        <div id="title">
            <h2>입양안내</h2><br>
        </div>
        <br><br>
        <div id="contents" width="450px">
            <img src="<%=request.getContextPath() %>/images/content1.PNG" alt="">
        </div>
        <br>
        <div id="pp">
            <div id="ptext">
                <div id="pTags">
                    <p style="letter-spacing: 4px;">해피캣해피독</p> 
                    <p style="letter-spacing: 20px;">무료</p> 
                    <p style="letter-spacing: 15px;">입소안내</p>
                </div >
                <div id="pTag"><br>
                    <p>해피캣해피독에서는 올바른 반려동물문화를 장려하기 위해<br><br>
                        무료 입양 시스템을 지양하고있습니다.<br><br>      
                        * 심사기준에 따라 입양이 불가할 수도 있습니다.</p>
                </div>
            </div>
        </div>
        <br><br><br>
        <div>
            <img src="<%=request.getContextPath() %>/images/KakaoTalk_Snapshot_20221102_184038.png" alt="">
            <br><br><br>
            <h2>해피캣해피독의 안전 입양 절차</h2>
        </div>
        <br><br>
        <div id="gray">
            <div id="graycontainer">
                <br>
                <div><h4>입양 신청 게시판</h4></div>
                <p><br>홈페이지 입양신청 게시판을 이용하여<br>
                    입양 상담 신청을 해주세요.</p>
            </div>
            <br><br>
            <div id="graycontainer">
                <br>
                <div><h4>1:1 전화상담</h4></div>
                <p><br>전화상담을 통해 아이의 정보 및 건강, <br>
                    기타사항에 대해<br>
                    보호자가 숙지가 되어있는지 확인이 필요합니다.</p>
            </div>
            <br><br>
            <div id="graycontainer">
                <br>
                <div><h4>방문상담</h4></div>
                <p><br>직접 방문을 통해 보호자가 아이의 상태를 <br>
                    육안으로 확인합니다.</p>
            </div>
            <br><br>
            <div id="graycontainer">
                <br>
                <div><h4>입양 결정</h4></div>
                <p><br>위 과정을 통해 보호자가<br>
                    입양을 결정합니다.</p>
            </div>
            <br><br>
            <div id="graycontainer">
                <br>
                <div><h4>입양 후 관리</h4></div>
                <p><br>보호자가 아이들을 입양 후 잘 관리되어지고 <br>
                    있는지 확인전화를 통해 <br>         
                    아이들의 상태를 확인합니다.</p>
            </div>
        </div>
        <br><br>
        <div id="adp_btn">
            <button type="button" id="adp_btn" class="btn btn-primary"><p>입양하러가기</p></button>
        </div>
        <br><br><br>
    </section>
</body>
</html>