package com.itwill.loopprac01;

public class LoopPracMain01 {

	public static void main(String[] args) {
		// 4장 2절 5번문제
		for (int i = 1; i<=4; i++) {
			for (int j = 1; j<=4; j++) {
				
				System.out.print("*");
				
				if (i == j) {
					break;
				}
			
			}
			System.out.println("");
		}

	}

}
