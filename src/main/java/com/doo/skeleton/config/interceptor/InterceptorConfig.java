package com.doo.skeleton.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

	private final FirstInterceptor firstInterceptor;
	private final SecondInterceptor secondInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(firstInterceptor);
		registry.addInterceptor(secondInterceptor);
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
