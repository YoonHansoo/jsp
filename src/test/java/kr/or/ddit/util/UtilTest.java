package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UtilTest {

	@Before
	public void setUp() throws Exception {
		
	}

	
	/**
	 * Method : test
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * Method 설명 :cookie 문자열 파싱 테스트
	 */
	@Test
	public void testCookieStringParsing() {
		/***Given***/
		String cookieStirng = "userId=brown; rememberme=y; test=value";
		

		CookieUtil cookieUtil = new CookieUtil(cookieStirng);
		
		/***When***/
		 String cookieValue = cookieUtil.getCookieValue("rememberme");
		 String cookieValue2 = cookieUtil.getCookieValue("userId");
		 String cookieValue3 = cookieUtil.getCookieValue("test");
		
		/***Then***/
		 assertEquals("y", cookieValue);
		 assertEquals("brown", cookieValue2);
		 assertEquals("value", cookieValue3);
	}
	
	/**
	 * Method : testGetFileNameFromPart
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * Method 설명 : part의 Content-Disposition 헤더로 부터 filename을 가져온다.
	 */
	@Test
	public void testGetFileNameFromPart() {
		/***Given***/
		
		String contentDisposition = "form-data; name=\"uploadFile\"; filename=\"cony.png\"";
		String contentDisposition1 = "form-data; name=\"uploadFile\"; filename=\"brown123.png\"";
		
	
;
		/***When***/
		String fileName = PartUtil.getFileNameFromPart(contentDisposition);
		String fileName1 = PartUtil.getFileNameFromPart(contentDisposition1);


		/***Then***/
		
		assertEquals("cony.png", fileName);
		assertEquals("brown123.png", fileName1);
	}
	

}
