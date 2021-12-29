package com.naomi.projects.cars;

import java.util.Arrays;

public class Country {
	
	private Highway[] highways = new Highway[5];

	public Country() {
	}
	
	public Country(Highway[] highways) {
		this.highways = highways;
	}
	
	public void addHighway(Highway highway) {
		for (int i = 0; i < highways.length; i++) {
			if(this.highways[i] == null) {
				this.highways[i] = highway;
				return;
			}
		}
	}

	public Highway[] getHighways() {
		return highways;
	}

	@Override
	public String toString() {
		return "Country [highways=" + Arrays.toString(highways) + "]";
	}
	
	
	
	

}
