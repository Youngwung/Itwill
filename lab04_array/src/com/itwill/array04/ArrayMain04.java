package com.itwill.array04;

import java.util.Random;

public class ArrayMain04 {

	public static void main(String[] args) {
//		정수 10개를 저장할 수 있는 배열(codes)을 만들고 기본값으로 초기화
		int[] codes = new int[10];
//		배열 codes에 1 이상 4이하 범위의 정수를 임의로 저장.
		Random rand = new Random();
		for (int i = 0; i < codes.length; i++) {
			codes[i] = rand.nextInt(1,5);
		}
		
//		codes 내용을 출력.
		for (int x : codes) {
			System.out.print(" "+x + "\t");
		}
//		문자열(String) 10개를 저장할 수 있는 배열(genders)를 만들고 기본값으로 초기화
		String[] genders = new String[codes.length];

//		codes의 원소가ㅣ 1 또는 3이면 "남성"을, codes의 원소가 2 또는 4이면 "여성"을 genders에 저장.
		
		for (int i = 0; i < codes.length; i++) {
			
			if (codes[i] == 1 || codes[i] == 3) {
				
				genders[i] = "남성";
				
			} else if (codes[i] == 2 || codes[i] == 4) {
				genders[i] = "여성";
			}
			
		}	
//		genders의 내용을 출력.
		System.out.println();
		for (String x : genders) {
			System.out.print(x +"\t");
		}
		System.out.println();
	}

}
