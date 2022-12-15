<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page import="java.util.List, java.util.Arrays,com.happy.animal.model.vo.Animal,com.happy.adopt.model.vo.AnimalPick" %>
    <% List<Animal> aniList = (List<Animal>)request.getAttribute("aniList"); List<AnimalPick> pick = (List<AnimalPick>)request.getAttribute("pick");%>

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
<%@ include file="/views/common/header.jsp"%>
	    <section id="content">
        <div id="imgs" style="width: 100%; height: 250px; background-color: rgba(211, 211, 211, 0.516); display: flex;">
            <img src="<%=request.getContextPath() %>/images/adopt/Q.jfif" alt="" style="margin-right: auto;">
            <div id="text" >
                <br>
                <p></p>
                <h1>입양하기</h1>
                 <p><br>보호중인 파양동물들과 유기된 동물들을<br>
                    상시로 공고하고 있습니다.<br>
                    자세한 안내는 입양안내를 참고해주세요.</p>
            </div>
            <img src="<%=request.getContextPath() %>/images/adopt/S.jfif" alt="" style="margin-left: auto;">
        </div>
        <div id="board-search">
            <div class="container">
                <div class="search-window">
                    <form action="">
                        <div class="search-wrap">
                            <label for="search" style="width:100px;">내용검색</label>
                            <input id="search" type="search" name="" placeholder="검색어를 입력해주세요." value="">&nbsp;
                            <button type="submit" class="btn btn-dark">검색</button> &nbsp;
                        </div>
                    </form>
                </div>
            </div>  
              <div id="numPerpage-container" style="float:right; width:300" >
	        	동물 분류 
	        	<form id="aniTypeF" action="">
	        		<select name="aniType_" id="aniType">
	        			<option value="전체">전체</option>
	        			<option value="강아지">강아지</option>
	        			<option value="고양이" >고양이</option>
	        		</select>
	        	</form>
        	</div> 
        </div>
       
        <br><br>

        	<div id="post" style="flex-wrap:wrap; width:80%;">
        	<% for(int i=0;i<aniList.size();i++){ %>
            <div id="dog-des" style="margin-bottom:0;">
                <a href="<%=request.getContextPath()%>/adopt/adoptdes.do?aniNo=<%= aniList.get(i).getAniNo() %>";>
                <img src="<%=request.getContextPath() %>/images/adopt/images.jfif" alt="" style="width:250px; height:180px;">
                </a> 
                <p  style="margin-bottom: 0; width:240px;">[<%=aniList.get(i).getAniType() %>] <%=aniList.get(i).getAniKind() %> <%=aniList.get(i).getAniName() %> 무료입양</p>
                <div style="margin-bottom: 100px; width:240px;" >
                	<% int count=0; %>
	            <%if(pick==null){ %>
	            	<!-- <h2 id="pick" >🤍</h2>  -->
	            <%}else{ %>
	            	<%for(int j=0;j<pick.size();j++){ %>
		            	<%if(((int)aniList.get(i).getAniNo())==((int)pick.get(j).getAniNo())){%>
		            		<% count++;%>	
		            	<%} } }%>  
		         <%if(count==0){%>
		        	 <h2 id="pick" style="font-size:18px;float: left;">🤍</h2>
		         <%}else{ %>
		         	<h2 id="pick" style="font-size:18px;float: left;">❤️</h2>
		         <%} %>
                    
                    <p style="float: right;">조회수 <%= aniList.get(i).getAdtViews() %></p>
                </div>
            </div>
       		 <%} %> 
        	</div>
			<div style="text-align:center;">
        	<%=request.getAttribute("pageBar") %>
        	</div>
        	<br><br>
		
    </section>
<%@ include file="/views/common/footer.jsp"%>


<!-- /* <form id="aniTypeF" action="">
<select name="aniType_" id="aniType">
	<option value="전체">전체</option>
	<option value="강아지">강아지</option>
	<option value="고양이" >고양이</option>
</select>
</form> */ -->

<script>
	$("#aniType").change(e=>{
		let aniType=$(e.target).val();
		console.log($(e.target).val())
		location.assign("<%=request.getContextPath()%>/adopt/adoptmain.do?aniType="+aniType);
	});
	
</script>