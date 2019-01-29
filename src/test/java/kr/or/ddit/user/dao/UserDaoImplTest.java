package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.model.UserVo;

public class UserDaoImplTest {

	@Test
	public void gertAllUserTest() {
		/*** Given ***/
		IUserDao userdao = new UserDaoImpl();
		/*** When ***/
		
		List<UserVo> list = userdao.gertAllUser();
		
		for(UserVo userVo : list)
			System.out.println(userVo);
		
		
		/*** Then ***/
		assertNotNull(list);
		assertEquals(5, list.size());
		
	}
	
	
	@Test
	public void 특정사용자_조회쿼리() {
		/***Given***/
		IUserDao userdao = new UserDaoImpl();
		/***When***/
		
		UserVo user  = userdao.selectUser("cony");
		
		System.out.println(user.getUserId());

		/*** Then ***/
		assertNotNull(user);
	}

}
