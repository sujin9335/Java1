package com.poly.abstracttest.model.vo;

public abstract class InnerAbstractMethod {

	//추상메소드선언하기
	//메소드 선언부에 abstract메소드를 사용하고, 메소드 선언부만 선언해놓은것
	//상속받은 클래스에서 반드시 구현(Override)해야하는 메소드 -> 메소드를 강제하기 때문에
	//자식클래스에는 반드시 추상메소드가 구현되어있다는 것을 보장함
	public abstract void testAbstract();
	
	
	
	
}
