package com.itwill.class03;

public class Person {
	// field
	String name;
	int age;
	
	
	// construct
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// method
	public void introduce() {
		System.out.printf("제 이름은 %s, 나이는 %d입니다.\n",name, age);
	}
}
