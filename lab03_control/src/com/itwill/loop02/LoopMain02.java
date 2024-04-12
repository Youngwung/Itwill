package com.itwill.loop02;

public class LoopMain02 {

	public static void main(String[] args) {
		// 5 4 3 2 1 순서로 출력
		
		for (int i = 5; i>=1; i--) {
			System.out.print(i+" ");
		}
		System.out.println();
		
		// 0 2 4 6 8 10 출력

		for (int i = 0; i <= 10; i+=2) { // n = n+2
			System.out.print(i+" ");	 //i는 지역변수라 다른 for문에서 사용하려면 다시 선언해야함.
		}
		System.out.println();

		for (int i = 0; i <= 5; i++) { // n = n+2
			System.out.print( 2 * i +" ");
		}
		System.out.println();
		
		for (int i = 0; i <= 10; i++) { 
			if (i % 2==0) {
				System.out.print(i+" ");
			}
		}
		System.out.println();
		
		// 10 8 6 4 2 0 출력해보기
		
		for (int i = 10; i >= 0; i--) {
			if(i % 2 == 0) {
				System.out.print(i +" ");
			}
			
		}
		System.out.println();
		
		
	}
	

}
