package kr.or.ddit.template;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/velocity")
public class VelocityServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//데이터 조회 / 입력
		
		List<String> rangers = new ArrayList<>();
		
		rangers.add("brown");
		rangers.add("sally");
		rangers.add("cony");
		
		request.setAttribute("rangers",rangers);
		
		
		request.getRequestDispatcher("/template/velocity.vm").forward(request, response);
	}


}
