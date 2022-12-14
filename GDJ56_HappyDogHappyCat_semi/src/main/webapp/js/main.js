const emailCk=(asValue)=> {
	//이메일 정규식 체크
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
 
	return regExp.test(asValue);
}

const passwordCk=(asValue)=> {
	//비밀번호 정규식 체크
	var regExp = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/;
 
	return regExp.test(asValue); 
}

const phoneCk=(asValue)=> {
	//전화번호 정규식 체크
	var regExp = /^01(?:0|1|[6-9])(?:\d{3}|\d{4})\d{4}$/;
 
	return regExp.test(asValue);
}

const idCk=(asValue)=> {
	//아이디 정규식 체크
	var regExp = /^[a-z]+[a-z0-9]{5,19}$/g;
 
	return regExp.test(asValue);
}

const yearCk=(asValue)=> {
	var regExp = /^\d{4}$/;
	
	return regExp.test(asValue);
}

const monthCk=(asValue)=> {
	var regExp = /^(0[1-9]|1[012])$/;
	
	return regExp.test(asValue);
}

const dayCk=(asValue)=> {
	var regExp = /^(0[1-9]|[12][0-9]|3[01])$/;
	
	return regExp.test(asValue);
}

$(()=>{
	$("#floatingPwCk").blur(e=>{
		const pw=$("#floatingPw").val();
		const pwck=$(e.target).val();
		if(pw==pwck){
			$("#pwResult").css({"color":"green","text-align":"start"}).text("비밀번호가 일치합니다.")
		}else{
			$("#pwResult").css({"color":"red","text-align":"start"}).text("비밀번호가 일치하지 않습니다.")
		}
	});	
});