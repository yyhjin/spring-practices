package com.poscodx.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	// ( ) 안 메서드가 실행되기 전에 얘를 실행해라
	// 첫번째는 리턴타입, 두번째는 메서드
	@Before("execution(public com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("---- Before Advice ----");
	}

	// 모든 리턴타입 허용
	@After("execution(* com.poscodx.aoptest.service.ProductService.find(String))")
	public void adviceAfter() {
		System.out.println("---- After Advice ----");
	}

	@AfterReturning("execution(* com.poscodx.aoptest.service.ProductService.find(String))")
	public void adviceAfterReturning() {
		System.out.println("---- AfterReturning Advice ----");
	}

	// ????
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex")
	public void adviceAfterThrowing(Throwable ex) {
		System.out.println("---- AfterThrowing Advice:" + ex + " ----");
	}

	// 모든 패키지의 ProductService
	@Around("execution(* *..*.ProductService.find(..))")
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable{
		/* before */
		System.out.println("---- Around(before) Advice ----");
		
		/* Point Cut Method 실행 */
		
//		Object[] params = {"Camera"};
//		Object result = pjp.proceed(params);  // 첫번째 인자?를 Camera로 바꿈
		
		Object result = pjp.proceed();
		
		/* after */
		System.out.println("---- Around(after) Advice ----");
		
		return result;
	}
}
