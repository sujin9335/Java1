package com.bs.variable;
	import java.util.Scanner;
public class StudentInfo {
		public static void main(String[] args) {
			//학생정보를 입력받고 출력하기
			//이름, 나이, 성별, 학년, 반, 번호, 키, 이메일을 입력받고
			//입력받은 내용 한번에 출력하기
			//StudentInfo클래스를 생성해서 구현하라
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("나이 : ");
		int age = sc.nextInt();
		System.out.print("성별 : ");
//		String sex = sc.next();
		char sex = sc.next().charAt(0);
		System.out.print("학년 : ");
		int a = sc.nextInt();
		System.out.print("반 : ");
		int b = sc.nextInt();
		System.out.print("번호 : ");
		int c = sc.nextInt();
		System.out.print("키 : ");
		double d = sc.nextDouble();
		sc.nextLine();
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.printf("이름은 %s 이고 나이 %d 성별 %s 학년 %d 반 %d 번호 %d 키 %.1f 이메일 %s 입니다", name,age,sex,a,b,c,d,email);
		
		
		
			
		}
}
