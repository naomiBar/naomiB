package com.naomi.basics.inheritance;

public class Rectangle extends Shape{
	
	private double length; 
	private double width;
	
	public Rectangle(String color, double length, double width) {
		super(color);
		this.length = length;
		this.width = width;
	} 
	
	public Rectangle(double length, double width) {
		this("Black", length, width);
	} 
	
	public Rectangle() {
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double getArea() {
		return length * width;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Rectangle)) {
			return false;
		}
		Rectangle other = (Rectangle)obj;
		return this.getColor() == other.getColor() &&
				this.length == other.length && this.width == other.width;
	}
}
