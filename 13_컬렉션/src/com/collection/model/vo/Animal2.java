package com.collection.model.vo;

import java.util.Objects;

public class Animal2 implements Comparable{

	private String name;
	private int age;
	private String type;
	
	public Animal2() {
		// TODO Auto-generated constructor stub
	}

	public Animal2(String name, int age, String type) {
		super();
		this.name = name;
		this.age = age;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Animal2 [name=" + name + ", age=" + age + ", type=" + type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal2 other = (Animal2) obj;
		return age == other.age && Objects.equals(name, other.name) && Objects.equals(type, other.type);
	}
	
	@Override
	public int compareTo(Object o) {
		return this.age-((Animal2)o).age ;
	}
	
	
}
