package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.model.vo.Student;

public class StudentView {
//사용자에게 화면을 출력해주는 역할
	//1. 메인화면 출력
	//2. 시스템 메세지를 출력
	//3. 입력화면을 출력해준다(학생, 학생수정, 삭제)
	public void mainMenu() {
		//프로그램이 시작되면 기능을 선택하게 하는 화면
		//mainMenu
		Scanner sc=new Scanner(System.in);
		StudentController controller=new StudentController();
		
		do {
			System.out.println("====== 학생관리 프로그램 v0.1 =====");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			System.out.println("4. 이름으로 조회");
			System.out.println("5. 전공으로 조회");
			System.out.println("6. 프로그램 종료");
			System.out.print("입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1 : controller.insertStudent();break;
				case 2 : System.out.println("개발중...");break;
				case 3 : System.out.println("개발중...");break;
				case 4 : System.out.println("개발중...");break;
				case 5 : System.out.println("개발중...");break;
				case 0 : System.out.println("학생관리프로그램을 종료하겠습니다");return;
				default : System.out.println("잘못된 메뉴를 선택하셨습니다");break;
			}
		}while(true);
	}
	
	public void printMsg(String msg) {
		System.out.println("===== 시스템 메세지 =====");
		System.out.println("내용: "+msg);
		System.out.println("=====================");
	}
	
	public Student inputStudentView() {
		Scanner sc=new Scanner(System.in);
		
		Student s=new Student();
		System.out.println("====== 학생 등록 ======");
		System.out.print("이름: ");
		String name=sc.nextLine();
		s.setName(name);
		System.out.print("나이: ");
		int age=sc.nextInt();
		s.setAge(age);
		System.out.print("성별: ");
		char gender=sc.next().charAt(0);
		s.setGender(gender);
		System.out.print("주소: ");
		sc.nextLine();
		String address=sc.nextLine();
		s.setAddr(address);
		System.out.print("전화번호: ");
		String phone=sc.nextLine();
		s.setPhone(phone);
		System.out.print("이메일: ");
		String email=sc.nextLine();
		s.setEmail(email);
		System.out.print("전공: ");
		String major=sc.nextLine();
		s.setMajor(major);
		return s;
		
	}
	
	
	
	
	
	
	
}
