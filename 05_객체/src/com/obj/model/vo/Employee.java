package com.obj.model.vo;

public class Employee {
	//핃드를 선언
	public String name;
	public String department;
	public String job;
	public int salary;
	public double bonus;
	
	public Employee() { //생성만, 필드에는 default값으로 초기화
		name="유병승";
		department="강사부";
		job="강사";
		salary=100;
		bonus=0.1;
	}
	public Employee(String name) {
		this.name=name;
	}
	public Employee(String name, String department, String job, int salary, double bonus) {
		this.name=name;
		this.department=department;
		this.job=job;
		this.salary=salary;
		this.bonus=bonus;
	}
	public void EmPrint() {
		System.out.println(name+" "+department+" "+job+" "+salary+" "+bonus);
	}
}	
