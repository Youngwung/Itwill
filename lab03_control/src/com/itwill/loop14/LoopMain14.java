package com.itwill.loop14;

import java.util.Scanner;

public class LoopMain14 {

	public static void main(String[] args) {

		System.out.println("교재 4장 2절 연습문제 7번");
		boolean run = true;
		int sum = 0;
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("-------------------------------------");
			System.out.print("선택>>>");
			int i = sc.nextInt();
			if (i == 1) {
				System.out.print("예금액>>>");
				int j = sc.nextInt();
				sum = sum + j;

			} else if (i == 2) {
				System.out.print("출금액>>>");
				int j = sc.nextInt();
				sum = sum - j;

			} else if (i == 3) {
				System.out.printf("잔고>>>%d\n", sum);
			} else {
				System.out.println("프로그램 종료.");
				run = false;

			}
		}

	}

}
