package com.inter.common;

public interface PrintDriver {

	void print();
//	void scanner();
	default void scanner() {
		System.out.println("스캐너작동중");
	}
	
	//기본메소드를 선언하게 하자
	//default메소드
	default void test() {
		System.out.println("기본메소드 추가하기");
	}
}
