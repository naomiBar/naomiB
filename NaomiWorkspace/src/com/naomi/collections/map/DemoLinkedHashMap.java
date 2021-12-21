package com.naomi.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class DemoLinkedHashMap {

	public static void main(String[] args) {

		Map<String, String> map = new LinkedHashMap<>();
		map.put("java", "a programming lanuage");
		map.put("table", "a furniture");
		map.put("dog", "an animal that barks");

		System.out.println(map);
		for(String key:map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
	}

}
