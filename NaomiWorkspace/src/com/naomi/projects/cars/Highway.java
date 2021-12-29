package com.naomi.projects.cars;

import java.util.Arrays;

public class Highway {
	
	private String name;
	private Car[] cars = new Car[50];
	
	
	public Highway(String name) {
		this.name = name;
	}
	
	public Highway(String name, Car[] cars) {
		this(name);
		this.cars = cars;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public void addCar(Car car) {
		for (int i = 0; i < cars.length; i++) {
			if(this.cars[i] == null) {
				this.cars[i] = car;
				return;
			}
		}
	}

	public Car[] getCars() {
		return cars;
	}

	@Override
	public String toString() {
		return "Highway [name=" + name + ", cars=" + Arrays.toString(cars) + "]";
	}
	
	
	

}
