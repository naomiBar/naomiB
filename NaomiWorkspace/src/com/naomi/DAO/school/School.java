package com.naomi.DAO.school;

public class School {

	private int id;
	private String name;
	private String address;
	
	public School() {
	}

	public School(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public School(int id, String name, String address) {
		this(name, address);
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
		
}
