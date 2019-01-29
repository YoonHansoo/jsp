package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.model.ProdVo;

public class ProdServiceImpl implements IProdService  {

	private IProdDao prodDao;
	
	public ProdServiceImpl() {
		prodDao = new ProdDaoImpl();
	}
	
	/**
	 * Method : selectProdInfo
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @param lprod_gu
	 * @return
	 * Method 설명 :prod의 정보를 조회하는 메서드
	 */
	@Override
	public List<ProdVo>  selectProdInfo(String lprod_gu) {
		return prodDao.selectProdInfo(lprod_gu);
	}

}
