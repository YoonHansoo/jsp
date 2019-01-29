package kr.or.ddit.prod.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.prod.model.ProdVo;

public class ProdDaoImplTest {
	@Test
	public void getAllLprod() {
		/*** Given ***/
		IProdDao proddao = new ProdDaoImpl();
		/*** When ***/
		
		List<ProdVo> list = proddao.selectProdInfo("P101");
		
		for(ProdVo ProdVo : list)
			System.out.println(ProdVo);
		
		
		/*** Then ***/
		assertNotNull(list);
		assertEquals(6, list.size());
		
	}
	
}
