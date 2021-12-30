package com.naomi.projects.school;

public class Grade {

	public enum Profession {
		MATH, CHEMISTRY, GEOGRAPHY, LITERATURE, PHYSICS, SPORTS;
	}
	public static final int LEN_PROFESSIONS = Profession.values().length;
	
	public static final int MIN_SCORE = 40;
	public static final int MAX_SCORE = 100;

	private Profession profession;
	private int score = MIN_SCORE;

	public Grade() {
	}

	public Grade(Profession profession, int score) {
		this.profession = profession;
		setScore(score);
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if (score >= MIN_SCORE && score <= MAX_SCORE) {
			this.score = score;
		}
	}

	@Override
	public String toString() {
		return "Grade [profession=" + profession + ", score=" + score + "]";
	}
	
	

}
