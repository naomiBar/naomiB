package com.naomi.basics.classes.inheritance;

public abstract class Shape {
	
	private String color;

	public Shape(String color) {
		this.color = color;
	}
	
	public Shape() {
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	

	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Shape)) {
			return false;
		}
		Shape other = (Shape)obj;
		return this.color == other.color;
	}
	
	public abstract double getArea(); 
}
