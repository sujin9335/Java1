package com.api.controller;

public class WrapperController {

	public static void main(String[] args) {
		//기본자료형을 객체화해서 사용할 수 있게 해주는 클래스
		//필요시에 자동으로 변환해줌
		Integer objInt=new Integer(10);
		System.out.println(objInt);
		System.out.println(objInt+100);
		objInt=100;
		int su=19;
		objInt=su;
		System.out.println(objInt);
		Object o=su;
		Object[] data= {100,'c',true,180.5};
		
		//Wrapper클래스는 필요한 메소드를 static으로 제공
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.min(100,90));
		
		//문자열을 기본형으로 변환해주는 메소드를 wrapper클래스에서 제공
		String test="19";
//		int age=test;
		int age=Integer.parseInt(test);
		System.out.println(age);
		//Integer.parseInt() 메소드를 이용할때는 문자열이 int형으로 변환이 가능한 값이여야한다
//		test="19살";
//		age=Integer.parseInt(test);
		
		String height="180.5";
		double h=Double.parseDouble(height);
		System.out.println(h);
		
		String data2="true";
		boolean flag=Boolean.parseBoolean(data2);
		System.out.println(data2);
		
		test(10);//Integer로 자동형변환해서 대입
		
		
		
		
		
		
	}
	public static void test(Object o) {
		System.out.println(o);
	}
}
