<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script src="<%=request.getContextPath() %>/js/jquery-3.6.1.min.js"></script> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    div#checklist h3{
        text-align: center;
    }
    div#ckbtn{
        text-align: center;
    }

</style>
<body>
    <div id="checklist">
    
        <h3><입양시 체크리스트></h3><br>
        <!-- <form id="adp_form"  onsubmit="return checkcheck();"> -->
            <ul>
            	
                <li>가족들과 충분한 협의가 되었는가<input type="checkbox" name="ck1" id="ck1"></li> 
                <br><br>
                <li>결혼, 독립 등 가정 환경이 바뀌어도 끝까지 보상될 자신이 있는가<input type="checkbox" name="ck2" id="ck2"> </li>               
                <br><br>
                <li>새로운 반려견을 위해 꾸준히 공부할 마음이 준비되었나<input type="checkbox" name="ck3" id="ck3"></li>            
                <br><br>
                <li>사료관리, 치료, 훈련 등에 소요되는 경제적 부담 준비는 되었는가<input type="checkbox" name="ck4" id="ck4"> </li>              
                <br><br>
                <li>반려견의 단점까지도 사랑할 준비가 되었는가<input type="checkbox" name="ck5" id="ck5"></li>           
            </ul>
            <br><br>
            <div id="ckbtn">
                <input id="ck-btn" type="button" value="확인완료" >
            </div>
        <!-- </form> -->
    </div>
</body>
<script>
    // const checkcheck=()=>{
        // const roommate=$('input:radio[name=roommate]').is(":checked");
        // const animal=$('input:radio[name=animal]').is(":checked");
        // const money=$('input:radio[name=money]').is(":checked");
        // const allergy=$('input:radio[name=allergy]').is(":checked");
        // const live=$('input:radio[name=live]').is(":checked");
        // if(!roommate||!animal||!money||!allergy||!live){
        //     alert('체크리스트를 모두 선택해주세요');
        //     // return false;
        // }
    // }
    /* $("input:radio").click(e=>{
        if(($(e.target).val())=='roommateY'){
            const result1=confirm('동거인의 동의를 얻으셨나요?');
            if(!result1){
                $("input[type=radio][name=roommate]").prop('checked', false);
            }
        }
        if(($(e.target).val())=='animalN'){
            const result2=confirm('동물에 대해 공부하실거죠?');
            if(!result2){
                $("input[type=radio][name=animal]").prop('checked', false);
            }
        }
        if(($(e.target).val())=='moneyN'){
            const result3=confirm('사료나 필요한 용품들 비용을 감당하실 수 있나요?');
            if(!result3){
                $("input[type=radio][name=money]").prop('checked', false);
            }
        }
        if(($(e.target).val())=='allergyY'){
            alert('알레르기가 있다면 입양을 다시 한번 고려해주세요.');
        }
        if(($(e.target).val())=='liveA'){
            const result4=confirm('소음방지패드를 준비해주세요!');
            //console.log(result);
            if(!result4){
                $("input[type=radio][name=live]").prop('checked', false);
            }
        }
    }); */
    $(()=>{
        $("input:button").click(e=>{
            const ck1=$('input:checkbox[name=ck1]').is(":checked");
            const ck2=$('input:checkbox[name=ck2]').is(":checked");
            const ck3=$('input:checkbox[name=ck3]').is(":checked");
            const ck4=$('input:checkbox[name=ck4]').is(":checked");
            const ck5=$('input:checkbox[name=ck5]').is(":checked");
            
            if(!ck1||!ck2||!ck3||!ck4||!ck5){
                alert('체크리스트를 모두 선택해주세요');
            }
            if(ck1&&ck2&&ck3&&ck4&&ck5){
                opener.document.getElementById("ckck").checked="true";
                close();
            }     
        });    
    });
    
</script>
</html>