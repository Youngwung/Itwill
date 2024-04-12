package com.itwill.z3_map03;

import java.util.TreeMap;

public class MapMain03 {

	public static void main(String[] args) {
		// TODO 단어 개수 세기(word counting):
		// 문자열에 등장하는 단어를 key로 하고,
		// 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고, 출력.
		
		String sentence = "짜장면 짬뽕 짜장면 볶음밥 김치찌개 부대찌개 김치찌개 된장찌개 ";
		// -> 결과: {짜장면 = 2, 짬뽕=1, 볶음밥=1, 김치찌개=2, 부대찌개=1, 된장찌개=1}
		
		String[] words = sentence.split(" "); // 공백으로 구분해서 단어들로만 이루어진 배열을 만들어줌.
		
		// 단어(key)-빈도수(value) 저장하기 위한 Map을 선언, 초기화
		TreeMap<String, Integer> wordCounts = new TreeMap<String, Integer>();
		
		// 배열에 저장된 단어들을 순서대로 하나씩 반복.
//		for (String x : words) {
//			if (wordCounts.keySet().contains(x)) {
//				wordCounts.put(x, wordCounts.get(x)+1);
//			} else {
//				wordCounts.put(x, 1);
//			}
//		}
//		System.out.println(wordCounts);
		
		// 선생님 코드
		for (String w : words) { // getOrDefault를 이용한 알고리즘.
			Integer count = wordCounts.getOrDefault(w, 0); // getOrDefault 사용법. count를 이용하는 알고리즘.
			// wordCounts2에 get으로 전달받은 문자열과 같은 key가 있으면 그 key의 value를 리턴하고
			// get으로 전달받은 문자열과 같은 key가 없으면 0을 리턴. 
			
			wordCounts.put(w, count+1);
			System.out.println(wordCounts);
		}
		System.out.println("----------------");
		
		TreeMap<String, Integer> wordCounts2 = new TreeMap<String, Integer>();
		
		for (String w: words) { // get을 이용한 알고리즘.
			Integer count = wordCounts2.get(w); 
			// wordCounts2에 get으로 전달받은 문자열과 같은 key가 있으면 그 key의 value를 리턴하고
			// get으로 전달받은 문자열과 같은 key가 없으면 null을 리턴. 
			
			if (count == null) { // get은 해당 key에 밸류가 없으면 null을 리턴하므로 조건문으로 count에 1을 넣고 맵에 저장.
				count = 1;
				wordCounts2.put(w, count);
			} else { // null이 아닌 경우 
				wordCounts2.put(w, count + 1);
			}
			
			System.out.println(wordCounts2);
			
		}
		
	}

}
