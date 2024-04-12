package com.itwill.class04;

public class ClassMain04 {

	public static void main(String[] args) {
		// 기본생성자를 사용해서 Rectangle 객체 생성, 메서드 호출
		Rectangle rec1 = new Rectangle();
		System.out.println(rec1);
		System.out.println("직사각형의 넓이: "+ rec1.area());
		System.out.println("직사각형의 둘레: "+ rec1.round());
		
		
		// 가로, 세로 길이를 아규먼트로 받는 생성자
		Rectangle rec2 = new Rectangle(3,4);
		System.out.println(rec2);
		System.out.println("직사각형의 넓이: "+ rec2.area());
		System.out.println("직사각형의 둘레: "+ rec2.round());

	}

}
