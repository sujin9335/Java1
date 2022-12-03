package com.inter.model.vo;

import com.inter.common.animal.inter.WaterMove;

public class Whale extends Animal implements WaterMove{

	public Whale(String name, int x, int y, String area, String type) {
		super(name,x,y,area,type);
	}
	
	@Override
	public void swim() {
		System.out.println("첨벙첨벙 고래수영행");
	}
}
