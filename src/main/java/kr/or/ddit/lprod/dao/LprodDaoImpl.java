package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVo;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVo> getAllLprod() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		List<LprodVo> lprodList = openSession.selectList("lprod.getAllLprod");
		openSession.close();
		return lprodList;
	}

}
