package com.student.model.vo;

import java.util.Objects;

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
	
	public Student(String name,int age,char gender,String address,
					String phone,String email,String major) {

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
	
	public String infoStudent() {
		return name+" "+age+" "+gender+" "+phone+" "+email+" "+address+" "+major;
	}
	
	@Override
	public boolean equals(Object o) {
		Student s=(Student)o;
		if(this.name.equals(s.name)&&this.age==s.age
						&&this.gender==s.gender
						&&this.phone.equals(s.phone)
						&&this.email.equals(s.email)
						&&this.address.equals(s.address)
						&&this.major.equals(s.major)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name,age,gender,phone,email,address,major);
	}
	
	@Override
	public String toString() {
		return name+" "+age+" "+gender+" "+phone+" "+email+" "+address+" "+major;
	}
	
	
	
}
