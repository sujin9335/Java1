package com.poly.model.vo;

public class Cat extends Animal{
	
	public Cat(String name, String gender) {
		super(name,gender);
	}
	public void bark() {
		System.out.println("야옹 야옹");
	}
}
