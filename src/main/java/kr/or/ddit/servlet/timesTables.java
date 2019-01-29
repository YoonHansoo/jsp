package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class timesTables extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter pw = resp.getWriter();
		pw.println("<!DOCTYPE html>                   ");
		pw.println("<html>                            ");
		pw.println("<head>                            ");
		pw.println("<meta charset=\"UTF-8\">          ");
		pw.println("<title>Insert title here</title>  ");
		pw.println("</head>                           ");
		pw.println("<body>                            ");
		pw.println("<table border=\"1\">              ");
		pw.println("	<table border=\"1\" border-collapse: collapse>");
		for (int i = 2; i <= 9; i++) {
			pw.println("<tr>");
			for (int j = 1; j <= 9; j++) {
				pw.println("<td>" + i + " * " + j + " = " + i * j + "</td>");
			}
			pw.println("</tr>");
		}
		pw.println("</body>                           ");
		pw.println("</html>                           ");

		pw.flush();
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
