package com.itwill.file06;

import java.io.Serializable;

public class Student implements Serializable{
	
	private int id;
	private String name;
	private Score score;
	
	//TODO Constructor, get/set, toString.
	public Student() {}
	public Student(int id, String name, Score score) {
		super();
		this.score = score;
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
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
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
}
	