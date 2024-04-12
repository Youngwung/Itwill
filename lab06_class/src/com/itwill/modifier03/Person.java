package com.itwill.modifier03;

public class Person {
	// field
	private String name; // 읽기 전용 필드
	private int age; // 읽기/쓰기 필드

	// constructor
	
	public Person(String name, int age) {
		if (name != null) {
			this.name = name;
			this.age = age;
		} else {
			throw new IllegalArgumentException();
		}
	}

	// method

		// getter
	public String getterName() {
		return this.name;
	}
	public int getterAge() {
		return this.age;
	}

		// setter
	public void setterAge(int age) { 
		this.age = age;
	}

}
