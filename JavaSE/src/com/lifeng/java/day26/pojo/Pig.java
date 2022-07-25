package com.lifeng.java.day26.pojo;

import java.io.Serializable;

public class Pig implements Serializable {
	private String name;
	private int age;
	public Pig() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pig(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Pig [name=" + name + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
		
}
