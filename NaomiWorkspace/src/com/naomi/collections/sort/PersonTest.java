package com.naomi.collections.sort;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {

	public static void main(String[] args) {

		List<Person> list = new ArrayList<>();
		list.add(new Person(105,"Naomi", 21));
		list.add(new Person(101,"Ruven", 20));
		list.add(new Person(107,"Odel", 17));
		list.add(new Person(103,"Talya", 14));
		list.add(new Person(100,"Eytan", 12));
		//print the list
		System.out.println(list);
		
		//sort the list by id (the natural)
		list.sort(null);
		//print the list after sort by id
		System.out.println(list);
		
		PersonNameComparator comparator = new PersonNameComparator();
		//sort the list by name
		list.sort(comparator);
		//print the list after sort by name
		System.out.println(list);
	}

}
