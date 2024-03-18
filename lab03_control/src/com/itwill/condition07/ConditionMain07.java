package com.itwill.condition07;

import java.util.Random;

public class ConditionMain07 {

	public static void main(String[] args) {
		// 조건문, 비교/논리 연산자 연습
		
		// 난수(random number) Random타입의 변수가 필요. Scanner와 비슷
		// 난수를 생성할 수 있는 타입의 변수를 선언, 초기화.
		Random rand = new Random();
		
		// rand.nextInt(x): 0 이상 x미만의 정수 난수를 반환.
		// rand.nextInt(x, y): x이상 y미만의 정수 난수를 반환.
		
		int java = rand.nextInt(101);
		//System.out.println(java);
		
		int sql = rand.nextInt(101);
		//System.out.println(sql);
		
		int javascript = rand.nextInt(101);
		//System.out.println(javascript);
		
		System.out.printf("Java과목의 점수는 %d점, SQL과목의 점수는 %d점, JavaScript과목의 점수는 %d점\n" , java, sql, javascript);
		
		// 세 과목이 모두 40점 이상이고, 평균이 60점 이상이면 "합격"
		// 그렇지 않으면 "불합격"
		int sum = java + sql + javascript;
		double aver = (double) sum / 3; 
		if (java >= 40 && sql >= 40 && javascript >= 40) {
			System.out.printf("당신의 평균 점수는 %.2f점이고, ", aver);
			if (aver >= 60) {
				System.out.println("시험의 결과는 합격입니다.");
			} else {
				System.out.println("평균점수가 60점 미만이므로 시험의 결과는 불합격입니다.");
			}
		
		} else {
			if (java < 40) {
				System.out.print("Java ");
			}
			if (sql < 40) {
				System.out.print("SQL ");
			}
			if (javascript < 40) {
				System.out.print("JavaScript ");
			}
			System.out.println("과목이 40점 미만이므로 불합격 처리되었습니다.");
		}
		
	}

}
