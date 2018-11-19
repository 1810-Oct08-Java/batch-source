package com.revature.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.beans.Bear;

@Aspect
@Component
public class BearAspect {

	@Before("execution(void bearHibernates())")
	public void stockedUpForWinter(JoinPoint jp) {
		Bear b = (Bear) jp.getTarget();
		if(b.isFull()) {
			System.out.println("Bear was stocked up and ready for winter");
		} else {
			System.out.println("Bear is going to be hungry when he wakes up");
		}
	}
	
	// * indicates a wildcard for our class or method signature (..) is a wildcard for our parameters
	@Around("execution(* wake*())")
	public void wakeBear(ProceedingJoinPoint pjp) throws Throwable {
		Bear b = (Bear) pjp.getTarget();
		//pjp.proceed();
		if(b.isFull() || !b.isAwake()) {
			System.out.println("You got lucky");
		} else {
			System.out.println("You became lunch");
		}
	}
	
	
	
}
