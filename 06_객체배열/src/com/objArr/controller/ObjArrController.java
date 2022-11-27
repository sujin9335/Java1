package com.objArr.controller;

import java.util.Scanner;

import com.objArr.model.vo.Person;

public class ObjArrController {
	public static void main(String[] args) {
		//Person 을 다수저장하기
		//객채 배열 선언하기
		Person[] persons=new Person[5];
		System.out.println(persons[0]);
		System.out.println(persons[1]);
		System.out.println(persons[2]);
		
		System.out.println(persons.length);
		
		
		//객체배열은 객체를 저장할 수 있는 변수를 만든것으로 변수에 객체를 생성 후 사용
		persons[0]=new Person();
		Person p;
		p=new Person();
		
		//배열에 저장된 객체에 값을 대입 하려면
		persons[0].setName("윤주");
		persons[0].setAge(28);
		persons[0].setAddress("경기도 과천시");
		
		System.out.println(persons[0].infoPerson());
		System.out.println(persons[0].getName());
		
		
//		persons배열에 사용자에게 입력받은 사람의 정보를 저장하기
//		persons=new Person[3];
//		//이름 나이 주소
//		//유병승 19 경기도 시흥시
//		//홍길동 44 강원도
//		//이순신 55 
//		Scanner sc=new Scanner(System.in);
//		
//		for(int i=0; i<persons.length; i++) {
//			//객체배열을 이용하려면 각변수에 객체를 생성해서 대입해야한다
//			persons[i]=new Person();
//			System.out.println("이름: ");
//			String name=sc.nextLine();
//			System.out.println("나이: ");
//			int age=sc.nextInt();
//			sc.nextLine();
//			System.out.println("주소: ");
//			String address=sc.nextLine();
//			persons[i].setName(name);
//			persons[i].setAge(age);
//			persons[i].setAddress(address);
//		}
//		System.out.println("==== 저장된 사람 ====");
//		for(int i=0; i<persons.length; i++) {
//			System.out.println(persons[i].getName()
//								+persons[i].getAge()+persons[i]);
//		}
//		//forEach문을 이용해서 출력
//		for(Person p:persons) {
//			System.out.println(p.getName()+p.getAge()+p.getAddress());
//		}
		
		
		//객체배열 선언과 동시에 초기화하기
		int[] intArrr= {1,2,3,4,5};
		Person[] persons2= {
			new Person(),
			new Person("유병승", 19, "경기도 시흥시"),
			new Person("이순신", 55, "전라도"),
			new Person("홍길동", 44, "강원도"),
			new Person("신사임당", 34, "경기도")
		};
		persons=new Person[] {new Person(), new Person()};
		
		
		//persons2에서 나이가 40대 이상인 사람 찾기
//		String result="";
//		for(int i=0; i<persons2.length; i++) {
//			int age=persons2[i].getAge();
//			if(age>=40) {
//				result+=persons2[i].getName();
//			}
//		}
//		System.out.println(result);
		
		for(int i=0; i<persons2.length; i++) {
			if(persons2[i].getAge()>=40) {
				System.out.println(persons2[i].infoPerson());
			}
		}
		
		
	}
}
