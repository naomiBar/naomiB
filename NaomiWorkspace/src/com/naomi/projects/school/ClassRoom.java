package com.naomi.projects.school;

import com.naomi.projects.school.Grade.Profession;

public class ClassRoom {
	
	public static final int MAX_STUDENTS = 15;
	
	private String name;
	private Teacher teacher;
	private Student[] students = new Student[MAX_STUDENTS];
	
	public ClassRoom() {
	}
	
	public ClassRoom(String name, Teacher teacher) {
		this.name = name;
		this.teacher = teacher;
	}
	
	public ClassRoom(String name, Teacher teacher, Student[] students) {
		this(name, teacher);
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	@Override
	public String toString() {
		String str = "";
		for (Student student : students) {
			str += "\n\t\t" + student;
		}
		return "ClassRoom: name = " + name + ",\n\t teacher = " + teacher + ",\n\t students: " + str;
	}
	
	public double avgScores() {
		double sumScores = 0;
		for (Student student : students) {
			sumScores += student.avgScores();
		}
		return sumScores / MAX_STUDENTS;
	}
	
	public double avgScoresForProfession(Profession profession) {
		int sumScores = 0;
		for (Student student : students) {
			sumScores += student.ScoreForProfession(profession);
		}
		return sumScores / MAX_STUDENTS;
	}
	
}
