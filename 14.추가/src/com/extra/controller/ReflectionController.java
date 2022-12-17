package com.extra.controller;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.extra.common.Gender;
import com.extra.model.vo.Student;

public class ReflectionController {

	public static void main(String[] args) {
		//자바에서 선언된 클래스의 정보를 가져오는 것
		//자바 클래스에 대한 정보를 관리하는 Class클래스를 제공
		//class, Field, method, constructor에 대한 정보를 확인, 호출
		Student s=new Student(100, "유병승", 19, 180.5, Gender.M, "경기도 시흥시");
		Class studentClass=s.getClass();
		//student클래스에 선언된 메소드를 조회
		Method[] methods=studentClass.getDeclaredMethods();
		for(Method m : methods) {
//			System.out.println(m);
			//선언된 메소드 중 get메소드 호출하기
			if(m.getName().contains("get")) {
//				System.out.println(m.getName());
				try {
					Object o=m.invoke(s);
					System.out.println(o);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		Field[] fs=studentClass.getDeclaredFields();
		for(Field f : fs) {
			System.out.println(f);
			System.out.println(f.getName());
			f.setAccessible(true);//set메소드를 이용해서 필드의 데이터를 변경할 수 있게 허용
			try {
				if(f.getName().contains("name")) {
					f.set(s, "홍길동");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		System.out.println(s.getName());
		
		
		Student s2=new Student(101, "경기도 시흥시", 19, 180.5, Gender.F, "유병승");
//		s2=new Student(102, "유병승");
//		s2=new Student("유병승",19);
		
		
		//Builder패턴을 이용해서 객체 생성하기
		//내부클래스를 선언해서 생성하는 로직을 만드는 것.
		
		Student s3=new Student.Builder() //빌더패턴
				.stdNo(103).name("유병승").gender(Gender.M)
				.address("경기도 시흥시").age(19).height(180.5)
				.build();
		System.out.println(s3);
		
		s3=new Student.Builder().stdNo(104).name("홍길동").build();
		System.out.println(s3);
		s3=Student.builder().name("이순신").age(19).build();
		System.out.println(s3);
	}
}
