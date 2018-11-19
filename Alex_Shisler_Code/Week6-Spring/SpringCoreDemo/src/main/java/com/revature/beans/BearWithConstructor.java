package com.revature.beans;

public class BearWithConstructor extends Bear {

	
	
	public BearWithConstructor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BearWithConstructor(int id, String name, Cave cave) {
		super(id, name, cave);
		// TODO Auto-generated constructor stub
	}

	public BearWithConstructor(Cave cave) {
		super();
		this.cave = cave;
	}

	@Override
	public String toString() {
		return "BearWithConstructor [id=" + id + ", name=" + name + ", cave=" + cave + "]";
	}

	@Override
	public void methodInBear() {
		System.out.println("method in BearWithConstructor. the bear is: "+toString());
		
	}
	
	
	
}
