package com.calculator.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.calculator.beans.Calculator;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Calculator c = (Calculator) ac.getBean("calculator");
		c.add(100,-58);
		c.subtract(50,25);
		c.multiply(3,18);
		c.divide(26, 7);
		c.divide(100000, 0);
	}

}
