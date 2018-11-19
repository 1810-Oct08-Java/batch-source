package com.revature.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning("within(com.revature.beans.*)")
	public void logAfter(JoinPoint jp) {
		log.info(jp.getSignature()+" was called");
	}
	
	@AfterThrowing("within(com.revature.beans.Bear)")
	public void logAfterException(JoinPoint jp) {
		log.error(jp.getSignature()+" threw an exception");
	}
	
	@After("execution(void bearHibernates())")
	public void logWithHibernate() {
		log.info("bear is trying to hibernate");
	}
	
	@After("execution(void set*(..))")
	public void logSetters() {
		log.info("setter called");
	}
	

}
