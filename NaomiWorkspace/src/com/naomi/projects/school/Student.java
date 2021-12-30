package com.naomi.projects.school;

import java.util.Arrays;

import com.naomi.projects.school.Grade.Profession;

public class Student extends Person {

	private Grade[] grades = new Grade[Grade.LEN_PROFESSIONS]; // one of each profession

	public Student() {
		super();
	}

	public Student(Name name, int age) {
		super(name, age);
	}

	public Student(Name name, int age, Grade[] grades) {
		super(name, age);
		this.grades = grades;
	}

	public Grade[] getGrades() {
		return grades;
	}

	public void setGrades(Grade[] grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + ", grades = " + Arrays.toString(grades) + "]";
	}

	public double avgScores() {
		int sumScores = 0;
		for (Grade grade : grades) {
			sumScores += grade.getScore();
		}
		return sumScores / Grade.LEN_PROFESSIONS;
	}
	
	public int ScoreForProfession(Profession profession) {
		for (Grade grade : grades) {
			if(grade.getProfession() == profession) {
				return grade.getScore();
			}
		}
		return 0;
	}

}
