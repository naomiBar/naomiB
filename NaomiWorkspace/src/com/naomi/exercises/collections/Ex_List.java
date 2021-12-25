package com.naomi.exercises.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.swing.Spring;

public class Ex_List {

	public static void main(String[] args) {

		// exercise 1
		List<Integer> list1 = new ArrayList<>();
		list1.add(5);
		list1.add(3);
		list1.add(8);
		System.out.println("the list: " + list1);
		System.out.println("third element: " + list1.get(2));
		int sum = 0;
		for (Integer num : list1) {
			sum += num;
		}
		System.out.println("sum of list: " + sum);
		System.out.println("average of list: " + (double) sum / list1.size());

		System.out.println("=================");

		// exercise 2
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			list2.add((int) (Math.random() * 61) + 20);
		}

		System.out.println("the list : " + list2);
		System.out.println("size of list: " + list2.size());
		System.out.println("first element: " + list2.get(0));
		System.out.println("last element: " + list2.get(list2.size() - 1));
		System.out.println("10th elemen: " + list2.get(9));

		// if(list2.contains(25)) { System.out.println("index: " + list2.indexOf(25)); }
		for (int i = 0; i < list2.size(); i++) {
			if (list2.get(i) == 25) {
				System.out.println("found 25!! index of this element: " + i);
			}
		}

		System.out.println("=================");

		// exercise 3
		List<Integer> list3 = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list3.add((int) (Math.random() * 6) + 5);
		}
		System.out.println("the list: " + list3);

		Set<Integer> set = new LinkedHashSet<>(list3);
		list3.clear(); // romove all the elements
		list3.addAll(set); // add all the elements without duplicates from the set
		System.out.println("the new list: " + list3);
	}

}
