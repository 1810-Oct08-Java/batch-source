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
public class CalcAspect {
	private Logger log = Logger.getRootLogger();
	
	@After("within(com.revature.beans.*)")
	public void logAfterMethod(JoinPoint jp) {
		log.info(jp.getSignature() + "was called");
	}
	
	@AfterReturning(pointcut="execution(int com.revature.beans.Calculator.add(..))", returning="retVal")
	public void logAfterAdd(JoinPoint jp, Object retVal) {
		log.info(jp.getArgs()[0] + "+" + jp.getArgs()[1]+ "="+retVal.toString());
	}
	
	@AfterReturning(pointcut="execution(int subtract(..))", returning="retVal")
	public void logAfterSubt(JoinPoint jp, Object retVal) {
		log.info(jp.getArgs()[0] + "-" + jp.getArgs()[1] + "=" + retVal.toString());
	}
	
	@AfterReturning(pointcut="execution(int multiply(..))", returning="retVal")
	public void logAfterMult(JoinPoint jp, Object retVal) {
		log.info(jp.getArgs()[0] + "*" + jp.getArgs()[1] + "=" + retVal.toString());
	}
	
	@AfterReturning(pointcut="execution(double divide(..))", returning="retVal")
	public void logAfterDiv(JoinPoint jp, Object retVal) {
		log.info(jp.getArgs()[0] + "/" + jp.getArgs()[1] + "=" + retVal.toString());
	}
	
	@AfterThrowing("within(com.revature.beans.*)")
	public void logDIvideByZero(JoinPoint jp) {
		log.error(jp.getSignature() + "divide by zero");
	}
}
