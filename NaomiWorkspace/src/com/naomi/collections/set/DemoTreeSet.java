package com.naomi.collections.set;

import java.util.Set;
import java.util.TreeSet;

public class DemoTreeSet {

	public static void main(String[] args) {

		//create a set:
		Set<String> set = new TreeSet<>();
		//print set size (number of elements):
		System.out.println("size: " + set.size());
		//add elements to set:
		set.add("hello");
		set.add("world");
		set.add("java");
		set.add("hello");
		set.add("java");		
		//print the set:
		System.out.println(set);
		//print set size (number of elements):
		System.out.println("size: " + set.size());
		
	}

}
