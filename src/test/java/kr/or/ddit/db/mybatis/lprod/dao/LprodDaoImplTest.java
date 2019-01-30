package kr.or.ddit.db.mybatis.lprod.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.util.model.PageVo;

public class LprodDaoImplTest {
	
	private ILprodDao proddao;
	@Before
	public void setup() {
		proddao = new LprodDaoImpl();
	}
	
	@Test
	public void lprod_페이징확인() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);

		/***When***/

		List<LprodVo> list = proddao.selectLprodPagingList(pageVo);
		/***Then***/
		assertEquals(5, list.size());
		
	}
	
	
}
