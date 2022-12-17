package com.collection.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.collection.model.vo.Animal2;

public class SetController {

	public static void main(String[] args) {
		//set에 대해 알아보자
		//다수의 데이터(객체)를 저장할 수 있는 클래스
		//HashSet, LinkedHashSet, treeSet
		//데이터를 중복해서 저장하지 않음 
		//저장된 특정데이터만 가져올수는 없다 *데이터를 지칭하는 이름이 없음
		HashSet set=new HashSet();
		//set에 데이터 추가하기
		//add()메소드 이용
		set.add("이동명");
		set.add("운주");
		set.add("김태훈");
		set.add("김성훈");
		set.add("박세훈");
		System.out.println(set);
		//set에 있는 데이터를 출력(가져오기)하기 위해서는
		//전체를 가져와 처리해야 한다 -> Iterator를 이용
		Iterator it=set.iterator();
		while(it.hasNext()) {
			Object o=it.next();
//			System.out.println(it.next());//스택방식이랑 빗스함 재사용x
			System.out.println(o);
		}
		
		//foreach문을 이용해서 처리하기
		for(Object o : set) {
			System.out.println(o);
		}
		
		//forEach메소드 이요하기
		set.forEach(o->System.out.println(o));
		
		//set에는 중복값을 저장하지 않는다 
		// -> 저장되는 클래스에 equals, hashCode메소드가 오버라이드되어 있어야함
		set.add("김태훈");
		set.add("김태훈");
		set.add("김태훈");
		set.add("김태훈");
		set.add("김태훈");
		set.add("김태훈");
		set.add("김태훈");
		set.forEach(o->System.out.println(o));
		
		
		Set animals=new HashSet();
		animals.add(new Animal2("뽀삐", 5, "강아지"));
		animals.add(new Animal2("야옹이", 3, "고양이"));
		animals.add(new Animal2("개코", 2, "도마뱀"));
		animals.add(new Animal2("개코", 2, "도마뱀"));
		animals.add(new Animal2("개코", 2, "도마뱀"));
				
		for(Object o : animals) {
			System.out.println(o);
		}
		
		Set test=new HashSet();
		
		//Set메소드로 데이터 확인하기
		//1. 저장된 데이터 갯수 확인
		System.out.println(animals.size());
		//2. 저장된 데이터가 있는지 없는지 확인
		System.out.println(animals.isEmpty());
		System.out.println(test.isEmpty());
		//3. 데이터 포함여뷰를 확인
		System.out.println(animals.contains(new Animal2("개코", 2, "도마뱀")));
		//4. 데이터 삭제하기
		animals.remove(new Animal2("개코", 2, "도마뱀"));
		for(Object o : animals) {
			System.out.println(o);
		}
		
		//List, Set에 호환관계
		System.out.println("List로 변환하고 인덱스로 데이터 출력하기");
		List animalList=new ArrayList(animals);
		System.out.println(animalList.get(0));
		System.out.println(animalList.get(1));
		
		animalList.add(new Animal2("개코", 5, "도마뱀"));
		animalList.add(new Animal2("개코", 5, "도마뱀"));
		animalList.add(new Animal2("개코", 5, "도마뱀"));
		animalList.add(new Animal2("개코", 5, "도마뱀"));
		animalList.add(new Animal2("개코", 5, "도마뱀"));
		
		System.out.println("list에 중복값 저장하기");
		animalList.forEach(o->System.out.println(o));
		
		System.out.println("set을 이용해서 중복값 제거");
		Set temp=new HashSet(animalList);
		animalList=new ArrayList(temp);
		animalList.forEach(o->System.out.println(o));
		
		HashSet lotto=new HashSet();
		while(lotto.size()!=6) {
			lotto.add((int)(Math.random()*45)+1);
		}
		System.out.println(lotto);
		ArrayList list=new ArrayList(lotto);
		list.sort((pre,next)-> (int)pre-(int)next);
		System.out.println(list);
		
		
		LinkedHashSet linkSet=new LinkedHashSet();
		linkSet.add(1);
		linkSet.add(2);
		linkSet.add(8);
		linkSet.add(7);
		linkSet.add(9);
		linkSet.add(5);
		System.out.println(linkSet);
		for(Object o : linkSet) {
			System.out.println(o);
		}
		
		TreeSet tset=new TreeSet();
		tset.add(1);
		tset.add(9);
		tset.add(6);
		tset.add(8);
		tset.add(7);
		tset.add(4);
		tset.add(3);
		System.out.println(tset);
		//TreeSet클래스에 객체를 저장하려면 저장되는 객체에 Comparable 인터페이스가 구현이 되있어야한다
		tset=new TreeSet(animals);
		for(Object o : animals) {
			System.out.println(o);
		}
		
		
		
		
	}
}
