package com.itwill.lambda01;

import com.itwill.lambda01.Calculator.Calculable;

public class LambdaMain01 {

	public static void main(String[] args) {
		// Calculator 타입 객체 생성
		Calculator calc = new Calculator(1, 2);

		// ------------별도 파일에 작성된 클래스 Adder 사용-----------
		// Calculable을 구현하는 객체 생성
		Calculator.Calculable adder = new Adder(); // Adder adder = new Adder();

		// Calcultor 객체의 메서드 호출.
		double result = calc.calculate(adder);
		System.out.println("result = " + result);
		// ------------지역 클래스를 사용한 코드----------------------
		class Subtracter implements Calculable {
			@Override
			public double calculate(double x, double y) {
				return x - y;
			}
		}
		result = calc.calculate(new Subtracter());
		System.out.println("result = " + result);

		// ------------익명 클래스를 사용한 코드------------------
		result = calc.calculate(new Calculable() {

			@Override
			public double calculate(double x, double y) {
				return x * y;
			}
		});
		System.out.println("result = " + result);

		// ------------ 람다 표현식 사용:
		calc.calculate((double x, double y) -> {return x / y;}); // 원래 람다 표현식.
		result = calc.calculate((x, y) -> x / y);
		System.out.println("result = " + result);

		result = calc.calculate((x, y) -> x * x + y * y);
		System.out.println("result = " + result);
		
		/*
		 * 람다 포현식(lambda expression): 익명 클래스 객체를 간단히 작성하기 위한 문법. 함수형 인터페이스(추상 메서드가 오직
		 * 1개인 인터페이스)만 람다 표현식을 사용할 수 있음.
		 * 
		 * 람다 표현식 문법: (파라미터 선언, ...) -> { 코드; } - 파라미터 선언에서 변수 타입은 생략 가능. - 람다 표현식
		 * 몸통({})에 한문장만 있는 경우, 중괄호와 세미콜론은 생략이 가능하다.
		 * 			(중괄호와 세미콜론은 세트) - 람다 포현식 몸통이 return
		 * 문장만 있는 경우에는, 리턴 값만 남김. (x, y) -> x/y - 람다 표현식에서 파라미터 개수가 1개인 경우에는 () 생략 가능.
		 * (x) -> 2 * x ==> x -> 2 * x - 파라미터가 없는 경우, ()는 생략 불가능! () -> "hello" ==xx=> -> "hello" 불가능.
		 *
		 * 
		 */
	}

}
