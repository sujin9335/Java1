package com.collection.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.collection.model.vo.Animal;

public class AnimalController {
	
	public void inputAnimal() {
		ArrayList list=new ArrayList();
		list.add(new Animal("뽀삐", 5.3, 10, "강아지"));
		list.add(new Animal("야옹이", 4.2, 5, "고양이"));
		list.add(new Animal("킥킥이", 15.3, 8, "원숭이"));
		list.add(new Animal("하하", 200.3, 9, "하마"));
		
		System.out.println("1");
//		animalPrint(list);
		System.out.println(list.toString());
		
		
		System.out.println("2");
		for(int i=0; i<list.size(); i++) {
			Animal a=(Animal)list.get(i);
			System.out.println(a.getName()+" "+a.getAge()+" "+a.getWeight());
		}
		
		System.out.println("3");
		for(int i=0; i<list.size(); i++) {
			Animal a=(Animal)list.get(i);
			if(a.getWeight()>=10) {
				System.out.println(a.getName()+" "+a.getType()+" "+a.getWeight());
			}
		}
		
		System.out.println("4");
		for(int i=0; i<list.size(); i++) {
			Animal a=(Animal)list.get(i);
			if(a.getAge()>=5) {
				System.out.println(a);
			}
		}
		
		System.out.println("5");
		for(int i=0; i<list.size(); i++) {
			Animal a=(Animal)list.get(i);
			a.setAge(a.getAge()+1);
			System.out.println(a);
		}
		
	
	}
	
	public static void animalPrint(List animal) {
		for(int i=0; i<animal.size(); i++) {
			System.out.println(animal.get(i));
		}
	}
	
	
}
