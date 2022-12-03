package com.inter.main;

import com.inter.controller.PrinterController;
import com.inter.printDriver.LGPrinter;

public class PrinterMain {

	public static void main(String[] args) {
		
		new PrinterController(new LGPrinter()).printDate();
		
	}
}
