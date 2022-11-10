package com.bs.variable;

public class StringTest {
	public static void main(String[] args) {
		
		//문자열 처리에 대해 알아보자
		//String은 자바에서 제공하는 하나의 클래스임
		//편리하게 사용하기 위해서 기본자료형처럼 사용이 가능함
		String name = "김수진";
		System.out.println(name);
		String name2 = new String("김수진");
		System.out.println(name2);
		
		//문자열을 +연산을 하면 문자열 결합이 된다
		//"문자"+"결합" -> "문자결합"
		//123+"문자" -> "123문자"
		//180.5+"문자" -> "180.5문자"
		String temp = "점심"+" 맛있게 "+"먹었나요?";
		System.out.println(temp);
		temp = "점심"+30+"분";
		System.out.println(temp);
		temp = "제 키는" + 180.5;
		System.out.println(temp);
		temp = 10+20+"안녕"+30+20; //왼족부터 default int형으로 합치고 뒤는 Sting으로 인식
		System.out.println(temp);
		temp = "번호는 "+(10+20)+"입니다"; //괄호부터 먼저
		System.out.println(temp);
		
		
		//리터럴값이 아닌 변수를 활용해서 문자열을 연결을 해보자
		String test = "김수진";
		int age = 19;
//		test = "박세현";
//		age=28;
		temp = test + age;//"김수진"+19;
		System.out.println(temp);
		
		
		//본인 이름, 나이, 키, 주소, 전화번호를 저장하는 변수를 만들고
		//변수에 각 데이터를 넣고 출력하는 기능 구현하기
		
		
		//String은 클래스로 유용한 기능(메소드)를 제공함
		//1. String에 저장된 문자열의 길이를 알려주는 기능(메소드)
		// length();
		//"문자열".length();
		//문자열변수명.length();
		System.out.println("문자열".length());
		System.out.println(test.length());
		
		//2. 문자열에 저장된 각 문자만 한개씩 출력하는 기능(메소드)
		String str = "경기도 시흥시";
		//charAt(번호);
		System.out.println(str.charAt(0));
		System.out.println(str.charAt(1));
		char ch = str.charAt(0);
		System.out.println(ch);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
