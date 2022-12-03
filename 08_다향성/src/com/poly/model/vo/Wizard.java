package com.poly.model.vo;

public class Wizard extends Character{
//	private int hp;
	private int mp;
//	private String name;
	private String magic;
	
	public Wizard() {
		// TODO Auto-generated constructor stub
	}

	public Wizard(int hp, int mp, String name, String magic) {
		super(name, hp);
//		this.hp = hp;
		this.mp = mp;
//		this.name = name;
		this.magic = magic;
	}

//	public int getHp() {
//		return hp;
//	}
//
//	public void setHp(int hp) {
//		this.hp = hp;
//	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

	public String getMagic() {
		return magic;
	}

	public void setMagic(String magic) {
		this.magic = magic;
	}
//	public void attackWizard() {
//		System.out.println(magic+"으로 공격했습니다");
//	}
	public void attack() {
		System.out.println(magic+"으로 공격했습니다");
	}
	
}