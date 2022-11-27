package com.inherit.controller;

import com.inherit.model.vo.Basic;
import com.inherit.model.vo.Cat;
import com.inherit.model.vo.Dog;
import com.inherit.model.vo.Employee;
import com.inherit.model.vo.Hamster;
import com.inherit.model.vo.Student;
import com.inherit.model.vo.Teacher;

public class InheritController {
	
	
	public void basicInherit() {
		//기본상속에 대해 알아보자
		//1. java에서 사용하는 모든 클래스는 Object클래스를 상속 받고 있음
		Basic b=new Basic();
		b.toString();
//		b.
				
		//클래스에 상속관계 설정하기
		//두개의 클래스간에 부모(super), 자식(sub) 관계를 설정하는 것을 말함
		//선언방법 : 클래스 선언부에 extends예약어를 사용
		//public class Test(클래스명) extends 상속할 클래스명(부모클래스){구현}
		Basic b1=new Basic();
		b1.setTitle("상속");
		System.out.println(b1.getTitle());
		
		Student s=new Student();
		Employee e=new Employee();
		Teacher t=new Teacher();
		
		s.setName("김태훈");
		e.setName("김성훈");
		t.setName("유병승");
		s.setEmail("th@na");
		e.setEmail("th@na");
		t.setEmail("th@na");
		
		s=new Student("김태훈",25,'남',"경기도",1,2,3);
		System.out.println(s.getName()+s.getAge()+
					s.getGender()+s.getAddress()+s.getGrade());
		
		System.out.println(s.infoStudent());
			
	}
	
	public void overrideTest() {
		//오버라이드에 대해 알아보자
		//재정의 -> 상속관계에 있을때 자식클래스에서 부모클래스에 정의되어있는 메소드를 커스터마이징하는 기능
		
		Cat c=new Cat("고양이", "나비", 8, '여');
		Dog d=new Dog("강아지", "달콩이", 10, '여');
		Hamster h=new Hamster("쥐", "햄찌", 1, '남');
		System.out.println(c.bark());
		System.out.println(d.bark());
		System.out.println(h.bark());
		
		//오버라이드 : 부모클래스에서 선언한 선언부대로 작성해야한다
		// 구현부의 내용만 변경이 되는것임
		//@Override 이노테이션을 사용 *선택
		//선언메소드가 오버라이드된 메소드인지 새로선언되는 메소드인지를 확인해줌
		
		//오버라이딩 vs 오버로딩
		//오버라이딩 : 재정의 ->메소드 선언부를 동일하게
		//오버로딩 : 이름만 동일하게 쓰는 다른 메소드 구현 -> 메소드명만 동일하게 매개변수는 다르게
		
		
		//Object 클래스의 메소드를 재정의해서 사용
		//1. equals() : 클래스의 동등성을 비교하기 위해서 재정의해야하는 메소드
		//2. hashcode() : 생성된 객체의 주소를 의미하는 hash(유일한값)을 출력
		//3. toString() : 생성된 객체를 표현할 수 있는 대표 문자열을 출력하는 메소드
		//4. clone() : 생성된 객체를 깊은복사할때 사용하는 메소드
		
		Student s=new Student("유병승", 19, '남', "경기도 시흥시", 1, 2, 3);
		Student s2=new Student("유병승", 19, '남', "경기도 시흥시", 1, 2, 3);
		Student s3=new Student("김병승", 19, '남', "경기도 시흥시", 1, 2, 3);
		System.out.println(s==s2);
		System.out.println(s.equals(s2));
		System.out.println(s.equals(s3));
		System.out.println(s); //Object의 toString메소드가 실행됨
		
	}
	
	
	
	
	
	
}
