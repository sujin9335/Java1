package com.poly.model.vo;

public class Dog extends Animal{

	public Dog(String name, String gender) {
		super(name,gender);
	}
	
	public void bark() {
		System.out.println("멍무엄ㅇ");
	}
}
