package com.inter.common;

public interface BasicInterface {

	//static final 변수만 선언이 가능
	public static final int age=19;
//	private String name; 불가능하다
	String email="teacherdev09@gmail.com";
	
	//추상메소드만 선언이 가능
//	public void test() {
//		System.out.println("일반 메소드 선언하기");
//	}
	void test();//public abstract 가 자동으로 붙음
	int calc(int su, int su2);

	
	
}
