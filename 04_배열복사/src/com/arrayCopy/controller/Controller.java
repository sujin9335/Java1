package com.arrayCopy.controller;

import java.util.Arrays;

public class Controller {
	public void arraycopytest() {
		//배열의 내용을 복사하기
		//1. 얕은복사 : 생성된 배열의 주소만 복사해서 활용하는것 원본을 수정
		//2. 깊은복사 : 새로운 배열을 생성해서 배열에 저장된 데이터를 복사 사본수정
		
		int[] intArr= {1,2,3,4,5};
		int[] copyArr=intArr;
		System.out.println("intArr배열 데이터");
		for(int i=0; i<intArr.length; i++) {
			System.out.print(intArr[i]+" ");
		}
		System.out.println();
		System.out.println("copyArr배열데이터");
		for(int i=0; i<copyArr.length; i++) {
			System.out.print(copyArr[i]+" ");
		}
		System.out.println();
		
		
		intArr[0]=100;
		System.out.println("intArr[0]"+intArr[0]);
		System.out.println("copyArr[0]"+copyArr[0]);
		
		//깊은복사하기
		//주소를 복사하는것이 아니라 데이터를 복사하는것
		//방법 3가지
		//1.for문을 이용해서 직접 데이터를 복사해주는 방법
		int[] deepCopyArr=new int[intArr.length];
		for(int i=0; i<intArr.length; i++) {
			deepCopyArr[i]=intArr[i];
		}
		System.out.println("intArr :");
		System.out.println(Arrays.toString(intArr));
		System.out.println("deepCopyArr :");
		System.out.println(Arrays.toString(deepCopyArr));
		intArr[1]=200;
		System.out.println("intArr[1]"+intArr[1]);
		System.out.println("deepCopyArr[1]"+deepCopyArr[1]);
		//Arrays클래스가 제공하는 메소드 활용하기
		//copyOf()
		deepCopyArr=Arrays.copyOf(intArr, 5);
		System.out.println("deepCopyArr: "+Arrays.toString(deepCopyArr));
		//배열명.clone()
		deepCopyArr=intArr.clone();
		System.out.println("deepCopyArr: "+Arrays.toString(deepCopyArr));
			
	}
	public void doubleArray() {
		//2차원배여에 대해 알아보자
		//배열이 두개 연결되어있는 구조
		//바툭판식으로 데이터를 저장하는 구조
		int[][] intArr;
		intArr=new int[3][3];
		System.out.println(intArr[0]);//주소값만 나옴
		System.out.println(intArr[0][0]);
		System.out.println(intArr[2][2]);
//		System.out.println(intArr[3][0]);//넘어가서 출력안됨
//		System.out.println(intArr[0][0]);//밑으로 모두출력
//		System.out.println(intArr[0][1]);
//		System.out.println(intArr[0][2]);
//		System.out.println(intArr[1][0]);
//		System.out.println(intArr[1][1]);
//		System.out.println(intArr[1][2]);
//		System.out.println(intArr[2][0]);
//		System.out.println(intArr[2][1]);
//		System.out.println(intArr[2][2]);
		
		for(int i=0; i<intArr.length; i++) {
			for(int j=0; j<intArr.length; j++) {
				System.out.print(intArr[i][j]);
			}
			System.out.println();
		}
		
		//2차원 배열에 값 대입하기
		intArr[0][0]=100;
		intArr[1][0]=200;
		for(int i=0; i<intArr.length; i++) {
			for(int j=0; j<intArr.length; j++) {
				intArr[i][j]=i;
				System.out.print(intArr[i][j]);
			}
			System.out.println();
		}
		
		//4*4 2차원 배열을 만들고 
		//1~16까지의 값을 0,0~3,3에 순서대로 대입하기
		int b=0;
		int[][] a=new int[4][4];
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				a[i][j]=++b;
				System.out.print(b<10 ? "0"+a[i][j]+" ":a[i][j]+" ");
			}
			System.out.println();
		
		}
		
		//2차원배열 선언과 동시에 초기화
		String[] names= {"우병승","박세현","윤주","김태훈","오윤재"};
		String[][] names2= {{"강아지","고양이","뱀"},{"고등어","금붕어","참치"}};
		for(int i=0; i<names2.length; i++) {
			for(int j=0; j<names2[i].length; j++) {
				System.out.print(names2[i][j]+" ");
			}
			System.out.println();
		}
		//names2의 저장소에 뱀이 저장된 위치를 출력하는 기능
		end:
		for(int i=0; i<names2.length; i++) {
			for(int j=0; j<names2[i].length; j++) {
				if(names2[i][j].equals("뱀")) {
					System.out.println("뱀은 "+i+","+j+"에 있다");
					break end;
				}
			}
		}
		
		
		
		
		
	}
	public void forEachTest() {
		//배열,리스트,Set,Map 자료형을 쉽게 순화하게하는 반복문
		//forEach : 데이터를 전체 순회하여 값을 찾거나 출력할때
		//for(변수선언 : 비열,List,Set,Map){처리로직}
		//for(조건식;조건식;증감식)
		int[] numbers= {10,20,30,40,50};
		for(int su : numbers) {
			System.out.println(su);
		}
		
		String[] names= {"박세현", "오윤재", "윤주", "이동명", "한호현", "김수진"};
		//김씨만출력하기
		for(String name:names) {
			if(name.charAt(0)=='김') 
				System.out.println(name);
			System.out.println(name);
		}
		
		String[][] names2= {{"강아지","고양이","뱀"},{"고등어","금붕어","참치"}};
		for(String[] animal:names2) {
			for(String aniName:animal) {
				System.out.print(aniName);
			}
			System.out.println();
		}
		
		//lotto만들기
		//1~45까지 번호를 6자리에 넣기
		//중복값을 허용하지 않음
		
		int[] lotto=new int[6];
		for(int i=0; i<lotto.length; i++) {
			int value=(int)(Math.random()*45)+1;
			lotto[i]=value;
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					//중복값이 없음
					i--;
					break;
					
					
				}
			}
		}
		for(int a:lotto) {
			System.out.print(a+" ");
		}
		
		
		System.out.println();
		//up&down게임만들기
		//랜덤으로 1~50까지의 수중 한개를 저장
		//사용자에게 값을 입력받아 랜덤값과 비교하고 랜덤값이 크면 up출력
		//작으면 Down출력 맞추면 정답입니다! 출력 정답을 맞출때까지 진행
		
		
		
		
		
		
		
		
	}
}
