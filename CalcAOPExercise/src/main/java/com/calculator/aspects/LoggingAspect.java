package com.calculator.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@Before("within(com.calculator.beans.Calculator)")
	public void logAfter(JoinPoint jp) {
		log.info("The method " + jp.getSignature() + " was called.");
	}

}
