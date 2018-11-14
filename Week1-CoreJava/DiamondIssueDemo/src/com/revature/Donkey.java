package com.revature;

public interface Donkey extends Animal {

	public default void makeNoise() {
		System.out.println("EEE AWWW");
	}
	
}
