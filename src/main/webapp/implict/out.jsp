<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  //스크립틀릿 : 자바 코드를 사용할 수 있는 영역
    //out : jsp 기본객체(묵시적 객체, implict 객체)
	//--> 개발자가 객체 선언 없이 사용할 수 있는 객체
	//localhost/implict/out.jsp
	
	out.print("안녕하세요");
	
	for(int i =2; i<=9; i++){
		out.write("<tr>");
		for(int j = 0; j <=9; j++){
			out.write("<td>" + i  + "*" + j + "=" + i*j);
			out.write("</td>");
		}
		out.print("</tr>");
	}
	
   
%>


</body>
</html>