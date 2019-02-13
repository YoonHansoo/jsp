package kr.or.ddit.encrypt.kisa.seed;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * KISA_SEED_CBC_test.java
 *
 * @author Hansoo
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정자 수정내용
 * ------ ------------------------
 * Hansoo 최초 생성
 * 복호화가 가능한 seed 알고리즘 테스트
 *
 * </pre>
 */
public class KISA_SEED_CBC_test {
	private Logger logger = LoggerFactory.getLogger(KISA_SEED_CBC_test.class);

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Method : testEncrypt
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * Method 설명 : 암호화-복호화 테스트
	 */
	@Test
	public void testEncrypt() {
		/***Given***/
		String plainText = "brown";
		
		
		/***When***/
		String encryptText = KISA_SEED_CBC.Encrypt(plainText);
		logger.debug("encrypt Text : {}", encryptText);
		
		String decryptText = KISA_SEED_CBC.Decrypt(encryptText);
	
		logger.debug("decryptText Text : {}", decryptText);
			
		
		
		/***Then***/
		assertEquals(plainText, decryptText);
		
	}

}
