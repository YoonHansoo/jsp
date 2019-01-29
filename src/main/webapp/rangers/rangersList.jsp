<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<String> rangerrangersList = (List<String>)request.getAttribute("rangersList"); // getAttribute 메서드의 return 타입은 Object
	%>
		
	<table>
	<tr>
	<th>이름</th>
	</tr>
	
	<%
	for(String ranger : rangerrangersList){
		out.write("<tr><td>" + ranger +"</td></tr>" );
	}
		%>			
	
	</table>
		
	
	
</body>
</html>