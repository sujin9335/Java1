package com.inter.printDriver;

import com.inter.common.PrintDriver;

public class CannonPrinter implements PrintDriver{

	public void cannonPrint() {
		System.out.println("케논프린터 인쇄중....");
	}
	
	@Override
	public void print() {
		cannonPrint();
	}
}
