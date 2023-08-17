package com.doo.skeleton.config.aop.path;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ExampleAspect2 {

	@Around("execution(* com.doo.skeleton.config.aop.*.Example2.*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		long begin = System.currentTimeMillis();
		Object reVal = pjp.proceed();
		log.debug("path time: {}", System.currentTimeMillis() - begin);
		return reVal;
	}
}
