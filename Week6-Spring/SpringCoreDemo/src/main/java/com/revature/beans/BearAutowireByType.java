package com.revature.beans;

public class BearAutowireByType extends Bear{

	public void setCaveSomething(Cave cave) {
		this.cave = cave;
	}
	
	
	
	@Override
	public String toString() {
		return "BearAutowireByType [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}



	@Override
	public void methodInBear() {
		System.out.println("method in BearAutowireByType. Bear is: "+toString());
		
	}

}
