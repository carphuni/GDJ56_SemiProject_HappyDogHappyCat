const emailCk=(asValue)=> {
	//이메일 정규식 체크
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
 
	return regExp.test(asValue);
}

const passwordCk=(asValue)=> {
	//비밀번호 정규식 체크
	//8 ~ 16자 영문, 숫자, 특수문자를 최소 한가지씩 조합
	var regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
 
	return regExp.test(asValue); 
}

const phoneCk=(asValue)=> {
	//전화번호 정규식 체크
	var regExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;
 
	return regExp.test(asValue);
}

const agencyPhoneCk=(asValue)=>{
	//전화번호(00[0]-000-0000) 정규식 체크
	var regExp = /^0[0-9]{1,2}-[0-9]{3}-[0-9]{4}$/;
 
	return regExp.test(asValue);
}

const idCk=(asValue)=> {
	//아이디 정규식 체크 
	//영문자로 시작하는 영문자 또는 숫자 6~20자 
	var regExp = /^[a-z]+[a-z0-9]{5,19}$/g;
 
	return regExp.test(asValue);
}

const yearCk=(asValue)=> {
	//년도 정규식 체크
	var regExp = /^\d{4}$/;
	
	return regExp.test(asValue);
}

const monthCk=(asValue)=> {
	//월 정규식 체크
	var regExp = /^(0[1-9]|1[012])$/;
	
	return regExp.test(asValue);
}

const dayCk=(asValue)=> {
	//일 정규식 체크
	var regExp = /^(0[1-9]|[12][0-9]|3[01])$/;
	
	return regExp.test(asValue);
}




const duplicateId=()=>{
	$.ajax({
		url:"/GDJ56_HappyDogHappyCat_semi/member/duplicateId.do",
		data:{"inputId":$("#floatingId").val()},
		success:data=>{
			if(idCk($("#floatingId").val())&&data=="null"){
				$("#idResult").text("사용가능한 아이디입니다");
			}else{
				$("#idResult").text("사용 불가능한 아이디입니다");
			}
		}
	})
}

const memberEnroll=()=>{
	//form 입력 데이터 json
	let form=$("#login-container").serialize();
	//form 입력 데이터 배열
	let formArray=$("#login-container").serializeArray();
	//form 배열 데이터 변수 저장
	var memberId=formArray[0].value
	var memberPw=formArray[1].value
	var memberPwCk=formArray[2].value
	var memberName=formArray[3].value
	var memberYear=formArray[4].value
	var memberMonth=formArray[5].value
	var memberDay=formArray[6].value
	var memberEmail=formArray[7].value
	var memberPhone=formArray[8].value
	var memberAddress=formArray[9].value
	
	//아이디 정규식 체크
	if($("#idResult").text()!="사용가능한 아이디입니다") {$("#idResult").text("아이디 중복확인이 필요합니다");return false;}
	if(!passwordCk(memberPw)) {$("#pwResult").text("비밀번호는 8 ~ 16자 영문, 숫자, 특수문자를 포함해야합니다").css("font-color","red"); return false;}
	if(memberName.length<2) {$("#nameResult").text("이름은 2자 이상이어여합니다"); return false;}else{$("#nameResult").hide()}
	if(!yearCk(memberYear)) {$("#birthResult").text("년도 입력이 올바르지 않습니다");return false;}
	if(!monthCk(memberMonth)) {$("#birthResult").text("월 입력이 올바르지 않습니다");return false;}
	if(!dayCk(memberDay)) {$("#birthResult").text("일 입력이 올바르지 않습니다"); return false;}else{$("#birthResult").hide()}
	if(!emailCk(memberEmail)) {$("#emailResult").text("이메일 입력이 올바르지 않습니다"); return false;}else{$("#emailResult").hide();}
	if(!phoneCk(memberPhone)) {$("#phoneResult").text("연락처 입력이 올바르지 않습니다( '-' 제외 )"); return false;}else{$("#phoneResult").hide();}
	if(memberAddress.length<1) {$("#addressResult").text("주소 입력이 올바르지 않습니다"); return false;}else{$("#addressResult").hide();}
		
	
	
	$.ajax({
		url:"/GDJ56_HappyDogHappyCat_semi/member/enrollEnd.do",
		data:form,
		success:data=>{
			alert(data.msg);
			location.replace("/GDJ56_HappyDogHappyCat_semi"+data.loc)
		}
	})
		
}


$(()=>{
	//비밀번호 확인 입력 후
	$("#floatingPwCk").blur(e=>{
		const pw=$("#floatingPw").val();
		const pwck=$(e.target).val();
		if(pw!=""&&pw==pwck){
			$("#pwResult").css({"color":"green"}).text("비밀번호가 일치합니다.")
		}else{
			$("#pwResult").css({"color":"red"}).text("비밀번호가 일치하지 않습니다.")
		}
	});	
	
	//아이디 입력칸 focus
	$("input#floatingId").focus(e=>{
		//아이디 확인 메세지 삭제
		$("#idResult").text("");
	})
});

const enrollAgencyEnd=()=>{
	var form=$("form#login-container").serialize();
	
	var inputAgencyPhone=$("floatingAgencyPhone").val();
	if(!agencyPhoneCk(inputAgencyPhone)){alert("시설 연락처가 옳지않습니다"); return false;}
	
	$.ajax({
		url:"/GDJ56_HappyDogHappyCat_semi/agency/enrollAgencyEnd.do",
		data:form,
		dataType:"json",
		success:data=>{
			alert(data.msg);
			location.replace("/GDJ56_HappyDogHappyCat_semi"+data.loc);
		}
	})
}

const updateMemberNameEnd=()=>{
	$.ajax({
		url:"/GDJ56_HappyDogHappyCat_semi/member/updateMemberNameEnd.do",
		data:$("form#login-floating").serialize(),
		success:data=>{
			
		}
	})
}

const winClose=()



