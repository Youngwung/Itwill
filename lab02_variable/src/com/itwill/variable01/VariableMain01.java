package com.itwill.variable01;

public class VariableMain01 {

	public static void main(String[] args) {
		// 변수(variable): 프로그램에서 필요한 데이터를 저장하는 메모리 공간.
		// 변수 사용:
		// (1) 변수 선언: 저장하는 데이터의 종류(타입)와 변수 이름을 선언. 
		// (2) 변수 초기화: 변수에 값을 처음 저장하는 것.
		int age; //정수(integer)를 저장하는 변수 age  					=> 변수 선언
		age = 28; // 변수 age를 28로 초기화(변수 age에 정수 28을 저장)  => 변수 초기화
		
		System.out.println("나이: "+ age);
		
		int x = 100; //변수를 선언과 동시에 초기화(변수 선언과 초기화를 한 문장으로 작성)
		System.out.println("x = " + x);
		
		// 자바(Java)의 기본 데이터 타입(총 8가지)
		// 정수 타입: byte, short, int, long, char
		// 실수 타입: float, double
		// 논리 타입: boolean
		
		long number = 123_456_789_000L; //long으로 선언해도 가능하면 int로 선언됨, int로 불가능하면 숫자끝에 L
		double pi = 3.141592;
		boolean isMarried = false;
		
		// 변수 이름 작성 규칙: 
		// - 변수 이름은 알파벳, 숫자, _, $ 만 사용 가능.
		// - 변수 이름은 대소문자를 구분함. ex) x, X는 서로 다른 변수.
		// - 변수 이름은 숫자로 시작할 수 없음.
		// - 변수 이름으로 자바의 키워드(예약어)는 사용할 수 없음. int, class, public 등등
		////////////////////////////////////////////여기까지문법 아래는관습///////////////////////////
		
		// - 변수 이름은 변수 역할에 어울리는 "의미 있는" 단어를 사용해서 만드는 것을 권장.
		// - 변수 이름은 2개 이상의 단어를 붙여서 만들 경우에는 "소문자"로 시작하는 camel 표기법을 권장.
		// ex) userId, userPassword
		// 비교) snake 표기법: user_id, user_password, is_married
		
	}

}
