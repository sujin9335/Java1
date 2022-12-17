package com.collection.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

import com.collection.common.FoodNmaeOrder;
import com.collection.model.vo.Food;

public class ListController {
	
	public static void main(String[] args) {
		//List인터페이스 이용하기
		//List는 Collection인터페이스를 상속받은 인터페이스
		//클래스를 다수저장, 관리하는 기능을 정의한 인터페이스
		//구현한 객체를 가지고 이용
		//ArrayList클래스 -> list데이터를 자주 수정되지 않을때 사용 *많이 사용
		//LinkedList클래스 -> list데이터를 자주 수정될때 사용
		//특징
		//배열과 동일하게 데이터를 인덱스번호로 관리함
		//데이터 순서가 있음
		//삽입, 수정, 삭제에 대한 메소드를 제공
		//하나클래스이기 때문에 연산자가 아닌 메소드로 데이터를 조작합니다
		
		//ArrayList클래스 이용하기
		//생성하기
		ArrayList list=new ArrayList(); //java.util 패키지에 있음
		
		//1. ArrayList에 데이터 저장하기
		// add()메소드 사용
		//특정한 제한을 설정하지 않으면 모든 타입을 저장할 수 있다
		list.add(true); //list의 0번 인덱스에 저장
		list.add(19);//list의 1번 인덱스에 저장
		list.add("유병승");
		list.add(new Date());
		System.out.println(list);
		
		// add(index,값) : 원하는 위치에 값을 넣을 수 있음
		list.add(1,"난 1번에 들어 갈꺼야");
		System.out.println(list);
		
		//2. ArrayList에서 데이터 출력하기
		//get(index번호) : 인덱스번호의 값을 가져오는 기능
		String msg=(String)list.get(1);
		System.out.println(msg);
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(4));
		
//		System.out.println(list.get(4));
		//인덱스번호를 초과해서 접근하면 exception이 발생함
		
		//3. list에 저장된 데이터의 수 확인하기
		// size() : list가 저장하고 있는 데이터수를 출력
		System.out.println("데이터 수: "+list.size());
		
		
		//반복문을 이용해서 list데이터 출력하기
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		//다수의 vo객체를 저장관리할떄 list 사용
		ArrayList foods=new ArrayList();
		foods.add(new Food("뼈다귀해장국", 10000, "한식"));
		foods.add(new Food("만둣국", 8000, "한식"));
		foods.add(new Food("햄버거", 9000, "양식"));
		foods.add(new Food("떡볶이", 4000, "분식"));
		
		System.out.println(foods);
		
		for(int i=0; i<foods.size(); i++) {
			System.out.println(foods.get(i));
		}
		
		//2번인덱스에 있는 음식의 이름, 가격출력하기
		Food f=(Food)foods.get(2);
		System.out.println(f.getName()+" "+f.getPirce());
		
		
		//4. 특정인덱스 값을 수정하기
		// set(index, 수정할값)
		foods.set(1, new Food("짬뽕", 9000, "중식"));
		System.out.println("set메소드 실행 후 출력");
		f=(Food)foods.get(1);
		System.out.println(f);
		System.out.println("전체 데이터 출력하기");
		
		for(int i=0; i<foods.size(); i++) {
			System.out.println(foods.get(i));
		}
		
		//5. list데이터 삭제하기
		// 원하는 데이터 삭제하기
		// remove(인덱스번호). remove(객체)
		foods.remove(2);
		System.out.println("삭제 후 전체출력");
		printArrayList(foods);
		foods.remove(new Food("짬뽕", 9000, "중식"));
		System.out.println("동일한 객체 지우구 출력하기");
		//저장된 클래스에 equals, hashcode메소드가 오버라이딩 되어있어야한다
		printArrayList(foods);
		
		// 전체데이터 삭제하기
		// clear();
		foods.clear();
		System.out.println(foods.size());
		
		
		//ArrayList 클래스에 데이터 저장, 수정, 샂게, 조회(가져오기)
		
		//List에 저장된 데이터를 찾아주는 메소드
		//contains(),indexOf,lastIndexOf()
		//1. contains(찾을객체) -> list에 있으면 true, 없으면 false;
		ArrayList names=new ArrayList();
		names.add("유병승");
		names.add("박세현");
		names.add("김수진");
		names.add("한호현");
		names.add("김성훈");
		names.add("윤주");
		System.out.println("contains결과: "+names.contains("한호현"));
		System.out.println("contains결과: "+names.contains("김태훈"));
		
		
		//List에 추가적인 메소드
		foods.add(new Food("탕수육", 25000, "중식"));
		foods.add(new Food("부대찌개", 10000, "한식"));
		Food newFood=new Food("초밥", 20000, "일식");
		if(!foods.contains(newFood)) {
			foods.add(newFood);
		}
		printArrayList(foods);
		
//		if(!foods.contains(newFood)) {
			foods.add(newFood);
//		}
		printArrayList(foods);
		
		//객체를 찾아 인덱스번호를 가져오기
		//초밥에 인덱스 번호 찾기
		int index=foods.indexOf(newFood);
		System.out.println(index);
		index=foods.lastIndexOf(newFood);
		System.out.println(index);
		
		index=foods.lastIndexOf(new Food("짜장면", 8000, "중식"));
		System.out.println(index);
		if((index=foods.indexOf(newFood))!=-1) {
			foods.set(index, new Food("한정식", 25000, "한식"));
		}
		printArrayList(foods);
		
		//추가메소드 
		//ArrayLlist를 배열로 변경해주는 메소드 : toArray();
		Object[] objFoods=foods.toArray();
		for(int i=0; i<objFoods.length; i++) {
			System.out.println(objFoods[i]);
		}
		
		//Conllection, List 인터페이스ArrayList가 구현한 인터페이스
		Collection c=new ArrayList();
		List l=new ArrayList();
		//List 인터페이스는 타입으로 많이 활용을 함
		l=foods;
		
		//배열을 List로 변경해주는 메소드 : Arrays.asList()
		Integer[] nums=new Integer[] {1,2,3,4,5,6};
		List numbers=Arrays.asList(nums);
		System.out.println(numbers);
		List data=Arrays.asList(new String[] {"유병승","홍길동","신사임당"});
		System.out.println(data);
		System.out.println(data.get(2));
		
		List foods2=Arrays.asList(new Food[] {new Food("김밥",4000,"한식"),
				new Food("라면",2000,"한식"),
				new Food("떡볶이",3000,"한식")});
		System.out.println(foods2);
		foods2.set(1, new Food("칼국수",8000,"한식")); //list get안됨
		printArrayList(foods2);
		
		//List.of() -> 선언과 동시에 초기화 *불변의 리스트
		data=List.of(1,2,3,4,5);
		System.out.println(data);
//		data.set(1, l00); //안됨
//		data.add(1, l00); //안됨
		data=List.of(new Food("김밥",4000,"한식"),
				new Food("라면",2000,"한식"),
				new Food("떡볶이",3000,"한식"));
		System.out.println(data);
		((Food)data.get(1)).setName("이제 오늘은 여기까지");//List는 불변이나 해당객체의 값은 수정이됨
		System.out.println(data);
		
		//ArrayList에 데이터가 있는지 확인하는 메소드
		//isEmpty() == size()==0 이거랑 같음
		System.out.println(names.isEmpty());
		names.clear();
		System.out.println(names.isEmpty());
		if(!names.isEmpty()) {
			printArrayList(names);
		}
		
		//List데이터를 전체 순회할때 forEach도 사용가능
		for(Object o : foods2) {
			Food f1=(Food)o;
			System.out.println(f1.getName()+" "+f1.getPirce());
		}
		
		
		
		
		//Anmial클래스를 선언
		//이름, 몸무게, 나이, 종류
		//뽀삐, 5.3, 10, 강아지
		//야옹이, 4.2, 5, 고양이
		//킥킥이, 15.3, 8, 원숭이
		//하하, 200.3, 9, 하마
		//데이터를 ArrayList에 저장
		//1. 저장된 데이터를 모두 출력(toString)
		//2. 저장된 데이터의 이름, 나이, 몸무게만 출력
		//3. 몸무게가 10kg 이상인 데이터의 이름, 종류, 몸무게 출력
		//4. 나이가 5살이상인 데이터의 전체내용을 출력
		//5. 저장된 데이터의 나이를 모두 한살씩 추가한 후 모든 데이터 출력
		
		//Studentmanage 프로젝트의 데이터 저장을 ArrayList로 변경해서 구현하기
		
//		listTest2();
		linkedListTest();
	}
	
	private static void printArrayList(List list) {
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	public static void listTest2() {
		//arratList추가 메소드
		//forEach(Consumer(functional 인터페이스))
		ArrayList foods=new ArrayList();//저장공간 생성
		foods.add(new Food("짜장면", 9000, "중식"));
		foods.add(new Food("치킨", 21000, "한식"));
		foods.add(new Food("김밥", 2000, "한식"));
		foods.add(new Food("초밥", 25000, "일식"));
		
		foods.forEach(new Test());
		
		foods.forEach(new Consumer() {
			@Override //test 클래스 오버라이드 되어있음
			public void accept(Object o) {
				Food f=(Food)o;
				if(f.getType().equals("한식")) {
					System.out.println(f);
				}
			}
		});
		System.out.println("람다식");
//		foods.forEach((o)->{System.out.println(o);});
		foods.forEach((o)->{
			Food f=(Food)o;
			if(f.getType().equals("한식")) {
				System.out.println(f);
			}
		});
		
		for(int i=0; i<foods.size(); i++) {
			System.out.println(foods.get(i));
		}
//		for(Object o : foods) {
//			
//		}
		
		//리스트에 저장된 데이터는 순서를 가지고 있음
		//정렬
		// 정렬 기준을 제공하는 클래스, 인터페이스를 구현
		// 값을 정렬하는 기준 : 메소드의 리턴값을 기준으로 설정
		// 양수 : 앞뒤에 순서를 변경
		// 음수 : 변경하지 않음
		// 0 : 변경하지 않음
		
		System.out.println("정렬전 foods");
		foods.forEach(o->System.out.println(o));
		
		//1. Comparator 인터페이스를 구현한 클래스를 이횽하는 방식 -> 정렬을 처리하는 전용클래스를 생성
//		Collections.sort(foods, new FoodPriceFilter());
		Collections.sort(foods, (pre,next)->{ //위에걸 람다로 바꿈
			Food f=(Food)pre;
			Food f2=(Food)next;
//			return f.getPirce()-f2.getPirce(); //양수만 나오면되니까 이런식이될수있음
			return f2.getPirce()-f.getPirce(); //위에꺼 반대			
//			if(f.getPirce()>f2.getPirce()) return +1;
//			else if(f.getPirce()<f2.getPirce()) return -1;
//			else return 0;
		});
		
		System.out.println("정렬후 foods");
		foods.forEach(o->System.out.println(o));
		
		//2. Comparable 인터페이스를 구현함 -> vo클래스에 구현
		System.out.println("compareTo로 정렬하기");
		Collections.sort(foods);
		foods.forEach(o-> System.out.println(o));
		
	
		List names=new ArrayList();
		names.add("유병승");
		names.add("박세현");
		names.add("김수진");
		names.add("오윤재");
		names.add("윤주");
		names.forEach(o->System.out.println(o));
		System.out.println("문자열 정렬하기");
		Collections.sort(names);
		names.forEach(o->System.out.println(o));
		
		
		//음식을 이름순으로 정렬하기
		System.out.println("음식 이름순으로 정렬하기");
		Collections.sort(foods, new FoodNmaeOrder());
		foods.forEach(o->System.out.println(o));
		System.out.println("음식이름 내림차순으로 정렬하기");
		Collections.sort(foods, (pre, next)->{
			return ((Food)(next)).getName().compareTo(((Food)pre).getName());
		});
		foods.forEach(o->System.out.println(o));
		
		
	}
	
	
	public static void linkedListTest() {
		//list 내부에 있는 데이터를 수정, 삭제, 삽입이 빈번한 경우
		//ArrayList보다 성능이 좋은 클래스
		LinkedList list=new LinkedList();
		list.add("유병승");
		list.add("박세현");
		list.add("김성훈");
		System.out.println(list.get(0));
		list.forEach(o->System.out.println(o));
		list.add(1, "김태훈");
		
		System.out.println(list.getFirst());
		System.out.println(list.getLast());
		
		//java에서 수정이 많다 -> LinkedList가 효율적임
		//java에서 보관용으로 사용 -> ArrayList가 료율 *웹에서 데이터 처리할때는 ArrayList클래스 사용
		System.out.println("정렬 후 로직");
		Collections.sort(list, (pre,next)->((String)pre).compareTo((String)next));
		list.forEach(o->System.out.println(o));
		System.out.println("정렬 후 로직");
		list.sort((pre,next)->((String)pre).compareTo((String)next));
		list.forEach(o->System.out.println(o));
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
