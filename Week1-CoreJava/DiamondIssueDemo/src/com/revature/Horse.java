package com.revature;

public interface Horse {
	
	public default void makeNoise() {
		System.out.println("NEIGH");
	}
	

}
