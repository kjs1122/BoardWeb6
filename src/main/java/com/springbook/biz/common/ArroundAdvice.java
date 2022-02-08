package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Aspect
@Service
public class ArroundAdvice {
	
	@Pointcut("PointcutCommon.allPointcut()")
	public void allPointcut() {};
	
	@Around("allPointcut()")
	public Object arroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String method = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		System.out.println(method + "()메소드 수행에 걸린 시간 " + stopWatch.getTotalTimeMillis() + "초");
		
		return obj;
		
		
		
		
		
		
//		
//		System.out.println("[사전처리] 비즈니스 로직 수행 전  어라운드 동작");
//		Object returnObj = pjp.proceed();
//		System.out.println("[사전처리] 비즈니스 로직 수행 후  어라운드 동작");
//		return returnObj;
	}
}
