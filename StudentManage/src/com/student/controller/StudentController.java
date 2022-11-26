package com.student.controller;

import com.student.model.dao.StudentDao;
import com.student.model.vo.Student;
import com.student.view.StudentView;

public class StudentController {
	private StudentDao dao=new StudentDao();
	//서비스를 진행하는 역할
	
	//1.main메뉴를 축력해주는 기능
	public void mainMenu() {
		new StudentView().mainMenu();
	}
	
	//2.학생등록서비스 기능
	public void insertStudent() {
		//1. 학생등록하는 화면을 실행
		Student s=new StudentView().inputStudentView();
//		System.out.println(s.infoStudent());
		//2. StudentDao 입력학생을 저장하기
		boolean result=dao.saveStudent(s);
		//3. 저장결과를 사용자에게 출력
		new StudentView().printMsg(result?"학생저장성공":"학생저장실패");
		
	}
}
