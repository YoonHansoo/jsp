package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CotextPathListener implements ServletContextListener {
	private Logger logger = LoggerFactory.getLogger(CotextPathListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		logger.debug("ServletContextEvent contextInitialized");
		
		
		//contextPath 값을 짧은 이름으로 application scope에 저장
		ServletContext application = sce.getServletContext();
		String contextPath = application.getContextPath();
		
		//$앞으로는 {cp}를
		//${cp}로 줄여 쓸 수 있음
		application.setAttribute("cp", contextPath);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
