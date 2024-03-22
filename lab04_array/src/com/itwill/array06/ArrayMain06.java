package com.itwill.array06;

public class ArrayMain06 {

	public static void main(String[] args) {
		// 다차원 배열: 배열들을 원소로 갖는 배열.
		// 2차원 배열: 1차원 배열들을 원소로 갖는 배열.
		// -2차원 배열은 인덱스를 2개를 갖음.

		// 2차원 배열 선언 & 초기화 방법 1:
		// 2차원 배열이 갖는 모든 원소들을 나열하면서 배열을 선언하고 초기화.
		// 타입[][] 변수 이름 = new 타입[][] {{...}, {...}, {...}, {...}, ...}
		// 타입[][] 변수 이름 = [][] {{...}, {...}, {...}, {...}, ...} (new 타입[][]) 생략 가능
		int[][] arrays = {
				{ 1, 2, 3, 4 },
				{ 5, 6, 7 },
				{ 8, 9, 10, 11, 12 },
		};
		
		System.out.println(arrays); // =>[[I .... 
		System.out.println(arrays.length); //-> 2차원 배열의 원소: 1차원배열, 1차원 배열 개수: 3
		System.out.println(arrays[0]); // => [I ....  1차원배열
		System.out.println(arrays[0].length); // => 2차원배열의 0번째 인덱스인 {1,2,3,4}의 길이 출력 = 4
		
		// 인덱스를 사용한 2차원 배열 원소 출력
		for (int i = 0; i < arrays.length; i++) {
			for (int j = 0; j < arrays[i].length; j++) {
				System.out.print(arrays[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		// each-for문을 사용한 2차원 배열 원소 출력.
		for (int[] x: arrays ) {
			for (int y : x) {
				System.out.print(y +"\t");
			}
			System.out.println();
		}
		
		
	}

}