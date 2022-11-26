package com.obj.model.vo;

public class Score {
	
	private String studentId;
	private int math;
	private int kor;
	private int eng;
	private int coding;
	
	public Score() {}
	
	public Score(String studentId) {
		this.studentId=studentId;
	}
	
	public Score(String studentId, int math, int kor, int eng, int coding) {
		this.studentId=studentId;
		this.math=math;
		this.kor=kor;
		this.eng=eng;
		this.coding=coding;
	}
	
	//기능(메소드)으로 변수를 이용하게 만들자
	//필드 값을 대입 -> setter()메소드
	//필드 값을 가져오기 -> getter()메소드
	//일반적으로 클래스에 선언된 필드는 각 setter와 getter메소드를 한개씩 있음
	
	//접근제한자 반환형 메소드명(매개변수){로직}
	//setter/getter에는 메소드명에 대한 규칙이 있음
	//getter : get필드명 -> getMath(), getEng()
	//setter : set필드명 -> setMath(), setEng()
	
	public void setMath(int math) {
		if(math>0) 
		this.math=math;
	}
	public int getMath() {
		return this.math;
	}
	
	public void setKor(int kor) {
		this.kor=kor;
	}
	public int getKor() {
		return this.kor;
	}
	
	public void setEng(int eng) {
		this.eng=eng;
	}
	public int getEng() {
		return this.eng;
	}
	
	public void setCoding(int coding) {
		this.coding=coding;
	}
	public int getCoding() {
		return this.coding;
	}
	
	public String getStudentId() {
		return this.studentId;
	}
	
	//객체의 정보를 알려주는 메소드 만들기
	public void infoScorePrint() {
		System.out.println(math+" "+kor+" "+eng+" "+coding);
	}
	public String infoScore() {
		return math+" "+kor+" "+eng+" "+coding;
	}
	
	//합계를 반환해주는 메소드 만들기
	public int addAll() {
		return math+kor+eng+coding;
	}
	
	//평균을 반환해주는 메소드 만들기
	public void avrAll() {
		System.out.printf("평균: %.1f", ((double)math+kor+eng+coding)/4);
	}
	
}
