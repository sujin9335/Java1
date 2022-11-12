package com.control.controller;
import java.util.Scanner;
public class ConditionController {
	public void iftest() {
		//if문에 대해 알아보자
		//if(조건식){조건식 true일때 실행하는 구문}
		//if의 {}에는 변수선언,연산자,메소드호출,조건문 등 다 사용이 가능하다
		//조건식 : true,false 값을 가지는 비교,논리연산 또는 메소드를 작성할 수 있다
		if(100>10) {
			System.out.println("100은 10보다 크다");
		}
		System.out.println("이건 if문 밖에 있는 구문");
		
		//사용자에게 수를 입력받아 입력받은 수가 20이면 20을 입력했네요 출력
		Scanner sc=new Scanner(System.in);
//		System.out.println("수입력: ");
//		int su=sc.nextInt();
//		if(su==20) {
//			System.out.print("20을 입력했네요");
//		}
//		
//		//입력받은 이름이 본인이름이면 참 이쁜이름이네요 출력
//		System.out.println("이름 : ");
//		String name=sc.next();
//		if(name.equals("김수진")) {
//			System.out.print("참 이쁜이름이네요");
//		}
		
		
		//나이가 20대면 열심히 공부해서 취업해야지
//		System.out.println("나이 : ");
//		int age = sc.nextInt();
//		if(age>=20&&age<30) {
//			System.out.println("열심히 공부해서 취업해야지");
//		}
		
		
		
		//입력받은 값이 5배수인지 확인하는 기능 구현하기
		//입력값이 5의 배수인경ㅇ 5의 배수입니다 출력
		//public void checkNumber(){}
		
		//아이디와 패스워드를 입력받아 아이디가 admin이고 패스워드가 9876이면
		//이름, 나이, 성별,전화번호를 입력받아 한번에 출력하는 기능
		//public void adminCeck(){}
		
		
		
		
		//if안에 변수를 선언이 가능
		//if안에 선언된 변수는 if내부에서만 사용이 가능함
		//if외부에서 선언된변수는 if내부에서도 사용이 가능함
		
		String outterData="if외부선언값";
		if(10>0) {
			String innerData="if내부선언값";
			System.out.println(outterData);//외부에서 선언된 데이터를 가겨옴
			System.out.println(innerData);
			//외부에서 선언한 변수의 이름을 사용 불가
			//String outterData="호호호";//사용불가
		}
		//System.out.println(innerData); //if내부에서 선언되서 if밖에서 사용불가
		
		
		//if문내부에서 다시 if문을 사용할 수 있다
		//성인인지 확인하고 성인이면 성별을 확인기 남자면 성인남자, 여자면 성인여자
		int age;
		System.out.print("나이는 : ");
		age=sc.nextInt();
		if(age>19) {
			System.out.print("성별은 : ");
			char gender=sc.next().charAt(0);
			if(gender=='남') {
				System.out.println("성인남자");
			}
			if(gender=='여') {
				System.out.println("성인여자");
			}
		}
		
	}
	public void ifelseTest() {
		//if~else구문에 대해 알아보자
		//반드시 둘중한개가 실행되는 코드
		//조건문이 true||false
		//true->if문의 중괄호가 실행
		//false->else문의 중괄호가 실행
		//if~else 한개그룹 같이 사용해야함 else문을 별도로 사용할수 없다
		
		
		//입력받은 수가 홀수인지 짝수인지 확인하는 기능
		Scanner sc=new Scanner(System.in);
		System.out.print("수 : ");
		int su=sc.nextInt();
		if(su%2==0) {
			System.out.println("짝수");
		}else {
			System.out.println("홀수");
		}
		//else예약어는 단독으로 사용이 불가
		//else {
		//}
		
		
		//아이디와 패스워드를 입력받고
		//아이디가 user01이고 패스워드가 user01이면
		//로그인 성공 출력, 아니면 로그인 실패 출력
		sc.nextLine();
		System.out.print("아이디: ");
		String id=sc.nextLine();
		System.out.print("비밀번호: ");
		String pass=sc.nextLine();
		
		if(id.equals("user01")&&pass.equals("user01")) {
			System.out.println("로그인 성공");
		}else {
			System.out.println("로그인 실패");
		}
		
		
		
		
		//미성년자만 회원가입 할 수 있는 기능만들기
		//미성년이면 아이디, 패스워드, 이름,별명,나이,키 입력받고 한번에 출력
		//미성년아니면 "성인은 가입할 수 업습니다" 출력
		//public void checkAgeEnroll(){}
		
		
	}
	public void ifelseifTest() {
		//if ~ else if() ~ else if() ~ else
		//계절을 확인하는 기능
		Scanner sc=new Scanner(System.in);
		System.out.print("계절을 확인할 달 : ");
		int month=sc.nextInt();
		//1,2,12
		//3~5
		//6~8
		//9~11
		if(month==1||month==2||month==12) {
			System.out.println("겨울");
		}else if(month>=3&&month<=5) {
			System.out.println("봄");
		}else if(month>=6&&month<=8) {
			System.out.println("여름");
		}else if(month>=9&&month<=11) {
			System.out.println("가을");
		}else {
			System.out.println("1~12값으로 입력하시오");
		}
		
		
		
		
		//성적등급을 출력하는 프로그램 만들기
		//입력받은 점수가 90점 이상이면 A
		//입력받은 점수가 80점 이상이면 B
		//입력받은 점수가 70점 이상이면 C
		//입력받은 점수가 60점 이상이면 D
		//입력받은 점수가 그 외면 F
		//점수와 등급을 출력하기
		System.out.print("점수 : ");
		int score=sc.nextInt();
		char level=' ';
		if(score>=90) {
			level='A';
		}else if(score>=80) {
			level='B';
		}else if(score>=70) {
			level='C';
		}else if(score>=60) {
			level='D';
		}else {
			level='E';
		}
		System.out.println(score+"점 등급은 "+level);
		
		
		
		
		//연령대별 메시지출력하기
		//10대 : 열심히 공부하세요! 좋은대학가야지요!
		//20대 : 열심히 준비하세요! 취직해야지요!
		//30대 : 열심히 일하세요! 돈모아야지요!
		//40대 : 열심히 돈버세요! 자식키워야지요!
		//50대 : 열심히 운동세요! 건강해야지요!
		//public void printMessage(){}
		
		
		
	}
	public void switchTest() {
		//switch문 활용하기
		//정해진 값에 대해서 분기처리할때 사용
		//switch()에 있는 값과 case에 있는 값을 동등비교해서 true가 나오는 구문을 실행
		//주로 메뉴를 만들때 사용
		//switch()안에는 변수,변수의 연산결과,메소드실행결과 넣을 수 있음
		//switch()안의 type int, char, String 세가지만 가능함
		
		System.out.println("=====후식=====");
		System.out.println("1.아이스크림");
		System.out.println("2.케이크");
		System.out.println("3.커피");
		System.out.println("4.과일");
		System.out.println("5.과자");
		Scanner sc=new Scanner(System.in);
		System.out.println("입력 : ");
		int choise=sc.nextInt();
		switch(choise) {
			case 1 : int su=10;System.out.println(su+"시원"); break; //break 안하면 뒤에것도 실행됨
			case 2 : System.out.println("달다"); break;
			case 3 : System.out.println("쓰다"); break;
			case 4 : System.out.println("시다"); break;
			case 5 : System.out.println("짭짭"); break;
			default : System.out.println("1~5숫자만 입력가능");
		}
		
//		if(choise==1) { //위에 케이스문과 똑같이 if문으로 대체가능
//			
//		}else if(choise==2) {
//			
//		}else if(choise==3) {
//			
//		}else if(choise==4) {
//			
//		}else if(choise==5) {
//			
//		}else {
//			
//		}
		
		
		//char형으로 이용하기
		System.out.println("====맥주====");
		System.out.println("가. 블랑");
		System.out.println("나. 블루문");
		System.out.println("다. 카스");
		System.out.println("라. 기네스");
		System.out.println("입력 : ");
		char chchoise=sc.next().charAt(0);
		switch(chchoise) {
			case '가' : System.out.println("블랑블랑");break;
			case '나' : System.out.println("블루블루");break;
			case '다' : System.out.println("카스카스");break;
			case '라' : System.out.println("기네스기네스");break;
			default : System.out.println("가~라 선택");
		}
		
		//String 으로 switch 이용하기
		System.out.println("당신의 취미 입력 (운동, 게임, 넷플릭스, 코딩)");
		String hobby=sc.next();
		switch(hobby) {
			case "운동" : System.out.println("건강");break;
			case "게임" : System.out.println("뿅뿅");break;
			case "넷플릭스" : System.out.println("창궐");break;
			case "코딩" : System.out.println("자바코딩");break;
		}
//		double bnum=180.5; // double 은 switch문 불가
//		switch(bnum) {
//			}
		
//		int num=20;
//		switch(num>10) { //사용불가
//		}
		
//		int num=20;
//		switch(num%3) { //3으로 나눈 나머지 int형이라 가능함
//		}
		
		//의도적으로 break문 생략하기
		int month=1;
		switch(month) {
			case 1 : case 2 : case 12 : System.out.println("겨울");break;
			case 3 : case 4 : case 5 : System.out.println("봄");break;
		}
		
		//나중에 만들것 예시
//		System.out.println("===사원 관리===");
//		System.out.println("1. 전체 사원 조회하기");
//		System.out.println("2. 전체 사원 조회하기");
//		System.out.println("3. 전체 사원 조회하기");
//		System.out.println("4. 전체 사원 조회하기");
//		System.out.println("5. 전체 사원 조회하기");
//		System.out.println("6. 전체 사원 조회하기");
//		System.out.println("0. 프로그램 종료");
//		int menu=sc.nextInt();
//		switch(menu) {
//			case 1 : new EmployeeController().seachAll();break;
//			case 2 : new EmployeeController().seachAll();break;
//			case 3 : new EmployeeController().seachAll();break;
//			case 4 : new EmployeeController().seachAll();break;
//			case 5 : new EmployeeController().seachAll();break;
//			case 6 : new EmployeeController().seachAll();break;
//		}
		
		
		
		
		
		//분식집 주문기능을 만들어보기
		//1. 떡볶이 3000원
		//2. 튀김 2500원
		//3. 순대 4000원
		//4. 참치김밥 4500원
		//1)메뉴를 선택하면 메뉴와 가격을 출력해주기
		// 예) 1선택시 떡볶이를 선택하셨습니다. 3000원 입니다
		//2)메뉴 선택 후 수량을 입력받아 
		// 예) 1선택시 떡볶이를 선택하셨습니다. 몇개 주문하시겠습니까?
		//	3개 -> 떡볶이 3개 9000원입니다. 출력
		
		
		
		//public void ex_test()
		//성인만 가입할 수 있는 회원가입 -> 미성년이면 회원가입불가합니다 출력
		//성인이면 내국인인지 외국인인지 확인하고
		//내국인이면 회원가입으로 내용을 출력 이름, 주소를 변수에 저장후 출력
		//외국인이면 외국인등록번호를 확인(있다. 없다 선택)
		//있으면 회원가입 내용을 출력 이름, 주소 저장후 출력
		//없으면 회원가입이 불가능합니다 출력
		//외국인 등록번호여부를 잘못누른 경우 잘못누르셨습니다 출력 후 프로그램 종료
		
		
		
	}
	
	
}
