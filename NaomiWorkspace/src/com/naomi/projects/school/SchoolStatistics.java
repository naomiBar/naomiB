package com.naomi.projects.school;

import com.naomi.projects.school.Grade.Profession;
import com.naomi.projects.school.Person.Name;

public class SchoolStatistics {

	public static void main(String[] args) {

		School school = new School();

		createSchool(school);
		showSchool(school);
		
		System.out.println("\n ==================== \n");
		showAvgScoresOfClassRoom(school);
		System.out.println("the average of school: " + school.avgScores());
		
		System.out.println("\n ==================== \n");
		showAvgScoresForProfessionOfClassRoom(school);

		System.out.println("\n ==================== \n");
		showAvgScoresForProfessionOfSchool(school);
		
		System.out.println("\n ==================== \n");
		int[] arr = amountStudents20_30(school);
		System.out.println(arr[0] + " amountStudents20_30 and their average is " + arr[1]);

		arr = amountStudents31(school);
		System.out.println(arr[0] + " amountStudents31 and their average is " + arr[1]);
		
		System.out.println("avgAgesOfStudents: " + avgAgesOfStudents(school));
		
		System.out.println("\n ==================== \n");
		showAmountTeachersForProfession(school);
		
		System.out.println("\n ==================== \n");
		showTeamSport(teamSport(school));
		
	}

	private static Student createStudent() {
		Name name = Person.Name.values()[(int) (Math.random() * Person.LEN_NAMES)];
		int age = (int) (Math.random() * Person.MAX_AGE - Person.MIN_AGE + 1) + Person.MIN_AGE;

		Grade[] grades = new Grade[Grade.LEN_PROFESSIONS];
		for (int i = 0; i < grades.length; i++) {
			Profession profession = Grade.Profession.values()[i];
			int score = (int) (Math.random() * Grade.MAX_SCORE - Grade.MIN_SCORE + 1) + Grade.MIN_SCORE;
			grades[i] = new Grade(profession, score);
		}
		return new Student(name, age, grades);
	}

	private static Teacher createTeacher() {
		Name name = Person.Name.values()[(int) (Math.random() * Person.LEN_NAMES)];
		int age = (int) (Math.random() * Person.MAX_AGE - Person.MIN_AGE + 1) + Person.MIN_AGE;
		Profession profession = Grade.Profession.values()[(int) (Math.random() * Grade.LEN_PROFESSIONS)];

		return new Teacher(name, age, profession);
	}

	private static void createSchool(School school) {
		for (int i = 0; i < School.MAX_CLASSROOMS; i++) {
			Student[] students = new Student[ClassRoom.MAX_STUDENTS];
			for (int j = 0; j < students.length; j++) {
				students[j] = createStudent();
			}
			school.getClassRooms()[i] = new ClassRoom("class " + (i + 1), createTeacher(), students);
		}
	}

	private static void showSchool(School school) {
		for(int i=0; i<School.MAX_CLASSROOMS; i++) {
			System.out.println(school.getClassRooms()[i]);
		}
	}

	private static void showAvgScoresOfClassRoom(School school) {
		for (int i = 0; i < School.MAX_CLASSROOMS; i++) {
			System.out.println("average of " + school.getClassRooms()[i].getName() +
					": " + school.getClassRooms()[i].avgScores());
		}
	}

	private static void showAvgScoresForProfessionOfClassRoom(School school) {
		for (int i = 0; i < School.MAX_CLASSROOMS; i++) {
			System.out.println("avgScores of " + school.getClassRooms()[i].getName() + ":");
			for(int j=0; j<Grade.LEN_PROFESSIONS; j++) {
				Profession profession = Grade.Profession.values()[j];
				System.out.println("\tfor profession " + profession + " is " +
						school.getClassRooms()[i].avgScoresForProfession(profession));
			}
		}
	}
	
	private static void showAvgScoresForProfessionOfSchool(School school) {
		System.out.println("avgScores of school:");
		for(int i=0; i<Grade.LEN_PROFESSIONS; i++) {
			Profession profession = Grade.Profession.values()[i];
			System.out.println("\tfor profession " + profession + " is " +
					school.avgScoresForProfession(profession));
		}
	}

	private static int[] amountStudents20_30(School school) {
		int[] arr = new int[2]; //{amount,avgScores}
		
		for(int i=0; i<School.MAX_CLASSROOMS; i++) {
			for(int j=0; j<ClassRoom.MAX_STUDENTS; j++) {
				int ageStudent = school.getClassRooms()[i].getStudents()[j].getAge();
				if(ageStudent >= 20 && ageStudent <= 30) {
					arr[0]++;
					arr[1] += school.getClassRooms()[i].getStudents()[j].avgScores();
				}
			}
		}
		arr[1] = arr[1] / arr[0];
		return arr;
	}

	private static int[] amountStudents31(School school) {
		int[] arr = new int[2]; //{amount,avgScores}
		
		for(int i=0; i<School.MAX_CLASSROOMS; i++) {
			for(int j=0; j<ClassRoom.MAX_STUDENTS; j++) {
				int ageStudent = school.getClassRooms()[i].getStudents()[j].getAge();
				if(ageStudent >= 31) {
					arr[0]++;
					arr[1] += school.getClassRooms()[i].getStudents()[j].avgScores();
				}
			}
		}
		arr[1] = arr[1] / arr[0];
		return arr;
	}

	private static double avgAgesOfStudents(School school) {
		int sum = 0, count = 0;
		for(int i=0; i<School.MAX_CLASSROOMS; i++) {
			for(int j=0; j<ClassRoom.MAX_STUDENTS; j++) {
				int ageStudent = school.getClassRooms()[i].getStudents()[j].getAge();
				sum += ageStudent;
				count++;
			}
		}
		return sum / count;
	}
	
	private static void showAmountTeachersForProfession(School school) {
		System.out.println("showAmountTeachers:");
		for(int i=0; i<Grade.LEN_PROFESSIONS; i++) {
			Profession profession = Grade.Profession.values()[i];
			int amount = school.amountTeachersForProfession(profession);
			System.out.println("\tfor profession " + profession + " is " + amount);
		}
	}
	
	private static Student[] teamSport(School school) {
		Student[] students = new Student[School.MAX_CLASSROOMS * ClassRoom.MAX_STUDENTS];
		int count = 0;
		for (int i = 0; i < School.MAX_CLASSROOMS; i++) {
			for (int j = 0; j < ClassRoom.MAX_STUDENTS; j++) {
				for (int h = 0; h < Grade.LEN_PROFESSIONS; h++) {
					Profession professionStudent = school.getClassRooms()[i].getStudents()[j].getGrades()[h].getProfession();
					int scoreProfession = school.getClassRooms()[i].getStudents()[j].getGrades()[h].getScore();
					if(professionStudent == Grade.Profession.SPORTS && scoreProfession > 90) {
						students[count++] = school.getClassRooms()[i].getStudents()[j];
					}
				}
			}
		}
		return students;
	}

	private static void showTeamSport(Student[] teamSport) {
		for (Student student : teamSport) {
			if(student != null) {
				System.out.println(student);
			}
		}
	}
}
