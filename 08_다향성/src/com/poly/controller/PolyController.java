package com.poly.controller;

import java.util.Scanner;

import com.poly.model.vo.Animal;
import com.poly.model.vo.Cat;
import com.poly.model.vo.Dog;
import com.poly.model.vo.Duck;
import com.poly.model.vo.Employee;
import com.poly.model.vo.Person;
import com.poly.model.vo.Snake;
import com.poly.model.vo.Student;
import com.poly.model.vo.Teacher;

public class PolyController {
	
//	private Student s;
//	private Employee e;
//	private Teacher t;
//	private Person p;
	

	public void basicPolytest() {
		//기본 다향성 적용해보기
		//다형성은 클래스간 상속관계에 있을때 부보클래스의 타입으로 선언된 변수에
		//자식클래스를 생성한 객체가 저장되는 것
		Person p=new Person();
		Student s=new Student();
		Employee e=new Employee();
		
//		Student s2= new Employee();
		Person p2=new Student("유병승",19,190,5,3);
		System.out.println(p2);
		System.out.println(p2.getAge());
		//부모타입에 저장된 자식객체는 부모클래스의 멤버들만 접근이 가능해짐 *자식의 멤버는 접근이 불가능!
		p2=new Employee("박세현",28,190,5,200);
		System.out.println(p2);
		System.out.println(p2.getName());
		System.out.println(p2.getAge());
//		System.out.println(p2.getSalary());
		//자식타입의 멤버(필드, 멤버메소드)에 접근하려면 형변환을 해줘야한다.
		//(자료형)변수명
		Employee e2=(Employee)p2;
		System.out.println(((Employee)p2).getSalary());
		
		
		//Object타입의 변수는 java에 사용하는 모든 클래스의 객체를 저장할 수 있다
		Object o=new Student();
		o=new Teacher();
		o=new Person();
		o=new Employee();
		o=new Scanner(System.in);
		o=new String();
//		printObject(new Employee("유병승",19,180.4,200,3));
//		printObject(new Student("유병승",19,180.5,3,5));
		printObject(new String("한개로 다 처리하자"));
		
		
		//자식타입클래스 변수에 부모타입의 객체를 저장할 수 있나?
		//Student s4=new Person(); //불가능하다
		
		
		//부모타입으로 선언된 변수에 저장된 데이터 타입확인하기
		printObject(new Employee("유병승",19,180.4,200,3));
		printObject(new Student("유병승",19,180.5,3,5));
		//instanceof 연산자를 이용하면 타입을 확인할 수 있음
		//변수명 instanceof 클래스명 -> true|false
		
		Student s5=new Student("유병승",19,180.4,200,3);
		Student s6=new Student("유병승",19,180.4,3,5);
		System.out.println(s5.equals(s6));
		
		
		
	}
	
	//객체를 출력하는 메소드 구현하기
	public void printObject(Object o) {
		
		if(o instanceof Student) {
			//학새잉면 이름, 나이 ,반 번호
			Student s=(Student)o;
			System.out.println(s.getName()+" "+s.getAge()+" "+s.getClass());
		}else if(o instanceof Employee) {
			//사원이면 이름, 나이, 월급, 보너스
			Employee e=(Employee)o;
			System.out.println(e.getName()+" "+e.getAge()+" "+e.getSalary());
		}else if(o instanceof Person) {
			//사람이면 이름, 나이, 키
		}
		
		
		
		
		System.out.println(o);
	}
//	public void printObject(Person p) {
//		
//	}
//	
//	public void printObject(Student s) {
//		
//	}
//	public void printObject(Teacher t) {
//		
//	}
//	public void printObject(Employee s) {
//		
//	}
	public void dynamicBindTest() {
		//메소드 동작바인딩
		//부모클래스타입에 저장된 자식클래스 객체가 있을때
		//부모메소드를 오버라이드한 메소드는 형변환 없이 자식 클래스의 메소드가 호출되는 것
		Person p=new Student("유병승",19,180,5,1);
		System.out.println(p);
		
//		Animal ani;
//		ani=new Dog("뽀삐","남");
//		ani.bark();
//		ani=new Cat("짬타이거","여");
//		ani.bark();
		totalBark(new Dog("뽀삐","남"));
		totalBark(new Cat("짬타이거","여"));
		totalBark(new Duck());
		totalBark(new Snake());
		
		
		
		
	}
	public void totalBark(Animal a) {
		a.bark();
	}
	
	
	public void polyArrayTest() {
		//학생, 사원, 선생관리
		Student[] students=new Student[10];
		Employee[] employees=new Employee[10];
		Teacher[] teacher=new Teacher[10];
		int personCount=0;
		
		for(int i=0; i<students.length; i++) {
			if(students[i]!=null) personCount++;
		}
		for(int i=0; i<students.length; i++) {
			if(employees[i]!=null) personCount++;
		}
		for(int i=0; i<teacher.length; i++) {
			if(teacher[i]!=null) personCount++;
		}
		System.out.println(personCount);
		
		Person[] persons=new Person[30];
		persons[0]=new Student("유병승",19,180.2,1,3);
		persons[1]=new Employee("홍길동",44,180.2,200,0);
//		persons[2]=new Teacher();
		persons[3]=new Student("이순신",18,148.2,2,3);
		
		personCount=0;
		for(int i=0; i<persons.length; i++) {
			if(persons[i]!=null) personCount++;
		}
		System.out.println(personCount);
		
		
		Animal[] animals=new Animal[10];
		animals[0]=new Dog("뽀삐","남");
		animals[1]=new Cat("야옹이","남");
		animals[2]=new Snake();
		animals[3]=new Dog("바둑이","여");
		animals[4]=new Animal("동물","여");
		System.out.println("관리되는 동물 울음소리 출력");
		for(int i=0; i<animals.length; i++) {
			if(animals[i]!=null) animals[i].bark();//동적바인딩
		}
		
		
		
	}
	
	
	
	
	
	
}
