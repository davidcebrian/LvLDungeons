package com.lvldungeons.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	private Integer id;
	
	private String name;

	public User() {
		super();
	}
	
	public User(String name) {
		super();
		this.name = name;
	}
	
	public User(Integer id, String name) {
		super();
		this.setId(id);
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
