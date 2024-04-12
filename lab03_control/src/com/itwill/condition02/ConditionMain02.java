package com.itwill.condition02;

import java.util.Scanner; // Scanner 사용을 위한 코드, 패키지선언문과 클래스 선언문 사이에 들어가는 import 문장
						  // 참조 타입 -> int, double같은 기본타입과 다르게 import 문장이 필요함.

public class ConditionMain02 {

	public static void main(String[] args) {
		// 콘솔 창에서 키보드 입력을 저장하는 방법.
		// (1) Scanner 타입의 변수를 선언하고, Scanner 객체를 저장.
		Scanner sc = new Scanner(System.in); //시스템의 입력창에서(지금은 콘솔) 입력을 받을 수 있는 도구를 생성.
		
		System.out.print("정수를 입력하세요 >>>>> "); 
		// 콘솔창에서 정수 1개를 입력받고, int 타입 변수에 저장		 	
		int i = sc.nextInt(); // (2) 콘솔에서 입력받은 정수를 변수에 저장.
								   //nextInt()는 정수타입이 대상, nextLine()은 문자열 타입이 대상
		if (i > 0) {
			System.out.printf("입력하신 숫자는 %d이고, 양수입니다.\n", i);
		} else if (i == 0) {
			System.out.printf("입력하신 숫자는 %d입니다.\n", i);
		} else {
			System.out.printf("입력하신 숫자는 %d이고, 음수입니다.\n", i);
		} 
		// 만약 입력받은 정수가 0보다 크면, "positive"를 출력
		// 만약 입력받은 정수가 0이면, "zero"를 출력
		// 그렇지 않으면, "negative"를 출력

	}

}
