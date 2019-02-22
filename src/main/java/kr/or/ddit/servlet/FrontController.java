package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.front.CommonController;
import kr.or.ddit.front.HadlerMapper;
import kr.or.ddit.front.HandlerInvoker;
import kr.or.ddit.front.ViewResolver;

// userList.do, rangersList.do ==> 
@WebServlet("*.do")
public class FrontController extends HttpServlet{
   
   private Logger logger = LoggerFactory.getLogger(FrontController.class);
   
   private HadlerMapper handleMapper;
   private HandlerInvoker handleInvoker;   //특정 컨트롤러 실행시킨다.
   private ViewResolver viewResolver;
   
   
   @Override
   public void init() throws ServletException {
      handleMapper = new HadlerMapper();
      handleInvoker = new HandlerInvoker();
      viewResolver = new ViewResolver();
   }
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      logger.debug("frontController doGet : {}", req.getRequestURI());
      
      //uri 요청을 처리해줄 컨트롤러 확인
      CommonController controller =  handleMapper.getController(req.getRequestURI());   //컨트롤러 객체를 찾아줌
      //controller.//화면에서 사용할 애들을 연결시켜주는 역할?
      
      
      //컨트롤러 실행
      String viewInfo = handleInvoker.invoke(req, resp, controller);
      
      //viewResolver를 통한 응답 생성
      viewResolver.viewRJesolve(req, resp, viewInfo);
      
      
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      doGet(req, resp);
   }
}