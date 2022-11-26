package com.obj.run;

import static com.obj.model.vo.MethodTest.*; //*로 여기 모든 static 메소드 접속가능

import java.util.Arrays;

import com.obj.model.vo.Animal;
import com.obj.model.vo.MethodTest;

public class MethodMain {

	public static void main(String[] args) {

		//MethodTest클래스의 printMsg메소드 실행하기
		//1.클래스 생성하기
		MethodTest mt=new MethodTest();
		
		//2.실행할 메소드 호울 -> 메소드 명을 이용한다
		mt.printMsg();
		
		//3.반환형이 있는 메소드 호출
//		int result=mt.plus();
//		System.out.println("반환값 : "+result);
//		int result2=mt.plus();
//		System.out.println("반환값 : "+result2);
		
		//4.매개변수있고 반환형이 없는 매소드 호출
		mt.printSendMsg("매개변수값");
//		mt.printSendMsg(10); // String 이라 int형 10이 안됨
		mt.printSendMsg("한시간후 점심시간");
		
		mt.calculator(100, 80, '+');
		mt.calculator(100, 80, '-');
		
		int[] resultArr=mt.returnArr();
		System.out.println(Arrays.toString(resultArr));
		
		Animal a=mt.getAnimal();
		System.out.println(a.name+a.age+a.type+a.gender);
		
		int[] paramArr=new int[] {5,6,7,8};
		mt.paramArr(paramArr);
		int[] param2Arr=new int[] {50,60,70,80};
		mt.paramArr(param2Arr);
		
		Animal y=new Animal("카키", 0, "강아지", '남');
		mt.paramObj(y);
		mt.paramObj(a);
		
		int number=100;
		mt.updateNumber(number);
		System.out.println(number);//안바뀜 100
		System.out.println(mt.updateNumber2(number));
		
		int[] intArr= {10,20,30,40}; //변함 intArr은 주소임
		System.out.println("intArr[0] 전 "+intArr[0]);
		mt.updateArr(intArr);//주소를 보내준거라 값이 변함
		System.out.println("intArr[0] 후 "+intArr[0]);
		
		Animal p=new Animal("유병승",19,"강아지",'남');
		System.out.println("수정전: "+p.name+p.age);
		mt.updatPerson(p);
		System.out.println("수정후: "+p.name+p.age);
		
		mt.testReturn("유병승");
		mt.testReturn("하");
		System.out.println("return 후 실행");
		
		//static메소드 호출하기
		//클래스명.메소드명() -> 호출함
		MethodTest.sendMsg("static 테스트");
		
		Math.random();//얘도 스테틱 메소드임
		
		//static 메소드 활용시 클래스명을 작성하지 않고 활용하기
		//static import를 이용하면된다( * 로 모든 static 메소드 이용도 가능)
		sendMsg("static import로 간단하게 사용하기");
		System.out.println(test(10)); 
		
	}

}
