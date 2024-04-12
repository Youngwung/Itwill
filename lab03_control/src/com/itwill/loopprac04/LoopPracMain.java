package com.itwill.loopprac04;

import java.util.Scanner;

public class LoopPracMain { 
	
	public static void main(String[] args) {
		// 4장 2절 7번 연습 문제
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println("--------------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------------");	
			System.out.print("선택>");				
			int num = sc.nextInt();
			if (num == 1) {
				System.out.println("예금액>");
				int x1 = sc.nextInt();
				balance += x1;
			} else if (num == 2) {
				System.out.println("출금액>");
				int x2 = sc.nextInt();
				balance -= x2;		
			} else if (num == 3) {
				System.out.println(balance);				
			} else if (num == 4) {
				break;
			} else {
				System.out.println("1 ~ 4까지의 숫자를 입력해주세요.");
			}
		}

	}

}
