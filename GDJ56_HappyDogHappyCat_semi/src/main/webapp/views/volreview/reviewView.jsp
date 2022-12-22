<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.happy.volreview.model.vo.VolComment,com.happy.volreview.model.vo.VolReview,com.happy.volreview.model.vo.VolReviewPhoto,java.util.List" %>
 <%
	VolReview vr = (VolReview)request.getAttribute("vr");
	List<VolReviewPhoto> photo = (List<VolReviewPhoto>)request.getAttribute("reviewPhoto");
	List<VolComment> comments = (List<VolComment>)request.getAttribute("comments");
%>   
<%@ include file="/views/common/header.jsp"%>

<div id="container">
    
<% if(loginMember!=null&&loginMember.getMemberNo()==vr.getMemberNo()||loginMember!=null&&loginMember.getMemberId().equals("admin")){ %>
<div style="margin-top:5px;" class="bt_wrap" >
  <a style="font-size:17px;margin-right:-65%;"href="<%=request.getContextPath()%>/updatevolreview.do?boardNo=<%=vr.getVntBoardNo()%>">수정</a>
  <a style="font-size:17px;margin-right:20%"href="<%=request.getContextPath()%>/deletevolreview.do?boardNo=<%=vr.getVntBoardNo()%>">삭제</a>
</div>
<%} %>
</div>

<section id="content">
	<div id="title">
	<br><br>
            <h2><%=vr.getVntTitle() %></h2><br>
        </div>
        <br><br>
        
        <div style="text-align: center; width: 600px; margin: auto; word-break:break-all;word-wrap:break-word;">
            <p><%=vr.getVntContents() %></p>
        </div>

        <br><br><br><br>
        <div id="detail">
            <div id="detailTitle"><br>
                <h2>HAPPY DOG HAPPY CAT</h2>
                <br>
            </div>
		
				<%for(int i=0;i<photo.size();i++){ %> 
					<img src="<%=request.getContextPath()%>/upload/volreview/<%=photo.get(i).getVntPhotoRename() %>" alt=""><br><br><br><br>
			 	<%} %>
           
        </div>
        <div id="checklist">
            <div id="detailTitle"><br>
            </div>
        </div>
     </section>
        
        <div id="reply" style=" text-align: left; width: 600px; margin: auto; word-break:break-all;word-wrap:break-word;">
        <div id="comment_box1" style="cursor: pointer;">
        	<h3>댓글창보기(<%=comments.size() %>)</h3>
        </div>
        <div id="comment_lists" style="padding:5px";>
	     	<form>
	            <textarea name="textarea1" id="textarea2" cols="90" rows="3" placeholder="댓글을 입력해주세요."></textarea>
	            <button id="reply-btn" type="button" class="btn btn-outline-secondary" style="float: right;">등록</button>
	       	</form>
	        <br><br>
	        <div style="border-top: solid rgba(0, 0, 0, 0.614);">
	        </div>
		        <%if(comments.isEmpty()){ %>
	        	<div style="border-bottom: solid rgba(0, 0, 0, 0.482);">
	            	<p>댓글이 없습니다.</p>
	        	</div>
	        <%}else{ %>
	        	<%for(int i=0;i<comments.size();i++){ %> 
	        	
	        		<div style="border-bottom: solid rgba(0, 0, 0, 0.482);">
		        			
		            		<p><b><%=comments.get(i).getMemberId() %></b> <small><%= comments.get(i).getVntCommentWrite() %></small></p>
		            		<p id="con2"><%=comments.get(i).getVntCommentContents() %></p>
		            		<div style="text-align:right;vertical-align: top;">
		            		<%if((loginMember!=null&&loginMember.getMemberId().equals(comments.get(i).getMemberId()))||(loginMember!=null&&loginMember.getMemberId().equals("admin"))){ %>
		        			<button style="margin-left:83%;margin-bottom:-30%;margin-top:-60%; margin-right:0%" class="btn-reply" value="<%=comments.get(i).getVntCommentNo()%>">수정</button>
		        			<input type="hidden" name="comNo" value="<%=comments.get(i).getVntCommentNo()%>">
   							<button style=":right;margin-top: -7%; class="btn-delete" onclick="location.replace('<%=request.getContextPath()%>/deletecomment.do?commentNo=<%=comments.get(i).getVntCommentNo()%>&&boardNo=<%=comments.get(i).getVntBoardNo()%>')">삭제</button>
		        			 <%}%> 
		        			</div>
						</div>
	       <%  }} %> 
		
	   
	    
        </div>
    </div>
    <br>
        <div id="adp_btn">
        	<a href="<%=request.getContextPath()%>/reviewlist.do">
            <button type="button" class="btn btn-primary" style="margin-top: 10%;"><p>목록가기</p></button>
            </a>
            <br>
        </div>
        <br><br>

 <style>
    div#comment_lists{
        display:none;
    }
    textarea{
    	box-sizing: border-box; 
    	border: solid 2px gray;
    	border-radius: 5px; 
    	resize: none;
    	outline-color: #FE6B8B;
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
    #content div{
            text-align: center;
        }
        #imgs img{
            width: 200px;
            height: 250px;
            opacity: 0.5; 
        }
    #container{
        text-align: center;
        padding:50px;
        /* padding-left: 210px; */
    }
    .bt_wrap {
             /* padding:20px; */
             margin-top: 50px;
             text-align: center;
             font-size: 0;
             margin-left:18%
         }
         
         .bt_wrap a {
             display: inline-block;
             min-width: 80px;
             /* margin-left: -40%; */
             padding: 10px;
             border: 1px solid #000;
             border-radius: 2px;
             font-size: 1.4rem;
             color:black;
         }
         
         .bt_wrap a:first-child {
             margin-left: 0;
             background-color: rgb(207, 207, 207);
             color:white;
             
         }
        

         .bt_wrap a:last-child{
          min-width: 80px;
          float:right;
          margin-right:17%;
            

         }
</style>
<script>
 $(()=>{
$(".btn-reply").click(e=>{
	
	const form=$("#comment_lists>form").clone();
	console.log($(e.target).val());
	form.find("button").attr("onclick", "test(event);").attr("value",$(e.target).val());
	/* form.find("button").removeAttr("Id").removeAttr("Class").addClass("insert2"); */
	form.find("textarea").removeAttr("Id").addClass("textarea5");
	form.insertAfter($(e.target).parents("div#comment_lists>div>div")).slideDown(800);

	
});

}) 

const test = (e) => {
			
			const reply=$(".textarea5").val();
			console.log(reply);
			const commentNo = $(e.target).val();
			console.log(commentNo);
			$.ajax({
				url:"<%=request.getContextPath()%>/updatecomment.do",
				type:"get",
				data:{reply:reply,commentNo:commentNo,memberId:"<%=loginMember!=null?loginMember.getMemberId():0%>" ,boardNo:"<%=vr.getVntBoardNo()%>"},
				success:data=>{
					console.log(data);
					/* $("#con2").innerHTML(data); */
					alert("댓글 수정 성공!")
					location.assign("<%=request.getContextPath()%>/volreviewview.do?boardNo=<%=vr.getVntBoardNo()%>");
				}});
			}
	    	
		

$("#textarea2").focus(e=>{
	if(<%=loginMember==null%>){
		$("#textarea2").blur();
		alert('로그인 후 이용할 수 있습니다.');
	}
		else{
		$("#reply-btn").click(e=>{
			const reply=$("#textarea2").val();
			console.log(reply);
			const commentNo = $("input[name=comNo]").val();
			console.log(commentNo);
			$.ajax({
				url:"<%=request.getContextPath()%>/volreviewcomment.do",
				type:"get",
				data:{reply:reply,memberId:"<%=loginMember!=null?loginMember.getMemberId():0%>" ,boardNo:"<%=vr.getVntBoardNo()%>"},
				success:data=>{
					console.log(data);
				
					alert("댓글 등록 성공!")
					location.assign("<%=request.getContextPath()%>/volreviewview.do?boardNo=<%=vr.getVntBoardNo()%>");
				}
	    	});
		});
		}
	
}); 

	$("#comment_box1 h3").click(e=> {  
	    $("#comment_lists").slideToggle(); 
	});

</script>

<%@ include file="/views/common/footer.jsp"%>