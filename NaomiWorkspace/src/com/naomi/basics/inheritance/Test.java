package com.naomi.basics.inheritance;

public class Test {

	public static void main(String[] args) {
		
		Shape shape, s;
		
		shape = new Rectangle("red", 5, 8);
		System.out.println("rectangle.area: " + shape.getArea());
		
		s = new Rectangle("red", 5, 8);
		System.out.println(s.equals(shape));
	
		
		shape = new Circle("yellow", 4);
		System.out.println("circle.area: " + shape.getArea());
		
		s = new Circle("red", 4);
		System.err.println(s.equals(shape));
		
		
		System.out.println("===========================");
		
		
		WLine line = new WLine(5, 4);
		line.print();
		
		
		System.out.println("===========================");
		
		
		Shape[] shapes = new Shape[3];
		shapes[0] = new Shape("red");
		shapes[1] = new Rectangle("yellow", 2, 3);
		shapes[2] = new Circle("black",7);
		
		for (int i = 0; i < shapes.length; i++) {
			Shape curr = shapes[i];
			System.out.println(curr);
			System.out.println("area: " + curr.getArea());
			
			// lets check if the current shape is a Circle
			if(curr instanceof Circle) {
				Circle c = (Circle)curr; // explicit casting
				System.out.println("radius: " + c.getRadius());
			}
		}
	}
}
