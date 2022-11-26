package com.obj.run;

import com.obj.model.vo.Score;

public class InfMain {
	public static void main(String[] args) {
		Score th=new Score();
//		th.math=70;  // private 로 막혀있어서 못쓴다
//		th.kor=90;
//		th.eng=88;
//		th.coding=100;
//		System.out.println("태훈점수: "+th.math+" "+th.kor+" "+th.eng+" "+th.coding);
//		th.math=-200;
//		System.out.println("태훈점수: "+th.math+" "+th.kor+" "+th.eng+" "+th.coding);
		
		//생성된 객체에 값을 대입할때는 클래스에 선언된 setter메소드를 이용한다
		th.setMath(70);
		th.setKor(90);
		th.setEng(88);
		th.setCoding(100);
		
		//생성된 객체에 값을 가져오기
		System.out.println("수학: "+th.getMath());
		System.out.println("국어: "+th.getKor());
		System.out.println("영어: "+th.getEng());
		System.out.println("코딩: "+th.getCoding());
		
		th.setMath(-200);
		System.out.println("수학: "+th.getMath());


		Score sh=new Score("sh_001");
		System.out.println(sh.getStudentId());
		sh.getStudentId();
		
		
		System.out.println(th.infoScore());
		th.infoScorePrint();
		
		
		System.out.println("합계: "+th.addAll());
		
		th.avrAll();
		
		
		
	}
}
