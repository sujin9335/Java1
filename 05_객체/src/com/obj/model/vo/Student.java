package com.obj.model.vo;

public class Student {
	//프로젝트에서 학생에 대한 정보를 저장,관리하는 역할
	public final int studentNo;
	public String name;
	public int age;
	public int grade;
	public int classNum;
	public double height;
	public String address;
	private static int no=0; //static에 따로 저장되서 계속 누적됨
	
	//초기화블록 선언하기
	{
		System.out.println("학생생성");
		studentNo=++Student.no;
		if(studentNo<10) {
			
		}
		
	}
	static {
		System.out.println("static 초기화블록 실행");
		Student.no=0;
	}
	
	
	
}
