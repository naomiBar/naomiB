package com.naomi.basics.classes.enums;

import java.util.Arrays;
import java.util.Scanner;

import com.naomi.basics.classes.enums.Car.Type;

public class CarTest {

	public static void main(String[] args) {
		Car car1 = new Car(111, 0, Color.RED, Type.SPORT);
		System.out.println(car1);
		
		System.out.println("===============");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter car number: ");
		int number = Integer.parseInt(sc.nextLine());
		
		System.out.print("enter car speed: ");
		int speed = Integer.parseInt(sc.nextLine());
		
		System.out.print("enter car color " + Arrays.toString(Color.values()) + ": ");
		Color color = Color.valueOf(sc.nextLine().toUpperCase());
		
		System.out.print("enter car type " + Arrays.toString(Type.values()) + ": ");
		Type type = Type.valueOf(sc.nextLine().toUpperCase());
		
		Car car2 = new Car(number, speed, color, type);
		System.out.println(car2);
		sc.close();
	}
}
