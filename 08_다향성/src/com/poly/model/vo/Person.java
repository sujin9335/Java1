package com.poly.model.vo;

public class Person {
	private String name;
	private int age;
	private double hight;
	
	public Person() {}

	public Person(String name, int age, double hight) {
		super();
		this.name = name;
		this.age = age;
		this.hight = hight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHight() {
		return hight;
	}

	public void setHight(double hight) {
		this.hight = hight;
	}
	
	@Override
	public String toString() {
		return name+" "+age+" "+hight;
	}
}
