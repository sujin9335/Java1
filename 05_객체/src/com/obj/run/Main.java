package com.obj.run;
import com.obj.controller.PublicTest;
import com.obj.controller.DefaultTest;
public class Main {
	public static void main(String[] args) {
		//클래스는 생성을 해야지 이용을 할 수 있다
		//클래스는 기본 코드, 생성할 규칙을 정의한 코드자체 -> 생성 해야지 활용이 가능!
		//선언된 클래스를 새엉하는 방법: new 연산자를 이용
		//new 클래스명();
		new PublicTest();
		//클래스는 하나의 타입으로 활용이 되기 때문에
		//생성된 클래스(객체)는 변수로 저장할 수 있다.
		PublicTest pt;
		pt=new PublicTest();
		//클래스는 new 연산자를 사용할때 마다 새로운 객체를 생성해서 반환
		
		
		//default로 선언된 클래스 생성하기 -> 외부패키지에서는 이용이 불가능함
		new DefaultTest();
		
		//설계에 의해서 특별한 경우가 아니면 클래스선언부의 접근제한자는 public으로 선언을 한다
		
		
	}
}
