package com.inherit.model.vo;

public class Person {
	
	private String name;
	private int age;
	private char gender;
	private String address;
	private String email;
	
	public Person() {
		
	}

	public Person(String name, int age, char gender, String address, String email) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.email = email;
		
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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void test() {
		System.out.println("보모클래스의 test메소드");
	}
	
	public final String personPrint() {
		return "사람 : " + name+age+gender+address+email;
	}
	
}
