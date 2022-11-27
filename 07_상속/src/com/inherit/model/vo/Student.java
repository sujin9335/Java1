package com.inherit.model.vo;

public class Student extends Person{


	private int grade;
	private int classNumber;
	private int number;
	
	public Student() {}

	public Student(String name, int age, char gender, String address, int grade, int classNumber, int number) {
		super(name, age, gender, address, null);
//		setName(name);
//		setAge(age);
//		setAddress(address);
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	
	//학생정보를 출력해주는 기능만들기
	public String infoStudent() {
		super.test();//부모 클래스
		test();//자식 클래스
		return getName()+" "+getAge()+" "+grade+" "+classNumber+number; //protected 는 상속이라 불러오기가능
	}
	
	public void test() {
		System.out.println("자식클래스의 test메소드");
	}
	
	//동등성 비교를 위해 equals 오버라이드하기
	@Override
	public boolean equals(Object o) {
		Student s=(Student)o;
		if(this.getName().equals(s.getName())
				&&this.getAge()==s.getAge()
				&&this.getGender()==s.getGender()
				&&this.getAddress()==s.getAddress()){
			
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
//		Object
		return "";
	}
	
	
}
