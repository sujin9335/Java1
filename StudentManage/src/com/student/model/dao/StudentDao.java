package com.student.model.dao;

import com.student.model.vo.Student;

public class StudentDao {
	private static StudentDao dao;
	private StudentDao() {}
	public static StudentDao getDao() {
		if(dao==null) dao=new StudentDao();
		return dao;
	}
	
	
	//입력된 학생(생성된 Student객체)을 관리하는 역할
//	private Student s1;
//	private Student s2;
//	private Student s3;
	//객체배열로 데이터 저장하기
	private Student[] students=new Student[10];
	
	
	
	public int saveStudent(Student s) {
		//boolean result=true;
//		if(this.s1==null) {
//			this.s1=s;
//		}
//		else if(this.s2==null) {
//			this.s2=s;
//		}
//		else if(this.s3==null) {
//			this.s3=s;
//		}
//		else {
//			result=false;
//		}
		int result=2; // 0: 저장성공 1:중복 2:저장공간부족
		//저장되는 값과 동일한 학생이 있는지 확인하고
		//중복학생이 있으면 저장하지 않도록 기능을 구현
		for(Student saveStudent : students) {
			if(saveStudent!=null&&saveStudent.equals(s)) return 1;
		}
		
		
		for(int i=0; i<students.length; i++) {
			//저장소에 null인곳에 매개변수값을 저장
			if(students[i]==null) {
				students[i]=s;
				result=0;
				break;
			}
		}
		
		
		return result;
	}
	
	public String searchAll() {
		String result="";
		//필드에 저장된 학생을 반환해주는 기능
//		if(s1!=null) result+=s1.infoStudent()+"\n";
//		if(s2!=null) result+=s2.infoStudent()+"\n";
//		if(s3!=null) result+=s3.infoStudent()+"\n";
//		System.out.println(result);
		for(Student s : students) {
			if(s!=null) result+=s.infoStudent()+"\n";
		}
		return result;
	}
	
	public String searchName(String searchName) {
		//매개변수로 전달된 값이랑 저장된 student객체들의 이름을
		//비교해서 일치하는 student 반환해주는 기능
		String result="";
//		if(s1!=null&&s1.getName().equals(searchName)) {
//			result+=s1.infoStudent()+"\n";
//		}
//		if(s2!=null&&s2.getName().equals(searchName)) {
//			result+=s2.infoStudent()+"\n";
//		}
//		if(s3!=null&&s3.getName().equals(searchName)) {
//			result+=s3.infoStudent()+"\n";
//		}
//		for(int i=0; i<students.length; i++) { //아랫것도 가능함
//			if(students[i]!=null&&students[i].getName().equals(searchName)) {
//				result+=students[i].infoStudent()+"\n";
//			}
//		}
		
		for(Student s : students) { //이것도 가능함
			if(s!=null&&s.getName().equals(searchName)) {
				result+=s.infoStudent()+"\n";
			}
		}
		
		
		
		return result;
	}
	
}
