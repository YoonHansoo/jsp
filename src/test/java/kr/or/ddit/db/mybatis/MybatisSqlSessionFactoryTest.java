package kr.or.ddit.db.mybatis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class MybatisSqlSessionFactoryTest {

	
	/**
	 * Method : testSqlSessionFactory
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * Method 설명 : MybatisSqlSessionFactory객체로부터 
	 * 			   sqlSessionFactory 객체가 정상적으로 생성되는 지 테스트
	 */
	@Test
	public void testSqlSessionFactory() {
		/***Given***/
		
		/***When***/
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();

		/***Then***/
		assertNotNull(sqlSessionFactory);  //Null이 아닐 때 참
	}
}
