package com.pp.admin.hibernate;

public class User {
	
	private Integer id;
	
	private String shortName;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	

	public String getShortName() {
		return shortName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	

}
