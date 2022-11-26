package com.obj.model.vo;

public class Animal {
	public String name;
	public int age;
	public String type;
	public char gender;
	
	public Animal() {
		
	}
	
	//this 생성자 이용하기
	//this() 클래스내부에 선언된 생성자를 호출
	//this()생성자는 코드의 맨 윗줄에 있어야함
	public Animal(String name) {
		this.name=name;
	}
	
	public Animal(String name, int age, String type) {
//		this.name=name;
		this(name);
		this.age=age;
		this.type=type;
		
	}
	
	public Animal(String name, int age, String type, char gender) {
//		this.name=name;
//		this.age=age;
//		this.type=type;
		this(name, age, type);
		this.gender=gender;
//		this(name, age, type); //밑에 있으면 안됨
	}
	
}
