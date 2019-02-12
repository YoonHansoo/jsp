package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import kr.or.ddit.util.PartUtil;

//
//5MB = 5 * 1MB
//1MB = 1024KB
//1KB = 1024BYTE
// 5MB = 5 * 1024 * 1024 byte
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024, maxRequestSize = 5 * 5 * 1024 * 1024) // 단위는 byte
public class FileUploadServlet extends HttpServlet {

	private static final String UPLOAD_PATH = "d:\\picture\\";
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class); // logger를 사용하는 클래스를 인자로 넣는다.
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileUpload.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String contentType = request.getContentType();
		String userId = request.getParameter("userId");
		String uploadFile = request.getParameter("uploadFile");

		// part 정보확인
		// request.getPart(name);
		// request.getParts();

		/*
		 * Collection<Part> parts = request.getParts();
		 * 
		 * for(Part part : parts){ 
		 *  logger.debug( "partName : {}" , part.getName());
		 * logger.debug("Content-Disposition {}: ", part.getHeader("Content-Disposition"));
		 *  }
		 */

		Part uploadFilePart = request.getPart("uploadFile");
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("contentDisposition : {}", contentDisposition);
		
		//application
		//localhost /upload --> 물리적경로를 확인
		ServletContext servletContext = getServletContext();  // servlet에서는 servletContext가 application을 나타냄
		String path = servletContext.getRealPath("/upload"); //파일을 놓을 폴더명을 적어줌 @어노테이션과 매핑 되는 것이 아님 url 주소창에 있는 부분 ex)localhost/upload
		logger.debug("path : {}", path );
		
		
		if(uploadFilePart.getSize()>0) { //파일의 크기가 0보다 클때만 파일을 작성
		//첨부파일 파일명
		String filename = PartUtil.getFileNameFromPart(contentDisposition);
		String uuidFilename = UUID.randomUUID().toString();
		//uploadFilePart.write(UPLOAD_PATH + uuidFilename);
		
		//server.core\tmp0\wtpwebapps\jsp\1uploadbrown.png
		
		//톰캣이 진짜 작동하는 위에서 만든 real path를 구해서 그 위치에 이미지를 넣어준다.
		uploadFilePart.write(path+ File.separator + uuidFilename); //윈도우에서  "\" 맥(리눅스)"/" 이기때문에 동적으로 구분하는 File.separator를 사용
		uploadFilePart.delete();// 파일 전송과정에서 임시디스크에 생긴 불필요한 파일을 지워주는 메서드
		}
		
		// uploadFilePart.write("d:\\picture\\brown.png");
		// 하위레벨은 상위 레벨을 포함
		// 로깅 레벨이 info : logger.info(...), logger.warn(...), logger.error(...)
		// 로깅 레벨이 error : logger.error(...)
		// trace, debug, info, warn, error
		// logger.debug("userId : " + userId);
		// logger.debug("uploadFile : " + uploadFile);
		// logger.debug("contentType : " + contentType);
		doGet(request, response);
	}
}
