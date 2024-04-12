package com.itwill.condition03;

import java.util.Scanner;

public class ConditionMain03 {

	public static void main(String[] args) {
		// Scanner 타입의 변수를 선언, 초기화
		Scanner sc = new Scanner(System.in);
		
		// 콘솔 창에서 Java 과목 점수를 입력받고 저장. (과목 점수는 0 ~ 100의 정수)
		System.out.print("Java 과목의 점수를 입력하세요 >>> ");
		int java = sc.nextInt();
		
		if ((java > 100) || (java < 0)) {
			System.out.println("ERROR. 0부터 100까지의 숫자만 입력해주세요.");
		}
		else {							
			// 콘솔 창에서 SQL 과목 점수를 입력받고 저장. 
			System.out.print("SQL 과목의 점수를 입력하세요 >>> ");
			int sql = sc.nextInt();
			if ((sql > 100) || (sql < 0)) {
				System.out.println("ERROR. 0부터 100까지의 숫자만 입력해주세요.");			
			}
			else {
				// 콘솔 창에서 JavaScript 과목 점수를 입력받고 저장.
				System.out.print("JavaScript 과목의 점수를 입력하세요 >>> ");
				int javascript = sc.nextInt();
				
				if ((javascript > 100) || (javascript < 0)) {
					System.out.println("ERROR. 0부터 100까지의 숫자만 입력해주세요.");
				} else {
					// 세 과목의 총점을 계산하고 출력. (정수) { 0 ~ 300}
					int s = java + sql + javascript;
					System.out.printf("당신의 세 과목 총 점은 %d점 입니다.\n", s);
					
					// 세 과목의 평균을 계산하고 출력. (실수)
					double a =  (double) s / 3;
					System.out.printf("당신의 평균 점수는 %.2f입니다. \n",a);
					
					// 세 과목의 평균이 90점 이상이면, "A"
					if (a >= 90) {
						System.out.println("당신의 성적은 A입니다.");
					}
					// 세 과목의 평균이 80점 이상이면, "B"
					else if (a >= 80) {
						System.out.println("당신의 성적은 B입니다.");
					}
					// 세 과목의 평균이 70점 이상이면, "C"
					else if (a >= 70) {
						System.out.println("당신의 성적은 C입니다.");
					}
					// 세 과목의 평균이 70점 미만이면, "F"
					else  {
						System.out.println("당신의 성적은 F입니다.");
					}
					
				}
				
				

			}

			
		}

	}

}
