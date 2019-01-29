package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IUserDao {
	
	/**
	 * Method : gertAllUser
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @return
	 * Method 설명 :전체 사용자 조회
	 */
	List<UserVo> gertAllUser();
	
	
	/**
	 * Method : selectUser
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @param userId
	 * @return
	 * Method 설명 :특정 사용자 조회
	 */
	public UserVo selectUser(String userId);
}
