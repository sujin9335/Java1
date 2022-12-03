package com.poly.main;

import com.poly.abstracttest.model.vo.AbstractChild;
import com.poly.abstracttest.model.vo.AbstractTest;
import com.poly.abstracttest.model.vo.InnerAbstractMethod;
import com.poly.abstracttest.model.vo.TestChild;
import com.poly.abstracttest.model.vo.TestChild2;

public class AbstractMain {

	public static void main(String[] args) {
//		AbstractTest at=new AbstractTest(); //객체화가 불가능함
		
		AbstractChild ac=new AbstractChild();
		ac.setName("김수진");
		System.out.println(ac.getName());
		//추상클래스 타입으로 사용이 가능
		AbstractTest at=new AbstractChild();
		
		//추상메소드를 포함하고 있는 클랫느느 반드시 추상클래스로 선언해야한다
		InnerAbstractMethod iam=new TestChild();
		iam.testAbstract();
		
		test(new TestChild());
//		test(new AbstractChild()); //안됨
		test(new TestChild2());
				
		//추상메소드가 선언된 클래스는 익명클래스로 생성할 수 있음
		InnerAbstractMethod in=new InnerAbstractMethod() {
			@Override
			public void testAbstract() {
				System.out.println("익명클래스로 구현한 메소드");
			}
		};
		
		test(in);
		
	}
	public static void test(InnerAbstractMethod param) {
		param.testAbstract();
	}
	
	
	
}
