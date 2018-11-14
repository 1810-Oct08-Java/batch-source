package com.revature;

public class Mule implements Donkey, Horse {

	public void makeNoise() {
		System.out.println("Donkey noise?");
	}

	
	/* autogeneratable options:
	@Override
	public void makeNoise() {
		Donkey.super.makeNoise();
	}

	@Override
	public void makeNoise() {
		Horse.super.makeNoise();
	}
	*/
}
