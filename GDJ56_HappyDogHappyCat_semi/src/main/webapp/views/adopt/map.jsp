<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page import="java.util.List, java.util.Arrays,com.happy.animal.model.vo.Animal,com.happy.adopt.model.vo.AnimalPick,com.happy.admission.vo.AnimalPhoto" %>
    <% Animal ani = (Animal)request.getAttribute("ani"); List<AnimalPick> pick = (List<AnimalPick>)request.getAttribute("pick"); 
    List<AnimalPhoto> aniPhoto=(List<AnimalPhoto>)request.getAttribute("aniPhoto");
    %>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b5705da8bbf6d5f007956cd8575caa16"></script>
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
      <div id="map" style="width:100%;height:350px;"></div>
      <button id="maphos" onclick="hospi();">병원</button>
      <div id="divdiv"></div>
<%@ include file="/views/common/footer.jsp"%>
<script>
 let hospital=[];
 //console.log(hospital);
 //console.log(hospital[0]);
 const hospi=()=>{
	 const maphoss=$("#maphos").val();                                            
		$.get("<%=request.getContextPath()%>/mainClass2?SIGUN_NM="+maphoss,data=>{
			//console.log(data);
			const table=$("<table>");
			const header=$("<tr>").html("<th>동물병원이름</th><th>전화번호</th><th>주소</th>");
			table.append(header);
			data.forEach(e=>{
				hospital.push(e);
				if(e["BSN_STATE_NM"]=="정상"){
					const tr=$("<tr>");
					const name=$("<td>").text(e["BIZPLC_NM"]);
					const phone=$("<td>").text(e["LOCPLC_FACLT_TELNO"]);
					const addr=$("<td>").text(e["REFINE_ROADNM_ADDR"]);
					tr.append(name).append(phone).append(addr);
					table.append(tr);
				}
			});
			$("#divdiv").html(table);
		console.log(hospital);
		console.log(hospital[0]);
		console.log(hospital[0]['REFINE_WGS84_LAT']);
		var mapContainer;
		//console.log(hospital[0]["BIZPLC_NM"]);
		
		 if(hospital.length==0){
			 mapContainer = document.getElementById('map'),
			 mapOption = { 
			     center: new kakao.maps.LatLng(38.4629693732, 126.8791539685), // 지도의 중심좌표
			     level: 3 // 지도의 확대 레벨
			 };
		 }else{
			 mapContainer = document.getElementById('map'),
			 mapOption = { 
				     center: new kakao.maps.LatLng(hospital[0]['REFINE_WGS84_LAT'],hospital[0]['REFINE_WGS84_LOGT']), // 지도의 중심좌표
				     level: 3 // 지도의 확대 레벨
				 };
		 }
	//console.log(mapOption);
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		var positions=[];
		if(hospital.length==0){
			positions = [
				  {
				     title: '카카오', 
				     latlng: new kakao.maps.LatLng(38.4629693732, 126.8791539685)
				 } 
				];
			}else{
				for(let i=0;i<hospital.length;i++){
					positions = [
						  {
						     title: '카카오', 
						     latlng: new kakao.maps.LatLng(hospital[i]['REFINE_WGS84_LAT'], hospital[i]['REFINE_WGS84_LOGT'])
						 } 
						];
				}
				
			}
		//마커를 표시할 위치와 title 객체 배열입니다 

		//마커 이미지의 이미지 주소입니다
		var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
		 
		for (var i = 0; i < positions.length; i ++) {
		 
		 // 마커 이미지의 이미지 크기 입니다
		 var imageSize = new kakao.maps.Size(24, 35); 
		 
		 // 마커 이미지를 생성합니다    
		 var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
		 
		 // 마커를 생성합니다
		 var marker = new kakao.maps.Marker({
		     map: map, // 마커를 표시할 지도
		     position: positions[i].latlng, // 마커를 표시할 위치
		     title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
		     image : markerImage // 마커 이미지 
		 });
		}	
		});
		
 }
  // 지도를 표시할 div  
 //var mapOption=[];
 
	
	
    
</script>
