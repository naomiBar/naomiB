package com.naomi.projects.school;

public abstract class Person {

	public enum Name{
		NAOMI, ODEL, DAN, RON, DOR, DAVID, SARAH, MIRI, SHACHAR, NOA, MICHAL, NOAM;
	}
	public static final int LEN_NAMES = Name.values().length;
	
	public static final int MIN_AGE = 20;
	public static final int MAX_AGE = 120;

	private Name name;
	private int age = MIN_AGE;

	public Person() {
	}

	public Person(Name name, int age) {
		this.name = name;
		setAge(age);
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= MIN_AGE && age <= MAX_AGE) {
			this.age = age;
		}
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
