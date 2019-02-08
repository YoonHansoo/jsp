package kr.or.ddit.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/userForm")
public class UserFormController extends HttpServlet {

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
		
		//1.사용자 아이디 중복체크
		//2-1. 중복체크 통과 : 사용자 정보 db에 입력
		//2-1-1.사용자 페이징 리스트 1 페이지로 이동
		//2-2.중복체크 통과 실패 : 사용자 등록페이지로 이동
		//
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
