package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodServiceImpl implements ILprodService{
	
	
	
	private ILprodDao lprodDao;
	
	public LprodServiceImpl() {
		lprodDao = new LprodDaoImpl();
	}
	
	
	/**
	 * Method : getAllLprod
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 lprod 정보 조회
	 */
	@Override
	public List<LprodVo> getAllLprod() {
		return lprodDao.getAllLprod();
	}

	
}
