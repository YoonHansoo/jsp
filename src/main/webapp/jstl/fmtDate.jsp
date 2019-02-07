<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:set var="now" value="<%= new Date()%>"></c:set>
		<%--date를 String으로 --%>	
		 now: ${now }
	<h2>ko</h2>
	<fmt:setLocale value="ko_kr"/>
	ko date : <fmt:formatDate value="${now }"/> <br/>
	ko date pattern : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd"/> <br/>
		
	<h2>de</h2>
	<fmt:setLocale value="de_de"/>
	de date : <fmt:formatDate value="${now }"/> <br/>
	
	<!-- String을 date로 -->
	<h2>String to date</h2>
		<fmt:parseDate value="2019-02-07 11:49" pattern="yyyy-MM-dd HH:mm"/>
		
		
	<h2>TimeZone</h2>
	<fmt:timeZone value="Asia/Bangkok" >
		Shanghai : <fmt:formatDate value="${now }" pattern="yyyy-MM-dd HH:mm"/> 
	</fmt:timeZone>	
	
	
	<h2>setTimeZone</h2>
	<fmt:setTimeZone value="US/Alaska" var="alaska"/> <!-- setTimeZone을 하면  변수처럼 사용 가능함 -->
		alaska : <fmt:formatDate value="${now }" timeZone="${alaska }" pattern="yyyy-MM-dd HH:mm"/> 
	
</body>
</html>