package com.jyoti.entity;

import java.io.Serializable;


public class Student implements Serializable {

	private final Integer id;
	private final String name;

	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
