package com.doo.skeleton.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FirstInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("firstInterceptor preHandler");
		log.debug("requestURI        : {}", request.getRequestURI());
		log.debug("method            : {}", request.getMethod());
		log.debug("requestedSessionId: {}", request.getRequestedSessionId());
		log.debug("contentType       : {}", request.getContentType());
		request.getParameterMap().forEach((t, u) -> log.debug("{}: {}", t, u));
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("firstInterceptor postHandler");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("firstInterceptor afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
