package com.obj.controller;

public class FieldTest {
	//클래스에 필드선언하기
	//클래스내에 필요한 상태값(데이터)가 있으면 선언하는것
	//선언하는 방식
	//클래스선어내부({}안)에 변수선언과 동일한 방식으로 선언
	//필드로 선언된 저장공간은 클래스 생성시 이용이 가능함, 생성하지 않으면 이용이 불가능
	//접근제한자 [예약어] 자료형 변수명;
	//public : 프로젝트 내에서 모두 직접접근이 가능함
	//protected : 상속받은 클래스나 같은 패키지내에서 직접접근이 가능
	//default : 같은패키지, 클래스내부에서 직접접근이 가능함
	//private : 클래스내부에서만 직접접근이 가능함
	// 직접접근 : 접근연산자 . 을 이용해서 변수에 접근하는것을 의미함
	public int age=19;
	String name="유병승";
	private char gender='남';
	
	//필드타입은 모든것을 다 선언할 수 있음
	//배열, 다른 클래스 등을 필드로 선언할 수 있다.
	public String[] hobby;
	public PublicTest pt;
	
	
	
	//필드에 예약어 사용하기
	//final, static
	//final : 변경되지않는 저장공간
	public final double height=180.5;//final은 무조건 선언해줘야됨
	public double weight;
	
	//static : 선언한 변수를 static영역에 저장하는 에약어
	public static int count=0;
	
	
	public void test() {
		System.out.println(this.age);
		System.out.println(this.name);
		System.out.println(this.gender);
		FieldTest.count+=20;
	}
	
}
