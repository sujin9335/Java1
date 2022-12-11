package com.file.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.file.model.vo.Person;

public class FileStreamController {

	public void fileSave() {
		//애플리케이션에서 관리하는 데이터(RAM)를 특정파일(HDD)에 저장하는 기능
		//1. FileOutputStream클래스를 생성
		//	매개변수있는 생성자를 이용
		//	1) string으로 파일의 경로+파일명을 전달하는 생성자
		//	2) File객체를 전달하는 생성자
		//2. 전송할 데이터를 write(int)메소드를 이용해서 전송
		//	1) byte단위 통신으로 int형으로 데이터를 전송 -> 일반문자열은 X
		//	2) 전체데이터를 전송할때까지 write()메소드를 반복실행
		//3. 반드시 생성된 FileOutputStream클래스를 반환(닫아주기)해야함
		// close();메소드 이용
		FileOutputStream fos=null;
		try {
			//fileOutputStream을 생성하면 매개변수 이름의 파일이 없으면
			//자동으로 해당경로에 파일을 생성해서 stream을 연결함
			String name="유병승";
			fos=new FileOutputStream("testfile");
			fos.write(10);
			fos.write(65);
			fos.write('a');
			fos.write(name.charAt(0));
			fos.write(name.charAt(1));
			fos.write(name.charAt(2));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally { //반드시 닫아줘야되서 finally실행
			try {
				if(fos!=null)fos.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	public void loadFile() {
		//HDD에 저장된 파일 애플리케이션으로 읽어오기
		//1. FileInputStream을 생성
		//	매개변수있는 생성자를 이용
		//	1) String으로 경로와 파일명 전달
		//	2) File객체를 전달
		// * 지정한파일이 없으면 exception 발생함
		//2. read()메소드를 이용해서 파일에 저장된 내용을 불러옴
		// int형으로 데이터를 가져옴 가져온데이터는 변수에 저장시켜야 재사용가능
		// 저장된 데이터의 크기나, 값을 얻기 때문에 ㅣ준이 read()메소드를 실행했을때 반환값이
		// -1이 나오면 데이터를 모두 읽어 온 것임 -> read()메소드가 -1을 반환할때까지 실행(반복문)
		//3. 반드시 FileInputStream클래스를 반환해줘야함
		//	close()메소드 이용
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("testfile");
			//데이터를 일어오기 전체데이터를 읽어올때
			//반복문
			int value=0;
			while((value=fis.read())!=-1){
				System.out.println((char)value);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis!=null)fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	}
	
	//문자열을 저장하기 위해서는
	//Reader, Writer클래스 상속받는 클래스를 이용
	//FileReader, FileWriter를 사용
	public void saveFileStr() {
		FileWriter writer=null;
		try {
			writer=new FileWriter("strdata");
			String name="유병승";
			int age=19;
			writer.write(name);
			writer.write(age);
			writer.write("19");
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer!=null)writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void loadFileStr() {
		FileReader fr=null;
		try {
			fr=new FileReader("strdata");
			int value=0;
			//StringBuffer sb=new StringBuffer();
			String str="";
			while((value=fr.read())!=-1){
//				System.out.println((char)value);
//				sb.append((char)value);
				str+=(char)value; // 새로운 객체를 계쏙만들어서 버퍼쓰는게 효율적임
				
			}
//			System.out.println(sb);
			System.out.println(str);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fr!=null)fr.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void memoFile() {
		Scanner sc=new Scanner(System.in);
		FileWriter writer=null;
		try {
			writer=new FileWriter(new File("mono"),true);//writer에서 뒤에 true주면 누적
			for(int i=0; i<3; i++) {
				System.out.print("메세지 입력 : ");
				String str=sc.nextLine()+"\n";
				writer.write(str);
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(writer!=null)writer.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	
	
	
	
	
	}
	
	public void memoLoad() {
		//try with resource구문 사용하기
		try(FileReader fr=new FileReader("mono");){
			int value=0;
			StringBuffer sb=new StringBuffer();
			while((value=fr.read())!=-1) {
				sb.append((char)value);
			}
			System.out.println(sb);
			String[] message=new String(sb).split("\n");
			for(int i=0; i<message.length; i++) {
				System.out.println((i+1)+"번째 메세지 : "+message[i]);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//파일에 저장할 더 효율적인 방법으로 처리하고 싶다~~ 욕망~~
	//보조스트림이용해보기 
	// 1. byte기반 스트림을 문자기반 스트림으로 변경해주는 보조스트림
	// 2. dataType기반으로 데이터를 저장할 수 있게 해주는 보조스트림
	// 3. 객체자체를 저장할 수있게 해주는 보조스트림
	// 4. 저장, 읽어오기 속도를 향상시켜주는 보조스트림
	
	//기본스트림에 특수한 기능을 추가한 것
	//보조스트림만 생성해서 이용할 수 없음 모든 보조스트림은 기본스트림을 생성한 객체를 이용
	//new 보조스트림(new 기본스트림());
	
	public void changeStream() {
		//byte단위로 불러온 stream을 문자열기반으로 stream으로 처리
		try(FileInputStream fis= new FileInputStream("mono");
				InputStreamReader isr=new InputStreamReader(fis)){
			int data=0;
			while((data=fis.read())!=-1) {
				System.out.println(data);
			}
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//제공되는 API 네트워크상에서 데이터를 가져올때 byte기반 스트림을 많이 이용하게 됨
		//그때 문자열을 받아서 처리하는 내용이면 InputStreamReader를 이용, 변환해서 사용
		try(FileWriter writer=new FileWriter("naver.html");) {
			URL url=new URL("https://www.naver.com");
			HttpURLConnection connect=(HttpURLConnection)url.openConnection();
			InputStream page=connect.getInputStream();
			InputStreamReader isr2=new InputStreamReader(page);
			int val=0;
			StringBuffer sb=new StringBuffer();
			
			while((val=isr2.read())!=-1) {
//				System.out.println((char)val);
				sb.append((char)val);
			}
			System.out.println(sb);
			
			writer.write(new String(sb));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	//데이터자료형을 유지하면서 파일에 데이터를 저장시켜주는 보조스트림
	public void dataTypeWriter(String name, int age, char gender, double height) {
		//DataOutputStream 보조스트림
		//기본스트림 fileOutputStream을 이용
		try(FileOutputStream fis=new FileOutputStream("data.dat");
				DataOutputStream dos=new DataOutputStream(fis);){
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeChar(gender);
			dos.writeDouble(height);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public void dataTypeReader() {
		try(FileInputStream fis=new FileInputStream("data.dat");
				DataInputStream dis=new DataInputStream(fis);){
			//데이터를 가져올때 주의사항
			//데이터를 writer했을때 자료형을 기준으로 동일한 순서로 불러와야함
			String name=dis.readUTF();
			int age=dis.readInt();
			char gender=dis.readChar();
			double height=dis.readDouble();
			System.out.println(name+" "+age+" "+gender+" "+height);		
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//자바에서 사용하는 객체를 저장하는 보조스트림이용하기
	//ObjectInputStream/ObjectOutputStream이용하자
	//파일로 저장하려는 객체는 조건이 있음 -> 직렬화, 역직렬화처리가 가능한 객체가 되어야한다
	//Serializable인터페이스를 구현하고 serialVersionUID값을 필드로 선언
	
	public void objectSave() {
		try(FileOutputStream fos=new FileOutputStream("Objectdata.dat");
				ObjectOutputStream oos=new ObjectOutputStream(fos);){
			Person p=new Person("김수진",19,'남',184.2);
			Person[] persons= {
					p,
					new Person("김수진",31,'남',190.5),
					new Person("박세현",28,'남',170.5)
			};
//			oos.writeObject(p);
			oos.writeObject(persons);
		}catch(IOException o) {
			o.printStackTrace();
		}
	}
	
	
	public void ovjectLoad() {
		try(FileInputStream fis=new FileInputStream("Objectdata.dat");
				ObjectInputStream ois=new ObjectInputStream(fis);){
//			Person p=(Person)ois.readObject();
			Person[] persons=(Person[])ois.readObject();
			for(Person p: persons) {
				System.out.println(p);
			}
			
//			System.out.println(p);
			
		}catch(IOException|ClassNotFoundException o) {
			o.printStackTrace();
		}
	}
	
	
}


