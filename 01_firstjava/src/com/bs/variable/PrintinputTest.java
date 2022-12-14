package com.bs.variable;

import java.util.Scanner;

public class PrintinputTest {
	public static void main(String[] args) {
		//내용 출력하기
		//System.out.println(), System.out.pritn();
		//()안에 대입된 내용(리터럴값, 변수)을 console창에 출력해줌
		
		String name = "김수진";
		int age = 19;
		System.out.println(name+" "+age);
		System.out.println("이렇게 출력해봐");
		System.out.print(name+" "+age);
		System.out.print("이렇게 출력해봐");
		
		System.out.println();
		//System.out.printf() 활용하기
		//출력양식을 문자열로 작성하고 값이 대입되는 부분에는 문구를 대입
		//나의 이름은 %s 나이는 %d 
		
		System.out.printf("나의 이름은 %s 나이는 %d 입니다.", name,age);
		//문자열 : %s
		//정수 : %d
		//실수 : %f
		//문자 : %c
		System.out.printf("\n오늘 %s 수업은 %d점 입니다", "자바",50);
		System.out.printf("\n오늘 %5s 수업은 %3d점 평균 %f입니다", "자바",50,54.3);
		System.out.printf("\n오늘 %-5s 수업은 %-3d점 평균 %.2f입니다", "자바",50,54.3);
		
		//문자열에 escape문 출력하기
		//개행, 자바사용하는 기호를 사용, 특정공간을 띄우는 것
		//개행 : \n
		//tab : \t
		//역슬러쉬 : \\
		//큰따옴표 : \"
		//작은따옴표 : \'
		String temp = "안녕 \n오늘 첫구업이였어\t\t 다들 열심히 듣는 것 같아! \"호호\"";
		System.out.println(temp);
		temp = "다운로드경로 : c:\\User\\user";
		System.out.println(temp);
		
		temp = "<p onclick=\"alert('test')\">이거클릭해봐</p>";
		System.out.println(temp);
		
		
		
		//사용자가 키보드에 입력하는 데이터 받아오는 방법
		//1. import java.utill.Scanner; 선언하기
		//2. Scanner를 생성하기
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		//3. 입력받을 데이터 자료형에 맞춰서 입력을 받기 -> 이용하는 사람으로 부터
		// 입력 받을 내용을 사용자에게 출력
		System.out.print("나이 : ");
		int age2 = sc.nextInt(); // 정수를 입력받을 때 사용
		System.out.println(age2);		
		System.out.print("키 : ");
		double height = sc.nextDouble();
		System.out.println(height);
		System.out.print("이름 : ");
		String name1 = sc.next();
		System.out.println(name1);
		//sc.next() : 입력 받는 값에 띄어쓰기가 없는경우
		//sc.nextLine() : 입력 받는 값에 띄어쓰기가 있는경우
		sc.nextLine(); // nextLine 이전에 다른 next가 나오면 한번 비워줘야됨
		System.out.print("주소 : ");
		String address = sc.nextLine();
		System.out.println(address);
		System.out.println("당신의 이름은 "+name1+"이고 나이는 "+age2+ " 키는 "+height+" 사는곳은 "+address);
		
		
		//학생정보를 입력받고 출력하기
		//이름, 나이, 성별, 학년, 반, 번호, 키, 이메일을 입력받고
		//입력받은 내용 한번에 출력하기
		//StudentInfo클래스를 생성해서 구현하라
		
		
		
		
		
	}
}
