package kr.or.ddit.front;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewResolver {
	
	/**
	 * Method : viewRJesolve
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @param viewInfo
	 * Method 설명 : viewInfo를 바탕으로 view처리 대상으로 위임
	 * 				처리대상 : forward, redirect
	 */
	public void viewRJesolve(HttpServletRequest req, HttpServletResponse resp,String viewInfo) {  
		if(viewInfo.startsWith("forward:")) {
			String uri = viewInfo.substring("forward:".length());   //인자 값이 하나면  시작값이 들어감
			try {
				req.getRequestDispatcher(uri).forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			
		}
		else if (viewInfo.startsWith("redirect")) {
			
		}
		
		else {
			new Error("에러");
		}
		
	}
}
