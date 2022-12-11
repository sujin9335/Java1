package com.student.view;

import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.model.vo.Student;

public class StudentView {
	private static StudentView view; // view 가 studentView 클래스 
	private StudentView() {} //생성자 막은것
	public static StudentView getView() {
		if(view==null) view=new StudentView();
		return view;
	}
	
//사용자에게 화면을 출력해주는 역할
	//1. 메인화면 출력
	//2. 시스템 메세지를 출력
	//3. 입력화면을 출력해준다(학생, 학생수정, 삭제)
	public void mainMenu() {
		//프로그램이 시작되면 기능을 선택하게 하는 화면
		//mainMenu
		Scanner sc=new Scanner(System.in);
		StudentController controller=StudentController.getController();
		
		do {
			System.out.println("====== 학생관리 프로그램 v0.1 =====");
			System.out.println("1. 학생등록");
			System.out.println("2. 학생수정");
			System.out.println("3. 학생삭제");
			System.out.println("4. 전체조회");			
			System.out.println("5. 이름으로 조회");
			System.out.println("6. 전공으로 조회");
			System.out.println("7. 저장하기");
			System.out.println("8. 불러오기");	
			System.out.println("0. 프로그램 종료");
			System.out.print("입력: ");
			int menu=sc.nextInt();
			switch(menu) {
				case 1 : controller.insertStudent();break;
				case 2 : System.out.println("개발중...");break;
				case 3 : System.out.println("개발중...");break;
				case 4 : controller.searchAll();break;
				case 5 : controller.searchName();break;
				case 6 : System.out.println("개발중...");break;
				case 7 : controller.saveData();break;
				case 8 : controller.loadData();break;
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
	
	public void printStudent(String data) {
		System.out.println("======조회한 정보=====");
		if(data.length()>0) System.out.println(data);
		else System.out.println("조회된 결과가 없습니다");
		System.out.println("===================");
	}
	
	public String inputName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("===== 이름으로 조회 =====");
		System.out.print("검색할 이름: ");
		return sc.nextLine();
		
	}
	
	
	
	
}
