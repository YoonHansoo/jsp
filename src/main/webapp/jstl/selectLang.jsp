<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-1.12.4.js"></script>

<script>

	$("#my_body").ready(function(){
		
		$("#select").change(function(){
			 $("#frm").submit();
			});
		"${param.select}"=="" ?  $("#select").val("ko") : $("#select").val("${param.select}");
		
	});
		        
	
	

</script>
</head>
<body id="my_body">
<%-- 
	select 변경 (ko->ja) --> 서버요청???   
	1.select로 변경한 로케일이 설정된 selectLang.jsp가 화면에 출력되도록
	2.select box option태그가 요청한 로케일로 선택이 되도록 설정
	3.만약 로케일 파라미터가 없을경우 기본값은 ko
 --%>
asd
	<form id="frm" action="/jstl/selectLang.jsp" method="get">		
	<select id="select" name ="select">
		<option value="ko">한국어</option>
		<option value="ja">日本の</option>
		<option value="en">english</option>
	</select> <br/>
	</form>
	
	
	<fmt:setLocale value="${param.select}"/>
	<fmt:bundle basename="kr.or.ddit.msg.msg">
		<fmt:message key="hello"/><br/>
		<fmt:message key="visitor"><br/>
			<fmt:param value="brown"></fmt:param>
		</fmt:message>
		
	</fmt:bundle>	
	
</body>
</html>