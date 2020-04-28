package kr.or.ksmart.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.or.ksmart.interceptor.CommonInterceptor;
import kr.or.ksmart.interceptor.CLoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
		
	@Autowired
	private CommonInterceptor commonInterceptor;
	
	@Autowired
	private CLoginInterceptor cLginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor)
		        .addPathPatterns("/**")
		        .excludePathPatterns("/css/**")
		        .excludePathPatterns("/plugins/**")
		        .excludePathPatterns("/dist/**")
		        .excludePathPatterns("/assets/**")
		        .excludePathPatterns("/coverImages/**")
		        .excludePathPatterns("/images/**")
				;
		registry.addInterceptor(cLginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/index")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/plugins/**")
		       	.excludePathPatterns("/dist/**")
		      	.excludePathPatterns("/assets/**")
		     	.excludePathPatterns("/coverImages/**")
		     	.excludePathPatterns("/images/**")
				;
	}
}
