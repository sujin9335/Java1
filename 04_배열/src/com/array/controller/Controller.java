package com.array.controller;
import java.util.Arrays;
import java.util.Scanner;
public class Controller {

	public void basicArray() {
		//기본배열 활용하기
		//배열은 기본으로 제공되는 저장공간으로 생성(new)을 해서 사용한다
		//저장되는 저장공간은 성형구조로 되어있음
		//배열 순서가 있고, new에 의해 생성되면 각 저장공간에 인덱스번호가 부여
		//인덱스번호는 0부터 시작함
		//저장공간을 이용할때는 배열을 저장한 변수명과 인덱스를 이용함
		//배열을 생성하는 방법
		//new 자료형[생성할공간의 갯수];
		//생성한 배열을 재사용하려면 반드시 변수에 넣어야 한다
		//배열자료형 -> 자료형[]
		//배열은 변수선언과 할당을 해야한다
		//자료형[] 배열변수명=new 자료형[갯수]
		
		int[] intArr; //int형배열을 저장하는 변수를 선언
		intArr=new int[5]; //변수에 int형 배열을 생성해서 대입
		System.out.println(intArr);
		//생성된 배열의 저장공간 활용하기
		//1.접근하는 방법
		// 변수명[인덱스명];
		int a=10;
		a=20;
		System.out.println(a);
		intArr[0]=100;
		intArr[1]=200;
		System.out.println(intArr[0]);
		System.out.println(intArr[1]);
		System.out.println(intArr[2]);
		System.out.println(intArr[3]);
		System.out.println(intArr[4]);
		//new 연산자로 heap영영에 공간을 생성하면 자동으로 기본값이 세팅된다
		//int 0, double 0.0, char ' ", String(참조자료형모두) null
		
		//반복문을 이용해서 배열의 저장공간에 접근할 수 있다
		for(int i=0; i<5; i++) {
			System.out.println(intArr[i]);
		}
		
		//반복문을 이용해서 각 변수공간에 값을 저장하기
		for(int i=0; i<5; i++) {
			intArr[i]=i;
		}
		for(int i=0; i<5; i++) {
			System.out.println(intArr[i]);
		}
		
		//수강생 5명 이름을 저장할 수 있는 배열을 만들고
		//각 배열저장공간에 이름을 저장하기
		//이동명,윤주,김태훈,박세현,최이경,김수진,오윤재
		
		String name[]=new String[5];
		name[0]="이동명";
		name[1]="윤주";
		name[2]="김태훈";
		name[3]="박세현";
		name[4]="최이경";
		
		for(int i=0; i<5; i++) {
			System.out.println(name[i]);
		}
		
//		System.out.println(name[5]); //오류남 0~4까지임
		//배열의 갯수를 확인하려면 length를 이용
		System.out.println(name.length);
		System.out.println(intArr.length);
		
		char chs[]=new char[10];
		System.out.println(chs.length);
		
		
		for(int i=0; i<chs.length; i++) {
			System.out.println(chs[i]);
		}
		for(int i=0; i<name.length; i++) {
			System.out.println(name[i]);
		}
		
		
		//선언과 동시에 초기화
		String name2[]= {"이동명","윤주","김태훈","오윤재","최이경","김수진","박세현"};
		for(int i=0; i<name2.length; i++) {
			System.out.println(name2[i]);
		}
		int[] intArr2;
//		intArr2={1,2,3,4,5,6,7,8}; // 선언과 동시에 안써서 못함
		intArr2=new int[]{1,2,3,4,5,6,7,8}; // 이렇게하면 따로 선언가능
		for(int i=0; i<intArr2.length; i++) {
			System.out.println(intArr2[i]);
		}
		
		
		
		//5명의 키를 입력받아 저장하고 
		//출력하는 기능을 만들기
		
		Scanner sc=new Scanner(System.in);
		
		double ki[]=new double[5];
//		for(int i=0; i<ki.length; i++) {
//			System.out.print(i+"번 키: ");
//			ki[i] = sc.nextDouble();
//		}
//		for(int i=0; i<ki.length; i++) {
//			System.out.println(i+" "+ki[i]);
//		}
		
		ki=new double[]{180.5,165.2,164.3,178.6,187.7};
		//저장된 배열에서 원하는 값을 찾기, 원하는 값만 가져오기
		//키가 180이상인 사람의 수 찾기
		int count=0;
		for(int i=0; i<ki.length; i++) {
			if(ki[i]>=180) {
				count++;
			}
		}
		System.out.println("180이상사람: "+count+"명");
		
		//배열은 한번 선언된 길이를 변경할 수 없다
		char[] alpha=new char[5];
		alpha[0]='a';
		alpha[1]='b';
		alpha[4]='d';
		for(int i=0; i<alpha.length; i++) {
			System.out.println(i+" "+alpha[i]);
		}
		
		alpha=new char[6]; // alpha[0],[1],[4] 지정한게 날라간다
		alpha[5]='e';
		for(int i=0; i<alpha.length; i++) {
			System.out.println(i+" "+alpha[i]);
		}
		
		
		//정수 10개를 저장할 수 있는 저장소를 만들고
		//10개에 랜던값으로 1~100까지의 수를 저장 후 출력
		int[] su=new int[10];
		
		for(int i=0; i<su.length; i++) {
			su[i]=(int)(Math.random()*100)+1;
		}
		for(int i=0; i<su.length; i++) {
			System.out.println(i+" "+su[i]);
		}
		
		int max=su[0];
		int min=su[0];
		for(int i=0; i<su.length; i++) {
			if(max<su[i]) {
				max=su[i];
			}
			if(min>su[i]) {
				min=su[i];
			}
		}
		System.out.println(Arrays.toString(su));
		System.out.println(max+" "+min);
		
		
		//배열은 선혈구조로 데이터에 순서가 있음
		//인덱스번호를 기준으로 순서를 정함...
		
		//정렬을 할 수 있다. 오름차순, 낼미차순정령
		//1,5,2,8,7,3,6,10
		//오름차순 : 1,2,3,5,6,7,8,10
		//내림찬순 : 10,8,7,6,5,3,2,1
		int[] numOrder= {1,5,2,8,7,3,6,10};
//		int temp=numOrder[1];
//		numOrder[1]=numOrder[2];
//		numOrder[2]=temp;
		System.out.println(Arrays.toString(numOrder));
		for(int i=0; i<numOrder.length; i++) {
			System.out.println(numOrder[i]);
			for(int j=0; j<i; j++) {
				if(numOrder[i]<numOrder[j]) {
					int temp=numOrder[i];
					numOrder[i]=numOrder[j];
					numOrder[j]=temp;
				}	
				System.err.println(numOrder[i]+" "+numOrder[j]);
			}
			
			
		}
		System.out.println(Arrays.toString(numOrder));
		
		
		
		//저장된 학생 중 박씨성을 가진 학생 조회하기
		String[] names3= {"이동명","윤주","김태훈","오윤재","최이경","김수진","박세현","박보검","박상민"};
		
		String sum1="";
		for(int i=0; i<names3.length; i++) {
			if(names3[i].charAt(0)=='박') {
				sum1+=names3[i];
			}
		}
		System.out.println(sum1);
		
		
		//대문자와 소문자의 갯수를 구하시오
		
		int count3=0;
		int count4=0;
		char[] alpha2= {'a','b','D','E','T','s','y','U','h'};
		for(int i=0; i<alpha2.length; i++) {
			if(alpha2[i]>='A'&&alpha2[i]<='Z') {
				count3++;
			}
			if(alpha2[i]>='a'&&alpha2[i]<='z') {
				count4++;
			}
		}
		System.out.println("대문자 : "+count3);
		System.out.println("소문자 : "+count4);
		
		
		
		
		
		
	}
	
	
	
}

