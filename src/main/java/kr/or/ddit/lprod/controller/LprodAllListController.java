package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.util.model.PageVo;

@WebServlet("/lprodList")
public class LprodAllListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ILprodService lprodService;   

	    
		@Override
		public void init() throws ServletException {
			lprodService = new LprodServiceImpl();
		}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_page = request.getParameter("page");
		String str_pageSize = request.getParameter("pageSize");
		
		int page = str_page==null?1:Integer.parseInt(str_page);
		int pageSize = str_pageSize==null?5:Integer.parseInt(str_pageSize);
		
		PageVo pageVo = new PageVo(page,pageSize);
		Map<String, Object> map = lprodService.selectLprodPagingList(pageVo);
		
		List<LprodVo> lprodList = (List<LprodVo>) map.get("lprodList");
		int lprodCnt= (int) map.get("lprodCnt");

		//마지막 페이지 값을 구함
		int lastPage = (lprodCnt+(pageSize-1))/pageSize; 
		
		
		request.setAttribute("lprodList",lprodList);		
		request.setAttribute("lastPage",lastPage);		
		request.setAttribute("page",page);		
		
		request.getRequestDispatcher(request.getContextPath()+"/lprod/lprodList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
