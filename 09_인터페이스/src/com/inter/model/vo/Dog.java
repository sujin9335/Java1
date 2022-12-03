package com.inter.model.vo;

import com.inter.common.animal.inter.MoveAble;

public class Dog extends Animal implements MoveAble{

	public Dog(String name, int x, int y, String area, String type) {
		super(name,x,y,area,type);
	}
	
	@Override
	public void move(int x, int y) {
		setX(x+10);
		setY(y+10);
	}
	
	
}
