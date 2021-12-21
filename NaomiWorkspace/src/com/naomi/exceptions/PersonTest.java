package com.naomi.exceptions;

public class PersonTest {

	public static void main(String[] args) {

		Person p = new Person();
		try {
			int age = (int)(Math.random()*201); //0-200
			p.setAge(age);
		} catch (PersonAgeExceptions e) {
			System.err.println(e.getMessage());
		}
		System.out.println("age: " + p.getAge());
	}
}
