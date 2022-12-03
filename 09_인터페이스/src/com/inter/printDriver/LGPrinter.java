package com.inter.printDriver;

import com.inter.common.PrintDriver;

public class LGPrinter implements PrintDriver{

	public void PrintLG() {
		System.out.println("LG프린터 인쇄중....");
	}
	
	@Override
	public void print() {
		PrintLG();
	}
	
	@Override
	public void test() {
		System.out.println("LG가 재정의했음test()");
	}
}
