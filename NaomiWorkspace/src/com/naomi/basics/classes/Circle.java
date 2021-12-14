package com.naomi.basics.classes;

public class Circle {

	private String color;
	private int radius;
	
	public Circle() {
	}
	
	public Circle(String color, int radius) {
		this.color = color;
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}
