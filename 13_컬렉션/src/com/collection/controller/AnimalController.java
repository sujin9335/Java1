package com.collection.controller;

import java.util.ArrayList;

import com.collection.model.vo.Animal;

public class AnimalController {
	
	public void inputAnimal() {
		ArrayList list=new ArrayList();
		list.add(new Animal("뽀삐", 5.3, 10, "강아지"));
		list.add(new Animal("야옹이", 4.2, 5, "고양이"));
		Animal c=new Animal("킥킥이", 15.3, 8, "원숭이");
		Animal d=new Animal("하하", 200.3, 9, "하마");
		
	
	}
	
	
	
}
