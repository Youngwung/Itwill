package com.itwill.lambda01;

public class Calculator {
	
	// 함수형 인터페이스(FunctionalInterface): 추상 메서드를 오직 1개만 갖는 인터페이스.(인지 검사하도록 컴파일러에게 지시.)
	@FunctionalInterface
	public interface Calculable {
		double calculate(double x, double y);
	}
	
	//field
	private double x;
	private double y;
	
	//constructor
	public Calculator(double x, double y) {
		this.x = x;
		this.y = y;
	}
	// 인터페이스를 아규먼트로 받고 인터페이스가 가지고있는 메서드를 리턴해주는 메서드.
	public double calculate(Calculable calc) {
		return calc.calculate(x, y);
	}
	
}
