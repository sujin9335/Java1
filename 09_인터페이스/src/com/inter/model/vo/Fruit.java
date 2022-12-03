package com.inter.model.vo;

import java.util.Objects;

public class Fruit {

	private String name;
	private String color;
	private int pirce;
	private double weight;
	
	public Fruit() {
		// TODO Auto-generated constructor stub
	}

	public Fruit(String name, String color, int pirce, double weight) {
		super();
		this.name = name;
		this.color = color;
		this.pirce = pirce;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPirce() {
		return pirce;
	}

	public void setPirce(int pirce) {
		this.pirce = pirce;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", color=" + color + ", pirce=" + pirce + ", weight=" + weight + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, name, pirce, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fruit other = (Fruit) obj;
		return Objects.equals(color, other.color) && Objects.equals(name, other.name) && pirce == other.pirce
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	
	
	
}
