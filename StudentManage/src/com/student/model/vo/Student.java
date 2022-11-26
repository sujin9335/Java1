package com.student.model.vo;

public class Student {
	
	private long studentNo;
	private static long count=0;
	private String name;
	private int age;
	private char gender;
	private String address;
	private String phone;
	private String email;
	private String major;
	
	{
		studentNo=++count;
	}
	
	
	public Student() {
	}
	
	public Student(long studentNo,String name,int age,char gender,String address,String phone,String email,String major) {
		this.studentNo=studentNo;
		this.name=name;
		this.age=age;
		this.gender=gender;
		this.address=address;
		this.phone=phone;
		this.email=email;
		this.major=major;
	}
		
		
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
		
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
		
	public void setGender(char gender) {
		this.gender=gender;
	}
	public char getGender() {
		return gender;
	}
		
	public void setAddr(String address) {
		this.address=address;
	}
	public String getAddr() {
		return address;
	}
		
	public void setPhone(String phone) {
		this.phone=phone;
	}
	public String getPhone() {
		return phone;
	}
		
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	
	public void setMajor(String major) {
		this.major=major;
	}
	public String getMajor() {
		return major;
	}
	
	public long getStudentNo() {
		return studentNo;
	}
	
	public void infoStudent() {
		
	}
	
}
