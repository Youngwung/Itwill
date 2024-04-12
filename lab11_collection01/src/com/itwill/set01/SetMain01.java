package com.itwill.set01;

import java.util.HashSet;
import java.util.TreeSet;

/*
 * Collection<E>
 * |__ List<E>
 *    |__ ArrayList<E>m LinkedList<E>, ...
 *    
 * Collection<E>
 * |__ Set<E>
 *     |__ HashSet<E>, TreeSet<E>, ...
 * 
 * Set<E> 의 특징:
 * (1) 중복된 값(equals()가 true인 값)을 저장하지 못함. (예) {1, 2, 2, 3, 3, 3 } = {1, 2, 3}
 * (2) 저장하는 순서가 중요하지 않음 - 인덱스가 없음. (예) {1, 2} = {2, 1}
 * 
 * HashSet<E>: Hash 알고리즘(검색을 빠르게 하기 위한 알고리즘)을 사용한 집합(Set). 
 * TreeSet<E>: Tree 알고리즘(정렬을 빠르게 하는 알고리즘)을 사용한 집합(Set).
 */

public class SetMain01 {

	public static void main(String[] args) {
		// 정수를 저장할 수 있는 TreeSet을 선언, 초기화
		TreeSet<Integer> numbers = new TreeSet<Integer>();
		System.out.println(numbers);
		System.out.println(numbers.size());
		
		// Set에 원소들을 저장
		numbers.add(1);
		numbers.add(100);
		numbers.add(50);	// 저장 순서 상관 없이 정렬 후 출력.
		numbers.add(30);
		numbers.add(50);	// 같은 값을 저장 시도 시 저장되지 않음.
		
		System.out.println(numbers);
		System.out.println(numbers.size()); 	// add를 5번 했지만 Set의 사이즈는 4.
		
		//Set<>.get(index) 메서드를 제공하지 않음! ==> 인덱스를 이용해서 원소를 얻을수 있는 메서드를 제공하지 않음.
		//향상된 for 문장은 가능. (일반 for문은 불가능. index가 없기 때문에 인덱스의 원소를 가져올 수 있는 방법이 없음.)
		for (Integer x: numbers) {
			System.out.print(x + ", ");
		}
		System.out.println();
		
		// Set<E>.set(int index, E value) 메서드를 제공하지 않음.
		// Set<E>.remove(int index) 메서드를 제공하지 않음.
		// Set<E>.remove(Object x) 메서드만 제공 - 값을 비교(equals)해서 같은 값의 객체를 삭제.
		numbers.remove(50);
		System.out.println(numbers);
		
		// 문자열을 저장하는 HashSet을 선언하고 초기화.
		HashSet<String> set = new HashSet<String>();
		System.out.println(set);
		System.out.println("size: "+set.size());
		set.add("hello");
		set.add("안녕하세요");
		set.add("hello");
//		set.add("가");
//		set.add("나");
//		set.add("다");
//		for (String x : set) {
//			System.out.println(x.hashCode());
//		}
		System.out.println(set);
		
		
	}

}
