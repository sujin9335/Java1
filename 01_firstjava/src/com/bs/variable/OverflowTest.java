package com.bs.variable;

public class OverflowTest {

	public static void main(String[] args) {
		//데이터 오버플로우 현상
		//값의 범위를 넘어서 계산이된 경우 예상과 다른 이상한 값이 출력되는 것
		byte bnum = 100;
		for(int i = 1; i<200; i++ ) {
			bnum++;
			System.out.println(bnum);
		}
		
		
		
		

	}

}
