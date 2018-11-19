package com.revature.intro;

public class ThreadStateDriver {

	public static void main(String[] args) {

		Thread t1 = new TestThread();
		
		System.out.println("Thread state: " + t1.getState() + "   isAlive? "+t1.isAlive());

		t1.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Thread state: " + t1.getState() + "   isAlive? "+t1.isAlive());		

		
	}

}
