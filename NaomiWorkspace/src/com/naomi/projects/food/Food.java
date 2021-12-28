package com.naomi.projects.food;

public abstract class Food {

	public enum Taste{
		SWEET, SPICY, BITTER, SOUR;
	}
	
	private double weight;
	private Taste taste;
	
	public Food() {
	}
	
	public Food(double weight, Taste taste) {
		this.weight = weight;
		this.taste = taste;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Taste getTaste() {
		return taste;
	}

	public void setTaste(Taste taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +" [weight=" + weight + ", taste=" + taste + "]";
	}
	
	
	
	
	
}
