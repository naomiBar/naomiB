package com.naomi.threads.synchronizing;

public class CarTest {

	public static void main(String[] args) {

		Car car = new Car(100);
		
		CarDriver dan = new CarDriver("dan", car, 50);
		CarDriver ron = new CarDriver("ron", car, 20);
		CarDriver yoram = new CarDriver("yoram", car, 30);
		CarDriver naomi = new CarDriver("naomi", car, 40);
		
		dan.start();
		ron.start();
		yoram.start();
		naomi.start();
		
		Thread.yield();
		System.out.println("RegisteredDrivers with car " + car.getNumber() + ": " + car.getRegisteredDrivers());
	}
}
