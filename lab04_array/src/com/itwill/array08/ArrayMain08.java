package com.itwill.array08;

public class ArrayMain08 {

	public static void main(String[] args) {
		// 2차원 배열을 선언 & 초기화 방법 2:
		// 2차원 배열을 그 타입의 기본값으로 초기화. (0, 0.0, null, false 등)
		// 타입[][] 변수이름 = new 타입[행의 개수(층)][열의 개수(방)]
		// - 행의 개수: 2차원 배열이 가지고있는 1차원 배열들의 개수 ===> 생략 불가
		// - 열의 개수: 각 1차원 배열이 가지고 있는 원소들의 개수. ===> **************생략 가능****************
		// -- 행의 개수는 생략하면 안됨! 열의 개수는 생략이 가능!!
		
		// (1) 2차원 배열을 생성할 때 행과 열의 개수가 모두 결정된 경우 => 직사각형 모양의 배열
		// -열의 개수를 생략하지 않음
		int[][] array1 = new int[2][3];
		
		for (int[] arr : array1) {
			for (int x: arr) {
				System.out.print(x+" ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		// (2) 2차원 배열의 행의 개수는 결정 되어져 있고, 열의 개수가 결정되지 않은경우
		// 2차원 배열이 가지고 있는 1차원 배열의 개수는 알고 있지만
		// 각각의 1차원 배열들의 원소 개수는 아직 결정되지 않은 경우
		// 또는 1차원 배열들의 길이가 모두 다른 경우.
		
		int[][] array2 = new int[3][]; // 1차원 배열 3개를 원소로 갖는 2차원 배열.
		
		// 열의 개수가 미정인 2차원 배열은 사용하기 전에 반드시 1차원 배열들을 각각 생성해야만 함.
		array2[0] = new int[2]; //원소 2개를 갖는 1차원 배열.
		array2[1] = new int[4]; //원소 4개를 갖는 1차원 배열.
		array2[2] = new int[3]; //원소 3개를 갖는 1차원 배열.
		
		for (int[] x:array2) {
			for(int y : x) {
				System.out.print(y +" ");
			}
			System.out.println();
		}
				

	}

}
