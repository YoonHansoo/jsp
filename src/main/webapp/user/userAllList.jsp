<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/dashboard.css"
	rel="stylesheet">

<script src="../../assets/js/ie-emulation-modes-warning.js"></script>



</head>


<body>
	<!--  헤더  삽입 -->
	<%@ include file="/module/header.jsp"%>
	<!--  내부에서 처리하기 떄문에 getContextPath를 사용할 필요가 없음. -->

	<div class="container-fluid">
		<div class="row">
			<!--사이드 삽입 -->
			<%@ include file="/module/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">전체 사용자 리스트</h1>
				<!--userList 정보를 화면에 출력하는 로직 -->
				<%
				List<UserVo> userList  = (List<UserVo>)request.getAttribute("userList");
				%>
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>#</th>
								<th>사용자 아이디</th>
								<th>사용자 이름</th>
								<th>별명</th>
								<th>등록일시</th>
							</tr>
						</thead>
						<tbody>
							<%
    		 for(int i =0; i < userList.size(); i++){
    		 	out.print("<tr class ='userTr' data-userid="+ userList.get(i).getUserId()+  ">");  //data-(Key) key은소문자로만 ex)data-pw
    		 	out.print("<td></td>");
    		 	out.print("<td>"+userList.get(i).getUserId() +"</td>");
    		 	out.print("<td>"+userList.get(i).getUserNm() +"</td>");
    		 	out.print("<td></td>");
    		 	out.print("<td>"+userList.get(i).getREg_dt_fmt() +"</td>");
    		 	out.print("</tr>");
    		 }
    		 %>


						</tbody>
					</table>
				</div>


			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

	<script>
	
		//문서 로딩이 완료된 이후 이벤트 등록 
		$(document).ready(function(){
			console.log("document ready");
			
			//사용자 tr태그 클릭 시 이벤트 핸들러 
					
		/* 방법1 택1
		$(".userTr").on("click",function(){
				console.log("userTr click");
			});
			*/
			
			//방법2 택1
			$(".userTr").click(function(){
				console.log("userTr click");
				
				//클릭한 userTr태그의 userId값을 출력
				/*  var userId= $(this).children()[1].innerHTML;
				 console.log("userId:"+userId); */
				 
				 var userId = $(this).data("userid");
				 
				 //user
				 // 1.document
				 //document.location = "/user?userId=" + userId;				
				 
				 //2. form
				 $("#userId").val(userId);
				 // $("#frm").attr("action","/userAllList"); 속성값 수정하는 방법  
				 $("#frm").submit();
	
			});
			
		});
	</script>

	<form id="frm" action="<%=request.getContextPath()%>/user" method="get">
		<input type="hidden" name="userId" id="userId" />
	</form>
</body>
</html>

