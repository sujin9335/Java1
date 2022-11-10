package com.bs.variable;

public class CastingTest {
	public static void main(String[] args) {
		//자동형변환
		//자료형의 범위가 작은 것에서 큰것으로 변환할때는 자동으로 변환을 해줌
		//산술연산자(+,=,*,/) 두개의 자료형이 다른 경우 더큰 자료형으로 자동변환을 해줌
		int score = 80;
		double dscore = score; // 자동형변환
		System.out.println(dscore);
		double total = score+10.2;
		System.out.println(total);
		
		//강제형변환
		//데이터 손실을 주의해야한다
		int num = 290;
		byte bnum = (byte)num; // 강제형변환
		System.out.println(bnum);
		
		int kor, eng, math;
		kor = 90;
		eng = 100;
		math = 100;
		//평균
		double avg = ((double)kor+eng+math)/3;
		System.out.println(avg);
		
		
		//char형의 형변환
		int chNum = 67;
		System.out.println(chNum);
		char ch = (char)chNum;
		System.out.println(ch);
		chNum = '넘';
		System.out.println(chNum);
		//다형성을 활용할때 많이 사용을 한다
		
		
		
		
				
		
		
		
		
	}
}
