package com.itwill.condition02;

import java.util.Scanner; //Scanner 사용을 위한 코드

public class ConditionMain02 {

	public static void main(String[] args) {
		// 콘솔창에서 정수 1개를 입력받고, int 타입 변수에 저장

		Scanner scanner = new Scanner(System.in);  //입력받기 위한 코드
		
		int i = scanner.nextInt(); //입력받은 정수를 변수 정수타입 i에 저장
								   //nextInt()는 정수타입이 대상, nextLine()은 문자열 타입이 대상
		
		if (i > 0) {
			
			System.out.println("positive");
		} else if (i == 0) {
			
			System.out.println("zero");
		} else {
			
			System.out.println("negative");
		} 
		// 만약 입력받은 정수가 0보다 크면, "positive"를 출력
		// 만약 입력받은 정수가 0이면, "zero"를 출력
		// 그렇지 않으면, "negative"를 출력

	}

}
