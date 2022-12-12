<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/header.jsp"%>
<body>
    <!--섹션 고정 이미지-->
     <section id="content">
        <div style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
            <img src="<%=request.getContextPath() %>/images/admission/dog1.png" alt="" style="margin-right: auto;">
            <div id="text" >
                <h1 style="font-size: 30px; text-align: center;">입소절차</h1>
                 <p style="font-size: 20px; text-align: center;">더이상 함께하지 못하게 된 아이들,<br>
                    <br>
                    갈 곳 없는 아이들이<br>
                    <br>
                    해피독해피캣으로 오는 과정입니다.<br>
                    <br>
            </div>
            <img src="<%=request.getContextPath() %>/images/admission/dog2.png" alt="" style="margin-left: auto;">
        </div>
    </section>
    <!--절차 이미지-->
    <div id="imgContainer" onclick="gotoApply();">
    	<img src="<%=request.getContextPath() %>/images/admission/ready.png" width="800" height="700">
    </div>
    
	<style>
	    #title{
	        text-align: center;
	        margin-top: 200px;
	        font-size: 25px;
	        /*font-family:"Poor Story"; */
	    }
	    #imgContainer{
	        text-align:center;
	    }
	    #content div{
	            text-align: center;
	        }
	        #content img{
	            width: 200px;
	            height: 250px;
	            opacity: 0.5; 
	        }
	    #text{
	        font-family:"Poor Story";
	        font-size: 18px;
	        margin:10px;
	    }

	</style>
	
	<script>
    const gotoApply=()=>{
        window.location.href='http://localhost:9090/GDJ56_HappyDogHappyCat_semi/views/admission/admissionList.jsp';
    }
</script>
</section>
<%@include file="/views/common/footer.jsp"%>