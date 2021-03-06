package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserServiceImplTest {
	
	private IUserService userService;
	
	@Before
	public void setUp() {
		userService = new UserServiceImpl();
		userService.deleteUser("test2");
	}
  //getAllUser 메소드를 테스트하는 메소드 작성
   @Test
   public void testGetAllUser(){
      
      List<UserVo> userList = userService.getAllUser();
      for(UserVo userVo : userList){
         System.out.println(userVo);
         
      
      assertNotNull(userService.getAllUser());
      //assertEquals(105, userList.size());
      }

   }
   
   @Test
   public void testSelectUser(){
         String userId = "brown";
        UserVo user = userService.selectUser(userId);

         System.out.println(user.getPass());
         assertNotNull(user);
   }
   
   @Test
   public void testselectUserPagingList() {
	   PageVo pageVo = new PageVo(1,10);
	   Map<String,Object> resultMap = userService.selectUserPagingList(pageVo); 
	   List<UserVo> userList  = (List<UserVo>) resultMap.get("userList");
	   
	   
	   int userCnt = (int) resultMap.get("userCnt");
	   System.out.println("userCnt:" + userCnt) ;

	   
	   assertNotNull(userList);
	   assertEquals(10, userList.size());
	   
	   assertNotNull(userCnt);
	   assertEquals(105, userCnt);
	   
   }
   @Test
   public void testInsertUser() {
	   /***Given***/
		UserVo vo = new UserVo();
		vo.setUserId("test2");
		vo.setUserNm("테스트2");
		vo.setAlias("별명2");
		vo.setAddr1("대전 중구 대흥로 76");
		vo.setAddr2("3층 ddit");
		vo.setZipcode("34941");
		vo.setPass("testpass2");
	   
	   /***When***/
		 int userCnt= userService.insertUser(vo);
		
	   /***Then***/
	   assertEquals(1,userCnt);
   }
   
   
   @Test
	public void 유저업데이트() {
		
		/***Given***/
		UserVo vo = new UserVo();
		vo.setUserId("james");
		vo.setUserNm("테스트112");
		vo.setAlias("별명수정완료");
		vo.setAddr1("대전 중구 대흥로 76");
		vo.setAddr2("2층 ddit");
		vo.setZipcode("34942");
		vo.setPass("testpass");

		/***When***/
		 int userCnt= userService.updateUser(vo);
		
		/***Then***/
			assertEquals(1, userCnt);
	}
   
   @Test
   public void EncryptPass_Test() {
	   /***Given***/
	

	/***When***/
	   userService.EncryptPass();

	/***Then***/
   }
   
}