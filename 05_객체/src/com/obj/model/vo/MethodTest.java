package com.obj.model.vo;

import java.util.Scanner;

//1. 데이터 보관용 클래스
//2. 기능을 제공하는 클래스
public class MethodTest {
	
	//메소드는 클래스가 제공하는 기능
	//메소드를 이용하려면 클래스를 반드시 생성하고 이용을 해야한다 *static예약어를 설정하지 않은 메소드
	//클래스 내부에 static 에약어 없이 선언된 메소드를 멤버메소드로 지칭함;
	//메소드 선언하는 방법
	//접근제한자 반환형 메소드명([매개변수]){ 로직(변수선언, 조건문, 반복문, 연산) [return]}
	
	//1. 반환형이 없고(void) 매개변수도 없는 메소드선언하기
	public void printMsg() {
		System.out.println("printMsg 메소스 실행");
		System.out.println("이것도 실행");
		int su=10;
		int su2=20;
		System.out.println(su+su2);
	}
	
	//2. 반환형이 있고 매개변수가 없는 메소드를 선언 -> 반환형을 지정했을때 로직에 반드시 return 예약어를 사용해야함
	// 지정된값을 더하기 연산을 하여 반환하는 기능
	public int plus() {
		Scanner sc=new Scanner(System.in);
		System.out.print("수 : ");
		int su=sc.nextInt();
		System.out.print("수2 : ");
		int su2=sc.nextInt();
		return su+su2;
	}
	//3. 매겨변수 있고 반환형이 없는 메소드 선언하기
	//전달받은 문자열을 출력하는 기능
	public void printSendMsg(String msg) {
		System.out.println(msg);
	}
	//매개변수는 필요한 만큼선언이 가능
	//계산기 기능만들기-> 숫자 2개, 연산자
	public void calculator(int su, int su2, char op) {
		int result=0;
		switch(op){
			case '+' : result=su+su2;break;
			case '-' : result=su-su2;break;
			case '*' : result=su*su2;break;
			case '/' : result=su/su2;break;
			
		}
		System.out.println(""+su+op+su2+"="+result);
	}
	//이제 자바 중간까지 왔네요! 문구를 바노한해주는 메소드 만들기
	//숫자를 1~5까지 더한수를 반환하는 메소드 만들기
	//두개의 문자열을 전달받아 합쳐서 출력하는 메소드 만들기
	//문자열을 전달받아 문자열에 중복값이 있는지 확인해주는 메소드 만들기
	//세개의 문자를 입력받고 합쳐서 출력하는 메소드 만들기
	
	
	//주의사항 반환형은 한개의 값만 반환이 가능
//	public int returnTest() {
//		return 10,10,656; //안됨
//	}
//	public String returnTest() {
//		return "하나","둘","셋";
//	}
	
	//배열, 클래스 매개변수, 반환형에 이용하기
	public int[] returnArr() {
		int[] intArr=new int[3];
		intArr[0]=10;
		intArr[1]=20;
		intArr[2]=30;
		return intArr;
//		return new int[] {10,20,30};
	}
	
	public Animal getAnimal() {
		Animal a=new Animal("달콩이", 10, "강아지", '여');
		return a;
	}
	
	//매개변수로 배열, 클래스 선언하기
	public void paramArr(int[] numbers) {
		for(int n: numbers) {
			System.out.println(n);
		}
	}
	
	public void paramObj(Animal a) {
		System.out.println(a.name+a.age+a.type+a.gender);
	}
	
	//매개변수로 받은 데이터를 수정하기
	//기본자료형을 매개변수를 받았을때 데이터 수정 ->
	//참조형자료형(배열,클래스)을 매개변수로 받았을때 데이터 수정 ->
	public void updateNumber(int number) {
		number+=100; //number=100+100; -> number=200
	}
	public int updateNumber2(int number) {
		number+=100; //number=100+100; -> number=200
		return number;
	}
	
	public void updateArr(int[] intArr) {
		intArr[0]=100;
	}
	
	public void updatPerson(Animal a) {
		a.name="홍길동";
		a.age=20;
		
	}
	
	
	//void 형도 return 예약어를 사용할 수 있다
	//return 예약어를 실행하면 그 라인에서 바로 반환
	public void testReturn(String msg) {
		if(msg.length()<2) {
			return;
		}
		System.out.println(msg);
	}
	
	//메소드 선언시 static 예약어를 사용할 수 있다
	public static void sendMsg(String msg) {
		System.out.println("메시지: "+msg);
	}
	
	public static String test(int su) {
		return "입력값 : "+su;
	}
	
	
}
