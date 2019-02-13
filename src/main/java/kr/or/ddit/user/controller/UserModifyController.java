package kr.or.ddit.user.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

@WebServlet("/userModifyForm")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class UserModifyController extends HttpServlet {
	IUserService userService;
private Logger logger = LoggerFactory.getLogger(UserModifyController.class);
	@Override
	public void init(ServletConfig config) throws ServletException {
		userService =new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserVo userVo = userService.selectUser(userId);
		
		
		
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
		
		Part profilePart = request.getPart("profile");
		 String filename = "";
		 String realFilename="";
		
		//사용자가 사진을 수정한 경우
		if(profilePart.getSize()>0) {
			String contentdisposition = profilePart.getHeader("Content-Disposition");
			 filename = PartUtil.getFileNameFromPart(contentdisposition);
			  realFilename = "d:\\picture\\"+UUID.randomUUID().toString(); //DB에 전체경로로 저장되어야 하기 떄문에
			  
			  userVo.setFilename(filename);
			  userVo.setRealFilename(realFilename);
			  profilePart.write(realFilename);
			  profilePart.delete();
		}
		  logger.debug("filename :{}",filename);
		  logger.debug("realFilename :{}",realFilename);
		  logger.debug("UserVogetfilename :{}",userVo.getFilename());
		  
			userService.updateUser(userVo);
			request.getSession().setAttribute("msg", "정상적으로 수정되었습니다.");
			response.sendRedirect(request.getContextPath()+"/user?userId="+userId); //URL을 바꾸는 것이기 때문에 pageContext를 써주는것이 좋다.
		
		
	}

}
