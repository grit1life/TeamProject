package kr.or.ksmart.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.or.ksmart.interceptor.CommonInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
		
	@Autowired
	private CommonInterceptor commonInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor)
		        .addPathPatterns("/**")
		        .excludePathPatterns("/static/**/")
		        .excludePathPatterns("/css/**")
		        .excludePathPatterns("/plugins/**")
		        .excludePathPatterns("/dist/**")
				;
		
	}
}
