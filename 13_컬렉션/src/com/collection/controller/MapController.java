package com.collection.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.model.vo.Animal2;
import com.collection.model.vo.Food;

public class MapController {

	public static void main(String[] args) {
		//Map의 저장구조 및 활용에 대해 알아보자
		//저장구조 : key : value의 쌍으로 구성되어있음
		//key : Object 자료형 -> 변수명
		//value : Object 자료형 -> 변수에 들어가 있는 값
		
		//key값은 중복이 불가능하다, value는 중복이 가능
		//순서가 없음
		
		//key값 일반적으로 String, int형(Integer)을 사용
		//순서가 없음
		
		//Map인터페이스를 구현한 클래스를 이용해서 사용
		//HashMap, TreeMap, Properties
		
		HashMap map=new HashMap();
		//데이터 저장하기
		//put(key,value) 
		map.put("뽀삐", new Animal2("뽀삐", 5, "강아지"));
		map.put("야옹이", new Animal2("야옹이", 2, "야옹이"));
		map.put("개코", new Animal2("개코", 10, "도마뱀"));
		
		//저장된 데이터 가져오기
		//get(key값)
		Object o=map.get("뽀삐");
		System.out.println(o);
		o=map.get("개코");
		System.out.println(o);
		
		//key값은 중복을 허용하지않음
		//동일한 key값으로 put()메소드를 실행하면 key에 있는 값을 덮어쓰기 해버림
		map.put("뽀삐", new Food("국밥", 10000, "한식"));		
		o=map.get("뽀삐");
		System.out.println(o);
		
		//map데이터 삭제하기
		map.remove("뽀삐");
		//일치하는 key가 없으면 null값을 반환
		o=map.get("뽀삐");
		System.out.println(o);
		
		//Map에 저장되어있는 객체의 데이터를 수정
		//개코의 나이를 수정하기
		o=map.get("개코");
		((Animal2)o).setAge(20);
		System.out.println(o);
		
		//map저장된 데이터 수 확인
		System.out.println(map.size());
		
		//map에 저장된 데이터 조회하기
		map.put("킥킥", new Animal2("킥킥", 5, "원숭이"));
		map.put("꼬끼오", new Animal2("꼬끼오", 10, "닭"));
		map.put("꿀꿀이", new Animal2("꿀꿀이", 16, "돼지"));
		map.put("음메", new Animal2("음메", 18, "소"));
		System.out.println(map);
		
		//map에 저장된 모든 데이터를 출력하기
		//1. key값을 먼저 가져옴 -> keySet()메소드 이용 key값을 set방식으로 반환해주는 로직
		//2. 가져온 key값으로 value가져와 출력 -> get(key)
		Set keys=map.keySet(); //map에 저장되어 있는 모든 key값을 가져옴
		System.out.println(keys);
		Iterator it=keys.iterator();
		while(it.hasNext()) {
//			System.out.println(it.next());
			Object k=it.next(); //두번쓰면 안되니까 k에 따로저장
			System.out.println(k+" : "+map.get(it.next()));
		}
		
		System.out.println("forEach문으로 map데이터 순회하기");
		//forEach문 활용하기
//		for(Object k : keys) {
		for(Object k : map.keySet()) { //위랑 이거 사용가능
//			System.out.println(k);
			System.out.println(k+" : "+map.get(k));
		}
		
		//key와 value를 한번에 반환해주는 메소드를 제공
		//entrySet(); Map.Entry
		Set entry=map.entrySet();
		System.out.println(entry);
		Iterator it2=entry.iterator();
		while(it2.hasNext()) {
			Map.Entry e=(Map.Entry)it2.next();
			//key값출력 : Map.Entry getKey();
			//value값출력 : Map.Entry getValue(); 
			System.out.println(e.getKey()+" : "+e.getValue());
		}
		
		System.out.println("forEach문 이용해서 접근하기");
		for(Object entry1 : map.entrySet()) {
			Map.Entry e=(Map.Entry)entry1;
			System.out.println(e.getKey());
			System.out.println(e.getValue());
					
		}
		
		
		//불변의 map을 생성할 수 있음
		//of()메소드 이용 
		Map test=Map.of("name","유병승","age",19,"gender",'M');
//		test.put("address", "경기도 시흥시");
		System.out.println(test);
		
		//특정 key값이 있는지 확인하는 메소드
		System.out.println(map.containsKey("꼬끼오"));
		//특정 갑싱 있는지 확인하는 메소드
		System.out.println(map.containsValue(new Animal2("음메", 18, "소")));
		
		//values를 이횽하면 value에 저장된 값을 Conllection으로 반환
		Collection c=map.values();
		List a=new ArrayList(c);
//		a=new ArrayList(map);
		System.out.println(a.get(0));
		
		
		//List에 Map을 저장해서 관리하는 방법
		List members=new ArrayList();
		members.add(Map.of("id", "admin", "password", "1234", "name", "관리자"));
		members.add(Map.of("id", "user01", "password", "1111", "name", "유저1"));
		members.add(Map.of("id", "user02", "password", "1111", "name", "유저2"));
		members.add(Map.of("id", "user03", "password", "1111", "name", "유저3"));
		System.out.println(members);
		for(Object m : members) {
//			System.out.println(m);
			System.out.println("아이디"+((Map)m).get("id"));
			System.out.println("이름"+((Map)m).get("name"));
		}
		
	}
}
