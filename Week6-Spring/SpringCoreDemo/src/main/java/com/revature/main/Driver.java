package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.BearAutowireByName;
import com.revature.beans.BearAutowireByType;
import com.revature.beans.BearWithAutomagic;
import com.revature.beans.BearWithConstructor;
import com.revature.beans.BearWithSetter;

public class Driver {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		BearWithConstructor b1 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		b1.methodInBear();
		
		BearWithSetter b2 = (BearWithSetter) ac.getBean("bearWithSetter");
		b2.methodInBear();
		
		BearAutowireByName b3 = (BearAutowireByName) ac.getBean("bearAutowireByName");
		b3.methodInBear();
		
		BearAutowireByType b4 = (BearAutowireByType) ac.getBean("bearAutowireByType");
		b4.methodInBear();
		
		BearWithAutomagic b5 = (BearWithAutomagic) ac.getBean("bearWithAutomagic");
		b5.methodInBear();
		

	}


}
