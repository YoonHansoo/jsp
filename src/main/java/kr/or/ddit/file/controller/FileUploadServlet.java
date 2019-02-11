package kr.or.ddit.file.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	
    private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);   // logger를 사용하는 클래스를 인자로 넣는다.   
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileUpload.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String uploadFile = request.getParameter("uploadFile");
		
		
		//하위레벨은 상위 레벨을 포함
		//로깅 레벨이 info : logger.info(...), logger.warn(...), logger.error(...)
		//로깅 레벨이 error : logger.error(...)
		// trace, debug, info, warn, error 
		logger.debug("userId : " + userId);
		logger.debug("uploadFile : " + uploadFile);
		
		
		doGet(request, response);
	}
}
