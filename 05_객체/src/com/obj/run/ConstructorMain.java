package com.obj.run;

import com.obj.model.vo.Animal;
import com.obj.model.vo.Employee;
import com.obj.model.vo.Inpo1;

public class ConstructorMain {
	public static void main(String[] args) {
		//생성자 활용하기
		//생성자는 클래스를 생성할때 이용하는 기능으로
		//클래가스 가지고 있는 변수공간(필드)에 데이터를 특정데이터를 대입할때 사용
		//두가지로 구분할 수 있음
		//1. 기본생성자 기본값으로 클래스를 생성하는 것 -> 클래스 내부에 생성자를 선언하지 않으면 자동으로 만들어줌
		//2. 매개변수있는 생성자 클래스를 생성하는 곳에서 보내준 데이터로 필드를 초기화하여 생성해주는 것
		
		//사람의 정보를 저장하는 클래스 생성하기
		//정보 : 이름, 나이, 성별, 전화번호
		Inpo1 p=new Inpo1();
		Inpo1 p2=new Inpo1("유병승",19,'남',"01093356987");
		System.out.println("p: "+p.name+" "+p.age+" "+p.gender+" "+p.phone);
		System.out.println("p2: "+p2.name+" "+p2.age+" "+p2.gender+" "+p2.phone);
		
		//사원의 정보를 저장하는 클래스를 만들고
		//이름 부서 직책 월급 보너스 * 외부접근이 가능하도록 선언
		//1. 기본생성자로 생성해서 유병승 강사부 강사 100 0.1 대입후 출력
		//2. 이름을 초기화하는 매개변수있는 생성자를 선언하여 다음 데이터를 대입 후 출력 박세현
		//3. 전체 정보를 초기화하는 매개변수를 선언하여
		//오윤재 개발부 연구원 600원 0.5
		//4. 필드에 사원번호를 추가하고 사번은 100부터 1씩증가되어 생성시 자동으로 부여될 수 있도록 하기
		Employee em1=new Employee();
//		em1.name="유병승";
//		em1.department="강사부";
//		em1.job="강사";
//		em1.salary=100;
//		em1.bonus=0.1;
		
		em1.EmPrint();
		
		Employee em2=new Employee("박세현");
		EmPrint2(em2);
		
		Employee em3=new Employee("오윤재","개발부","연구원",600,0.5);
		ConstructorMain a1=new ConstructorMain();
		a1.EmPrint3(em3);
		
		
		//this() 생성자 이용하기
		Animal a=new Animal("나비", 9, "고양이", '여');
		System.out.println(a.name+" "+a.age+" "+a.type+" "+a.gender);
		
		
		
		
		
	}
	public static void EmPrint2(Employee em) {
		System.out.println(em.name+" "+em.department+" "+em.job+" "+em.salary+" "+em.bonus);
	}
	public void EmPrint3(Employee em) {
		System.out.println(em.name+" "+em.department+" "+em.job+" "+em.salary+" "+em.bonus);
	}
}
	
	