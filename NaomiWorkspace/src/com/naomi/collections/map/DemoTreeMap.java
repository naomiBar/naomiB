package com.naomi.collections.map;

import java.util.Map;
import java.util.TreeMap;

public class DemoTreeMap {

	public static void main(String[] args) {

		Map<String, String> map = new TreeMap<>();
		map.put("java", "a programming lanuage");
		map.put("table", "a furniture");
		map.put("dog", "an animal that barks");

		System.out.println(map);
		
		for(String key:map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
	}

}
