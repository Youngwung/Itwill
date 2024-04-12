package com.itwill.inheritance01;

// 스마트TV는 기본TV를 확장(상속)한다. 사용조건은 스마트TV는 기본TV를 포함.
// 상위(super), 부모(parent) 클래스, 기본(base) 클래스 - BasicTv  =>자주쓰는 단어는 상위(super)
// 하위(sub), 자식(child) 클래스, 유도(derived) 클래스 - SmartTv  					하위(sub) 
// 모든 클래스의 최상위 클래스는 java.lang.Object 클래스.
// 상위클래스가 Object인 경우 extends java.lang.Object는 생략 가능.(대부분 생략)
public class SmartTv extends BasicTv {
	
	private String ip;
	
	public void webBrowsing() {
		System.out.println("인터넷 연결");
	}
	
	public void checkChannel() {
//		System.out.println(channel); 상위클래스에서 private로 선언된 필드는 아무리 하위클래스여도 접근이 불가
		System.out.println(getChannel()); //getter를 사용해서 접근한다. => 또는 변수를 선언할 때 private 대신 protected로 선언한다.
	}
	
}
