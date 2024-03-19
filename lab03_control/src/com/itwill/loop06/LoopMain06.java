package com.itwill.loop06;

public class LoopMain06 {

	public static void main(String[] args) {
		// 중첩 반복문: 반복문 안에서 반복문을 사용.
		// 구구단 2단 ~ 9단까지 출력
		for (int x = 2; x < 10; x++) {
			System.out.println("------------------- "+ x + "단 -------------------");
			for (int y = 1; y < 10; y++) {
				System.out.printf("%d x %d = %d\t", x, y, x * y);
				if (y % 3 == 0) {		// 3번 출력할 때마다 줄바꿈을 하기 위한 문장
					System.out.println();
					System.out.println();
				}
			}
			System.out.println("-------------------------------------------");
			
		}

	}

}
