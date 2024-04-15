package com.itwill.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Stream 클래스 & 메서드
		
		Random rand = new Random();
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			numbers.add(rand.nextInt(100));
		}
		System.out.println(numbers);
		
		//numbers의 원소들 중에서 짝수들만 선택(필터링)한 새로운 리스트를 만들고, 출력.
		
		
		// (1) for문 이용해서 만들기
		ArrayList<Integer> evens1 = new ArrayList<Integer>();
		for (Integer x : numbers) {
			if (x % 2 == 0) {
				evens1.add(x);
			}
		}
		System.out.println(evens1);
		
		// (2) Stream클래스와 객체생성으로 만들기.
		
		List<Integer> evens2 = numbers.stream().filter(new Predicate<Integer>() { // stream() 메서드는 모든 리스트가 가지고 있다.
			// toList를 사용하지 않으면 리턴값이 stream. 사용하면 List타입 리턴.
			@Override
			public boolean test(Integer t) {
				return t % 2 == 0;
			}
			
		}).toList(); // 생성자 호출까지 Stream 타입이다. 여기에서 .toList()메서드를 사용하면 리턴타입으로 리스트를 제공한다.
		System.out.println(evens2);
		
		// (3) Stream클래스와 람다표현식을 이용해서 만들기
		List<Integer> evens3 = numbers.stream().filter((x) -> x % 2 == 0).toList(); 
		// filter메서드는 람다표현식으로 [ (아규먼트한개) -> (조건식) ] 을 입력해주고 Stream 타입을 리턴한다. 
		System.out.println(evens3);
		
		
		// Stream을 사용해서, numbers의 원소들 중에서 홀수들만 선택한 리스트를 만들고 출력.
		List<Integer> odds = numbers.stream().filter((x) -> x % 2 == 1).toList();
		System.out.println(odds);
		
		// stream 사용해서, numbers의 원소들의 제곱을 저장하는 리스트를 만들고 출력.
		
		List<Integer> squares = numbers.stream().map(x -> x * x).toList();
		// map 메서드는 람다표현식으로 [ (아규먼트 한개) -> (원하는 수식) ]을 입력해주고 Stream 타입을 리턴한다.
		System.out.println(squares);
		
		// Stream을 사용해서 numbers의 원소들 중 홀수들의 제곱을 저장하는 리스트를 만들고 출력
		
		List<Integer> oddSquares = numbers.stream().filter(x -> x % 2 == 1).map(x -> x * x).toList();
		System.out.println(oddSquares);

		List<Integer> oddSquares2 = new ArrayList<Integer>();
		
		for (Integer x : numbers) {
			if (x % 2 == 1) {
				oddSquares2.add(x * x);
			}
		}
		System.out.println(oddSquares2);
		
		List<String> languages = Arrays.asList("java", "javascript", "python", "c", "kotlin");
		
		// languages의 원소들 중 문자열 길이가 5글자 이상인 원소들의 리스트
		
		List<String> up5Leng = languages.stream().filter(x -> x.length() > 4).toList(); 
		System.out.println(up5Leng);
		
		// languages의 문자열을 대문자로 변환한 리스트
		List<String> toUpper = languages.stream().map( x -> x.toUpperCase()).toList();
		System.out.println(toUpper);
		// languages의 원소들 중 길이 5글자 이상인 문자열을 대문자로 변환한 리스트
		List<String> up5ToUpper = languages.stream().filter(x -> x.length()>4)
//				.map(x -> x.toUpperCase())
				.map(String::toUpperCase) // 메서드 참조를 사용한 람다 표현식 (1).
				.toList();
		System.out.println(up5ToUpper);
		
		
		/*
		 * 람다: (파라미터 선언) -> 리턴값   [가장 간단한 형식 - 문장이 한개이고, 그 문장이 리턴문장인경우]
		 * "메서드 참조(method reference)"를 사용한 람다 표현식
		 * (1) 람다가 아규먼트를 1개만 갖고,
		 * 	___람다의 리턴값이 그 아규먼트에서 "파라미터가 없는 메서드"를 호출한 경우:
		 * 		x -> x.toUpperCase()
		 * 		String::toUpperCase   =>둘이 같은 결과를 주는 표현식
		 * (2) 람다가 아규먼트를 1개만 갖고,
		 * 람다의 구현부가 메서드 1개 호출이고, 그 메서드가 람다의 아규먼트를 전달받는 경우:
		 */
		
		languages.forEach((x) -> {System.out.println(x); }); // forEach 메서드는 메서드 내부에 Stream을 포함하고 있다.
		// for-each 문장을 만들어주는 메서드.
		System.out.println("----------------------");
		languages.forEach(System.out::println);
		
	}

}
