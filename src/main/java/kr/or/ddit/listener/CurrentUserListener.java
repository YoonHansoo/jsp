package kr.or.ddit.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

public class CurrentUserListener implements HttpSessionAttributeListener {
	private Logger logger = LoggerFactory.getLogger(CurrentUserListener.class);
	
	private List<UserVo> currentLoginUserList;
	
	public CurrentUserListener(){
		currentLoginUserList = new ArrayList<>();
	};
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		//신규 사용자 로그인 체크 여부
		
		if("userVo".equals(event.getName())) {
			UserVo userVo = (UserVo) event.getValue();
			currentLoginUserList.add(userVo);
			
			event.getSession().getServletContext().setAttribute("currentLoginUserList", currentLoginUserList);
			
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		if("userVo".equals(event.getName())) {
			UserVo userVo = (UserVo) event.getValue();
			currentLoginUserList.remove(userVo);
			
			event.getSession().getServletContext().setAttribute("currentLoginUserList", currentLoginUserList);
			
		}
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		attributeAdded(event);
	}

}
