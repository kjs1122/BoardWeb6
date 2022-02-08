package com.springbook.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect // aspect == pointcut + advice
public class LogAdvice {
	
//	@Pointcut("execution(* com.springbook.biz..*Impl.*(..))")
//	public void allPointcut() {}//메소드 역할 아님 id역할
//	
//
//	@Before("allPointcut")
//	public void printLog() {
//		System.out.println("[공통로그] 비즈니스 로직 수행 전 동작");
//		
//	}
}
