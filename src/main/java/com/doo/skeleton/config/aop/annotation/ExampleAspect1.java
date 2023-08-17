package com.doo.skeleton.config.aop.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExampleAspect1 {

	@Before(value = "@annotation(com.doo.skeleton.config.aop.annotation.ExampleAnnotation1)")
	public void getMessageOperationInfo(JoinPoint joinPoint) {

        // Method Information
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        System.out.println("full method description: " + signature.getMethod());
        System.out.println("method name: " + signature.getMethod().getName());
        System.out.println("declaring type: " + signature.getDeclaringType());

        // Method args
        System.out.println("Method args names:");
        Arrays.stream(signature.getParameterNames())
          .forEach(s -> System.out.println("arg name: " + s));

        System.out.println("Method args types:");
        Arrays.stream(signature.getParameterTypes())
          .forEach(s -> System.out.println("arg type: " + s));

        System.out.println("Method args values:");
        Arrays.stream(joinPoint.getArgs())
          .forEach(o -> System.out.println("arg value: " + o.toString()));

        // Additional Information
        System.out.println("returning type: " + signature.getReturnType());
        System.out.println("method modifier: " + Modifier.toString(signature.getModifiers()));
        Arrays.stream(signature.getExceptionTypes())
          .forEach(aClass -> System.out.println("exception type: " + aClass));

        // Method annotation
        Method method = signature.getMethod();
        ExampleAnnotation1 messageOperation = method.getAnnotation(ExampleAnnotation1.class);
        System.out.println("Account operation annotation: " + messageOperation);
        System.out.println("Account operation value: " + messageOperation.operation());
        
//        http://localhost:8080/config/aop/msg?a=a&b=1
//        full method description: public int com.doo.skeleton.config.aop.MessageExample.methodNm(java.lang.String,int) throws com.doo.skeleton.config.exception.BusinessException
//        method name: methodNm
//        declaring type: class com.doo.skeleton.config.aop.MessageExample
//        Method args names:
//        arg name: param1
//        arg name: param2
//        Method args types:
//        arg type: class java.lang.String
//        arg type: int
//        Method args values:
//        arg value: a
//        arg value: 1
//        returning type: int
//        method modifier: public
//        exception type: class com.doo.skeleton.config.exception.BusinessException
//        Account operation annotation: @com.doo.skeleton.config.aop.MessageOperation(operation="methodNm")
//        Account operation value: methodNm
    }
}
