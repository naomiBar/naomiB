package com.naomi.basics.classes.enums;

public class ColorTest {
	
	public static void main(String[] args) {
		
		Color cl = Color.BLACK;
		System.out.println(cl);
		System.out.println(cl.ordinal());
		
		System.out.println("==============");
		
		Color[] colors = Color.values();
		for (Color color : colors) {
			System.out.println(color);
		}
	}
}
