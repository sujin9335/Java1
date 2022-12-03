package com.inter.printDriver;

import com.inter.common.PrintDriver;

public class SamsungPrinter implements PrintDriver{
	
	public void printSamsung() {
		System.out.println("삼성프린트 인쇄중....");
	}
	
	@Override
	public void print() {
		printSamsung();
	}
}
