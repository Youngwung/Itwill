package com.itwill.singleton;

/*
 * 	싱글턴(singleton): 힙에 오직 한 개만 존재하는 객체.
 *  싱글턴 디자인 패턴(singleton design pattern):
 *	클래스를 설계할 때 객체를 오직 하나만 생성할 수 있도록 작성하는 디자인 패턴. 
 *	(1) private static field => 타입 이름은 자기 클래스 이름 여기선 Captain
 *	(2) private constructor (생성자) => 다른 클래스에서 생성하지 못하게 만들기 위함.
 *	(3) public static method => 오직 한 개의 생성자를 만들어주는 메서드
 *
 *	데이터를 관리하는 객체를 만드는 경우 쓰일 수 있음.
 *	데이터 관리 객체가 여러개인 경우 서로 다른 객체가 관리하는 데이터가 달라질 수 있기 떄문에 사용할 수 있음.
 */


public class Captain {
	// (1)
	private static Captain instance = null;
	
	private String name;
	
	// (2)
	private Captain () {
		this.name = "캡틴 아메리카";
	}	// 자바에서 자동으로 만들어주는 기본생성자는 public 이므로 private으로 만들어줌.
	
	// (3)
	public static Captain getInstance() {
		if (instance == null) {
			instance = new Captain();
		}
		
		return instance;
	}
	
	//getter
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
