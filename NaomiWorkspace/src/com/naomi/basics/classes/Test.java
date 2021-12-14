package com.naomi.basics.classes;

import a.Point;

public class Test {

	public static void main(String[] args) {
		
		//אחרת ממחלקה אובייקט ליצור אפשר --> import ידי על
		Point p = new Point(5,9);
		p.printPoint();
		System.out.println("===============");
		
		//Circle
		Circle c = new Circle();
		c.setColor("red");
		c.setRadius(2);
		Circle c2 = new Circle("red",3);
		System.out.println("C2.color: " + c2.getColor());
		System.out.println("===============");
		
		//Rectangle
		Rectangle r = new Rectangle(3,5);
		r.print();
		System.out.println("Area: " + r.getArea());
		System.out.println("Perimeter: " + r.getPerimeter());
		System.out.println("===============");
		
		//Line
		Line li = new Line(10);
		li.draw();
		Line li2 = new Line(2);
		li2.draw();
	}
}
