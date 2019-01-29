package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IUserService {

	/**
	 * Method : getAllUser
	 * 작성자 : Hansoo
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 사용자 정보 조회
	 */
	List<UserVo> getAllUser();
	
	public UserVo selectUser(String userId);
}
