package kr.or.ddit.util;

public class CookieUtilTeacher {

   private String[] cookieArray; //필드에 저장해놓고
   
   public CookieUtilTeacher(String cookieString){
      
     
      
      cookieArray = cookieString.split("; ");
   }
   
   /**
   * Method : getCookieValue
   * 작성자 : PC05
   * 변경이력 :
   * @param string
   * @return
   * Method 설명 : 쿠기이름에 해당하는 쿠키 값을 조회
   */
   public String getCookieValue(String cookiename) {
      String cookieValue = ""; 
      
      for(String cookie : cookieArray){
         if(cookiename.equals(cookie.split("=")[0])){
            cookieValue = cookie.split("=")[1];
            break;
         }
      }
      return cookieValue;
   }
}



     /*String[] split = cookieString.split("; ");
      
      for(int i=0; i<split.length; i++){
         String[] split2 = split[i].split("=");
         if(cookiename.equals(split2[0])){
            cookiename =split2[1];
         }
      }
      
      return cookiename;
   }

}
*/