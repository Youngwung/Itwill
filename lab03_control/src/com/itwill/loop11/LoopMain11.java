package com.itwill.loop11;

public class LoopMain11 {

	public static void main(String[] args) {
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력 
		System.out.println("------while문------\n");
		System.out.println("Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력 ");
		
		int sum = 0;
		int i = 1;
		while (i < 11) {
			sum += i;
			i++;
		}
		System.out.printf("sum = %d\n\n", sum);

		// Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.
		System.out.println("Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.");	
		sum = 0;
		i = 2;
		while (i < 101) {
			sum = sum + i;
			i = i + 2;
		}
		System.out.printf("sum = %d\n\n", sum);
		
		sum = 0;
		i = 2;
		while (i < 101) {
			if (i % 2 == 0) {
			sum = sum + i;
			}
			i++;
		}
		System.out.printf("sum = %d\n\n", sum);
		
		// Ex3. 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력.
		System.out.println("Ex3. 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력.");	

		sum = 0;
		i = 1;
		while (i < 101) {
			sum += i;
			i += 2;			
		}
		System.out.printf("sum = %d\n\n", sum);
		
		sum = 0;
		i = 1;
		while (i < 101) {
			if (i % 2 == 1) {
			sum += i;
			}
			i++;			
		}
		System.out.printf("sum = %d\n\n", sum);
		
		// Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력 
		System.out.println("------for문------\n");
		System.out.println("Ex1. 1부터 10까지 자연수들의 합을 계산하고 출력 ");
		sum = 0;
		for (i = 1; i < 11; i++) {
			sum+= i;	
		}
		System.out.printf("sum = %d\n\n", sum);
		
		// Ex2. 1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.
		System.out.println("1부터 100까지 자연수들 중에서 짝수들의 합을 계산하고 출력.");
		sum = 0;
		for (i = 2; i < 101; i = i + 2) {
			sum += i;
		}
		System.out.printf("sum = %d\n\n", sum);
			
		// Ex3. 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력.
		System.out.println("Ex3. 1부터 100까지 자연수들 중에서 홀수들의 합을 계산하고 출력.");	
		
		sum = 0;
		for (i = 1; i < 101; i += 2) {
			sum += i;
		}
		System.out.printf("sum = %d\n\n", sum);
		
	}
	
}

