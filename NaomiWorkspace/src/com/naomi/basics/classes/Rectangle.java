package com.naomi.basics.classes;

public class Rectangle {

	private int length;
	private int width;

	public Rectangle() {
	}

	public Rectangle(int length, int width) {
		this.setLength(length);
		this.setWidth(width);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getArea() {
		return this.width * this.length;
	}

	public int getPerimeter() {
		return this.width * 2 + this.length * 2;
	}
	
	public void print() {
		System.out.print("Length: " +  this.length);
		System.out.println("   Width: " +  this.width);
	}
}
