package com.operator.controller;

public class OperatorController {
	//기능제공 클래스
	public void singleOp() {
		//단항연상자에 대해 알아보자
		//1. 부정연산자 : boolean형 데이터를 반전시키는 연산자
		//표현 : !변수명 또는 !기능(메소드)호출구문
		// ex) !flag, !str.equals("test");
		System.out.println("========= 부정연산자 활용하기 =========");
		boolean flag = true;
		System.out.println(flag);
		System.out.println(!flag);
		
		System.out.println("김수진".equals("김수진"));
		System.out.println(!"김수진".equals("수진"));
		
		int age = 19;
		System.out.println(age<20);
		System.out.println(!(age<20));
		
		
		//증가, 감소연산 -> 변수에 1씩 더하거나 빼는 연산
		//++변수, 변수++ -> 변수=변수+1
		//--변수, 변수-- -> 변수=변수-1
		//횟수를 확인할때 많이 사용, for문에서
		
		int count = 0;
		count++;
		System.out.println(count);
		++count;
		System.out.println(count);
		//++연산이 단독으로 사용했을때는 연산결과가 동일하다
		//다른연산과 같이 사용했을때는 앞에 있을때(전위)와 뒤에 있을때(후위) 다름
		count = 0;
		//int result = count++;// 연산순서가 다름 -> 대입연산 후 증가연산 실
		int result = ++count; // 증가연산을 실행 후 대입연산을 실행
		System.out.println(result);
		System.out.println(count);
		
		int num=10;
		num--;
		System.out.println(num);
		num=10;
		//int result2 = num--;
		int result2 = --num;
		System.out.println(result2);
		System.out.println(num);
				
		count = 0;
		num = 10;
		result = count++ +20;
		System.out.println(result);
		
		
	}
	public void calculatorOP() {
		//산술 연산자에 대해 알아보자
		//+,-,*,/,%(나머지값)
		int su=2;
		int su2=10;
		//더하기 빼기
		int result=su+su2;
		System.out.println(result);
		result=su+20;
		result=22+20;
		
		su=20;
		su2=10;
		result=su-su2;
		System.out.println(result);
		
		//곱하기 연산
		result=su*su2;
		System.out.println(result);
		
		//나누기 연산
		su=10;
		su2=3;
		double result2=(double)su/su2;//주의!!! 실수가 나올수 있기때문에 double형으로 변환
		System.out.println(result2);
		
		//나머지 연산 %
		//짝수, 홀수, 배수, 약수 등을 구할때 사용
		//어떤수 x를 4로 나눴을때 나머지?? 0,1,2,3
		su=30;
		result=su%3;
		System.out.println(result);
		result=su%7;
		System.out.println(result);
		
		//비교연산을 이용해서 배수,짝수,홀수를 구할수 있다
//		num%2==0 ->짝수 
//		num%2==1 ->홀수 
//		num%8==0 ->8의 배수
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
