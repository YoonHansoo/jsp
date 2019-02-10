package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
//@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	public LoginCheckFilter() {
		
	}
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("LoginCheckFilter doFilter");
		//전처리
		//1.session에 UserVo(LoginServlet에서 정상 로그인 처리 되었을 시 저장한 속성)가 있는 지 확인(정상적으로 로그인 한 상태인지 확인)
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse hsresp = (HttpServletResponse) response;
		HttpSession session = hsr.getSession();
		UserVo userVo = (UserVo) session.getAttribute("userVo");
		
		//2-1.정상 로그인 상태이면 --> chain.doFilter 호출
		if(userVo != null) {
			chain.doFilter(request, response);
		}
		
		//2-2.로그인 상태가 아니라면 --> 로그인 화면으로 이동(/login get)
		
		//*** 모든 페이지에 대해 적용해야 하나??
		//세션이 필요한 페이지와 필요하지 않은 페이지 구분 필요
		// ** login 페이지 화면 요청(/login get) session 검증이 필요 없음
		// ** login 요청 처리(/login post) session 검증이 필요 없음
		// ** /js/*, /css/* 하위 모든 파일
		//ex)localhost/login
		else {
			String uri = hsr.getRequestURI(); //login
			
			if(uri.equals("/login") || uri.endsWith(".js")   // js,css 폴더 하위 폴더는 검증하지 않음
					|| uri.endsWith(".css")
					|| uri.endsWith(".jpg")
					|| uri.endsWith(".jpeg")
					|| uri.endsWith(".gif")
					|| uri.endsWith(".png"))
				chain.doFilter(request, response); //얘는 그냥 보내줌
			else {
				hsresp.sendRedirect(hsr.getContextPath()+"/login"); //userVo가 null임으로 login페이지로 보내라.
			}
		}
		
		//후처리
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
