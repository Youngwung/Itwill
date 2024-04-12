package com.itwill.inheritance06;

public class InheritanceMain06 {

	
	public static void main(String[] args) {
		// 기본 생성자를 사용해서 Point 타입 객체 생성
		Point p1 = new Point();
		System.out.println(p1); // p1.toString()

		// 아규먼트를 갖는 생성자를 사용해서 Point 타입 객체 생성
		Point p2 = new Point(0, 0);
		System.out.println(p2); // p2.toString()

		System.out.println("equals() 메서드 결과: " + p1.equals(p2));
		System.out.println("비교 연산자 == 결과: " + (p1 == p2)); // p1과 p2의 주소값을 비교.
		// 객체의 동등비교에서는 비교 연산자(==, !=)를 사용하면 안됨!
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

		// String 객체의 동등(equals) 비교
		String s1 = new String("hello"); // new로 생성한 String은 같은 문자열이어도 참조값이 서로 다름.
		String s2 = new String("hello");
		System.out.println("p1, p2 비교 연산자 == 결과: " + (s1 == s2)); // p1과 p2의 주소값을 비교. 결과: false.
		System.out.println("p1, p2 equals() 메서드 결과: " + s1.equals(s2));

		String s3 = "hello"; // new 없이 만든 String은 같은 문자열이면 참조값이 서로 같음.
		String s4 = "hello";

		System.out.println("p3, p4 비교 연산자 == 결과: " + (s3 == s4)); // p3와 p4의 주소값을 비교. 결과: true.
		System.out.println("p3, p4 equals() 메서드 결과: " + s3.equals(s4));

		User u1 = new User("duddnd", "1234");
		User u2 = new User("duddnd", "5678");
		User u3 = new User();
		System.out.println(u1.toString());
		System.out.println(u2.toString());
		System.out.println(u3.toString());
		
		System.out.println(u1.equals(u2));
		System.out.println(u1.equals(u3));
		System.out.println(u3.equals(u1));
		
		System.out.println(u1.hashCode());
		System.out.println(u2.hashCode());
		System.out.println(u3.hashCode());
		
		

	}

}
