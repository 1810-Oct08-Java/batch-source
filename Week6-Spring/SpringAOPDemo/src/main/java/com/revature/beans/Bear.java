package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Bear {
	
	private static boolean isWinter = false;
	private boolean isFull = true;
	private boolean isAwake = true;
	
	public static boolean isWinter() {
		return isWinter;
	}
	
	public static void setIsWinter(boolean isWinter) {
		Bear.isWinter = isWinter;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public boolean isAwake() {
		return isAwake;
	}

	public void setAwake(boolean isAwake) {
		this.isAwake = isAwake;
	}

	@Override
	public String toString() {
		return "Bear [isFull=" + isFull + ", isAwake=" + isAwake + "]";
	}
	
	

}
