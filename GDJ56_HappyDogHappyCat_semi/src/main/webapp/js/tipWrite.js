$(() => {
    //여기 아래 부분
    $("#summernote").summernote({
      height: 300, // 에디터 높이
      minHeight: null, // 최소 높이
      maxHeight: null, // 최대 높이
      focus: true, // 에디터 로딩후 포커스를 맞출지 여부
      lang: "ko-KR", // 한글 설정
    });

    $("#summernote").summernote(
      "code",
      "<br><div>1.발견지역:</div><div>2.품종:</div><div>3.성별:</div><div>4.특이사항</div><div>5.보호자전화번호:</div>"
    );
  });
  
  var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
  mapOption = { 
      center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
      level: 7 // 지도의 확대 레벨 
  }; 

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var marker; //마커 

//HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
if (navigator.geolocation) {
  
  // GeoLocation을 이용해서 접속 위치를 얻어옵니다
  navigator.geolocation.getCurrentPosition(function(position) {
      
      var lat = position.coords.latitude, // 위도
          lon = position.coords.longitude; // 경도
      
      var locPosition = new kakao.maps.LatLng(lat, lon); // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
      
      // 마커와 인포윈도우를 표시합니다
      displayMarker(locPosition);
          
    });
  
} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다
  
  var locPosition = new kakao.maps.LatLng(33.450701, 126.570667);
      
  displayMarker(locPosition);
}

//지도에 마커와 인포윈도우를 표시하는 함수입니다
function displayMarker(locPosition) {

  // 마커를 생성합니다
  	  marker = new kakao.maps.Marker({  
      map: map, 
      position: locPosition
  }); 
  
  
  // 지도 중심좌표를 접속위치로 변경합니다
  map.setCenter(locPosition);      
}    

//지도에 클릭 이벤트를 등록합니다
//지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
 // 클릭한 위도, 경도 정보를 가져옵니다 
 var latlng = mouseEvent.latLng; 
 
 // 마커 위치를 클릭한 위치로 옮깁니다
 marker.setPosition(latlng);
 
 
 $("input[name='lat']").val(latlng.getLat());
 $("input[name='lon']").val(latlng.getLng());
 console.log($("input[name='lat']").val());
 console.log($("input[name='lon']").val());
 
});



