package com.itwill.method04;

import java.util.Random;

public class MethodMain04 {

	public static void main(String[] args) {
		// 다양한 리턴 타입:

		Random random = new Random();

		int number = random.nextInt(100);
		System.out.println("number = " + number);

		// Ex1. isEven(정수): 정수가 짝수이면 true, 그렇지 않으면 false를 리턴.
		boolean result = isEven(number);
		System.out.println("isEven = " + result);
		
		// Ex2.
        int x = random.nextInt(100);
        int y = random.nextInt(100);
        System.out.println("x=" + x + ", y=" + y);
        
        int big = whoIsBig(x, y); // x, y 중 크거나 같은 수를 리턴.
        System.out.println("big=" + big);
        
        // Ex3.
        int code = random.nextInt(1, 5);
        String gender = parseGenderCode(code); // 1 또는 3이면 "male", 2 또는 4이면 "female", 그 이외에는 "unknown"
        System.out.println("code=" + code + ", gender=" + gender);

	}

	/**
	 * 아규먼트로 전달된 정수가 짝수인 지, 홀수인 지를 boolean타입으로 리턴하는 메서드.
	 * 
	 * @param number 정수 타입/ 짝수, 홀수를 검사할 정수.
	 * @return boolean 타입/ number가 짝수이면 true, 그렇지 않으면 false.
	 */
	public static boolean isEven(int number) {

//		if (number % 2 == 0) {
//			return true;
//		} else {
//			return false;
//		}
		// 다른방법
		// (1)리턴할 타입을 미리 선언
//		boolean result = false; // (2)기본값으로 초기화
//
//		// (4) 할거 하기
//		if (number % 2 == 0) {
//			result = true;
//		} else {
//			result = false;
//		}
//
//		return result; // (3)리턴 문장 만들기
//		
//		// 구조를 미리 만들어두어서 실수 요소를 줄이는 방법인듯.
//		// 리턴은 단 한번만 실행되어야 하므로 한 문장의 리턴문장만을 남기기 위한 방법.
		
		return (number % 2 == 0) ? true : false;
		
	}	
//		------------------------------2번-------------------------------------
	/**
	 * 두 정수를 전달받아 둘 중 큰 수를 반환하는 메서드
	 * @param x 정수 타입
	 * @param y 정수 타입
	 * @return x >= 0 이면 x, 그렇지 않으면 y
	 */
	public static int whoIsBig(int x, int y) {
		int result = 0;
		if (x >= y) {
			result = x;
		} else {
			result = y;
		}
		
		return result;
	}
		
//	-----------------------------------3번--------------------------------------
	/**
	 * 성별을 의미하는 정수코드를 문자열로 변환하는 메서드
	 * @param x 성별 코드/ 1, 2, 3, 4.
	 * @return x가 1 또는 3이면 "male", x가 2 또는 4이면 "female" 반환.그 이외의 코드값인 경우에는 "unknown" 반환
	 */
	public static String parseGenderCode(int x) {
		String result = null;
		
		if (x == 1 || x == 3) {
			result = "male";
		} else if (x == 2 || x == 4) {
			result = "female";
		} else {
			result = "unknown";
		}
		
		return result;
	}
	

}
