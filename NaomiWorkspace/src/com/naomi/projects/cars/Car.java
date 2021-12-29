package com.naomi.projects.cars;

public abstract class Car {



	private int number;
	private int speed; //0-110
	
	
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
		if(speed>=0 && speed<=110) {
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
