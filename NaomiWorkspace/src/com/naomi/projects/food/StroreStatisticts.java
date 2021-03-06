package com.naomi.projects.food;

import com.naomi.projects.food.Food.Taste;

public class StroreStatisticts {

	public static void main(String[] args) {

		Store store = new Store();
		createStore(store);

		System.out.println("amountFruits: " + amountFoods(store.getFruits()));
		System.out.println("amountVegetables: " + amountFoods(store.getVegetables()));
		
		System.out.println("\n\t For Fruits");
		showWeight(store.getFruits());
		System.out.println("\n\t For Vegetables");
		showWeight(store.getVegetables());
		
		System.out.println("\n\t Fruits");
		printFoods(store.getFruits());
		
		System.out.println("\n\t Vegetables");
		printFoods(store.getVegetables());
		
		
	}

	private static void createStore(Store store) {
		int lenFruits = store.getFruits().length;
		int lenVegetables = store.getVegetables().length;
		for (int i = 0; i < lenFruits + lenVegetables; i++) {
			
			double weight = (Math.random() * 6);
			int lenTaste  = Taste.values().length;
			Taste taste = Taste.values()[(int) (Math.random() * lenTaste)];
			
			if (i < lenFruits) {
				Fruit fruit;
				if ((Math.random()) > 0.5) {
					fruit = new Apple(weight, taste);
				} else {
					fruit = new Strawbery(weight, taste);
				}
				store.addFruit(fruit);
			} 
			else {
				Vegetable vegetable;
				if ((Math.random()) > 0.5) {
					vegetable = new Carrot(weight, taste);
				} else {
					vegetable = new Tomato(weight, taste);
				}
				store.addVegetable(vegetable);
			}
		}
	}


	private static int amountFoods(Food[] foods) {
		int sum = 0;
		for (int i = 0; i < foods.length; i++) {
			if(foods[i] != null) {
				sum++;
			}
		}
		return sum;
	}

	private static void printFoods(Food[] foods) {
		for (int i = 0; i < amountFoods(foods); i++) {
			System.out.println(foods[i]);			
		}
	}

	private static void showWeight(Food[] foods) {
		double weightMax = foods[0].getWeight();
		double weightMin = foods[0].getWeight();
		double sum = 0; 
		for (int i = 0; i < amountFoods(foods); i++) {
			double weight = foods[i].getWeight();
			if(weight>weightMax) {
				weightMax = weight;
			}
			if(weight<weightMin) {
				weightMin = weight;
			}
			sum+=weight;
		}
		System.out.println("weightMax: " + weightMax);
		System.out.println("weightMin: " + weightMin);
		System.out.println("weightAvg: " + sum/amountFoods(foods));
	}

}
