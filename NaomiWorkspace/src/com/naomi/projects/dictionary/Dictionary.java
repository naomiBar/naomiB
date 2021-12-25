package com.naomi.projects.dictionary;

import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Dictionary {

	private Map<String, String> map;
	
	private Dictionary() {
		map = new TreeMap<>();
	}

	private static Dictionary instance = new Dictionary();

	public static Dictionary getInstance() {
		return instance;
	}


	
	public void addEntry(String key, String value) {
		map.put(key, value);
	}
	
	public String getDefinition(String key) {
		return map.get(key);
	}
	
	public void editEntry(String key, String value) {
		map.replace(key, value);
	}

	public void deleteEntry(String key) {
		map.remove(key);
	}
	
	public Set<String> getAllEntriesSorted() {
		return map.keySet();
	}
	
}
