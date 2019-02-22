package kr.or.ddit.front;

import java.util.HashMap;
import java.util.Map;

/**
 * HandlerMapper.java
 *
 * @author SEM
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정자 수정내용
 * ------ ------------------------
 * SEM 최초 생성
 *   uri 정보를 바탕으로 해당 요청을 처리해줄 컨트롤러를 생성, 반환 해주는 객체
 * </pre>
 */
public class HadlerMapper {
   //Map<url 문자열, url 요청을 처리할 컨트롤러 클래스명>
   private Map<String, String> urlControllerMap;
   
   public HadlerMapper(){
      //db, properties 에서 데이터를 조회해야되나
      //테스트 목적으로 직접 넣어준다.
      urlControllerMap = new HashMap<String, String>();
      														 
      urlControllerMap.put("/userList.do", "kr.or.ddit.front.UserListController");
      urlControllerMap.put("/rangersList.do", "kr.or.ddit.front.RangersListController");   
   }
   
   /**
    * Method : getController
    * 작성자 : SEM
    * 변경이력 :
    * @param uri
    * @return
    * Method 설명 : uri 요청을 처리해줄 pojo controller 리턴
    */
   public CommonController getController(String uri){   //원래는 Object였는데 그것을 사용하게 되면 if문으로 uri를 구분해줘야하기 때문에 따로 interpace로 빼서 사용 
      String classInfo=urlControllerMap.get(uri);
      
      //인스턴스를 생성하는 방법
      // 1.Integer i= new Interger(); //객체를 생성하기 위해서 [new]연산자를 사용
      // String msg = "msg" //예외적인 케이스
      // 2.class 정보를 이용하여 객체를 생성 : 문자열 -> 클래스를 생성
      //UserVO userVO = new UserVO();
      // that  = this;
      CommonController controller  =null;
      try {
         Class clazz =  Class.forName(classInfo);   //class을 사용할수없으니까 clazz라고 사용을 한다.
         //class.forName은 import대신 동적으로 클래스를 생성할 떄 이용하는 방법
         
   /*      //만약 클래스를 잘사용하지 않는다면 이렇게 if문을 많이 사용하게 된다.
         if(uri.equals("/userlistcontroller")){
            UserListController controller  = (UserListController)clazz.newInstance();
         }
         else if(uri.equals("/rangerListController")){
            RangersListController controller  = (RangersListController)clazz.newInstance();
         }
         */
         	
          controller  = (CommonController)clazz.newInstance();    //이 것을 받게 되면 궂이 if을 사용하지 않아도된다.
         
         
      } catch (ClassNotFoundException e) {
      } catch (InstantiationException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      return controller;
   }
}














