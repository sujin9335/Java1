package com.inter.model.vo;

import com.inter.common.BasicInterface;
import com.inter.common.BasicInterface2;

public class BasicInterfaceClass implements BasicInterface, BasicInterface2 {

	//인터페이스는 구현하면 인터페이스에 서언된 메소드를 모두 재정의 해야한다
	@Override
	public void test() {
		System.out.println("인터페이스내용 재정의");
	}
	
	@Override
	public int calc(int su, int su2) {
		return su+su2;
	}
	
	@Override
	public String sum(String str, String str2) {
		return str+str2;
	}
	
	@Override
	public boolean result(String str) {
		for(int i=0; i<str.length(); i++) {
			if('A'<=str.charAt(i)&&str.charAt(i)<='Z') {
				return true;
			}
		}
		return false;
	}
	
	
	
	
}
