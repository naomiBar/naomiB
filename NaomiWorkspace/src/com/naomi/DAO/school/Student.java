package com.naomi.DAO.school;

public class Student {

	private int id;
	private int school_id;
	private String name;
	private String email;
	
	public Student() {
	}

	
	public Student(int school_id, String name, String email) {
		this.school_id = school_id;
		this.name = name;
		this.email = email;
	}

	public Student(int id, int school_id, String name, String email) {
		this(school_id, name, email);
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSchool_id() {
		return school_id;
	}


	public void setSchool_id(int school_id) {
		this.school_id = school_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", school_id=" + school_id + ", name=" + name + ", email=" + email + "]";
	}
	
}
