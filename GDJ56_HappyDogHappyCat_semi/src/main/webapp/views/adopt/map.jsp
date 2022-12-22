<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page import="java.util.List, java.util.Arrays,com.happy.animal.model.vo.Animal,com.happy.adopt.model.vo.AnimalPick,com.happy.admission.vo.AnimalPhoto" %>
    <% Animal ani = (Animal)request.getAttribute("ani"); List<AnimalPick> pick = (List<AnimalPick>)request.getAttribute("pick"); 
    List<AnimalPhoto> aniPhoto=(List<AnimalPhoto>)request.getAttribute("aniPhoto");
    %>
<%@ include file="/views/common/header.jsp"%>


    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"> -->

<style>
	#content div{
            text-align: center;
        }
        #imgsbar img{
            width: 200px;
            height: 250px;
            opacity: 0.5; 
        }
    div#title{
        text-align: center;
        border-bottom: 2px solid rgb(194, 192, 192);
        width: 1000px;
        margin: 0 auto;
    }
    div#imgs{
        text-align: center;
    }
    div#description>table, td, th{
        margin:auto;
        border : 1px solid rgb(215, 211, 211);
        border-collapse : collapse;
    }
    div#description>table th{
        background-color: rgba(220, 220, 220, 0.612);
    }
    div#description>table{
        width: 800px;
        height: 200px;
        text-align: center;
    }
    div#detail{
        text-align: center;
    }
    div#detailTitle{
        text-align: center;
        border-top: 2px solid rgb(194, 192, 192);
        width: 700px;
        margin: 0 auto;
    }
    div#detailTitle h2{
        color: rgb(59, 120, 235);
    }
    div#detail img{
        width: 350px;
        height: 250px;
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
	.sideBanner {
        position: absolute;
        width: 140px;
        height: 140px;
        top: 50px;
        right: 20px;
        border-radius: 80px;
        border: solid 2px rgb(215, 211, 211);
    }
    #sideBanner-inner{
        text-align: center;
    }
    #pick{
        cursor: pointer;
    }
    #btnlistdiv{
            width:900px; 
            height:100px; 
            margin: auto;
        }
        #btnlist{
            width: 80px;
            height: 38px;
            float: right;
            cursor: pointer;
        }
</style>

    
	         
      <input type="text" id="maphos">
      <button id="maphos" onclick="hospi();">병원</button>
      <div id="divdiv"></div>
<%@ include file="/views/common/footer.jsp"%>
<script>
 
 const hospi=()=>{
	 const maphoss=$("#maphos").val();                                            
	 location.assign("https://openapi.gg.go.kr/Animalhosptl?SIGUN_NM="+maphoss);
 }
	
	
	
    
</script>
