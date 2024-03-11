package com.hoshi.web.util;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPConfig {
	
	@Pointcut("execution(* com.hoshi.web.controller.*.*(..))")
	public void cut() {
		
	}
	
	@Before("cut()")
	public void before(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("시작할 때 : " + methodSignature.getName());  //실행 메소드명
		System.out.println("시작할 때 : " + methodSignature.getMethod()); //
		
		Object[] args = joinPoint.getArgs();
		System.out.println(Arrays.toString(args));
		
		System.out.println("==============새시작==============");
		for (Object object : args) {
			System.out.println("파라미터 타입 : "+object.getClass().getSimpleName());
			System.out.println("파라미터 타입 : "+object);
			System.out.println();
		}
		System.out.println("===================================");
	}
	
	@After("cut()")
	public void after(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println(methodSignature.getName()+"메서드가 종료되었습니다.");
	}
	
}
