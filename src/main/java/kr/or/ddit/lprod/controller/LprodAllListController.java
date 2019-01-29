package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;

@WebServlet("/lprodList")
public class LprodAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ILprodService lprodService;   

	    
		@Override
		public void init() throws ServletException {
			lprodService = new LprodServiceImpl();
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//userService 사용자 전체 정보를 조회
		List<LprodVo> lprodList;
		lprodList = lprodService.getAllLprod();
		
		
		//사용 전체 정보를 request 객체에 속성으로 설정
		request.setAttribute("lprodList",lprodList);		
		
		request.getRequestDispatcher(request.getContextPath()+"/lprod/lprodAllList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
