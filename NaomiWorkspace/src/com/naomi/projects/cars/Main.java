package com.naomi.projects.cars;

public class Main {

	public static void main(String[] args) {

		Country country = new Country();
		createCountry(country);

		initializeCountry(country);
		showCountry(country);

		System.out.println("amountCars in country: " + amountCars(country));
		
		System.out.println("avgSpeed in country: " + avgSpeed(country));
		
		System.out.println("maxSpeed in country: " + maxSpeed(country));
		
		System.out.println("busyHighway in country: " + busyHighway(country));
		
	}

	private static void createCountry(Country country) {
		for (int i = 0; i < country.getHighways().length; i++) {
			Highway highway = new Highway("highway " + (i + 1));
			country.addHighway(highway);
		}
	}

	private static void initializeCountry(Country country) {

		int lenCars = 5;
		for (int i = 0; i < country.getHighways().length; i++) {
//			int lenCars = country.getHighways()[i].getCars().length;
			for (int j = 0; j < lenCars; j++) {
				int speed = (int) (Math.random() * 151);
				Car car;
				if (Math.random() > 0.5) {
					car = new FamilyCar((j + 1), speed);
				} else {
					car = new SportsCar((j + 1), speed);
				}
				country.getHighways()[i].addCar(car);
			}
			lenCars++;
		}
	}

	private static void showCountry(Country country) {
		for (int i = 0; i < country.getHighways().length; i++) {
			System.out.println(country.getHighways()[i]);
		}
	}

	private static int amountCarsInHighway(Highway highway) {
		int amount = 0;
		for (int i = 0; i < highway.getCars().length; i++) {
			if (highway.getCars()[i] != null) {
				amount++;
			}
		}
		return amount;
	}

	private static int amountCars(Country country) {
		int amount = 0;
		for (int i = 0; i < country.getHighways().length; i++) {
			int amountCarsInHighway = amountCarsInHighway(country.getHighways()[i]);
			System.out.println(country.getHighways()[i].getName() + ": amountCars - " + amountCarsInHighway);
			amount+=amountCarsInHighway;
		}
		return amount;
	}

	private static double avgSpeedinHighway(Highway highway) {
		int sum = 0, count = 0;
		for (int i = 0; i < highway.getCars().length; i++) {
			if(highway.getCars()[i] != null) {
				sum += highway.getCars()[i].getSpeed();
				count++;
			}
		}
		return sum/count;
	}
	
	private static double avgSpeed(Country country) {
		double sum = 0;
		int count = 0;
		double maxAvg = 0;
		String nameHighwayOfMaxAvg = "";
		
		for (int i = 0; i < country.getHighways().length; i++) {
			double avgSpeedinHighway = avgSpeedinHighway(country.getHighways()[i]);
			System.out.println(country.getHighways()[i].getName() + ": avgSpeed - " + avgSpeedinHighway);
			if(avgSpeedinHighway > maxAvg) {
				maxAvg = avgSpeedinHighway;
				nameHighwayOfMaxAvg = country.getHighways()[i].getName();
			}
			sum += avgSpeedinHighway;
			count++;
		}
		System.out.println("nameHighwayOfMaxAvg is " + nameHighwayOfMaxAvg + " with speed: " + maxAvg);
		return sum/count;
	}

	private static int maxSpeedinHighway(Highway highway) {
		int maxSpeed = 0;
		for(int i=0; i<highway.getCars().length; i++) {
			if(highway.getCars()[i] != null) {
				if(highway.getCars()[i].getSpeed() > maxSpeed) {
					maxSpeed = highway.getCars()[i].getSpeed();
				}				
			}
		}
		return maxSpeed;
	}
	
	private static int maxSpeed(Country country) {
		int maxSpeed = 0;
		for (int i = 0; i < country.getHighways().length; i++) {
			int maxSpeedinHighway = maxSpeedinHighway(country.getHighways()[i]);
			System.out.println(country.getHighways()[i].getName() + ": maxSpeed - " + maxSpeedinHighway);
			if(maxSpeedinHighway>maxSpeed) {
				maxSpeed = maxSpeedinHighway;
			}
		}
		return maxSpeed;
	}

	private static String busyHighway(Country country) {
		int maxCars = 0;
		String nameOfbusyHighway = "";
		for(int i=0; i<country.getHighways().length; i++) {
			int cars = 0;
			for(int j=0; j<country.getHighways()[i].getCars().length; j++) {
				if(country.getHighways()[i].getCars()[j]  != null) {
					cars++;
				}
			}
			if(cars>maxCars) {
				maxCars = cars;
				nameOfbusyHighway = country.getHighways()[i].getName();
			}
		}
		
		return nameOfbusyHighway;
	}

}
