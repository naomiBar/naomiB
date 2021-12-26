package com.naomi.exercises.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Ex_Set {

	public static void main(String[] args) {

		// exercise 4
		Set<String> set1 = new HashSet<>();
		set1.add("naomi");
		set1.add("odel");
		set1.add("talya");
		System.out.println("the set: " + set1);

		Iterator<String> it = set1.iterator();
		it.next();
		it.next();
		System.out.println(it.next());
		
		System.out.println("=================");

		// exercise 5
		Set<Integer> set2 = new LinkedHashSet<>();
		while(set2.size() < 10) {
			set2.add((int) (Math.random() * 11));
		}
		System.out.println("the set: " + set2);
		
		Iterator<Integer> it1 = set2.iterator();
		while(it1.hasNext()){
			if(it1.next()%2==0) {
				it1.remove();
			}
		}
		System.out.println("the new set: " + set2);
	}

}
