package com.collection.common;

import java.util.Comparator;

import com.collection.model.vo.Food;

public class FoodNmaeOrder implements Comparator{

	@Override
	public int compare(Object pre, Object next) {
		// TODO Auto-generated method stub
		
		//이름순으로 정렬하기
		Food preFood=(Food)pre;
		Food nextFood=(Food)next;
		
		
		return preFood.getName().compareTo(nextFood.getName());
	}

	
	
	
}
