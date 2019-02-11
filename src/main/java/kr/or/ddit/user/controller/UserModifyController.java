package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

@WebServlet("/userModifyForm")
public class UserModifyController extends HttpServlet {
	IUserService userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		userService =new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		String userId = request.getParameter("userId");
		System.out.println(userId);
		UserVo userVo = userService.selectUser(userId);
		System.out.println(userVo.getAddr1());
		
		
		
		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setUserNm(userNm);
		userVo.setAlias(alias);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		userVo.setZipcode(zipcode);
		userVo.setPass(pass);
		
		
			userService.updateUser(userVo);
			request.getSession().setAttribute("msg", "정상적으로 수정되었습니다.");
			response.sendRedirect(request.getContextPath()+"/user?userId="+userId); //URL을 바꾸는 것이기 때문에 pageContext를 써주는것이 좋다.
		
		
		
	}

}
