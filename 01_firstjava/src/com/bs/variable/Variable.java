package com.bs.variable;

public class Variable {
	//main 메소드 만들기
	public static void main(String[] args) {
		//변수 선언하기
		//RAM 영역에서 사용할 공간을 확보하는것
		boolean flag;
		//boolean 자료형은 1byte로 true, false리터럴을 저장할수 있다
		//선언한 변수를 이용하려면 변수명을 사용한다
		flag = true;
		System.out.println(flag);
		flag = false;
		System.out.println(flag);
		//변수는 단 한개값만 저장함 -> 코드의 순서에 따라 제일 마지막에 대입한 데이터만 남아있음
		
		
		//정수형 변수 선언/대입하기
		byte bnum; //파일데이터를 가져오거나 할때 사용 -> byte 배열을 이용함
		short snum; //2byte크기를 갖는다
		int num; //4byte크기를 갖고 기본적으로 숫자를 저장할때 많이 사용 default 자료형
		long lnum; //8byte크리를 갖고 int형의 범위를 넘어서는 값을 저장할때 사용
		
		bnum = 100;
		snum = 120;
		num = 200;
		lnum = 100000000000L;
		
		System.out.println(bnum);
		System.out.println(snum);
		System.out.println(num);
		System.out.println(lnum);
		
		
		//실수 : 소수함수
		float fnum; //4byte
		double dnum; //8byte default 자료형
		fnum = 180.5f;
		dnum = 65.5;
		
		
		//문자를 저장하는 변수
		char ch; //2byte 문자한개를 저장할 수 있는 공간으로 지정된 코드표와 매핑되어있음 
		//문자를 표시하는 리터를은 ''로 표현을함
		ch = 'A';//65로 저장
//		ch = "AB";//안됨 한글자만 가능
		
		//단어나 문장을 저장하는 변수
		//String -> 문장, 단어, 1개이상의 문자를 저장하는 저장소
		String msg;
		msg="여러분 조금 있으면 점신시간이에요!";
		System.out.println(ch);
		System.out.println(msg);
		
		
		//변수의 명령규칙
		//1. 대소문자 구분 *변수명의 첫글자는 소문자로 작성한다
		int age;
		age = 19;
		int aGe;
		aGe = 33;
		System.out.println(age);
		System.out.println(aGe);
		//2. 변수명의 길이에는 제한이 없다
		double ajweiofjawoiefjoiawefjoiwaj;
		ajweiofjawoiefjoiawefjoiwaj = 3.14;
		System.out.println(ajweiofjawoiefjoiawefjoiwaj);
		//3.예약어을 사용할 수 없다
//		short public;
		//4. 특수기호는 _ $ 만 사용이 가능함
		char $ch;
		char ch_;
//		char ch^;
		//5. 여러단어로 변수명을 선언할때는 낙타봉표기법을 준수한다
		String userId;
		int memberNo;
		
		
		//변수선언할때 동일한 자료형에 다수의 변수를 선언한다면 한번에 선언할 수도있다
//		int a;
//		int b;
//		int c;
//		int d;
		int a,b,c,d;
		a = 10;
		b = 20;
		c = 30;
		d = 40;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		//동일영역안에서 동일한 이름의 변수를 사용할 수 있다 (상단 public static void main(String[] args) 이거)
//		String a; // 위에 a가 int로 선언되어있음
		
		
		//상수활용하기
		//상수는 한번값을 대입하면 그 값을 유지하는 저장공간 *더이상 다른 값을 대입할 수 없다
		//에러코드, 에러메시지, 관리자게정아이디
		final int AGE; //상수선언 (대문자로 표시)
		AGE = 19;
		System.out.println(AGE);
//		AGE = 20; //에러가 발생
		
		
		
		
		
		
		
		
		
	}
}
