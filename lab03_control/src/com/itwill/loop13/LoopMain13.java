package com.itwill.loop13;

public class LoopMain13 {

	public static void main(String[] args) {

		// 교재 4장 2절 연습문제 5번
		// *
		// **
		// ***
		// ****
		// 를 출력하세요

		System.out.println("교재 4장 2절 연습문제 5번");

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("교재 4장 2절 연습문제 5번 while써보기");
		int i = 1;

		while (i <= 4) {
			int j = 1;
			while (j <= i) {
				System.out.print("*");
				j++;
			}

			System.out.println();
			i++;
		}
		System.out.println();

		// 교재 4장 2절 연습문제 6번
		// *
		// **
		// ***
		// ****
		// 를 출력하세요
		System.out.println("교재 4장 2절 연습문제 6번");

		for (i = 1; i <= 4; i++) {

			for (int j = 4; j >= 1; j--) {
				if (j > i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}

			System.out.println();
		}
		System.out.println();

		System.out.println("교재 4장 2절 연습문제 6번 while 써보기");
		i = 1;
		while (i <= 4) {
			int j = 4;
			while (j > 0) {
				if (j > i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
				j--;
			}

			i++;
			System.out.println();
		}

		System.out.println();

		System.out.println("교재 4장 2절 연습문제 6번 강사님 풀이");

		for (i = 1; i <= 4; i++) {

			for (int j = 1; j <= 4; j++) {
				if (j <= 4 - i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}

			System.out.println();
		}
		System.out.println();
		
		
		System.out.println("교재 4장 2절 연습문제 6번 조건문 안쓰고 가능?");

		for (i = 1; i <= 4; i++) {

			for (int j = 1; j <= 4 - i; j++) {
				System.out.print(" "); 
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();


	}

}
