package kr.or.ksmart.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.or.ksmart.interceptor.CustomerInterceptor;
import kr.or.ksmart.interceptor.CommonInterceptor;
import kr.or.ksmart.interceptor.LoginInterceptor;
import kr.or.ksmart.interceptor.StaffInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
		
	@Autowired
	private CommonInterceptor commonInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Autowired
	private CustomerInterceptor customerInterceptor;
	
	@Autowired
	private StaffInterceptor staffInterceptor;
	
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
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/index")
				.excludePathPatterns("/files/**")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/plugins/**")
		       	.excludePathPatterns("/dist/**")
		      	.excludePathPatterns("/assets/**")
		     	.excludePathPatterns("/coverImages/**")
		     	.excludePathPatterns("/images/**")
				;
		
		registry.addInterceptor(staffInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/files/**")
				.excludePathPatterns("/index")
				.excludePathPatterns("/staff/**")
				.excludePathPatterns("/*")
				.excludePathPatterns("/css/**")
				.excludePathPatterns("/plugins/**")
				.excludePathPatterns("/dist/**")
				.excludePathPatterns("/assets/**")
				.excludePathPatterns("/coverImages/**") 
				.excludePathPatterns("/images/**") 
				;
		 
		
		  registry.addInterceptor(customerInterceptor) 
				  .addPathPatterns("/**")
				  .excludePathPatterns("/")
				  .excludePathPatterns("/files/**")
				  .excludePathPatterns("/index")
				  .excludePathPatterns("/*") 
				  .excludePathPatterns("/css/**")
				  .excludePathPatterns("/plugins/**") 
				  .excludePathPatterns("/dist/**")
				  .excludePathPatterns("/assets/**") 
				  .excludePathPatterns("/coverImages/**")
				  .excludePathPatterns("/images/**") ;
		 
	}
}
