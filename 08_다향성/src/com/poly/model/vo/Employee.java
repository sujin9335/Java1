package com.poly.model.vo;

public class Employee extends Person{

	
		private int salary;
		private double bonus;
		
		public Employee(){}

		public Employee(String name, int age, double hight, int salary, double bonus) {
			super(name, age, hight);
			this.salary = salary;
			this.bonus = bonus;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public double getBonus() {
			return bonus;
		}

		public void setBonus(double bonus) {
			this.bonus = bonus;
		}
		
		
		
}
