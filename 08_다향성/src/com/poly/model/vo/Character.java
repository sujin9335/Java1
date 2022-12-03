package com.poly.model.vo;

public class Character {

	private String name;
	private int hp;
	
	public Character() {
		// TODO Auto-generated constructor stub
	}

	public Character(String name, int hp) {
		super();
		this.name = name;
		this.hp = hp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public void attack() {
		
	}
	
	
}
