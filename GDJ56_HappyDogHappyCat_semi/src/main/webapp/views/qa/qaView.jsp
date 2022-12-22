<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List,
com.happy.qa.vo.QaForm
,com.happy.qa.vo.QaComment
,com.happy.qa.vo.QaPhoto"%>
<%
	QaForm q=(QaForm)request.getAttribute("qas");
	List<QaComment> qc=(List<QaComment>)request.getAttribute("comments");
	List<QaPhoto> qp=(List<QaPhoto>)request.getAttribute("qaPhoto");
%>
<%@include file="/views/common/header.jsp"%>
	<div id="title">
  		<br>
    	<h3>Q&A[<%=q.getQaBoardNo() %>]:<%=q.getQaTitle() %></h3><br>
  	
    <br><br>
    
  	<%if(qp.isEmpty()){ %>
  		<div id="imgs">
  			<p>사진 없음</p>
  		</div>
  	<%}else{ 
  		for(int i=0;i<qp.size();i++){ %>
  			<div id="imgs">
  				<img src="<%=request.getContextPath() %>/upload/qa/<%=qp.get(i).getQaPhotoReName() %>" alt="" width="350" height="250">
    		</div>
    	<%}
  	} %>
    <br><br>
 	</div>
  	<div id="description">
    	<table >
        	<tr>
            	<th>작성날짜</th>
                    <td><%=q.getQaWriteDate() %></td>
           </tr>
                 <th>문의 내용</th>
                    <td><%=q.getQaContents() %></td>
       </table>
    		
    </div>
    <div id="comment-container" >
    	<%if(loginMember!=null&&loginMember.getMemberId().equals("admin")) {%> 
   		<div class="comment-editor" >
   			<form action="<%=request.getContextPath() %>/qa/commentWrite.do?qaBoardNo=<%=q.getQaBoardNo() %>" 
   			method="post" style="justify-content: center; display: flex; margin-top: 10px; align-items: flex-end; margin-left: 70px;" >
   				<textarea name="content" cols="55" rows="3" placeholder="답변"></textarea>
   				<input type="hidden" name="boardref" value="">
   				<input type="hidden" name="level" value="1"/>
   				<input type="hidden" name="commentref" value="0"/>
   				<input type="hidden" name="commentWriter" value="">
   					
   					<button	type="submit" id="btn-insert" style="margin-left: 10px;">등록</button>
   					
   			</form>
   		</div>	
   		<%} %>
   		<br>
   		<div style="border-top: solid rgba(0, 0, 0, 0.482);width:400px; margin:auto;">
   		</div>
        	   <%if(qc.isEmpty()){ %>
		<div style="border-bottom: solid rgba(0, 0, 0, 0.482); width:400px; margin:auto; text-align:center;">
            <p>조회된 답변이 없습니다.</p>
        </div>
           <%}else{ 
               for(QaComment q1: qc){      %>
        <div style="border-bottom: solid rgba(0, 0, 0, 0.482); width:400px; margin:auto;">
                     <p>관리자:&nbsp;<%=q1.getQaCommentWriteDate() %><br> </p>
                     <%if(loginMember!=null&&loginMember.getMemberId().equals("admin")) {%>
                     <button style="float:right;"
                     onclick="location.assign('<%=request.getContextPath()%>/qa/commentDelete.do')">X</button>
                     <%} %>
                    <p><%=q1.getQaCommentWriteContent() %></p>
        </div>
             <%} %>
           <%} %>
        
        </div>
   	</div>
   		
   		
   
    <script>
    	$(()=>{
    		$(".comment-editor>form>textarea").focus(e=>{
    			if(<%=loginMember==null%>){
    				alert("로그인 후 이용할 수 있습니다.");
    				$("#userId").focus();
    			}
    		});
    		$(".btn-reply").click(e=>{
    			const tr=$("<tr>");
    			const form=$(".comment-editor>form").clone();
    			form.find("textarea").attr({"rows":"1"});
    			form.find("input[name=level]").val("2");
    			form.find("input[name=commentref]").val($(e.target).val());
    			form.find("button").removeAttr("id").addClass("btn-insert2");
    			const td=$("<td>").attr("colspan","2").append(form);
    			tr.append(td);
    			tr.find("td").css("display","none");
    			tr.insertAfter($(e.target).parents("tr")).children("td").slideDown(800);
    			$(e.target).off("click");
    		});
    	})
    </script>
   	
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
	    section#board-container{width:600px; margin:0 auto; text-align:center;}
	    section#board-container h2{margin:10px 0;}
	    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
	    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
	    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
	    div#comment-container button#btn-insert{width:60px;height:50px; color:white; background:gray;}
	    div#comment-container
	    background-color:darkgray;position:relative;top:-20px;}
	     /*댓글테이블*/
	    table#writed-comment-container{width:600px; margin:0 auto; border-collapse:collapse; clear:both; } 
	    table#tbl-comment tr td{border-bottom:1px solid; border-top:1px solid; padding:5px; text-align:left; line-height:120%;}
	    table#tbl-comment tr td:first-of-type{padding: 5px 5px 5px 50px;}
	    table#tbl-comment tr td:last-of-type {text-align:right; width: 100px;}
	    table#tbl-comment button.btn-reply{display:none;}
	    table#tbl-comment button.btn-delete{display:none;}
	    table#tbl-comment tr:hover {background:lightgray;}
	    table#tbl-comment tr:hover button.btn-reply{display:inline;}
	    table#tbl-comment tr:hover button.btn-delete{display:inline;}
	    table#tbl-comment tr.level2 {color:gray; font-size: 14px;}
	    table#tbl-comment sub.comment-writer {color:navy; font-size:14px}
	    table#tbl-comment sub.comment-date {color:tomato; font-size:10px}
	    table#tbl-comment tr.level2 td:first-of-type{padding-left:100px;}
	    table#tbl-comment tr.level2 sub.comment-writer {color:#8e8eff; font-size:14px}
	    table#tbl-comment tr.level2 sub.comment-date {color:#ff9c8a; font-size:10px}
	    /*답글관련*/
	    table#tbl-comment textarea{margin: 4px 0 0 0;}
	    table#tbl-comment button.btn-insert2{width:60px; height:23px; color:white; background:#3300ff; position:relative; top:-5px; left:10px;}
	</style>
<%@include file="/views/common/footer.jsp"%>        
       