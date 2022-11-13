package com.control.controller;
import java.util.Scanner;
import java.util.Random;
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
//		for(int i=1; i<6; i++) {
//			System.out.println(i);
//		}
//		//1부터 10까지 수 중 짝수만 출력하기
//		for(int i=1; i<11; i++) {
//			if(i%2==0) {
//				System.out.print(i+" ");
//			}
//		}
		//System.out.println(i); // i 사용 불가(for안에있음)
		//for문의 ()선언한 변수, {}안에 선언한 변수는 외부에서 이용이 불가능하다
		
		
		
		//같이 수강하는 학생 3명 이름을 입력받아 출력하기
		//이동명, 윤주, 김태훈 이세현, 최이경, 김수진
//		String totalName="";
//		for(int i=1; i<4; i++) {
//			System.out.print("\n학생이름 : ");
//			String name=sc.next();
//			totalName+=name;
//		}
//		System.out.println(totalName);
		
		
		//1부터 10까지 수의 합계를 출력
		int total1=0;
		
		for(int i=1; i<11; i++) {
			System.out.print(i+" ");
			total1+=i;
		}
		System.out.println(total1);
		
		//숫자 세개를 입력받아 합계를 출력하기
		
		int sum=0;
		for(int i=1; i<4; i++) {
			System.out.print("수입력: ");
			int su=sc.nextInt();
			sum+=su;
		}
		System.out.println(sum);
		
		
	}
	public void forTest() {
		//for문에 선언하는 초기식, 조건식, 증감식을 반드시 사용해야 하나요?
		//for (초기식;조건식;증감식){반복 구문}
		Scanner sc=new Scanner(System.in);
		
		
		int count=0;
		for(;count<10;count++) {
			System.out.println("이것도 되니?");
		}
		for(;count<20;) {
			System.out.println(count++);
		}
//		for(;;) {
//			System.out.println("무한루프");
//			System.out.println("계속 반복할까요?(y/n)");
//			char choise=sc.next().charAt(0);
//			if(choise=='n'){
//				break;
//			}
//		}
		
		for(int i=0, j=10; i<10; i++,j++) {
			System.out.println(i+" "+j);
		}
	
		//사용자가 입력한 만큼 반복하기
		//사용자가 5를 입력하면 1~5까지 수 출력
		//사용자가 10을 입력하면 1~10까지 수 출력
		//사용자가 100을 입력하면 1~100까지 수 출력
//		System.out.print("입력 수 : ");
//		int num=sc.nextInt();
//		
//		for(int i=1; i<=num; i++) {
//			System.out.print(i+" ");
//		}
		
		
		
		
		//사원정보를 입력받는 기능 구현하기
		//입력받을 사원의 수를 사용자에게 입력받고
		//그 수만큼 사원의 이름, 나이 직책 월급, 보너스를 입력받고 출력하기
		//public void insertEmp()
		
		
		//문자열을 한개문자씩 접근하기
		String msg="일요일날도 열심히 해봅시다!";
		//charAt();
		System.out.println(msg.charAt(0));
		System.out.println(msg.charAt(1));
		System.out.println(msg.charAt(2));
		System.out.println(msg.charAt(3));
		System.out.println(msg.charAt(14));
		
		
		for(int i=0; i<msg.length(); i++) {
			//System.out.println(i);
			if(msg.charAt(i)==' ') {
				System.out.println(i+"번째 공백");
			}
			//System.out.print(msg.charAt(i));
		}
		
		
		//입력받은 문자열에 대문자 알파벳이 있는지 확인하는 기능 구현하기
		
//		System.out.print("입력 문자: ");
//		String inputStr=sc.nextLine();
//		int checkCount=0;
//		for(int i=0; i<inputStr.length(); i++) {
//			char checkCh=inputStr.charAt(i);
//			if(checkCh>='A'&&checkCh<='Z') {
////				System.out.println("있다");
//				checkCount++;
//			}
////			System.out.println(inputStr.charAt(i));
//		}
//		System.out.println(checkCount>0 ? checkCount+"개 있다" : "없다");
		
		
		
		
		//1. 입력받은 문자에 솜누자가 있는지 확인해주는 기능구현하기
		//public void checkStrLower()
		//2. 입력받은 문자에 숫자가 있는지 확인하고 있는 수를 출력해주는 기능 구현하기
		//public void checkStrNumber()
		
		
		
	}
	public void doubleFor() {
		//중첩반복문 활용하기
		//반복문 내부에 다시 반복문을 선언한 구조
		
		for(int i=0; i<10; i++) {
			System.out.println(i+"외부 반복문");
			for(int j=0; j<10; j++) {
				System.out.print(j+"내부반복문");
			}
			System.out.println("내부반복문 종료");
		}
		
		
		for(int i=2; i<10; i++) {
			System.out.println(i+"단");
			for(int j=1; j<10; j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}
		}
		
		//입력받은 문자열의 중복값을 확인하는 기능 -> 중복반복문을 이용
		// apple ->중복값 있는지 
		String target="apple";
		for(int i=0; i<target.length(); i++) {
//			System.out.println(target.charAt(i));
			char ch=target.charAt(i);
			for(int j=0; j<target.length(); j++) {
//				System.out.println(ch+" "+target.charAt(j));
				if(i!=j&&ch==target.charAt(j)) {
					System.out.println(ch+" "+target.charAt(j));
				}
			}
		}
		
		// * 찍기
		//****
		//****
		//****
		for(int i=0; i<3; i++) {
			for(int j=0; j<4; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//*
		//**
		//***
		//****
		//*****
		for(int i=0; i<5; i++) {
			for(int j=0; j<(i+1); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//*****
		//****
		//***
		//**
		//*
		for(int i=0; i<5; i++) {
			for(int j=0; j<(5-i); j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	public void whileTest() {
		//반복문을 구현하는 방법중 하나
		//특정조건으로 반복문을 싱행할때 많이 사용
		//무한루프를 사용할때
		//while(조건식){반복할 코드}
		
		//1~10출력하기 ->for을 많이 이용
		int i=0;
		while(i<10) {
			System.out.println(i+1);
			i++;
		}
		
		
		//사용자에게 메세지를 입력받아 출력하는 기능구현
		//사용자가 "끝" 메세지를 입력하면 종료
		Scanner sc=new Scanner(System.in);
//		String total="";
//		String msg="";
//		while(!msg.equals("끝")){
//			System.out.print("메세지: ");
//			msg=sc.nextLine();
//			total+=msg;
//		}
//		System.out.println(total);
		
		int choise=100;
		while(choise!=0) {
			System.out.println("=====점심메뉴====");
			System.out.println("1. 참김");
			System.out.println("2. 라면");
			System.out.println("3. 햄버거");
			System.out.println("4. 돈까스");
			System.out.println("0. 종료");
			System.out.print("메뉴: ");
			choise=sc.nextInt();
		}
		
		
		//계산기프로그램 만들기
		//public void calculator()
		//두개의 정수와 연사낮를 받아서 계산을 해주는 기능
		//계산결과를 출력 후 계속하시겠습니까? Y를 입력하면 계산한번 더
		//n을 입력하면 계산기를 종료 하겠습니다 출력
		
		
		
	}
	public void calculator() {
		Scanner sc=new Scanner(System.in);
		
		char endStr='y';
		
		while(endStr=='y') {
//		while(ture){
		System.out.println("정수1 :");
		int num1=sc.nextInt();
		System.out.println("정수2 :");
		int num2=sc.nextInt();
		
		System.out.println("+, -, * 선택: ");
		char a=sc.next().charAt(0);
		
		int result=0;
		switch(a) {
			case '+' : result=num1+num2;break;
			case '-' : result=num1-num2;break;
			case '*' : result=num1*num2;break;		
				}
		
		System.out.println(result);
		
		System.out.println("계속하시겠습니까?(y,n) : ");
		endStr = sc.next().charAt(0);
		while(endStr!='y'&&endStr!='n') {
			System.out.println("잘못 입력 \n y또는 n입력");
			endStr=sc.next().charAt(0);
			}
		
//		if(endStr=='n') {
//			break;
//		}
		}
		
		
	}
	public void dowhileTest() {
		//dowhile문 사용하기
		//반복될 코드는 무조건 한번실행 후 조건에 의해 더 실행할지 말지 결정하는 구문
		//do{반복실행 코드}while(조건문);
		
		char flag='n';
		while(flag=='y') {
			System.out.println("실행하자");
		}
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("dowhile실행0");
			System.out.println("y/n입력 : ");
			flag=sc.next().charAt(0);
		}while(flag=='y');
		
		
	}
	public void breakContinueTest() {
		//break 현재 실행되고 있는 반복문을 중단할때 사용
		//contine continue 아래라인에 있는 코드를 생략하고 반복문을 실행할때
		//break continue 특정조건을 만들어서 활용을 함
		
		int count=0;
		while(true) {
			System.out.println("실행하자");
			if(count++>10) {
				break;//멈춰라
			}
		}
		
		target:
		for(int i=0; i<10; i++) {
			System.out.println(i);
			for(int j=0; j<5; j++) {
				System.out.print(j+" ");
				if(j==2) {
					break target;
				}
			}
			System.out.println();
		}
		//입력받은 문자열에 중복이 있는지 없는지 확인하는 기능
		
		String a="banana";
		int count1=0;
		for(int i=0; i<a.length(); i++) {
			for(int j=0; j<a.length(); j++) {
				if(i!=j&&a.charAt(i)==a.charAt(j)) {
					count1++;
					break;
				}
			}
		}
		
		
		
		//continue문 활용하기
		for(int i=0; i<100; i++) {
			if(1%2==0) {
				continue;
			}
			System.out.println(i);
		}
		
		
		
		
		
	}
	public void randomTest() {
		//자바에서 랜덤값을 출력하기
		//두가지 방법으로 가능
		
		//1.Math.random()
		//2.Random클래스
		System.out.println(Math.random());
		//랜던값은 기본적으로 0~1사이의 실수로 출력
		//정수로 랜덤출력
		//0~9
		System.out.println((int)(Math.random()*10));
		//1~10
		System.out.println((int)(Math.random()*10)+1);
		
		//Random클래스 이용하기
		//java.util 에있음
		Random rnd=new Random();
		System.out.println("random클래스로 랜던값구하기");
		System.out.println(rnd.nextInt());
		//0~9
		System.out.println(rnd.nextInt(10));
		//0~10
		System.out.println(rnd.nextInt(10)+1);
		
		
		
		
	}
	
	
	
}
	

