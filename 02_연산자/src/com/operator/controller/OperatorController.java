package com.operator.controller;
import java.util.Scanner;
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
		//계산기 프로그램만들기
		//public void mycalculator()메소드 만들고
		//사용자에게 두수를 입력받고 그 두수의 +,-,*,/의 결괄르 출력하는 기능만들기
		
	public void compareOP(){
		//비교연산자에 대해 알아보자
		//비교연산의 결과는 boolean(ture, false)반환
		//동등 비교 : 값의 일치, 붙일여부를 판단
		//기본자료형 : ==, !=
		//참조자료형 : equals(); -> 메소드 (기능)
		//대소 비교 : 값의 크기를 비교->크다 작다 크거나같다 작거나같다
		//숫자형자료형에 적용
		//<,>,<=,>=
		
		int num=20;
		int num2=30;
		int num3=20;
		
		System.out.println("num은 num2와 같니? "+(num==num2));
		System.out.println("num은 num3와 같니? "+(num==num3));
		
		//불일치 !=
		System.out.println("num과 num2는 일치하지않지? "+(num!=num2));
		System.out.println("num과 num3는 일치하지않지? "+(num!=num3));
		
		double bnum=0.123;
		double bnum2=0.222;
		System.out.println(bnum==bnum2);
		System.out.println(bnum!=bnum2);
				
		//char형 동등비교하기
		char ch='A';
		char ch1='a';
		char ch2='A';
		System.out.println("ch==ch1 : "+(ch==ch1));
		System.out.println("ch==ch2 : "+(ch==ch2));
		System.out.println("ch!=ch1 : "+(ch!=ch1));
		
		//문자열을 동등비교하기 클래스(창조형자료형)을 비교하는 것임
		//equals()메도스를 이용
		String str="김수진";
		String str1="박수진";
		String str2="김수진";
		String str3=new String("김수진"); //객체를 새로만듬
	
		System.out.println("str==str1 : "+(str==str1));
		System.out.println("str==str2 : "+(str==str2));
		System.out.println("str==str3 : "+(str==str3));
		System.out.println(str+" "+str3); //같은데 false
		
		//문자열을 비교할때는 반드시 equals로 비교한다
		//변수명||문자열리터럴.equals(비교할 문자열변수||리터럴)
		System.out.println("str.equals(str3) : "+(str.equals(str3)));
		System.out.println("김수진".equals(str));
		
		//1. import java.utill.Scanner;
//		Scanner sc=new Scanner(System.in);
//		System.out.print("당신의 이름은 : ");
//		String name=sc.next();
//		System.out.println(str==name);
//		System.out.println(str.equals(name));
		
		
		//대소비교하기
		num=100;
		num2=200;
		num3=90;
		System.out.println("=====대소비교하기====");
		System.out.println("> "+(num>num2));
		System.out.println("< "+(num<num2));
		System.out.println("<= "+(num<=num2));
		System.out.println("<= "+(num<=num3));
		System.out.println(">= "+(num>=num3));
		
//		System.out.println("당신의 나이? : ");
//		int age=sc.nextInt();
//		System.out.println(age>19); //true성인 false미성년
		
		
		//char은 대소비교가 가능할까?
		ch='A';
		ch2='B';
		char ch3='c';
		System.out.println("'A'<'B'"+(ch<ch2));
		System.out.println("'A'>'B'"+(ch>ch2));
		
		//입력받은값이 알파벳 대문자인지 확인하는 기능
		System.out.println('A'<=ch3&&'Z'>=ch3);
		System.out.println('Z'>=ch3);
		
		
		//문자열은 대소비교가능하니?
//		System.out.println(str<name); //불가
	}	
	public void logicOP() {
		//논리연산자에 대해 알아보자
		//논리를 and, or로 연결한 결과를 true,false로 출력해주는 것
		//&&(and) : 그리고 두개의 논리가 모두 true일때 true 반환
		//||(or) : 또는 두개의 논리가 하나라도 true이면 true 반환
		//일반적으로 비교연산, boolean반환해주는 메소드를 이용해서 논리연산을 사용
		
		//id가 admin이고 pasword가 1234가 맞니?
		String id="user01";
		String pass="1234";
		boolean result=id.equals("admin")&&pass.equals("1234");
		System.out.println(result);
		
		id="admin";
		result=id.equals("admin")&&pass.equals("1234");
		System.out.println(result);
		
		pass="4444";
		result=id.equals("admin")&&pass.equals("1234");
		System.out.println(result);
		
		
		
		//입력받은 나이가 19세 이상이고 사는지역이 서울이면 true, 아니면 false출력
		
		Scanner sc=new Scanner(System.in);
		
//		System.out.print("나이 : ");
//		int age = sc.nextInt();
//		System.out.print("사는지역 : ");
//		String a = sc.next();
//		
//		result = age>=19&&a.equals("서울");
//		System.out.println(result);
		
		
		
		//숫자의 범위를 나타낼때 사용
		int su=20;
		//result=1<su<10; //인식못함
		result=1<su&&su<10;
		System.out.println(result);
		
		
		//or ||
		//둘중 하나만 true면 true
		
		//사는지역이 서울이나 경기도면 true, 아니면 false	
		String addr="서울";
		System.out.println(addr.equals("서울")||addr.equals("경기도"));
		
//		su<10||su>20
		
		
		//서울이나 인천사는 사람
		//20대 이면서 서울사는 사람
		//20대: 나이가 20살 이상이고 29이하 인사람==20대 주소지가 서울이랑 일치하는 사람
		int age=24;
		System.out.println(age>=20&&age<=29&&addr.equals("서울"));
		//20대 이거나 30대인 사람
		//나이가 20살이상이고 29살이하 또는 나이가 30이상이고 39살 이하인 사람
		System.out.println(age>=20&&age<=20||age<=30&&age<=39);
		//* 논리연산은 여러개 사용할 수 있다
		
		
		//사는곳이 서울또는 인천이면서 30대인 사람 조회하기
		System.out.print("사는곳 : ");
		addr=sc.next();
		System.out.print("나이 : ");
		age=sc.nextInt();
		//연산자 우선순위에 주의할것!
		System.out.println((addr.equals("서울")||addr.equals("인천"))&&age>=30&&age<=39);
		
		
	}
	
	public void complexOP() {
		//복합대입연산자
		//+=, -=, *=, /=
		//특정변수에 값을 누적하거나 차감 하는 로직을 작성할때 사용
		int sum=0;
		sum=sum+10;
		System.out.println(sum);
		sum=sum+20;
		System.out.println(sum);
		sum+=100;//sum=sum+100
		System.out.println(sum);
		
		String msg="입력";
		msg=msg+"추가내용";
		System.out.println(msg);
		
		msg+="내용2";
		System.out.println(msg);
		
		sum-=100;
		System.out.println(sum);
		
		
		//용돈관리기능, 잔고에 대한 내역관리
		//출력해줄 페이지를 구성할때 사용
		String page="<html>";
		page+="<head>";
		page+="<title>이전 내페이지</title>";
		page+="<head>";
		page+="<head>";
		page+="<head>";
		page+="<head>";
		System.out.println(page);
		
		int total, value; 
		total=3000;
		Scanner sc=new Scanner(System.in);
		System.out.println("==용돈관리프로그램==");
		System.out.print("지출,수입 입력 : ");
		
		System.out.println("1. 수입");
		System.out.println("2. 지출");
		System.out.print("번호입력 : ");
		int flag=sc.nextInt();
		
		//total+=sc.nextInt();
		value=sc.nextInt();
		total+=value;
		System.out.println("현재 잔액: "+total+"원");
		System.out.print("지출,수입 입력 : ");
		//total+=sc.nextInt();
		value=sc.nextInt();
		total+=value;
		System.out.println("현재 잔액: "+total+"원");
		System.out.print("지출,수입 입력 : ");
		//total+=sc.nextInt();
		value=sc.nextInt();
		total+=value;
		System.out.println("현재 잔액: "+total+"원");
		
		
		
		//수학 영어 국어 코딩 점수를 입력받고
		//합계와 평균을 출력하는 기능 군현하기 * 전체값을 저장하는 변수는 한개만 선언
		//* 복합대입연산자를 이용해보세요!
		//public void calcGrade()
		
		//사용자에게 문자열을 4개 입력받고 입력받은 문자열 한번에 모두 출력하기
		//public void inputMsgPrint()
		
		//사용자에게 숫자를 입력받아 합계를 구하는 기능 구현하기
		//public void calcInputNum()
		
		
	}
	public void thirdOP() {
		// 상황연산자 이용하기
		// 조건식(true||false) ? true일때 실행내용 : false일때 실행내용;
		
		//입력받은 값이 10보다 크면 우와 크다를 출력, 작으면 우와 작다 출력
		Scanner sc=new Scanner(System.in);
		System.out.print("숫자입력 : ");
		int su=sc.nextInt();
		String result=su>10 ? "우와 크다" : "우와 작다";
		System.out.println(result);
		
		
		//점수를 입력받아 60점 이상이면 합격출력 아니면 불합격출
		System.out.print("점수 : ");
		int grad=sc.nextInt();
		result=grad>=60 ? "합격" : "불합격";
		System.out.println(result);
		
		
		//아이디와 패스워드를 입력받아 아이디가 admin이고 패스워드가 user01이면
		//로그인성공 아니면 로그인실패
		sc.nextLine();
		System.out.print("아이디: ");
		String id=sc.nextLine();
		System.out.print("비밀번호: ");
		String pass=sc.nextLine();
		result=id.equals("admin")&&pass.equals("user01") ? "성공" : "실패";
		System.out.println(result);
			
		
	}
	
}
