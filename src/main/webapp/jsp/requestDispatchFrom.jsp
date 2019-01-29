<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% 
    	//dispatch 방식은 서버 내부에서 위임이 이루어진다.
    	//1. Client가 localhost/jsp/requestDispatchFrom.jsp 요청
    	//2. /jsp/requestDispatch.jsp로 위임
    	
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/jsp/requestDispatchTo.jsp");
    	rd.forward(request, response); // 최초로 받은 인자들을 그대로 보내준다.
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>