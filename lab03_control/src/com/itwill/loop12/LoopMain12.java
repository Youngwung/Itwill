package com.itwill.loop12;

import java.util.Random;

public class LoopMain12 {

	public static void main(String[] args) {
		// 교재 4장 2절 연습문제 2번
		// 1부터 100까지의 정수 중에서 3의 배수의 총합을 구하는 코드를 작성해보세요.
		System.out.println("교재 4장 2절 연습문제 2번");
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum = sum + i;
			}
		}
		System.out.printf("sum = %d\n\n", sum);

		// 교재 4장 2절 연습문제 3번
		// 주사위 2개를 던졌을 때 결과를 (x, y) 형식으로 출력.
		// 주사위 2개의 눈의 합이 5가 되면 실행을 멈춤.
		System.out.println("교재 4장 2절 연습문제 3번");
		Random rand = new Random();
		while (true) {

			int x = rand.nextInt(1, 7);
			int y = rand.nextInt(1, 7);
			System.out.printf("(%d, %d)\n", x, y);
			if (x + y == 5) {
				break;
			}

		}
		System.out.println();

		System.out.println("교재 4장 2절 연습문제 3번- do-while써보기");
		int x, y;

		do {
			x = rand.nextInt(1, 7);
			y = rand.nextInt(1, 7);
			System.out.printf("(%d, %d)\n", x, y);
		} while (x + y != 5);

		System.out.println();

		// 교재 4장 2절 연습문제 4번
		// 4x + 5y = 60 방정식을 만족하는 x와 y를 찾기
		// 단, x와 y는 10 이하의 자연수
		System.out.println("교재 4장 2절 연습문제 4번");
		x = 1;

		while (x <= 10) {
			y = 1;

			while (y <= 10) {

				if ((4 * x + 5 * y) == 60) {
					System.out.printf("(%d, %d)", x, y);
				}

				y++;
			}

			x++;
		}
		System.out.println();

	}

}
