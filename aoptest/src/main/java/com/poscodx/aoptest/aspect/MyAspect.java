package com.poscodx.aoptest.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	// ( ) 안 메소드가 실행되기 전에 얘를 실행해라
	@Before("execution(public com.poscodx.aoptest.vo.ProductVo com.poscodx.aoptest.service.ProductService.find(String))")
	public void adviceBefore() {
		System.out.println("---- Before Advice ----");
	}

	@After("execution(* com.poscodx.aoptest.service.ProductService.find(String))")
	public void adviceAfter() {
		System.out.println("---- After Advice ----");
	}

	@AfterReturning("execution(* com.poscodx.aoptest.service.ProductService.find(String))")
	public void adviceAfterReturning() {
		System.out.println("---- AfterReturning Advice ----");
	}

	@AfterThrowing(value="execution(* *..*.ProductService.find(String))", throwing="ex")
	public void adviceAfterThrowing(Throwable ex) {
		System.out.println("---- AfterThrowing Advice:" + ex + " ----");
	}
}
