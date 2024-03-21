package com.itwill.note03;

import java.util.Scanner;

public class NoteMain03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("1 이상의 숫자를 입력하세요.");
			int u = sc.nextInt();
			if (u <= 0) {
				System.out.println("ERROR= 1 이상의 숫자를 입력해주세요.");

			} else if (u > 1) {
				for (int i = 1; i <= u; i++) {
					System.out.print(i + " ");
				}
				System.out.println();
			}
		}
	}

}
