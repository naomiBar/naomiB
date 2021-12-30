package com.naomi.projects.school;

import com.naomi.projects.school.Grade.Profession;

public class Teacher extends Person {

	private Profession profession;

	public Teacher() {
	}

	public Teacher(Name name, int age) {
		super(name, age);
	}

	public Teacher(Name name, int age, Profession profession) {
		super(name, age);
		this.profession = profession;
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Teacher [" + super.toString() + ", profession = " + profession + "]";
	}

	
	
	

}
