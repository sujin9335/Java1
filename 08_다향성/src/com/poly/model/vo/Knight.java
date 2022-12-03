package com.poly.model.vo;

public class Knight extends Character{
	
//	private int hp;
//	private String name;
	private int power;
	private String weapon;
	
	public Knight() {
		// TODO Auto-generated constructor stub
	}

	public Knight(int hp, String name, int power, String weapon) {
		super(name, hp);
//		this.hp = hp;
//		this.name = name;
		this.power = power;
		this.weapon = weapon;
	}

//	public int getHp() {
//		return hp;
//	}
//
//	public void setHp(int hp) {
//		this.hp = hp;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}
	
//	public void attackKnigth() {
//		System.out.println(weapon+"으로 공격했습니다");
//	}

	public void attack() {
		System.out.println(weapon+"으로 공격했습니다");
	}
}
