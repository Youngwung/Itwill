package com.itwill.loop01;

public class LoopMain01 {

	public static void main(String[] args) {
		// 반복문
		System.out.println("Java1");
		System.out.println("Java2");
		System.out.println("Java3");
		System.out.println("Java4");
		System.out.println("Java5");
		// 가장 간단하게 복붙
		System.out.println("-------------");
		
		
		for (int i = 1; i<=5; i++) {
			System.out.println("Java" +i);
		}
		
		// 지역 변수(local valiable): 메서드 안에서 서언한 변수.
		// 지역 변수의 사용 범위:
		// 지역 변수는 선언된 순간부터 변수가 포함된 블록({...}) 안에서만 사용 가능.
		// 따라서 for문 안에서 선언된 i는 for문 밖의 메인메소드에서 사용 불가!
		// for 문장의 초기식(int i = 1;) 에서 선언된 (지역) 변수는 for 블록 안에서만 사용 가능!
		
		// 증가/감소 연산자 : ++ (1증가), -- (1감소)
		// 증가/감소 연산자는 변수 이름 앞 또는 뒤에서 사용 가능: i++, ++i  => 단독 사용 시 두 개의 의미는 같음.
		int x = 1;
		int y = x++ + 1; // 덧셈(+)을 먼저 계산한 후 x값을 1 증가시킴.
		// ==> y = x + 1; x++; 같은 결과
		System.out.println("x = " +x);
		System.out.println("y = " +y);
		
		x = 1;
		y = ++x + 1; // x 값을 먼저 1 증가시킨 후 덧셈(+)을 수행
		// ==> x++; y = x+1; 같은 결과
		System.out.println("x = " +x);
		System.out.println("y = " +y);
		
	}

}
