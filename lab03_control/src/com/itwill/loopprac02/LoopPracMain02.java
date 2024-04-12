package com.itwill.loopprac02;

public class LoopPracMain02 {

	public static void main(String[] args) {
		// 4장 2절 6번문제
		
		for (int i = 1; i <= 4; i++) {
			
			for (int j = 4; j >= 1 ; j--) {
				if (j > i) { // 중첩문 내에 
					System.out.print(" ");
				} else if (j <= i) {
					System.out.print("*");
				}
			}
		System.out.println();	
		}

	}

}
