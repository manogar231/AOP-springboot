package com.eminds.apoproject.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Aspect
@Configuration
@Component
@Slf4j
public class Aspectdemo {
  
	
	@Autowired
	HttpServletRequest servletRequest;
	
	@Before(value = "@annotation(PrintOne) && args(..)")
	public void before_aspectExceution(JoinPoint joinPoint) {
		 if (servletRequest == null) {
	            throw new RuntimeException("request should be HttpServletRequestType");
	        }
        String name=joinPoint.getSignature().getName();
        log.info("Before Method exceuted successfully ::"+name);
	} 
	
	@After(value = "@annotation(PrintOne) && args(..)")
	public void after_aspectExceution(JoinPoint joinPoint) {
	String afterjoinpointname=joinPoint.getSignature().getName();
		log.info("After Method Exceuted ::" + afterjoinpointname);
	}
}
