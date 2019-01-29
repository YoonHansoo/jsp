package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sun.org.apache.regexp.internal.recompile;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.user.model.UserVo;

public class UserDaoImpl implements IUserDao {

	/**
	 * Method : gertAllUser 작성자 : Hansoo 변경이력 :
	 * 
	 * @return Method 설명 :전체 사용자 조회
	 */
	public List<UserVo> gertAllUser() {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();  //getSqlSessionFactory 객체를 얻어옴
		
		SqlSession sqlSessin = sqlSessionFactory.openSession();  //mapper에 있는 sql을 실행할 수 있는 session객체를 얻어옴
		 List<UserVo> userList = sqlSessin.selectList("user.getAllUser");  //Ibatis에서 queryForList와 동일함
		 sqlSessin.close(); //사용한 sqlSessin 객체 반납
		 return userList; 
	}
	
	public UserVo selectUser(String userId) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSessin = sqlSessionFactory.openSession();
		
		UserVo userVo = sqlSessin.selectOne("user.selectUser", userId);  //Ibatis에서 queryForObject와 비슷함
		sqlSessin.close();//사용한 sqlSessin 객체 반납 
		return userVo;
	}
}
