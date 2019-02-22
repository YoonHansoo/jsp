package kr.or.ddit.front;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* HandlerInvoker.java
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
* controller 실행, 실행결과로 리턴된 view정보를 리턴
* </pre>
*/
public class HandlerInvoker {
   public String invoke(HttpServletRequest req, HttpServletResponse resp,CommonController controller){   //스프링 환경을 위해 설명하기 위한것 
	   	String viewinfo = controller.process(req, resp);
      return viewinfo;
   }
}