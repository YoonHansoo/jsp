package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MulCalculation
 */
@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first = request.getParameter("first");
		String second = request.getParameter("second");
	
		int int_first = Integer.parseInt(first);
		int int_second = Integer.parseInt(second);
		
		int sum = int_first * int_second;
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", sum);
		 request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
		
	}

	

}
