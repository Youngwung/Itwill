package com.itwill.loop09;

public class LoopMain09 {

	public static void main(String[] args) {
		// 중첩 while 문장을 사용해서 구구단 1단부터 12단까지 출력
		int i = 2;	
		while (i < 13) {
			System.out.printf("-----------------------------%d단----------------------------\n", i);
			int j = 1;//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< for 문장과의 차이점
			while (j < 13) {
				System.out.printf("%d x %d = %d\t", i, j, i * j);
				if (j % 4 == 0) {
					System.out.println();
				}
				j++;			
			}
			i++;
		}

		
	}
	
}

