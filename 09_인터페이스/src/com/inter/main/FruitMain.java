package com.inter.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.inter.common.FruitFilter;
import com.inter.model.vo.Fruit;

public class FruitMain {

	public static void main(String[] args) {
		Fruit[] fruits=new Fruit[] {
				new Fruit("사과", "빨강", 15000, 5.2),
				new Fruit("바나나", "노랑", 8000, 2.4),
				new Fruit("키위", "녹색", 20000, 3.5),
				new Fruit("수박", "녹색", 28000, 4.2),
				new Fruit("딸기", "빨강", 12000, 1.2),
		};
		Fruit[] result=searchColor(fruits,"빨강");
		System.out.println(Arrays.toString(result));
		
		result=searchFruit(fruits, (f)->f.getColor().equals("빨강"));
		printFruit(result);
		
		
		List<Fruit> list=Arrays.asList(fruits).stream()
		.filter((f)->f.getColor().equals("빨강")).collect(Collectors.toList());
		
		
		
	}
	
	private static void printFruit(Fruit[] fruit) {
		for(Fruit f : fruit) {
			if(f!=null) {
				System.out.println(f);
				
			}
		}
	}
	
	public static Fruit[] searchFruit(Fruit[] data, FruitFilter filter) {
		Fruit[] result=new Fruit[data.length];
		int index=0;
		for(int i=0; i<data.length; i++) {
			if(filter.filter(data[i])) {
				result[index++]=data[i];
			}
		}
		return result;
	}
	
	
	public static Fruit[] searchColor(Fruit[] data, String color) {
		Fruit[] result=new Fruit[data.length];
		int index=0;
		for(int i=0; i<data.length; i++) {
			if(data[i].getColor().equals(color)) {
				result[index++]=data[i];
			}
		}
		return result;
	}
	
}
