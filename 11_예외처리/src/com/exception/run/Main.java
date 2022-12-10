package com.exception.run;

import java.io.IOException;

import com.exception.common.MyException;
import com.exception.common.MyRunException;
import com.exception.controller.ExceptionTest;

public class Main {
	public static void main(String[] args) {
		ExceptionTest et=new ExceptionTest();
//		et.unchekedException();
//		et.exceptionResolved();
		try {
			et.checkedException();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//나의 Exception 발생시키기
		try {
			throw new MyException("나만의 예외!!");//checkedException
		}catch(MyException e) {
			e.printStackTrace();
		}
		
		
		throw new MyRunException("RunTimeException상속 예외");
		
	}
}
