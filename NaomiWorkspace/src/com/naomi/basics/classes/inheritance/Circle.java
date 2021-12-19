package com.naomi.basics.classes.inheritance;

public class Circle extends Shape{
	
	private double radius;

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}
	
	public Circle(double radius) {
		this("Black", radius);
	}

	public Circle() {
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Circle)) {
			return false;
		}
		Circle other = (Circle)obj;
		return this.getColor() == other.getColor() &&
				this.radius == other.radius;
	}
}
