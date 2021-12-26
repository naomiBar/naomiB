package com.naomi.projects.dictionary;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Dictionary {

	private Map<String, String> map = new TreeMap<>();
	
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
