package com.itwill.variable04;

public class VariableMain04 {

	public static void main(String[] args) {
		// 문자(character) 타입 변수 char
		// char 타입은 문자 1개의 유니코드 값(2바이트 정수)를 저장하는 타입.
		// 문자는 작은따옴표를 사용('a'), 문자열은 큰따옴표를 사용("abc")
		
		char ch1 = 'B';
		System.out.println(ch1);
		System.out.println((int) ch1);
		
		// char는 문자의 유니코드를 저장하는 특별한 종류의 정수 타입.
		// -> 사칙연산이 가능. 크기 비교도 가능.
		char ch2 = (char) (ch1 + 1);  //ch1은 char지만 사칙연산을 하기 위해 자동으로 int로 변경됨
		
		System.out.println(ch2);
		System.out.println((int) ch2);
		
		int ch3 = (ch2 + 1);
		System.out.println((char) ch3);
		System.out.println(ch3);

		// 1. 변수는 같은 타입의 값만 저장할 수 있음.
		// 2. 큰 범위의 타입에는 작은 범위 타입의 값을 저장할 수 있음. 
		// 3. 작은 범위의 타입에 큰 범위 값을 저장하려고 하면 에러가 발생.
		// 3-1 예외) 정수 리터럴(literal, 상수)은 범위를 넘지 않으면 byte, short, char에 저장 가능
				// short s = (short) 1; =>맞는 문법 1은 int이기때문
				// short s = 1;  => 정수에서 편의성 제공
		
		//강제 타입 변환(casting): 변수의 타입을 강제로 바꿈. 큰 범위값을 작은범위 타입에 저장하려고 사용
		
		
		
		
		
	}

}
