package com.naomi.collections.list;

import java.util.LinkedList;
import java.util.List;

public class DemoLinkedList {

	public static void main(String[] args) {

		//create a list:
		List<String> list = new LinkedList<>();
		//print list size (number of elements):
		System.out.println("size: " + list.size());
		//add elements to list:
		list.add("hello");
		list.add("java");
		list.add("world");
		list.add("hello");
		list.add("java");		
		//print the list:
		System.out.println(list);
		//print list size (number of elements):
		System.out.println("size: " + list.size());
		//get element by index:
		System.out.println("element in index 2: " + list.get(2));
		
	}

}
