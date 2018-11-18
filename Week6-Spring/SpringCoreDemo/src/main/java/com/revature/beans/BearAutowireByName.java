package com.revature.beans;

public class BearAutowireByName extends Bear {
	
	public void setCaveSomething(Cave cave) {
		this.cave = cave;
	}

	
	
	@Override
	public String toString() {
		return "BearAutowireByName [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}



	@Override
	public void methodInBear() {
		System.out.println("method in BearWithAutowireByName. Bear is: "+toString());
		
	}
	
	

}
