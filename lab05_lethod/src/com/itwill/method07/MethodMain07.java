package com.itwill.method07;

public class MethodMain07 {

	public static void main(String[] args) {
		// 가변길이 인수(variable-length argument)
		// 메서드의 아규먼트 개수가 미리 정해져 있지 않은 경우.
		// 메서드를 호출할 때마다 아규먼트 개수가 달라질 수 있음.
		System.out.printf("Hello\n"); // argument 1개
		System.out.printf("안녕하세요, %s\n", "오쌤"); // argument 2개
		System.err.printf("%d x %d = %d \n", 5, 2, 10); // argument 4개
		
		int total = addAll();
		System.out.println("total = " + total);

		total = addAll(1, 100);
		System.out.println("total = " + total);

		total = addAll(1, 3, 5);
		System.out.println("total = " + total);
		
		System.out.println("-----------------------");
		int str = calculate("/");
		System.out.println(str);
		
		int zero = calculate("+");
		System.out.println(zero);
		
		int one = calculate("*");
		System.out.println(one);
		
		int sum = calculate("+",5,5,5,5);
		System.out.println(sum);
		int dot = calculate("*",1,2,3,4,5);
		System.out.println(dot);
	}
	

	// 가변길이 인수를 갖는 메서드를 선언하는 방법:
	// 가변길이 인수를 저장하는 파라미터는 "변수타입... 변수이름" 형식으로선언.
	// 가변길이 인수는 메서드안에서 배열처럼 취급.
	// -가변길이 인수는 length 속성을 가지고 있음.
	// -for 문, 향상된 for 문에서 사용할 수 있음.
	// 가변길이 인수를 저장하는 파라미터는 반드시 마지막 파라미터여야 함!
	// 가변길이 인수를 저장하는 파라미터는 2개 이상 있을 수 없음!
	// 가변길이 인수를 갖는 메서드를 호출할 때는 아규먼트 개수의 제한이 없음.
	// - 아규먼트를 전달하지 않아도 됨.

	public static int addAll(int... args) {
		int result = 0;
		System.out.println("length = " + args.length);
		for (int x : args) {
			result += x;
		}

		return result;
	}
	
	/**
	 * calculate.
	 * op의 값이 "+"인경우에는, 가변길이 인수 values의 합을 리턴. values가 없으면 0을 리턴.
	 * op의 값이 "*"인경우에는, 가변길이 인수 values의 곱을 리턴. values가 없으면 1을 리턴.
	 * op의 값이 "+"나"*"가 아니면 0을 리턴.
	 * 
	 * @param op 연산자. "+" 또는 "*".
	 * @param values 기변길이 인수. 정수(int).
	 * @return velues들의 합 또는 곱.
	 */
	
	public static int calculate(String op, int... values) {
		int result = 0;
		if (op == "+") {
				for (int x : values) {
					result += x;
				}
		} else if (op == "*") {
			result = 1;
			for (int x : values) {
				result *= x;
			}
		}
		return result;
	}
}
