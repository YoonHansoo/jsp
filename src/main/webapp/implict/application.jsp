<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
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
		out.write("applicaton getServerInfo():" + application.getServerInfo() + "<br/>");
		out.write("applicaton getServletContextName():" + application.getServletContextName() + "<br/>");
		out.write("applicaton getContextPath():" + application.getContextPath() + "<br/>");
		out.write("applicaton getMajorVersion():" + application.getMajorVersion() + "<br/>");
		out.write("applicaton getMinorVersion:" + application.getMinorVersion() + "<br/>");
	%>

	<h2>초기화 파라미터</h2>
	ADMIN :
	<%=application.getInitParameter("ADMIN")%>
	<br />

	<h2>리소스 접근</h2>

	<%
		//webapp/main.jsp --> /main.jsp

		InputStream is = application.getResourceAsStream("/main.jsp");
		InputStreamReader isr = new InputStreamReader(is);

		BufferedReader br = new BufferedReader(isr);

		char[] buffer = new char[512];
		int len = 0;
		while ((len = br.read(buffer, 0, buffer.length)) != -1) {  //파일을다 읽으면 -1을 리턴한다.
			out.write(buffer);
		}
	%>

</body>
</html>