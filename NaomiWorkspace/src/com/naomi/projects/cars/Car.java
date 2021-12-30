package com.naomi.projects.cars;

public abstract class Car {

	private int number;
	private int speed; // 0-110
	public static final int MIN_SPEED = 0;
	public static final int MAX_SPEED = 110;
	

	public Car(int number) {
		this.number = number;
	}	
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSpeed() {
		return speed;
	}

	public boolean setSpeed(int speed) {
		if (speed >= MIN_SPEED && speed <= MAX_SPEED) {
			this.speed = speed;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [number=" + number + ", speed=" + speed + "]";
	}

}
