<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
sm=top_hty&fbm=1&ie=utf8&query=html
<c:import url="https://search.naver.com/search.naver">
   <c:param name="query" value="html"></c:param>
</c:import>
<%-- 
<c:import url="/userPagingList">
<c:param name="page" value="5"></c:param>
  </c:import> --%>
</body>
</html>