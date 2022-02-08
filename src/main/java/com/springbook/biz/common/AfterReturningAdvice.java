package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;


@Service
@Aspect
public class AfterReturningAdvice { // 메소드가 끝난 후
	
	
	
	@AfterReturning(value = "PointcutCommon.getPointcut()", returning = "returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {

		String method = jp.getSignature().getName();
		if (returnObj instanceof UserVO) {
			UserVO user = (UserVO) returnObj;
			if (user.getRole().equals("admin")) {
				System.out.println(user.getName() + " 로그인(admin)");
			}
		}

		

		System.out.println("[사전 처리]" + method + "() 메소드 ARGS 정보 : " + returnObj.toString());
		

	}
}
