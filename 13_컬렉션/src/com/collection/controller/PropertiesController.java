package com.collection.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesController {

	public static void main(String[] args) {
		//Properties클래스 이용하기
		//map방식으로 처리 -> key, value로 되어있음
		//파일과 연결해서 데이터를 관리할 수 있음
		//프로그램에서 사용자맞는 설정값, 환결설정내용을 관리할 때 사용할 수 있음
		Properties props=new Properties();
		//데이터 저장 -> key 문자열, value 문자열
		props.put("name", "유병승");
		props.put("email", "asdf@asdf");
		props.setProperty("phone", "01093356987");
		props.setProperty("address", "서울시 강남구");
		System.out.println(props);
		
		//저장된값을 간편하게 파일로 저장시킬 수 있음
		//store()메소드 제공
//		try {
//			props.store(new FileOutputStream("test.properites"),"");
//			props.storeToXML(new FileOutputStream("test.xml"), "xmltest");
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
		
		//저장된 데이터 가져오기
		//load()
		Properties loadProps=new Properties();
		try {
			System.out.println("가져오기 전 loadProps내용");
			System.out.println(loadProps);
			loadProps.load(new FileInputStream("test.properites"));
			System.out.println("가져오기 후 loadProps내용");
			System.out.println(loadProps);
			//불러온 데이터 출력하기
			//getProperty();
			System.out.println(loadProps.getProperty("name"));
			
			loadProps.load(new FileReader("driver.properties"));
			System.out.println("driver : "+loadProps.getProperty("driver"));
			System.out.println("url : "+loadProps.getProperty("url"));
			
			//xml파일 불러오기
			loadProps.loadFromXML(new FileInputStream("test.xml"));
			System.out.println(loadProps.getProperty("name"));
			System.out.println(loadProps.getProperty("test"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
