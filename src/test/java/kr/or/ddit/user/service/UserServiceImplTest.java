package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;

public class UserServiceImplTest {

  //getAllUser 메소드를 테스트하는 메소드 작성
   @Test
   public void testGetAllUser(){
      IUserService userdao = new UserServiceImpl();
      
      List<UserVo> userList = userdao.getAllUser();
      for(UserVo userVo : userList){
         System.out.println(userVo);
         
      
      assertNotNull(userdao.getAllUser());
      assertEquals(5, userList.size());
      }

   }
   
   @Test
   public void testSelectUser(){
      IUserDao userdao = new UserDaoImpl();
         String userId = "brown";
        UserVo user = userdao.selectUser(userId);

         System.out.println(user.getPass());
         assertNotNull(user);
   }
}