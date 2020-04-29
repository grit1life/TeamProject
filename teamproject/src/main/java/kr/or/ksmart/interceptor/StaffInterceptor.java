package kr.or.ksmart.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class StaffInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		
		String sLevel = (String)session.getAttribute("SLEVEL");
		if(sLevel == null) {
			sLevel = "0";
		}
		int SLEVEL = Integer.parseInt(sLevel);
		
		if(SLEVEL == 2) {
			System.out.println(SLEVEL);
			response.sendRedirect("/index");
		}
		return super.preHandle(request, response, handler);
	}
	
}
