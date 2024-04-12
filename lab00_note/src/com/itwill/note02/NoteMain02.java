package com.itwill.note02;

import java.util.Random;

public class NoteMain02 {

	public static void main(String[] args) {
//		int i = 0;
//		int j = 0;
		int x = 0;
		int y = 0;
		Random r = new Random();
		while (x + y != 5) {
			
			x = r.nextInt(1, 7);
			y = r.nextInt(1, 7);
			
//			i = (int) (Math.random()*6) +1;
//			j = (int) (Math.random()*6) +1;
		}
//		System.out.printf("(%d, %d)", i, j);
		System.out.printf("(%d, %d)", x, y);
	}

}
