package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.catalina.User;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

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
	
	List<UserVo> selectUserPagingList(PageVo pageVo);

	/**
	 * Method : getUserCnt
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 수 조회
	 */
	int getUserCnt();
}
