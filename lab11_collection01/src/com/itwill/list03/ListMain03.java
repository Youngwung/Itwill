package com.itwill.list03;

import java.util.ArrayList;
import java.util.Random;

public class ListMain03 {

	public static void main(String[] args) {
		// 1. 정수를 저장할 수 있는 ArrayList를 선언(numbers), 객체 생성.
		ArrayList<Integer> numbers = new ArrayList<>();
		
		// 2. numbers에 [0, 100) 범위(0이상 100미만)의 난수 20개를 저장.
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			numbers.add(r.nextInt(100));
		}
		// 3. numbers를 출력.
		System.out.println("numbers: 	"+numbers);
		
		// 4. 홀수들만 저장할 수 있는 ArrayList를 선언(odds), 객체 생성
		ArrayList<Integer> odds = new ArrayList<>();
		// 5. numbers에 저장된 숫자들 중에서 홀수들을 찾아서 odds에 저장. 
		for (int i = 0; i < 20; i++) {
			if (numbers.get(i) % 2 == 1) {
				odds.add(numbers.get(i));
			}
		}
		
		// 6. odds를 출력.
		System.out.println("odds: 		"+odds);
		// 7. 정수를 저장할 수 있는 ArryList를 선언(evenSquares), 객체 생성
		ArrayList<Integer> evenSquares = new ArrayList<>();
		ArrayList<Integer> even = new ArrayList<>();
		// 8. numbers에 저장된 숫자들 중에서 짝수를 찾아서 찾은 짝수의 제곱을 evenSquares에 저장.
		for (int i = 0; i < 20; i++) {
			if (numbers.get(i) % 2 == 0) {
				evenSquares.add(numbers.get(i)*numbers.get(i));
			}
		}
		for (int i = 0; i < 20; i++) {
			if (numbers.get(i) % 2 == 0) {
				even.add(numbers.get(i));
				evenSquares.add(numbers.get(i)*numbers.get(i));
			}
		}
//		for (int i = 0; i < odds.size(); i++) {
//			numbers.remove(odds.get(i));
//		}
//		System.out.println("even: 		"+numbers);
//		for (int i = 0; i < numbers.size();i++) {
//			evenSquares.add(numbers.get(i)*numbers.get(i));
//		}
//		원래배열에서 홀수를 제거한 후 짝수를 출력.
		
		// 9. evenSquares를 출력.
		System.out.println("even: 		"+even);
		System.out.println("evensquares: 	"+evenSquares);
	}

}
