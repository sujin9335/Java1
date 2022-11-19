package com.obj.run;
import java.util.Arrays;

import com.obj.controller.FieldTest;
import com.obj.controller.PublicTest;
import com.obj.model.vo.Student;
//import com.obj.controller.DefaultTest;
public class Main {
	public static void main(String[] args) {
		//클래스는 생성을 해야지 이용을 할 수 있다
		//클래스는 기본 코드, 생성할 규칙을 정의한 코드자체 -> 생성 해야지 활용이 가능!
		//선언된 클래스를 새엉하는 방법: new 연산자를 이용
		//new 클래스명();
		new PublicTest();
		//클래스는 하나의 타입으로 활용이 되기 때문에
		//생성된 클래스(객체)는 변수로 저장할 수 있다.
		PublicTest pt;
		pt=new PublicTest();
		//클래스는 new 연산자를 사용할때 마다 새로운 객체를 생성해서 반환
		
		
		//default로 선언된 클래스 생성하기 -> 외부패키지에서는 이용이 불가능함
//		new DefaultTest();
		
		//설계에 의해서 특별한 경우가 아니면 클래스선언부의 접근제한자는 public으로 선언을 한다
		
		
		//FieldTest클래스에 선언된 필드 이용하기
		//ctrl+shift+o 상단 import 자동생성
		FieldTest ft=new FieldTest();
		//FieldTest의 각 변수에 접근하기
		System.out.println(ft);
		//접근연산자 . 을 이용해서 클래스에 선언된 변수에 접근할 수 있다
		System.out.println(ft.age);
//		System.out.println(ft.name);
//		System.out.println(ft.gender);
//		System.out.println(ft.height);
		ft.age=-100;
		System.out.println(ft.age);
		System.out.println("ft.test()실행");
		ft.test();
		
		FieldTest ft2=new FieldTest();
		System.out.println("ft2.test()실행");
		ft2.test();
		
		System.out.println(ft2.hobby);
		System.out.println(ft2.pt);
		ft2.hobby=new String[5];
		ft2.hobby[0]="운동";
		System.out.println(Arrays.toString(ft2.hobby));
		ft2.pt=new PublicTest();
		System.out.println(ft2.weight);
		
		
		
		//static 필드에 접근하기
		//클래스를 생성하지 않고 접근이 가능
		//클래스명.static필드변수명
		System.out.println(FieldTest.count);
//		System.out.println(ft2.count);//접근할수 있지만 잘사용안함
		FieldTest.count=10;
		System.out.println(FieldTest.count);
		ft2.test();
		System.out.println(FieldTest.count);
		
		
		
		//학생정보를 저장하는 클래스를 생성해서 이용하기
		//학생정보 : 이름, 나이, 학년, 반, 키, 주소
		//모든필드는 어디서든 접근가능하게 설정
		//아래 학생들을 생성해서 출력
		//유병승 19 1 3 180.5 경기도시흥시
		//홍길동 33 3 3 174.2 강원도
		//이순신 57 2 2 163.2 전라도
		//신사임당 45 2 1 152.2 강원도
		Student bs=new Student();
		bs.name="유병승";
		bs.age=19;
		bs.grade=1;
		bs.classNum=3;
		bs.height=180.5;
		bs.address="경기도 시흥시";
		Student hong=new Student();
		hong.name="홍길동";
		hong.age=33;
		hong.grade=3;
		hong.classNum=3;
		hong.height=174.2;
		hong.address="강원도";
		Student lee=new Student();
		lee.name="이순신";
		lee.age=57;
		lee.grade=2;
		lee.classNum=2;
		lee.height=163.2;
		lee.address="경기도 시흥시";
		
		System.out.println(bs.studentNo+" "+bs.name+" "+bs.age+" "+bs.grade+" "+bs.classNum+" "+bs.height+" "+bs.address);
		
		
		
		
		
		Student sh=new Student();
		System.err.println(sh.name+" "+sh.age);
		//초기화 블록 : 클래스가 생성될때(new) 실행할 내용이 있다면 선언하는 기능
		//1.인스턴스초기화 블록
		//	- 클래스를 생성할때 마다 실행됨
		//	- 생성한 클래스의 수를 계산하거나, 특정필드에 임의의 값을 부여할때 사용할 수 있음
		//2.static초기화 블록
		//	- 클래스를 생성할때 최초한번만 실행됨
		//	- static 변수를 초기화 해줄때 사용
		
		
		
		
		
		
		
	}
}
