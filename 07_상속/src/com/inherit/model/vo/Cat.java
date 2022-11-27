package com.inherit.model.vo;

public class Cat extends Animal{
	public Cat() {
		
	}
	public Cat(String type, String name, int age, char gender) {
		super(type, name, age, gender);
	}
	
	@Override
	public String bark() {
		return "야옹";
	}
	
}
