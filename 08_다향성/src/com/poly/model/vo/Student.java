package com.poly.model.vo;

public class Student extends Person {
	
	private int grade;
	private int classNumber;
	
	public Student() {}

	public Student(String name, int age, double hight, int grade, int classNumber) {
		super(name, age, hight);
		this.grade = grade;
		this.classNumber = classNumber;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(int classNumber) {
		this.classNumber = classNumber;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student) {
			Student s=(Student)o;
			if(getName().equals(s.getName())&&grade==s.grade) {
				return true;
			}
				
			}return false;
		}
		
	@Override
	public String toString() {
		return "학생 "+super.toString()+" "+grade;
	}
	
	
	
}
