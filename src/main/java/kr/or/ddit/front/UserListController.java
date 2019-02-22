package kr.or.ddit.front;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

/**
* UserListController.java
*
* @author PC02
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC02 최초 생성
* 사용자 전체 리스트 조회 컨트롤러
* </pre>
*/
public class UserListController implements CommonController{

   @Override   //기존의 두겟에서는 void이지만 String로 반환을 해준다.(스프링을 흉내내는것?)
   public String process(HttpServletRequest req, HttpServletResponse resp) {
      //사용자 리스트를 조회
      IUserService userService =new UserServiceImpl();
      List<UserVo> userList = userService.getAllUser();
      
      //사용자 리스트 정보 속성설정
      req.setAttribute("userList", userList);
      
      //사용자 리스트 정보를 출력할 화면 정보 리턴
      //forward, redirect --> (스프링에서는 )json응답, jsp응답, tiles응답
      return "forward:/front/userList.jsp";
   }

}