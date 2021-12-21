package com.naomi.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DemoHashMap {

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("java", "a programming lanuage");
		map.put("table", "a furniture");
		map.put("dog", "an animal that barks");

		System.out.println(map);
		for(String key:map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
		System.out.println("==============");
		
		System.out.println("java: " + map.get("java"));
//		System.out.println(map.);
		
		System.out.println("==============");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter word: ");
		String key = sc.nextLine();
		if(map.containsKey(key)) {
			System.out.println(key + ": " + map.get(key));
		}else {
			System.out.println("sorry. " + key + " is not in dictionary");
		}
		sc.close();
	}

}
