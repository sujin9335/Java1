package com.inter.main;

import com.inter.common.BasicInterface;
import com.inter.common.TestLambda;

public class AnnoMain {
	
	public static void main(String[] args) {
		//인터페이스 익명클래스로 이용하기
		BasicInterface bif=new BasicInterface() {
			@Override
			public void test() {
				System.out.println("익명클래스로 정의");
			}
			
			@Override
			public int calc(int su, int su2) {
				return su*su2;
			}
		};
		
		bif.test();
		System.out.println(bif.calc(20, 20));
		
		
		//인터페이스에 선언된 추상메소드가 한개인것은 funtional 인터페이스임
		//람다표현식을 적용할 수 있음
		//() => {}
		
		TestLambda tl=new TestLambda() {
			@Override
			public String checkStr(String str, char ch) {
				return str;
			}
		};
		//추상메소드에 대해 구현체 부분만 표시
		//(매개변명, 매개변수명,....)->{로직 return 값;}
		//()->{로직 return 값;}
		//로직없이 바로 return값을 작성하는경우
		//(매개변수, 매개변수,....)->리턴값
		
		
		tl=(str,ch)->"안녕";
		tl=(str,ch)->{
			int index=-1;
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i)==ch) {
					return "있다";
				}
			}
			return "없다";
		};
		System.out.println(tl.checkStr("banana", 'i'));
		
		
		
		
	}
}
