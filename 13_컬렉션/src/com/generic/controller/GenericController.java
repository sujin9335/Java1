package com.generic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.collection.model.vo.Food;

public class GenericController {

	public static void main(String[] args) {
		//제네릭
		//
		List<String> names=new ArrayList();
		names.add("유병승");
		names.add("박세현");
		String str=names.get(0);
		
		for(String data : names) {
			System.out.println(data);
		}
		
		
//		List name2=new ArrayList();
//		name2.add("유병승");
//		str=(String)name2.get(0);
//		
//		for(Object data : name2) {
//			System.out.println(data);
//		}
		
		
		MyGeneric<String> my=new MyGeneric();
		my.setData("유병승");
		String data=my.getData();
		System.out.println(data);
		
		MyGeneric<Integer> my1=new MyGeneric<Integer>();
		my1.setData(19);
		int age=my1.getData();
		System.out.println(age);
		
		
		List<Food> foods=new ArrayList();
		foods.add(new Food("햄버거", 9000, "양식"));
		foods.add(new Food("짜장면", 9500, "중식"));
		foods.add(new Food("라면", 4000, "한식"));
		foods.add(new Food("떡볶이", 12000, "한식"));
		foods.add(new Food("초밥", 21000, "일식"));
	
		for(Food f : foods) {
			if(f.getPirce()>10000)
			System.out.println(f);
		}
		
		Set<Food> foodSet=new HashSet(foods);
		Iterator<Food> it=foodSet.iterator();
		while(it.hasNext()) {
			Food f=it.next();
			System.out.println(f);
		}
		
		HashMap<String,Food> foodMap=new HashMap();
		foodMap.put("햄버거",new Food("햄버거", 9000, "양식"));
		foodMap.put("짜장면",new Food("짜장면", 9500, "중식"));
		foodMap.put("라면",new Food("라면", 4000, "한식"));
		foodMap.put("떡볶이",new Food("떡볶이", 12000, "한식"));
		foodMap.put("초밥",new Food("초밥", 21000, "일식"));
		
		Set<String> keys=foodMap.keySet();
		Iterator<String> mpIt=keys.iterator();
		while(mpIt.hasNext()) {
			String k=mpIt.next();
			Food f=foodMap.get(k);
			System.out.println(k+" : "+f);
		}
		
		Set<Map.Entry<String,Food>> entry=foodMap.entrySet();
		Iterator<Map.Entry<String,Food>> itFood=entry.iterator();
		while(itFood.hasNext()) {
			Map.Entry<String, Food> d=itFood.next();
			String k=d.getKey();
			Food f=d.getValue();
			System.out.println(d.getKey()+" : "+d.getValue());
		}
		
		for(String k : foodMap.keySet()) {
			Food f=foodMap.get(k);
		}
		for(Map.Entry<String, Food> d : foodMap.entrySet()) {
			String k=d.getKey();
			Food f=d.getValue();
			System.out.println(k);
			System.out.println(f);
		}
		
		System.out.println(foods);
		foods.sort((f,f1)->f.getPirce()-f1.getPirce());
		foods.forEach(f->System.out.println(f.getName()+" "+f.getPirce()));
		
		
		
		
	}
}
