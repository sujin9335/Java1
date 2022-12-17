package com.collection.common;

import java.util.Comparator;

import com.collection.model.vo.Food;

public class FoodPriceFilter implements Comparator{
	
	@Override
	public int compare(Object pre, Object next) {
		//food의 가격을 기준으로 내림차순정렬하기
		Food preFood=(Food)pre;
		Food nextFood=(Food)next;
		if(preFood.getPirce()>nextFood.getPirce()) return +1;
		else if(preFood.getPirce()<nextFood.getPirce()) return -1;
		else { //값이 동일하면
			return preFood.getName().compareTo(nextFood.getName());
		}
		
	}

}
