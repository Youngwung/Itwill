package com.itwill.inheritance08;

public class InheritanceMain08 {
	
	public static void main(String[]  args) {
		// Rectangle 타입의 객체 생성
//		Rectangle rect = new Rectangle(4.0, 3.0);
		Shape rect = new Rectangle(4.0, 3.0);
		rect.draw();
		// Circle 타입의 객체 생성
//		Circle cir = new Circle(1);
		Shape cir = new Circle(1);
		cir.draw();
	}

}
