package com.itwill.singleton;

public enum Singleton {
	
	INSTANCE; // public static final Singleton Instance = new Singleton();
	
	private String name;

	// enum 타입의 생성자는 private만 가능, private 수식어는 생략 가능.
	Singleton() { // private Singleton
		this.name = "헐크";
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
