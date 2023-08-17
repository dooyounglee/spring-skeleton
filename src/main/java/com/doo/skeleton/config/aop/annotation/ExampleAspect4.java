package com.doo.skeleton.config.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ExampleAspect4 {

	@Around("@annotation(ExampleAnnotation1)")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		long begin = System.currentTimeMillis();
		Object reVal = pjp.proceed();
		log.debug("annotation time: {}", System.currentTimeMillis() - begin);
		return reVal;
	}
}
