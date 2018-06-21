package com.briup.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class OneAnnotation {
	@Pointcut("execution(* com.briup.aop.HelloAnnotation.*(..))")
	public void anyMethod(){}
	@Before(value = "anyMethod()")
	public void addPointCut(JoinPoint jp) {
		System.out.println(jp.getStaticPart()+"------ÇÐµã-------"+jp.getSignature().getName());
	}

	@After(value = "anyMethod()")
	public void afterSayHello() {
		System.out.println("After : ");
	}

	@Around(value = "execution(public String com.briup.aop.HelloAnnotation.doPrint(..))")
	public void aroundSayHello(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Around Before !! ");
		joinPoint.proceed();
		System.out.println("Around After !! ");
	}

	@AfterReturning(pointcut = "anyMethod()", returning = "reval")
	public void afterReturningSayHello(String reval) {
		System.out.println("After Returning : " + reval);
	}
}
