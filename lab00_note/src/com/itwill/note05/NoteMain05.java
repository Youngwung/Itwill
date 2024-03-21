package com.itwill.note05;

public class NoteMain05 {

	public static void main(String[] args) {
		// 약수 구해보기

		int n = 12;
		int c = 0;
		for (int i = 1; i <n; i++) {
			if (n % i == 0) {
				System.out.printf(i +" ");
				c++;
			}
		}
		System.out.println();
		System.out.printf("약수의 개수는 %d개 입니다.", c);
	}

}
