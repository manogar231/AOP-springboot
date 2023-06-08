package com.eminds.apoproject.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class Aspectdemo {
 
	@Pointcut("@annotation(PrintOne) && args(..)")
	public void pointcut() {}
	
	@Before(value = "pointcut()")
	public void before_aspectExecution(JoinPoint joinPoint){
        String name=joinPoint.getSignature().getName();
        String args=joinPoint.getArgs().toString(); 
        log.info("Before Method exceuted successfully ::"+name+" "+"::"+args);
	} 
	@After(value = "pointcut()")
	public void after_aspectExecution(JoinPoint joinPoint) {
	String afterjoinpointname=joinPoint.getSignature().getName();
		log.info("After Method Exceuted ::" + afterjoinpointname);
	}
	@AfterReturning(value = "@annotation(PrintOne)&& args(..)" , returning = "object")
	public void afterreturning_aspect(Object object) {
		log.info("This is from After Returing  " +" :: " + object);
	}
	@AfterThrowing(value = "@annotation(PrintOne)&& args(..)" , throwing = "exception")
	public void afterthrowing(Throwable exception) {
		log.info("This is from After throwing"+ " :: " + exception);
	}
}
