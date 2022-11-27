package com.inherit.model.vo;

public class Dog extends Animal{
	public Dog() {
		
	}
	public Dog(String type, String name, int age, char gender) {
		super(type, name, age, gender);
	}
	
	@Override
	public String bark() {
		return "멍멍";
	}
	
//	@Override
	public void bark1() {
		
	}
	
	
}
