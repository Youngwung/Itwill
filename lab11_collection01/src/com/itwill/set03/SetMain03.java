package com.itwill.set03;

import java.util.HashSet;

public class SetMain03 {

	public static void main(String[] args) {
		// Score 타입을 저장할 수 있는 HashSet을 선언, 초기화.
		HashSet<Score> scores = new HashSet<Score>();
		System.out.println(scores);

		// scores에 Score 객체들을 저장.
		scores.add(new Score());
		scores.add(new Score(0, 0, 0)); 
		//hashcode가 다르면 같은 0 0 0이어도 같은 주머니에 들어가지 않는다.=> hashCode재정의 시 같은 주머니에 들어감. 
		scores.add(new Score(100, 50, 0));
		scores.add(new Score(50,0,100)); 
		// hashcode가 같지만 equals이 성립하지 않는 경우 같은 주머니에 들어가지만 중복처리 하지않는다.
		System.out.println(scores);
	}

}
