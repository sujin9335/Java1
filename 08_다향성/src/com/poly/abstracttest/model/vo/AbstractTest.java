package com.poly.abstracttest.model.vo;

//추상클래스는 abstract 예약어를 사용해서 선언
public abstract class AbstractTest {
	//클래스를 생성하는 것이 불가능해짐
	//상속하여 사용
	
	//일반클래스가 가지는 모든 요소를 선언할 수 있음
	
	private String name;
	
	public AbstractTest() {
		// TODO Auto-generated constructor stub
	}

	public AbstractTest(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
