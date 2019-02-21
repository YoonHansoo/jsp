package kr.or.ddit.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logout기능 
		//session객체를 무효화
		//1.정해진 시간이 지날경우
		//2.session.invalidate();
		
		HttpSession session = request.getSession();
		
		//session.setMaxInactiveInterval(interval); 활성화 시간 설정  : 세션의 유효시간 설정
		//2.web.xml
		//<session-congig>
		//	<session-timeout>분단위</session-timeout>
		//</session-config>
		
		session.invalidate();
		
		//로그인 페이지로 이동
		request.getRequestDispatcher("/login").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
