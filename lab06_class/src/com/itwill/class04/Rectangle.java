package com.itwill.class04;

public class Rectangle {
	
	//field
	double width; // 직사각형의 가로 길이
	double height; // 직사각형의 세로 길이
	
	//생성자
	// (1) 기본 생성자
	// (2) 가로/세로를 아규먼트로 전달받아서 초기화 하는 생성자
	
	public Rectangle() {
		
	}
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	//method
	// (1) 넓이를 리턴
	public double area() {
	
		return this.height * this.width;
	}
	
	// (2) 둘레 길이를 리턴
	public double round() {
		return 2*(this.height + this.width);
	}
	
	
}
