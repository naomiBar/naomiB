package com.naomi.threads.synchronizing;

import java.util.ArrayList;
import java.util.List;

public class Car {
	
	private int number;
	private int km;
	private List<String> registeredDrivers = new ArrayList<>();
	
	public Car(int number) {
		this.number = number;
	}
	
	public void registerDriver() {
		Thread driver = Thread.currentThread();
		registeredDrivers.add(driver.getName());
		System.out.println("\tdriver " + driver.getName() + " registered to car " + number);
	}
	
	public synchronized void drive(int distance) {
		Thread driver = Thread.currentThread();
		System.out.println("driver " + driver.getName() + " started at " + km + " km. for a distance of " + distance
				+ " km with car " + number);
		km += distance;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("driver " + driver.getName() + " finished at " + km + " km. with car " + number);
	}

	public int getNumber() {
		return number;
	}

	public List<String> getRegisteredDrivers() {
		return registeredDrivers;
	}
	
	
	

}
