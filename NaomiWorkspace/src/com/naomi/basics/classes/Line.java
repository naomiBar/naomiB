package com.naomi.basics.classes;

public class Line {

	private int length;
	
	public Line() {	
	}

	public Line(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public void draw(){
		for (int i = 1; i <= length; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
		

}
