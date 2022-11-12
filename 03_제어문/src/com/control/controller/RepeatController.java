package com.control.controller;
import java.util.Scanner;
public class RepeatController {
	public void basciFor() {
		//반복문
		//반복문 지정한 코드를 원하는 수만큼 반복해주는 구문이다
		//for문을 이용해 보자
		//for(초기식(기준변수선언); 조건식(기준변수를 기준으로 true,false 값을 반환하는 조건문); 증감연산(기준변수의 값을 변경하는 연산))
		//	{반복 실행될 코드}
		
		//오늘의 마지막시간이네요 5번 출력하기
//		System.out.println("오늘의 마지막시간이네요");
//		System.out.println("오늘의 마지막시간이네요");
//		System.out.println("오늘의 마지막시간이네요");
//		System.out.println("오늘의 마지막시간이네요");
//		System.out.println("오늘의 마지막시간이네요");
		//오늘 반복문 기본만하고 끝낼게요 100번출력
		
		
		//반복문을 활용해서 코드 실행하기
		for(int i=1; i<6; i++) {
			System.out.println(i+"오늘의 마지막시간이네요");
		}
		//오늘은 반목문 기본만 할게요 100번출력하기
		for(int i=1; i<101; i++) {
			System.out.println(i+"오늘은 반복문 기본만 할게요");
		}
		
		
		//1부터 60까지 출력하는 반복문 만들어보자
		for(int i=1; i<=60; i++) {
			System.out.println(i);
		}
		
		
		//for문 {}안에는 변수선언, 메소드호출, 조건문 연산 등을 작성할 수 있다.
		//사용자에게 메세지를 5번 입력받기
		Scanner sc=new Scanner(System.in);
//		for(int i=1; i<6; i++) {
//			System.out.print(i+"메시지 입력 : ");
//			String msg=sc.nextLine();
//		}
		
		
		//반복문에서 사용하는 기준변수를 잘 이용해야함
		for(int i=1; i<6; i++) {
			System.out.println(i);
		}
		//1부터 10까지 수 중 짝수만 출력하기
		for(int i=1; i<11; i++) {
			if(i%2==0) {
				System.out.print(i+" ");
			}
		}
		//System.out.println(i); // i 사용 불가(for안에있음)
		//for문의 ()선언한 변수, {}안에 선언한 변수는 외부에서 이용이 불가능하다
		
		
		
		//같이 수강하는 학생 3명 이름을 입력받아 출력하기
		//이동명, 윤주, 김태훈 이세현, 최이경, 김수진
		String totalName="";
		for(int i=1; i<4; i++) {
			System.out.print("\n학생이름 : ");
			String name=sc.next();
			totalName+=name;
		}
		System.out.println(totalName);
		
		
		
		
		
		
		
		
	}
}
