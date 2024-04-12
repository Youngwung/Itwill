package com.itwill.z3_map01;

import java.util.HashMap;
import java.util.Set;

/*
 * Collection<E>
 * |__ List<E>, Set<E>
 * 
 * Map<K, V>
 * |__ HashMap<K, V> TreeMap<K, V>, ...
 * 
 * Map<K, V>: 키(Key)와 값(Value)의 쌍으로 구성된 데이터를 저장하는 자료 구조.
 * (1) Key: 중복된 값을 가질 수 없음. Map에서 하나의 값을 찾기 위한 인덱스와 비슷한 역할.
 * 		- 데이터를 저장/검색/수정/삭제할 때 값을 찾기 위한 용도.
 * 		- 연속된 값을 가질 필요는 없음.
 * (2) Value: 중복된 값을 가질 수 있음.
 * 
 * HashMap<K, V>: Key를 기준으로 검색을 빠르게 할 수 있는 Map.
 * TreeMap<K, V>: Key를 기준으로 정렬을 빠르게 할 수 있는 Map.
 */

public class MapMain01 {

	public static void main(String[] args) {
		// 정수를 key로 하고, 문자열을 value로 하는 HashMap을 선언, 초기화.
		HashMap<Integer, String> map = new HashMap<>();
		System.out.println(map); //{}
		System.out.println(map.size());
		
		// map에 key-value 데이터를 저장:
		map.put(1, "홍길동");
		map.put(10, "오쌤");
		map.put(101, "홍길동");
		System.out.println(map);
		
		// map에 저장된 값(value) 
		System.out.println(map.get(100)); // -> key가 없으면 null을 리턴.
		
		// getOrDefault(ket, default)
		
		System.out.println(map.getOrDefault(10, "아무개")); //-> key가 존재하면, key에 매핑된 value를 리턴.
		// key 10에는 "오쌤"이 저장되어있으므로 그냥 "오쌤"을 리턴
		
		System.out.println(map.getOrDefault(11, "아무개")); //-> key가 없으면, 아규먼트 defaultValue를 리턴.
		// key 11에는 아무것도 없으므로 null이 들어있는데, 이 때 default에 있는 "아무개"를 리턴한다.
		
		// keySet(): Map의 Key들로 이루어진 집합(set)을 리턴.
		Set<Integer> keySet = map.keySet();
		System.out.println(keySet);
		
		for (Integer k : keySet) {
			System.out.println("["+k + " : " +map.get(k)+"]");
		}
		
		// Map에 저장된 데이터 삭제: remove(key)
		String remove = map.remove(101); // 리턴 타입은 삭제한 "Value".
		System.out.println(remove); // 삭제한 value를 출력. "홍길동"
		System.out.println(map); // 결과 확인
		
		
		// put(key, value)
		// (1) key가 존재하지 않으면, 새로운 key-value 쌍의 데이터를 저장.
		// (2) key가 존재하면, 해당 키의 값을 변경. 
		map.put(10, "No Name");
		System.out.println(map); // {1=홍길동, 10=No Name}
		
		map.replace(10, "오쌤"); // put의 기능 중 (2)번 기능만 가지고 있는 메서드.
		System.out.println(map);
	}

}
