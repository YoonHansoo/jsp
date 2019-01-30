package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.org.apache.regexp.internal.recompile;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

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


	@Override
	public int getLprodCnt() {
		return lprodDao.getLprodCnt();
	}


	@Override
	public Map<String, Object> selectLprodPagingList(PageVo pageVo) {
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("lprodList", lprodDao.selectLprodPagingList(pageVo));
		map.put("lprodCnt", lprodDao.getLprodCnt());
		
	return map;
	}

	
}
