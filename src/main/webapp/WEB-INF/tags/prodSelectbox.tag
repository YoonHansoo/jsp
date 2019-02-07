<%@tag import="java.sql.PreparedStatement"%>
<%@tag import="com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream"%>
<%@tag import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@tag import="java.sql.SQLException"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.Statement"%>
<%@tag import="java.sql.Connection"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="prod_lgu" type="java.lang.String"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	Connection conn = null;
	PreparedStatement ptmt = null;
	ResultSet rs = null;
	
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String userId = "user_alphasoo";
		String password ="1234";
		conn = DriverManager.getConnection(url, userId, password);
		
		
		
		String sql = "select * from PROD "  
				   + "where PROD_LGU = ?" ;
		
		ptmt = conn.prepareStatement(sql);
		ptmt.setString(1, prod_lgu); // el태그는 화면에 보여주기 위한 방법이고 attribute name="prod_lgu" 이 값은 자바변수로 바로 사용 할 수 있다.
		
		rs = ptmt.executeQuery();
		
		System.out.println("=====쿼라문 실행결과=======");
		
			out.print("<select>");
		while(rs.next()){
			System.out.println("1");
			out.print("<option value = '" +rs.getString("PROD_ID")+"'>" + rs.getString("PROD_NAME") + "</option>" );			
		}
			out.print("</select>");
		
	}catch (SQLException e) {
		e.printStackTrace();
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	}finally {
		if(rs!=null) {
			try{
				rs.close();
			}catch (SQLException e2) {
			}
		}
		if(ptmt !=null) {
			try {
				ptmt.close();
			}catch (SQLException e3) {
			}
		}
		if(conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e3) {
			}
		}
	}
	 %>