const fn_myPage=()=>{
	$.ajax({
		url:"/GDJ56_HappyDogHappyCat_semi/member/myPage.do",
		type:"post",
		data:{memberPw:$("input[name=memberPw]").val()},
		success:data=>{
			console.log(data);
		}
		
	})
}