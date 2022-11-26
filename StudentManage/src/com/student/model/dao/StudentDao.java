package com.student.model.dao;

import com.student.model.vo.Student;

public class StudentDao {
	//입력된 학생(생성된 Student객체)을 관리하는 역할
	private Student s1;
	private Student s2;
	private Student s3;
	
	
	public boolean saveStudent(Student s) {
		boolean result=true;
		if(this.s1==null) {
			this.s1=s;
		}
		else if(this.s2==null) {
			this.s2=s;
		}
		else if(this.s3==null) {
			this.s3=s;
		}
		else {
			result=false;
		}
		return result;
	}
	
}
