package kr.or.ddit.util.log;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
	
	/*
	 * slf4j => simple logging facade 4 java
	 *	->log라이브러리의 인터페이스로 어떤 라이브러리를 쓰던 표준화된 방법을 제공함 
	 * 
	 */
	
	
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
		logger.error("error {},{},{}" + "test","test2",new HashMap<>());  //이렇게 하면 해당하지 않는 로그를 찍을 때 연산되지 않아서 과부하를 줄여줌  {}를 쓰고 ,에 다른 객체 등을 기입  
		
		
	}
	
	public static void main(String[] args) {
		
		LogbackTest logbackTest = new LogbackTest();
		
		
		
	}
	
	
}
