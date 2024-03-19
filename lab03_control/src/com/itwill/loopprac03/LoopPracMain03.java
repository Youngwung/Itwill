package com.itwill.loopprac03;

public class LoopPracMain03 {

	public static void main(String[] args) {
		// 4장2절 연습문제 4번 4x + 5y = 60의 모든 해를 구해서 (x, y)의 형태로 출력하시오. x와 y는 10 이하의 자연수

		for (int i = 1; i<= 10; i++) {
			
			for (int j = 1; j <= 10; j++) {
				
				if (4*i + 5*j == 60) {
					System.out.printf("(%d, %d) ", i, j);					
				}
				
			}
			
		}
		
	}

}
