package com.exception.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ExceptionTest {

	public void unchekedException() {
		//발생가능성이 있는 예외에 대해 처리구문을 작성하지 않아도 되는
		//예외(Exception)
		//ArithmeticException : 수학적으로 계산이 불가능 할때 발생
		int su=10;
		int su2=0;
//		System.out.println(su/su2);
		System.out.println("여기는 실행하니?");
		//ArrayIndexOutOfBoundsException : 할당된 배열의 인덱스번호를 넘어서 지정했을때
		int[] intArr=new int[3];//0~2
//		System.out.println(intArr[3]);
		
		//ClassCastException : 클래스를 잘못 형변환했을때
		Object o="유병승";
//		Integer i=(Integer)o;
		
		//NumberFormatException : 숫자로 변환되지 않는 문자열을 변환했을때 발생
		String str="10";
		str=null;
//		su=Integer.parseInt(str);
		
		//NullPointerException : 참조형 변수에 null이 있는 상태에서 접근연산자를 사용했을때
		str.length();
		
		//예외가 발생하면 그 코드에서 실행은 멈춘다
		//실행을 중단하지 않고 계속 실행되게 하려면 발생한 예외에 대한 처리를 해줘야 한다
		System.out.println("실행!!");
		
		
		
		
		
	}
	public void exceptionResolved() {
		//발생하는 예외를 처리하기
		//1. try~catch문을 이용해서 처리
		// - 예외가 발생했을때 처리 로직을 직접작성
		//try{
		//	예외발생이 예상이 되는 코드를 작성 
		//}catch(){
		//	예외발생시 처리할 로직 작성
		//}
		int[] intArr= {1,2,3,4,5};
		String str=null;
		try {
			intArr[4]=100;
			System.out.println("이거는 됨?");
			int su=str.length();
			System.out.println("문자열 길이: "+su);
		}catch(ArrayIndexOutOfBoundsException e) {
			int[] temp=new int[intArr.length+1];
			for(int i=0; i<intArr.length; i++) {
				temp[i]=intArr[i];
			}
			intArr=temp;
			intArr[5]=100;
		}catch(NullPointerException e) {
			str="유병승";
			System.out.println("문자열 길이: "+str.length());
		}
		System.out.println(Arrays.toString(intArr));
		
		
		//try{}안에 작성한 변수는 try 안에서만 사용이 가능
		String test="안녕";
		try {
			test.charAt(3);
		}catch(StringIndexOutOfBoundsException e) {
			test="안녕하세요";
			System.out.println(test.charAt(3));
		}
		
		//예외에 대한 처리로직이 동일하다면 하나의 catch문으로 선언 할 수 있다
		try {
			String[] strs= null;
			String temp=strs[0];
			String strTemp="하하";
			Object o=strTemp;
			int intTemp=(Integer)o;
		}catch(ClassCastException|NullPointerException e) {
			System.out.println(e.getMessage());
		}
//		catch(NullPointerException e) {
//			System.out.println(e.getMessage());
//		}
		
		
		//예외클래스도 상속관계가 있음 -> 모든 예외클래스는 Exception클래스를 상속받음
		//부모Exception은 자식Exception을 처리 할 수 있다
		//Exception모든 예외 다 처리할 수 있다
		try {
			String temp=null;
			temp.length();
			
		}catch(NullPointerException e) {
				
		}catch(Exception e) {
			System.out.println("Exception이 예외 처리함");
		}
		System.out.println("Exception 예외처리 후 실행");
		
		
		//예외를 직접 발생시킬 수 있다
		//throw 예외클래스를 생성
		//예) throw new IllegalArgumentException("잘못된 인수 전달될");
		//throw로 예외를 발생하면 
		// checkedException은 반드시 처리해줘야함 -> IOException
		// uncheckedException은 처리하지않아도 됨
		
//		throw new IllegalArgumentException("잘못된 인수입니다");
		
		System.out.println(divided(10,2));
//		System.out.println(divided(10,0));
		
		//finally{} -> 예외가 발생, 예외가 발생하지않아도 무조건 실행되어야 하는 구문을 작성할때 사용
		//파일입출력 시 스트림을 닫아줄때 사용
		try {
			String temp=null;
			temp.length();
		}catch(NullPointerException e) {
			System.out.println("NullPointerException 발생");
			return;
		}finally {
			System.out.println("반드시 실행해야됨");
		}
		
		
		//2. throws예약어를 이용해서 처리
		// - 예외처리구문을 호출하는 곳에 위임
		// - uncheckedException보다는 checkedException에서 많이 사용
		
		
		
		
		
	}
	
	public int divided(int su, int su2) {
		if(su==0||su2==0) {
			throw new IllegalArgumentException("인자값은 0은 될수없습니다");
		}
		return su/su2;
	}
	
	public void checkedException() 
			throws IOException{
		//checkedException은 반드시 처리구문ㄴ을 작성해야하는 예외클래스
		//IOException 클래스 자식클래스들...
//		try {
//			throw new IOException("checkedException");
//		}catch(IOException e) {
//			e.printStackTrace();//에러가 발생한 위치를 알려줌
//			//Exception발생시 출력한 빨강로그...
//		}
		
		//IO관련된 메소드를 호출할때 발생
		try {
			FileReader fr= new FileReader("test.txt");
			fr.read();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
//		try {
			checkedThrowsTest();
//		}catch(FileNotFoundException e) {
//			
//		}
		
		
	}
	//throws로 예외 처리하기
	public void checkedThrowsTest() 
			throws IOException{
		FileReader fr=new FileReader("test.txt");
		fr.read();
	}
	
	//예외클래스 커스터마이징하기
	//시스템에 필요한 예외만들기
	//Exception, RuntimeException, IOException을 상속한
	//클래스를 만들면 Exception 클래스가 된다
	
	
}
