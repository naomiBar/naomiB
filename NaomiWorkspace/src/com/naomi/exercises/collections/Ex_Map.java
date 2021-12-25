package com.naomi.exercises.collections;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ex_Map {

	public static void main(String[] args) {

		// exercise 6
		Map<Character, Integer> map1 = new LinkedHashMap<>();
		for(char ch ='A'; ch<= 'Z'; ch++) {
			map1.put(ch, (int)ch);
		}
		System.out.println("the map: " + map1);
		System.out.println("the keys: " + map1.keySet());
		System.out.println("the values: " + map1.values());

		System.out.println("=================");

		Map<Integer, String> map2 = new LinkedHashMap<>();
		map2.put(1, "Sunday");
		map2.put(2, "Monday");
		map2.put(3, "Tuesday");
		map2.put(4, "Wednesday");
		map2.put(5, "Thursday");
		map2.put(6, "Friday");
		map2.put(7, "Saturday");
		System.out.println("the map: " + map2);
		System.out.println("the keys: " + map2.keySet());
		System.out.println("the values: " + map2.values());
		
		System.out.println("=================");
		
		Map<Integer,String> map3 = new LinkedHashMap<>();
		map3.put(1, "ONE");
		map3.put(2, "TWO");
		map3.put(3, "THREE");
		map3.put(4, "FOUR");
		map3.put(5, "FIVE");
		System.out.println("the map: " + map3);
		System.out.println("the keys: " + map3.keySet());
		System.out.println("the values: " + map3.values());

		System.out.println("=================");

		// exercise 7
		Map<String, String> map4 = new TreeMap<>();
		map4.put("dog", "an animal that barks");
		map4.put("car", "a vehicle");
		map4.put("java", "a programming language");
		
		System.out.print("Enter a key: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		for(String key:map4.keySet()) {
			if(input.contains(key)) {
				System.out.println(key + ": " + map4.get(key));
			}
		}
//		System.out.println(input + ": " + map4.get(input));
		sc.close();
			
	}	
}
