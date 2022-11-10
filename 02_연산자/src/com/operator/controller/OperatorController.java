package com.operator.controller;

public class OperatorController {
	//기능제공 클래스
	public void singleOp() {
		//단항연상자에 대해 알아보자
		//1. 부정연산자 : boolean형 데이터를 반전시키는 연산자
		//표현 : !변수명 또는 !기능(메소드)호출구문
		// ex) !flag, !str.equals("test");
		System.out.println("========= 부정연산자 활용하기 =========");
		boolean flag = true;
		System.out.println(flag);
		System.out.println(!flag);
		
		System.out.println("김수진".equals("김수진"));
		System.out.println(!"김수진".equals("수진"));
		
		int age = 19;
		System.out.println(age<20);
		
		
	}
}
