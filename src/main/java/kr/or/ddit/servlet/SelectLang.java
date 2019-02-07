package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectLang")
public class SelectLang extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p_select = request.getParameter("select");
		
		p_select = p_select == null? "kor" : p_select;
		request.setAttribute("select", p_select);
		request.getRequestDispatcher(request.getContextPath() + "/jstl/selectLang.jsp").forward(request, response);
	}


}
