package com.calculator.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import com.calculator.beans.Calculator;

@Aspect
@Component
public class CalcAspect {
	
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(value = "within(com.calculator.beans.Calculator)", returning = "returnValue")
	public void logOperation(JoinPoint jp, Object returnValue) {
		//Calculator c = (Calculator) jp.getTarget();
		System.out.println(returnValue);
		log.info("The result is equal to: " + returnValue);
	}
	
	@AfterThrowing("execution(int divide(int,int))")
	public void logDivideByZero() {
		log.info("Error: attempted to divide by zero");
	}
	
//	@Around("execution(* wake*())")
//	public void wakeBear(ProceedingJoinPoint pjp) throws Throwable {
//		Bear b = (Bear) pjp.getTarget();
//		//pjp.proceed();
//		if (b.isFull() || !b.isAwake()) {
//			System.out.println("You got lucky");
//		}
//		else {
//			System.out.println("You became lunch");
//		}
//	}
}
