package com.naomi.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

public class DemoLinkedHashSet {

	public static void main(String[] args) {

		//create a set:
		Set<String> set = new LinkedHashSet<>();
		//print set size (number of elements):
		System.out.println("size: " + set.size());
		//add elements to set:
		set.add("hello");
		set.add("java");
		set.add("world");
		set.add("hello");
		set.add("java");		
		//print the set:
		System.out.println(set);
		//print set size (number of elements):
		System.out.println("size: " + set.size());
		
	}

}
