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
	<table border="1">
		<%-- <%for(int i=2; i<10; i++) { %>
   <tr>
      <%for(int j = 1; j<10; j++){ %>
      <td> <%= i %> * <%= j %> = <%= i*j %></td> 
      <%} %>
   </tr>
   <%} %> --%>
	<c:forEach begin="2" end="9" var="i">
		<tr>
		<c:forEach begin="1" end="9" var="j">
			<td>${i} * ${j} = ${i*j} </td>
		</c:forEach>
	</tr>
	</c:forEach>

	</table>

</body>
</html>