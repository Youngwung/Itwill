package com.itwill.note01;

public class NoteMain01 {

	public static void main(String[] args) {

		for (int i = 1; i < 5; i++) {
			for (int j = 4; j > 0; j--) {
				if (j > i) {
				System.out.print(" ");
				} else {
				System.out.print("*");
				}
			}

			System.out.println();
		}
		
	}

}
