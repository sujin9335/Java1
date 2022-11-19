package com.obj.controller;

public class TestMain {
	public static void main(String[] args) {
		new DefaultTest();
		FieldTest ft=new FieldTest();
		System.out.println(ft.age);
		System.out.println(ft.name);//default 접근제한자는 같은 패키지내에서 접근이 가능
		//System.out.println(ft.gender);
		ft.age=20;
		ft.name="손오공";
		System.out.println(ft.age);
		System.out.println(ft.name);
		
		
		
	}
}
