package com.naomi.collections.sort;

import java.util.Objects;

public class Person implements Comparable<Person>{
	
	private int id;
	private String name;
	private int age;
	
	@Override
	public int compareTo(Person other) {
		//return this.name.compareTo(other.name); // for String
		if(this.id<other.id) {
			return -1;
		}
		if(this.id>other.id) {
			return 1;
		}
		return 0;
	}
	
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return age == other.age && id == other.id && Objects.equals(name, other.name);
	}


}
