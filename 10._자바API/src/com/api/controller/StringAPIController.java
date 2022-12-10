package com.api.controller;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.api.model.Person;

public class StringAPIController {

	public static void main(String[] args) {
		//자바에서 문자열처리에 대한 클래스는 3가지가 있음
		//String : 기본적으로 문자열을 처리할때 기본자료형처럼사용
		//StringBuffer : 클래스 사용방식으로 문자열을 관리 -> 생성, 메소드 호출
		//StringBuilder : 클래스 사용방식으로 문자열을 관리 -> 생성, 메소드 호출
		String name="유병승";
		name=new String("유병승");
//		StringBuffer sb="크리스마스";
		StringBuffer sb=new StringBuffer("크리스마스");
		System.out.println(name);
		System.out.println(sb);
		
		//저장된 문자열을 변경하게 되면 차이가 발생
		//저장된 문자열에 유후~ 추가하기
		
		//저장된 공긴이 변경되는 차이가 발생
		System.out.println("String 변경전 주소 : "+name.hashCode());
		System.out.println("StringBuffer 변경전 주소 : "+sb.hashCode());
		name+="유후~";
		System.out.println(name);
		//StringBuffer의 문자열을 수정할때는 메소드를 이용해야한다
		//append()메소드이용
//		sb+="유후";
		sb.append("유후~");
		System.out.println(sb);
		System.out.println("String 변경후 주소 : "+name.hashCode());
		System.out.println("StringBuffer 변경후 주소 : "+sb.hashCode());
		
		//String -> 일반적인 문자열을 저장관리할때 사용
		//StringBuffer -> 네트워크상에서 문자열을 전송할때 사용, 문자를 조작할때(수정, 삽입, 삭제)
		
		
		//String에서 제공하는 문자열을 다루는 메소드 -> 반환값을 활용해야함
		//1. 문자열을 합쳐주는 기능 : concat()
		String test="메가스터디 IT";
		test=test.concat(" 자바반");
		System.out.println(test);
		//2. 특정문자를 포함했는지 확인해주는 기능 : contains() boolean
		boolean result=test.contains("IT");
		System.out.println(result);
		if(test.contains("IT")) {
			System.out.println("요즘 코딩이 대세!!");
		}
		//3. 문자열에서 특정문자의 인덱스번호를 찾는기능 : indextOF() int
		int index=test.indexOf("I");
		System.out.println(index);
		//다른 메소드와 같이 사용
		index=test.indexOf("0");//지정 문자열을 찾을 수 없으면 -1 반환
		System.out.println(index);
		if(test.indexOf("IT")!=-1) {
			System.out.println("요즘 코딩이 대세!!");
		}
		// lastIndexOf() : 오른쪽에서 검색을 시작
		test="banana";
		index=test.indexOf("a");
		System.out.println(index);
		index=test.lastIndexOf("a");
		System.out.println(index);
		
		//4. 특정패턴을 갖는 문자열을 배열로 변환해주는 기능 : split("기준값")
		//특정패턴 -> 유병승, 박세현, 김수진, 윤주, 김태훈
		//csv 파싱할때 많이 사용
		test="유병승,박세현,김ㅅ쥔,윤주,김태훈";
		String[] names=test.split(",");
//		System.out.println(Arrays.toString(test));
		for(String n : names) {
			System.out.println(n);
		}
		test="유병승,19,남,경기도시흥시,180.5\n김태훈,25,남,겸기도용인시,190.5\n박세현,28,남,인천시,185.5";
		String[] persons=test.split("\n");
		Person[] personsArr=new Person[3];
		int count=0;
		for(String p : persons) {
			String[] person=p.split(",");
			Person pObject=new Person();
			pObject.setName(person[0]);
			pObject.setAge(Integer.parseInt(person[1]));
			pObject.setGender(person[2].charAt(0));
			pObject.setAddress(person[3]);
			pObject.setHeight(Double.parseDouble(person[4]));
			System.out.println(pObject);
			personsArr[count++]=pObject;
			
		}
		for(Person p:personsArr) {
			if(p.getAge()>=20)
				System.out.println(p);
		}
		
		//5. 배열 데이터를 특정구분자를 포함하는 문자열로 변환해주는 기능
		//String.join("특정구분자", 배열변수명); static메소드임
		String[] data={"서울", "대전", "대구", "부산", "광주", "전주"};
		test=String.join("," , data);
		System.out.println(test);
		
		//6. 문자열의 지정구역을 잘라내는 기능
		// substring(시작인덱스번호[, 끝인덱스번호]);
		test="유병승";
		test=test.substring(2);
		System.out.println(test);
		test="여러분 크리스마스에 뭐하세요?";
		String resultStr=test.substring(11);
		System.out.println(resultStr);
		resultStr=test.substring(test.indexOf("뭐"));
		System.out.println(resultStr);
		
		test="C:/test/data/yoo.jpg";
		//파일명, 확장자를 따로 분리하기
		String fileName=test.substring(test.lastIndexOf("/")+1,test.indexOf("."));
		System.out.println(fileName);
		String ext=test.substring(test.indexOf(".")+1);
		System.out.println(ext);
		String dir=test.substring(0,test.lastIndexOf("/"));
		System.out.println(dir);
		
		//7. 영문자를 대문자, 소문자로 일괄변경해주는 기능
		// toUpperCase(), toLowerCast();
		test="AbcDEFG";
		resultStr=test.toUpperCase();
		System.out.println(resultStr);
		resultStr=test.toLowerCase();
		System.out.println(resultStr);
		
		Scanner sc=new Scanner(System.in);
//		System.out.println("진행하시겠습니까?(y/n)");
//		String choice=sc.next();
//		if(choice.toLowerCase().equals("y")) {   //||choice.equals("Y")) {
//			System.out.println("진행시켜!");
//		}
		
		//8. 문자열의 양쪽끝에 공백을 제거해주는 기능 : trim()
		test="   유병승   ";
		if(test.trim().equals("유병승")) {
			System.out.println("자바선생님");
		}
		
		//9. 다른타입의 데이터를 문자열로 변경하는 기능
		int age=19;
		double height=180.5;
		char gender='M';
//		test=(String)age;
		//String에서 제공하는 형변환메소드를 이용
		//Static으로 제공 valueOf()
		test=String.valueOf(age);
		System.out.println(test);
		test=String.valueOf(height);
		System.out.println(test);
		test=String.valueOf(gender);
		System.out.println(test);
		
		//10. 지정문구를 다른 문구로 변경해주는 기능
		//replace()
		test="자바공부가 어렵다";
		System.out.println(test);
		test=test.replace("어렵다", "쉽다");
		System.out.println(test);
		
		
		
		
		//StringBuffer클래스 다루기
		//원본저장솔르 수정함
		//메소드실행시 반환형을 갖지않음(void)
		//저장된 문자열 조작하는 기능
		//1. 저장된 문자열에 특정 문구를 추가하는 기능 : append()
		StringBuffer sbTest=new StringBuffer();
		System.out.println(sbTest);
		sbTest.append("이제 곧 쉬는시간");
		System.out.println(sbTest);
		sbTest.append("이제 쉴까요?");
		System.out.println(sbTest);
		
		//2. 문자열의 특정위치에 삽입을 하는 기능 : insert()
		sbTest.insert(3, "곧곧곧곧");
		System.out.println(sbTest);
		sbTest.insert(sbTest.indexOf("쉴"), "그만 ");
		System.out.println(sbTest);
		
		//3. 특정위치에 문자를 삭제하는 기능 : delete()
		sbTest.delete(0, 13);
		System.out.println(sbTest);
		// 한글자만 지우는 기능 : deleteCharAt()
		sbTest.deleteCharAt(0);
		System.out.println(sbTest);
		
		//4. 특정문자를 한글자수정하는 기능 : setCharAt()
		sbTest.setCharAt(0, '곧');
		System.out.println(sbTest);
		
		//String에서 제공하는 기본 length, substring, replace, indexOf... 다 제공
		sbTest.replace(0, 1, "이제");
		System.out.println(sbTest);
		resultStr=sbTest.substring(0,5);
		System.out.println(resultStr);
		
		//String 클래스와 상호호환
		//test=sbTest;
		test=new String(sbTest);
		sbTest=new StringBuffer(resultStr);
		
		
		//StringBuilder클래스는 StringBuffer클래스와 동일함
		StringBuilder sb1=new StringBuilder("빌더값");
		System.out.println(sb1);
		sb1.append("test");
		System.out.println(sb1);
		sb1.substring(0);
		
		
		
		
		//StringTokenizer클래스 이용하기
		//문자열을 특정문자를 기준으로 구분하고
		//iterate 방식으로 한개씩  가져와 사용하는 클래스
		// String클래스의 split()메소드와 비슷
		
		test="AA|BB|CC";
		test="oracle,html/css,javascript/jquery,servlet/jsp,mybatis";
		StringTokenizer st= new StringTokenizer(test,",/");
		//StringTokenizer에서 데이터를 가져올때
		//제공하는 메소드를 이용
		while(st.hasMoreElements()) {
//			System.out.println(st.nextToken());
			String d=st.nextToken();
			System.out.println(d);
		}
		
		
		
		
		
	}
}
