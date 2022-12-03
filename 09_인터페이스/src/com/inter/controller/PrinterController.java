package com.inter.controller;

import com.inter.common.PrintDriver;
import com.inter.printDriver.CannonPrinter;

public class PrinterController {

//	private SamsungPrinter sp=new SamsungPrinter();
//	private LGPrinter lp=new LGPrinter();
	private CannonPrinter cp=new CannonPrinter();
	private PrintDriver driver;
	
	
	public PrinterController(PrintDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	
	public void printDate() {
//		sp.print();
//		lp.print();
//		cp.cannonPrint();
		
		driver.print();
		driver.test();
		
	}
	public void scannerDtat() {
		driver.scanner();
	}
	
}
