package com.choa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//공통로직이므로 어노테이션으로 공통사항클래스임을 알려준다.
@Component
@Aspect
public class CardCheck {
	
	
	@Before(" execution(* com.choa.aspect..Trip.*(..))")
	
	public void reservation(){
		System.out.println("예약 완료");
		System.out.println("==========================");
	}
	
	@Around("execution(* com.choa.aspect..Transport.*(..))")
	public Object check(ProceedingJoinPoint join){
		System.out.println("삑 in");
		
		Object obj = null;
		
		try {
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("삑 out");
		return obj;
	}
	
	
	
}
