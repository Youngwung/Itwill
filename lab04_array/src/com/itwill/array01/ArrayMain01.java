package com.itwill.array01;

public class ArrayMain01 {

	public static void main(String[] args) {
		// 배열의 필요성: 
		
		// 점수들
//		int score1 = 100; // 첫번째 학생의 점수
//		int score2 = 90;  // 두번째 학생의 점수
//		int score3 = 80;  // 세전째 학생의 점수
//		
//		// 총점
//		int totla = score1 + score2 + score3;
//		System.out.println("총점 :" +totla);
		
		// 총점이나 평균을 구하기 위해서는 학생 수 만큼의 변수를 선언하고 초기화를 해야함.
		// 학생이 50명이면 변수 50개를 선언 및 초기화를 해야하고 총점을 구하기 위해서 변수 50개를 모두 써 줘야함.
		// 수정이 필요할 때 귀찮은 경우가 많음.
		
		
		// 배열 (array): 같은 타입의 데이터 여러개를 하나의 변수 이름으로 저장하기 위한 타입.
		// 인덱스 (index): 배열에 값을 저장하거나, 저장된 값을 읽어올 때 사용하는 정수.
		//   -배열에서 데이터가 저장된 위치를 나타내는 정수
		//	 -인덱스는 0부터 시작하는 연속된 정수.
		// 	 -배열의 마지막 인덱스는 (배열의 원소 개수 -1)
		
		// 배열 선언 및 초기화 방법 1:
		// 타입[] 변수이름 = new 타입[원소 개수];
		// 이 방법은 배열의 모든 원소를 배열 타입의 기본 값으로 초기화.
		// => 정수 타입의 기본값(0), 실수 타입의 기본값(0.0), boolean 타입의 기본값(false)
		int[] scores = new int[3]; 
		// int 타입 3개를 저장할 수 있는 배열
		// 모든 값은 0으로 초기화
		System.out.println(scores);
		System.out.println(scores[0]); // 배열 scores의 인덱스 0 위치의 원소를 출력
		
		// 데이터를 변경하고 싶으면
		scores[0] = 100;
		System.out.println(scores[0]); 	
		
		// 모든 배열 타입의 변수는 length 라는 이름의 속성을 가지고 있음.
		// length: 배열의 길이. => 배열의 원소 개수.
		System.out.println("length ="+scores.length);
		
		//반복문 (for 문)을 사용해서 배열의 모든 원소를 순서대로 출력.
		
		for (int i = 0; i < scores.length; i++) {	
			//조건문 해석 (인덱스는 0번부터 시작함; 배열의 마지막 인덱스 = 배열의 원소 개수 -1; 인덱스는 연속된 숫자라 i++)
			System.out.println(i + ":" + scores[i]);
			
		}
		
		
		}

}

