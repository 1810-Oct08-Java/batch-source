package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.BearWithConstructor;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BearWithConstructor b1 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b1.methodInBear();
		//BearWithSetter b2 = (BearWithSetter) ac.getBean()
	}
}
