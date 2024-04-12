package com.itwill.set02;

import java.util.HashSet;
import java.util.Random;

public class SetMain02 {

	public static void main(String[] args) {
		// 정수를 저장하는 HashSet을 선언, 초기화
		HashSet<Integer> integer = new HashSet<Integer>();
		// 집합(Set)에 [0, 10) (0이상 10미만) 범위의 (서로 다른) 난수 5개를 저장.
		Random r = new Random();
		while (true) {
			
			integer.add(r.nextInt(10));
			
			if (integer.size() == 5) {
				break;
			}
		}
		// 향상된 for 문장을 사용해서 집합의 내용을 출력.
		System.out.print("[ ");
		for (Integer x : integer) {
			System.out.print(x + "  ");
		}
		System.out.println("]\n");

	}

}
