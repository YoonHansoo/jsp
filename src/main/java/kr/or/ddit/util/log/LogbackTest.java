package kr.or.ddit.util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
	
	
	private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	//1. logger 선언
	//private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	//private Logger logger = LoggerFactory.getLogger("kr.or.ddit.util.log.LogbackTest");
				//-> <logger name="kr.or.ddit" level="DEBUG"/>
			
	public LogbackTest() {
		
		//설정에 등록한 level보다 같거나 심각한 레벨만 로그에 찍힌다.(설정파일을 통해 로그를 지우지 않고 관리할 수 있다.)
		logger.trace("test");   
		logger.trace("trace" + "test");
		logger.debug("debug" + "test");
		logger.info("info" + "test");
		logger.warn("warn" + "test");
		
		logger.error("error" + "test");
		logger.error("error {},{},{}" + "test","test2","test3");
		
		
	}
	
	public static void main(String[] args) {
		
		LogbackTest logbackTest = new LogbackTest();
		
		
		
	}
	
	
}
