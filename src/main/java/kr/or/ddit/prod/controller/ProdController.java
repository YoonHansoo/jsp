package kr.or.ddit.prod.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;

@WebServlet("/prod")
public class ProdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private IProdService prodService;   

	    
		@Override
		public void init() throws ServletException {
			prodService = new ProdServiceImpl();
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//prod 정보를 조회
		String lprod_gu = request.getParameter("lprodGu");
		List<ProdVo> prodList;
		prodList = prodService.selectProdInfo(lprod_gu);
		
		
		//사용 전체 정보를 request 객체에 속성으로 설정
		request.setAttribute("prodList",prodList);		
		
		request.getRequestDispatcher(request.getContextPath()+"/prod/prodList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
