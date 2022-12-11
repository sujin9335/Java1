package com.file.controller;

import java.io.File;
import java.io.IOException;

public class FileController {

	public void basicFile() {
		//파일을 조작할 수 있는 File 클래스에 대해 알아보자
		//HDD(하드)저장되어 있는 파일을 관리할 수 있는 클래스->File
		//1.File 클래스 생성하기 *경로에 존재하는 파일명, 없는 파일명
		//매개변수있는 생성자를 이용해서 생성 -> 파일경로+파일명
		File myFile=new File("test.bs");//상대경로, 프로젝트폴더가 자동으로 설정됨
//		File myFile=new File("D:/SuJin/JavaSujin/Java1/FileTest");
		
		//2.File클래스를 이용해서 새로운 파일 생성하기
		//createNewFile()메소드를 이용
		try {
			System.out.println(myFile.createNewFile());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//3.폴더생성하기
		//폴덜르 지정하는 File클래스를 생성하고 생성메소드를 호출
		File dir=new File("a");
		//mkdir()-> 1개의 폴더를 만들때, mkdirs()-> 한번에 여러하위 폴더를 만들때
		System.out.println("폴더생성결과: "+dir.mkdir());
		File dir2=new File("word/kor/seoul");
		System.out.println("폴더생설결과: "+dir2.mkdirs());
		
		//파일생성시 주의할점 폴더는 존재해야한다. *존재하지 않는 폴더면 폴더를 생성 후 파일생성
		File dir3=new File("c:/Users/user/bs");
		if(!dir3.exists()) dir3.mkdir();
		File test=new File("c:/Users/user/bs/test.bs");
		try {
			if(!test.exists()) {//파일이 없으면...
				test.createNewFile();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//4.현재 존재하고 있는 파일의 정보를 확인하기
		File curfile=new File("test.txt");
		//1)파일명 확인하기
		System.out.println(curfile.getName());
		//2)파일의 경로확인하기
		System.out.println(curfile.getAbsolutePath());
		//3)폴더인지 확인 / 파일인지 확인
		System.out.println(curfile.isDirectory());
		System.out.println(curfile.isFile());
		
		
		//5.파일 삭제하기
		//delete() 메소드이용
		File deFile=new File("test.bs");
		System.out.println(deFile.delete());
		deFile=new File("test.txt");
		System.out.println(deFile.delete());
		
		//폴더 지우기 -> 한개씩만(최하위폴더)만 지워짐
		File delDir=new File("한글");
		System.out.println(delDir.delete());
		delDir=new File("word/kor/seoul");
		System.out.println(delDir.delete());
		
		
		
	}
	public void fileManage() {
		//특정폴더에 있는 전체파일 가져오기
		File f=new File("c:/Windows/System32");
		
		//폴더안에 있는 파일을 가져오는 방법
		//1. 문자열로 파일명을 가져오는 방법-> list()메소드 이용
		String[] files=f.list();
//		for(String file : files) {
//			File temp=new File("c:/Windows/System32/"+file);
//			System.out.println(temp.getName()+" "+temp.isFile());
//		}
//		System.out.println("파일갯수: "+files.length);
		
		
		//2. File클래스로 파일을 가져오는 방법-> listFile()메소드 이용
		File[] files2=f.listFiles();
//		for(File file: files2) {
//			System.out.println(file.getName()+" : "+file.isFile());
//		}
		
		//폴더에 exe파일만 가져오기
//		files=f.list(new FilenameFilter(){
//			
//			@Override
//			public boolean accept(File dir, String name) {
//				return name.contatins("exe");
//			}
//			
//		});
		
		files=f.list((dir,name)->name.contains("exe"));
		System.out.println(files.length);
		
		
		files2=f.listFiles((file)->file.isDirectory());
		System.out.println(files2.length);
		for(File file : files2) {
			System.out.println(file);
		}
		
	}
	
}
