<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
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
// DB작업에 필요한 객체 변수 선언
Connection conn = null;
Statement stmt = null;
ResultSet rs = null; // 퀴리문이 select일 경우에 필요함
BasicDataSource bds = null;
try {

	bds = new BasicDataSource();
	bds.setUsername("user_alphasoo");
	bds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	bds.setPassword("1234");
	bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	bds.setInitialSize(5); //커넉션풀 사이즈
	
	
	
     // 1. 드라이버 로딩
    //Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버가 잘 들어있는가 체크하는 과정

   // 2. DB에 접속(Connection객체생성)
	 conn = bds.getConnection();   
   // 3. Statement객체 생성 => Connection 객체를 이용한다.
   	stmt = conn.createStatement();

   // 4.SQL문을 Statement객체를 이용하여 실행하고
   // 실행결과를 ResultSet객체에 저장한다.
   String sql = "select * from lprod"; // 실행할 SQL문
   rs = stmt.executeQuery(sql); // SQL문이 select일 경우에는 --> executeQuery()에서드를 사용
                           // insert,update,delete일 경우는 --> executeUpdate()메서드를 사용

   // 5. ResultSet객체에 저장되어있는 자료를 반복문과 next()메서드를 이용하여 차례로 읽어와 처리한다.
   System.out.println("실행한 쿼리문 : " + sql);
   System.out.println("=== 쿼리문 실행 결과 ===");

   // rs.next() => ResultSet객체의 데이터를 가리키는 포인터를 다음 레코드로 이동시키고
   // 그곳에 자료가 있다면 true, 없으면 false를 반환한다.
   while (rs.next()) {
      // 컬럼의 자료를 가져오는 방법
      // 방법1) rs.get자료형 이름("컬럼명")
      // 방법2) rs.get자료형이름(컬럼번호) =>컬럼번호는 1부터 시작
     out.write("lprod_id : " + rs.getInt("lprod_id") + "<br/>");
     out.write("lprod_gu : " + rs.getString("lprod_gu") + "<br/>");
     out.write("lprod_nm : " + rs.getString("lprod_nm") + "<br/>");
     out.write("--------------------------------------------------" + "<br/>");
   }

   System.out.println("출력끝...");

} catch (SQLException e) {
   e.printStackTrace();
}
// catch (ClassNotFoundException e) { e.printStackTrace(); }
finally {
   
   if (rs != null)try {rs.close();} catch (SQLException e2) {}
   if (stmt != null)try {   rs.close();} catch (SQLException e2) {   }
   if (conn != null)try {rs.close();} catch (SQLException e2) {}
   bds.close(); //사용이 끝난 bds객체를 반환
   
 //  localhost/connection/jdbc.jsp
}
%>



</body>
</html>