package com.student.controller;

import com.student.model.dao.StudentDao;
import com.student.model.vo.Student;
import com.student.view.StudentView;

public class StudentController {
	//객체 singLeton패턴으로 구현하기 (new 로선언하는거 하나로 통일)
	private static StudentController controller;
	private StudentController() {}
	public static StudentController getController() {
		if(controller==null) controller=new StudentController();
		return controller;
	}
	
	
	private StudentDao dao=StudentDao.getDao();
	//서비스를 진행하는 역할
	
	//1.main메뉴를 축력해주는 기능
	public void mainMenu() {
		StudentView.getView().mainMenu();
	}
	
	//2.학생등록서비스 기능
	public void insertStudent() {
		//1. 학생등록하는 화면을 실행
		Student s=StudentView.getView().inputStudentView();
//		System.out.println(s.infoStudent());
		//2. StudentDao 입력학생을 저장하기
		int result=dao.saveStudent(s);
		String msg="";
		switch(result) {
			case 0 : msg="학생저장 성공";break;
			case 1 : msg="중복학생입니다 저장할 수 없습니다";break;
			case 2 : msg="저장공간이 부족하여 저장할 수 없습니다";break;
		}
		//3. 저장결과를 사용자에게 출력
//		StudentView.getView().printMsg(result?"학생저장성공":"학생저장실패");
		StudentView.getView().printMsg(msg);
		
	}
	
	//3.전체학생을 조회하는 기능
	public void searchAll() {
		//dao에 저장되어있는 학생정보를 가져오기 -> StudentDao
		String searchStudent=dao.searchAll();
		
		//가져온 데이터를 출력 -> StudentView
		StudentView.getView().printStudent(searchStudent);
		
	}
	
	public void searchName() {
		//이름으로 조회하는 기능
		String searchName=StudentView.getView().inputName();
		String result=dao.searchName(searchName);
		StudentView.getView().printStudent(result);
	}
	
}
