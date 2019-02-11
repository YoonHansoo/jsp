package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	
	IUserService userService;
	
	@Override
	public void init() throws ServletException {
		 userService = new UserServiceImpl();
	}

	/**
	 * Method : doGet
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * Method 설명 :사용자 정보 등록
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/user/userForm.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");


		//2-1. 중복체크 통과 : 사용자 정보 db에 입력
		//2-1-1.사용자 페이징 리스트 1 페이지로 이동
		//2-2.중복체크 통과 실패 : 사용자 등록페이지로 이동
		//l.

		String userId = req.getParameter("userId");
		String userNm = req.getParameter("userNm");
		String alias = req.getParameter("alias");
		String addr1 = req.getParameter("addr1");
		String addr2 = req.getParameter("addr2");
		String zipcode = req.getParameter("zipcode");
		String pass = req.getParameter("pass");
		
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setUserNm(userNm);
		userVo.setAlias(alias);
		userVo.setAddr1(addr1);
		userVo.setAddr2(addr2);
		userVo.setZipcode(zipcode);
		userVo.setPass(pass);
		
		//아이디가 중복되었을 때
		if(userService.selectUser(userId) != null) {
			System.out.println("중복된 값");
			req.setAttribute("userVo", userVo);
			req.setAttribute("msg", "중복체크에 실패하였습니다.");
			
			//forward 시에는 최초 요청한 method를 변경할 수 없음 ex) post -> post
			doGet(req, resp);
		}
		
		//아이디가 중복되지 않았을 때(정상입력)
		else {
			System.out.println("중복되지 않음");
			userService.insertUser(userVo);
			req.getSession().setAttribute("msg", "정상 등록 되었습니다.");
			resp.sendRedirect(req.getContextPath()+"/userPagingList"); //URL을 바꾸는 것이기 때문에 pageContext를 써주는것이 좋다.
		}
	}

}
