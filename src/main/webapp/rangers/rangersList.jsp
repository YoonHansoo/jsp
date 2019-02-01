<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>스크립틀릿 / 표현식</h2>
	<%
		List<String> rangerrangersList = (List<String>) request.getAttribute("rangersList"); // getAttribute 메서드의 return 타입은 Object
	%>

	<table>
		<tr>
			<th>이름</th>
		</tr>

		<%
			for (String ranger : rangerrangersList) {
				out.write("<tr><td>" + ranger + "</td></tr>");
			}
		%>

	</table>
	<%
		//for(String str : request.getAttribute("rangersList"))
	%>
	<h2>jstl / el</h2>
	<table>
		<tr>
			<td>이름</td>
		</tr>
		<c:forEach items="${rangersList}" var="ranger">

			<tr>
				<td>${ranger}</td>  
			</tr>
		</c:forEach>
	</table>

	<h2>jstl/ el - vo</h2>
	<table>
		<tr>
			<td>이름</td>
			<td>별명</td>
			<td>나이</td>
		</tr>
		<c:forEach items="${rangersVoList}" var="ranger">
		<tr>
		<td>${ranger.name} / ${ranger.getName()}  / ${ranger.test}</td>   
		<%--name 속성은 getter 뒷부분을 잘라서 가져온다. 만약 rangerVO에 getName이 getName1으로 바뀌면 ${ranger.name1}이라고 해야한다.--%> 
		<td>${ranger.alias}</td>
		<td>${ranger.age}</td>
		</tr>
		</c:forEach>
		<c:if test="${ranger.nam eq '홍길동' }">
		
		
		</c:if>
	</table>
	
	<h2>동일한 속성명</h2>
	userName(표현식) : <%=request.getAttribute("userName") %> <br/>
	userName(el -default) :${userName} <br> 
	userName(el -request) :${requestScope.userName} <br> 
	userName(el -session) :${sessionScope.userName} <br> 
	userName(el -application) :${applicationScope.userName} <br> 
	userName : ${userName} <br/>
	
	<h2> el 기본객체 param</h2>
	표현식 : <%=request.getParameter("p") %> <br/>
	el : ${param.p} <br/>

</body>
</html>