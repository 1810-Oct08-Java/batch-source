package com.revature.sync;

public class Count {
	
	int count;
	
	public synchronized void increment() {
		count++;
	}

}
