package com.naomi.projects.school;

import com.naomi.projects.school.Grade.Profession;

public class School {

	public static final int MAX_CLASSROOMS = 5;

	private ClassRoom[] classRooms = new ClassRoom[MAX_CLASSROOMS];

	public School() {
	}

	public School(ClassRoom[] classRooms) {
		this.classRooms = classRooms;
	}

	public ClassRoom[] getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(ClassRoom[] classRooms) {
		this.classRooms = classRooms;
	}
	
	public double avgScores() {
		double sumScores = 0;
		for (ClassRoom classRoom : classRooms) {
			sumScores += classRoom.avgScores();
		}
		return sumScores / MAX_CLASSROOMS;
	}
	
	public double avgScoresForProfession(Profession profession) {
		double sumScores = 0;
		for (ClassRoom classRoom : classRooms) {
			sumScores += classRoom.avgScoresForProfession(profession);
		}
		return sumScores / MAX_CLASSROOMS;
	}
	
	public int amountTeachersForProfession(Profession profession) {
		int amount = 0;
		for (ClassRoom classRoom : classRooms) {
			if(classRoom.getTeacher().getProfession() == profession) {
				amount++;
			}
		}
		return amount;
	}

}
