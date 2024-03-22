package com.itwill.array05;

import java.util.Random;

public class ArrayMain05 {

	public static void main(String[] args) {
		// 과제:
		// 정수(int) 5개를 저장할 수 있는 배열을 선언하고, 기본값으로 초기화
		int[] ar = new int[5];

		// 배열에 0이상 10 이하의 난수 5개를 저장.
		Random random = new Random();
		for (int i = 0; i < ar.length; i++) {
			ar[i] = random.nextInt(11);
		}
		for (int x : ar) {
			System.out.print(x + " ");
		}
		System.out.println();
		// 배열 원소들 중 최댓값을 찾아서 출력.
		int max = ar[0]; // 배열의 첫번째 원소를 최댓값으로 가정

		for (int i = 0; i < ar.length; i++) {// 배열의 모든 원소를 순서대로 하나씩 꺼내면서 반복
			int x = ar[i];
			if (max < x) {// 배열에서 꺼낸 값이 (현재까지의) 최댓값보다 크다면
				max = x; // 최댓값을 배열에서 꺼낸 값으로 변경
			}
		}
		System.out.println("최댓값 = " + max);
		// 배열 원소들 중 최솟값을 찾아서 출력.

		int min = ar[0];
		for (int i = 0; i < ar.length; i++) {
			int x = ar[i];
			if (min > x) {
				min = x;
			}
		}
		System.out.println("최솟값 = " + min);
	}

}