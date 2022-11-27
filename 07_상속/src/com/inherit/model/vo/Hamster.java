package com.inherit.model.vo;

public class Hamster extends Animal{
	public Hamster() {

	}
	public Hamster(String type, String name, int age, char gender) {
		super(type, name, age, gender);
	}
	
	@Override
	public String bark() {
		return "찍찍";
	}
}
