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
      "<br><div>1.발견지역 : </div><div>2.품종 : </div><div>3.성별 : </div><div>4.특이사항 : </div><div>5.보호자전화번호 : </div>"
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

( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */
	imageView = function imageView(att_zone, btn){

	    var attZone = document.getElementById(att_zone);
	    var btnAtt = document.getElementById(btn)
	    var sel_files = [];
	    // 이미지와 체크 박스를 감싸고 있는 div 속성
	    var div_style = 'display:inline-block;position:relative;'
	                  + 'width:150px;height:120px;margin:5px;border:1px solid #00f;z-index:1';
	    // 미리보기 이미지 속성
	    var img_style = 'width:100%;height:100%;z-index:none';
	    // 이미지안에 표시되는 체크박스의 속성
	    var chk_style = 'width:30px;height:30px;position:absolute;font-size:24px;'
	                  + 'right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00';
	  
	    btnAtt.onchange = function(e){
	      var files = e.target.files;
	      var fileArr = Array.prototype.slice.call(files)
	      
	      for(f of fileArr){
	        imageLoader(f);
	      }
	    }  
	    
	  
	    // 탐색기에서 드래그앤 드롭 사용
	    attZone.addEventListener('dragenter', function(e){      
	      e.preventDefault();
	      e.stopPropagation();
	    }, false)
	    
	    attZone.addEventListener('dragover', function(e){
	      e.preventDefault();
	      e.stopPropagation();
	      
	    }, false)
	  
	    attZone.addEventListener('drop', function(e){
	      var files = {};
	      e.preventDefault();
	      e.stopPropagation();
	      var dt = e.dataTransfer;
	      files = dt.files;
	      for(f of files){
	        imageLoader(f);
	      }
	      
	    }, false)
	  
	    
	    /*첨부된 이미리즐을 배열에 넣고 미리보기 */
	    imageLoader = function(file){
	      sel_files.push(file);
	      var reader = new FileReader();
	      reader.onload = function(ee){
	        let img = document.createElement('img')
	        img.setAttribute('style', img_style)
	        img.src = ee.target.result;
	        attZone.appendChild(makeDiv(img, file));
	        
	      }
	      
	      reader.readAsDataURL(file);
	   
	    }
	    
	    /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */
	    makeDiv = function(img, file){
	     
	      var div = document.createElement('div')
	      div.setAttribute('style', div_style)
	      
	      var btn = document.createElement('input')
	      btn.setAttribute('type', 'button')
	      btn.setAttribute('value', 'x')
	      btn.setAttribute('delFile', file.name);
	      btn.setAttribute('style', chk_style);
	      btn.onclick = function(ev){
	        var ele = ev.srcElement;
	        var delFile = ele.getAttribute('delFile');
	        for(var i=0 ;i<sel_files.length; i++){
	          if(delFile== sel_files[i].name){
	            sel_files.splice(i, 1);      
	          }
	        }
	        
	        dt = new DataTransfer();
	        for(f in sel_files) {
	          var file = sel_files[f];
	          dt.items.add(file);
	        }
	        btnAtt.files = dt.files;
	        var p = ele.parentNode;
	        attZone.removeChild(p)
	      }
	      div.appendChild(img)
	      div.appendChild(btn)
	      return div
	     
		 }
})('att_zone', 'btnAtt')


$("#saveBtn").click(e=>{
	//등록버튼 클릭 시
	let memberNo = $("input[name=memberNo]").val();//회원 번호
	console.log(memberNo);
	let category=$("form select").val();//카테고리
	console.log(category);
	let inputs=$("form input").not("input[class*=note]").not("input[name=memberNo]");;//input 데이터
	let summernoteContent = $('#summernote').summernote('code');//섬머노트 내용
	console.log(summernoteContent);
	const files=$("input[name=upload2]")[0].files;//첨부파일 데이터
	
	//폼데이터 형태에 데이터 넣기
	let form=new FormData();
	
	form.append("category",category);
	
	inputs.each((i,v)=>{
		console.dir(v);
		console.log("param"+i+$(v).attr("name"),$(v).val());
		form.append("param"+i,$(v).val());
	});
	
	$.each(files,(i,v)=>{
		console.log("파일"+i+v);
		form.append("upfile"+i,v);
	});		
		
	
	form.append("content",summernoteContent);
	form.append("memberNo",memberNo);
	
	console.log("확인"+$("input[name='tipTitle']").val());
	 	
	 if($.trim($("input[name='tipTitle']").val())==""){
		alert("제목을 입력해주세요");
	 }else if(files.length==0||files.length>3){
		alert("사진을 1장 이상 3장 이하 첨부해주세요.");
	 }else if($("input[name='lat']").val()==""){
		alert("지도에 발견장소를 클릭해 주세요");
	 }else{
		$.ajax({
		url :"/GDJ56_HappyDogHappyCat_semi/tip/tipWriteEnd.do",
		data : form,
		type : "post",
		contentType:false,
		processData:false,
		success : e=>{
			alert(e.msg);
			location.replace('/GDJ56_HappyDogHappyCat_semi'+e.loc);
			}
		 });
	 }
			 
});




