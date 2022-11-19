package com.obj.model.vo;

public class Inpo1 {
	
	public String name;
	public int age;
	public char gender;
	public String phone;
	//생성자 선언하기
	public Inpo1() {
		System.out.println("기본생성자호출");
	}//기본생성자 선언
	
	//매개변수있는 생성자 선언하기
	//호출하는곳에서 보내주는 데이터를 필드에 저장하는 기능
	public Inpo1(String name1, int age1, char gender1, String phone1) {
		System.out.println("매개변수있는 생성자");
		System.out.println(name1+age1+gender1+phone1);
		name=name1;
		age=age1;
		gender=gender1;
		phone=phone1;
			
	}
	public Inpo1(String name1, int age1) {
		name=name1;
		age=age1;
	}
	
}
