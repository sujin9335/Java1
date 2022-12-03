package com.poly.model.vo;

public class Archer extends Character{

//	private int hp;
//	private String name;
	private int power;
	private String weapon;
	private int count;
	
	public Archer() {
		// TODO Auto-generated constructor stub
	}

	public Archer(int hp, String name, int power, String weapon, int count) {
		super(name, hp);
//		this.hp = hp;
//		this.name = name;
		this.power = power;
		this.weapon = weapon;
		this.count = count;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
//	public void attackArcher() {
//		
//	}
	
	public void attack() {
		System.out.println(weapon+"을 쐇습니다"+(count--)+" 남았습니다");
	}
}
