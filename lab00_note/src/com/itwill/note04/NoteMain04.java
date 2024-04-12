package com.itwill.note04;


public class NoteMain04 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {

			if (i %3 == 0) {
				sum += i;
			}
		}
		System.out.printf("100까지의 자연수 중 3의 배수의 총 합 = %d", sum);

	}

}
