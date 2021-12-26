package com.naomi.projects.dictionary;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class Dictionary {

	private Map<String, String> map = new TreeMap<>();
	
	public void addEntry(String entry, String definition) throws DictionaryException {
		if(entry == null || entry.length() == 0 || definition == null || definition.length() == 0) {
			throw new DictionaryException("addEntry failed - invalid entry or definition");
		}
		if(map.containsKey(entry)) {
			throw new DictionaryException("addEntry failed - entry already exists");
		}
		map.put(entry, definition);
	}
	
	public String getDefinition(String entry) throws DictionaryException {
		if(!map.containsKey(entry)) {
			throw new DictionaryException("getDefinition failed - entry not exists");
		}
		return map.get(entry);
	}
	
	public void editEntry(String entry, String definition) throws DictionaryException {
		if (entry == null || entry.length() == 0 || definition == null || definition.length() == 0) {
			throw new DictionaryException("editEntry failed - invalid entry or definition");
		}
		if (!map.containsKey(entry)) {
			throw new DictionaryException("editEntry failed - entry not exists");
		}
		map.put(entry, definition);
	}

	public void deleteEntry(String entry) throws DictionaryException {
		if (!map.containsKey(entry)) {
			throw new DictionaryException("deleteEntry failed - entry not exists");
		}
		map.remove(entry);
	}
	
	public Set<String> getAllEntriesSorted() {
		return map.keySet();
	}
}
