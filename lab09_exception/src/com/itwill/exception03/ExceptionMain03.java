package com.itwill.exception03;

import java.util.Scanner;

public class ExceptionMain03 {

	private final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ExceptionMain03 app = new ExceptionMain03();

//		int x = app.inputInteger();
		int x = app.inputInteger2();
		System.out.println("x = " + x);

	}
	
	public int inputInteger2() {
		try {
			System.out.print("정수 입력 >>");
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException n) {
			System.out.println("정수로 입력하세요....");
			return inputInteger2(); // 재귀호출: 자기 자신을 호출해서 무한루프같은 효과를 얻음.
		}
		
	}
	

	public int inputInteger() {
		boolean run = true;
		int result = 0;
		while (run) {
			
			try {
				System.out.print("정수 입력>> ");
				result = Integer.parseInt(sc.nextLine());
				run = false;
			} catch (NumberFormatException n) {
				System.out.println("숫자만 입력해주세요");
				System.out.println(n.getMessage());
			}
		}
		return result;
		
	}

}
