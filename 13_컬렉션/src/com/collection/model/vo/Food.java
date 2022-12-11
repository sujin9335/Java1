package com.collection.model.vo;

import java.io.Serializable;

public class Food implements Serializable{

	
	private static final long serialVersionUID = 2191821167971458969L;
	private String name;
	private int pirce;
	private String type;
	
	public Food() {
		// TODO Auto-generated constructor stub
	}

	public Food(String name, int pirce, String type) {
		super();
		this.name = name;
		this.pirce = pirce;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPirce() {
		return pirce;
	}

	public void setPirce(int pirce) {
		this.pirce = pirce;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", pirce=" + pirce + ", type=" + type + "]";
	}
	
	@Override
	public boolean equals(Object o) {
		if(this==o) return true;
		else {
			if(!(o instanceof Food)) return false;
			else {
				Food f=(Food)o;
				if(name.equals(f.name)
						&&pirce==f.pirce
						&&type.equals(f.type)) return true;
				else return false;
			}
		}
	}
	
	//해쉬코드 오버라이딩 해야됨 시간이없어서 못함
	
	
}
