package com.itwill.z3_map02;

import java.util.Set;
import java.util.TreeMap;

public class MapMain02 {

	public static void main(String[] args) {
		// 문자열을 key로 하고, 정수를 value로 하는 TreeMap을 선언, 초기화.
		TreeMap<String, Integer> menu  = new TreeMap<String, Integer>();
		//(예) <과목이름, 점수>, <메뉴, 가격>, 
		
		menu.put("짜장면", 7000);
		menu.put("짬뽕", 8000);
		menu.put("볶음밥", 8000);
		System.out.println(menu);
		
		// keySet(): TreeMap에서는 오름차순 정렬된 키들의 집합(set)을 리턴.
		Set<String> keySet= menu.keySet(); // => keySet메서드는 향상된 for문을 사용하기 좋다.
		System.out.println(keySet); 
		for (String x : keySet) {
			System.out.println(x+" = "+ menu.get(x));
		}
		System.out.println("------------------");
		// descendingKeySet(): TreeMap에서 내림차순 정렬된 키들의 집합(Set)을 리턴.
		Set<String> keySet2 = menu.descendingKeySet(); //=> 내림차순.
		for (String k: keySet2) {
			System.out.println(k+" = "+menu.get(k));
		}
		
	}

}
