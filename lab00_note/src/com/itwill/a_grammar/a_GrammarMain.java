package com.itwill.a_grammar;

import java.util.Random; // Random을 사용하기 위한 import 문


import java.util.Scanner; // Scanner를 사용하기 위한 import 문


public class a_GrammarMain {

	public static void main(String[] args) {

		// Random(랜덤)

		Random random = new Random(); // 난수를 만들기 위한 변수 random을 선언
		int random_a = random.nextInt(1, 11); // 1이상 11 미만의 난수를 random_a에 저장, 1은 생략가능하고 그 경우 0이상 n미만의 난수를 저장한다.

		// Scanner(스캐너)
		Scanner scanner = new Scanner(System.in); // 입력받기 위한 변수 scanner를 선언
		int scanner_a = Integer.parseInt(scanner.nextLine()); // scanner로 입력받아 scanner_a에 정수로 저장
		double scanner_b = Double.parseDouble(scanner.nextLine()); // scanner로 입력받아 scanner_b에 실수로 저장
		String scanner_c = scanner.nextLine(); // scanner로 입력받아 scanner_c에 문자열로 저장

		// Array(배열)
		int[] array01 = new int[10]; // int 타입 데이터 10개를 저장할 수 있는 배열을 생성
		int[] array01_1 = { 1, 2, 3, 4 }; // 배열선언 두번째 방법. new 필요 없이 데이터를 나열하여 생성
		int array01_a = array01[0]; // array 배열의 0번째 인덱스를 array_a에 저장 / 1이 저장됨

		double[] array02 = new double[10]; // double 타입 - 실수
		double[] array02_1 = { 1, 2, 3, 4 }; // 실수를 나열하여 생성
		double array02_a = array02[0]; // 1이 저장됨

		String[] array03 = new String[10]; // String 타입 - 문자열
		String[] array03_1 = { "가", "나", "다", "라" };
		String array03_a = array03[0]; // (가) 저장

		int leng = array01.length; // leng 변수에 array01배열의 길이 (10) 을 저장, 이 코드는 읽기 전용 코드. 배열의 길이를 바꾸는 것은 불가.

		/////////다차원배열
		// (1) 첫번째 방법: 타입[][] 변수 이름 = new 타입[][] {{...}, {...}, {...}, {...}, ...}
		int[][] arrays01 = { { 1, 2, 3, 4 }, { 5, 6 }, { 7, 8, 9, 10, 11, 12 }, }; // 2차원 배열이 갖는 모든 원소들을 나열하면서 배열을
																					// 선언하고 초기화. 1차원 배열끼리 길이가 같지 않아도 됨.
//		int[][] arrays02 = { // 알아보기 쉽게 선언하기.
//				{ 1, 2, 3 }, 
//				{ 4, 5, 6 }, 
//				{ 7, 8, 9 }, 
//		};
		
		// (2) 두번 째 방법: 2차원 배열의 행의 개수는 결정 되어져 있고, 열의 개수가 결정되지 않은경우
		// 2차원 배열이 가지고 있는 1차원 배열의 개수는 알고 있지만
		// 각각의 1차원 배열들의 원소 개수는 아직 결정되지 않은 경우
		// 또는 1차원 배열들의 길이가 모두 다른 경우.
		// 타입[][] 변수이름 = new int[n][];
		int[][] arrays04 = new int[3][]; // 1차원 배열 3개를 원소로 갖는 2차원 배열.
		// 열의 개수가 미정인 2차원 배열은 사용하기 전에 반드시 1차원 배열들을 각각 생성해야만 함.
		arrays04[0] = new int[2]; //원소 2개를 갖는 1차원 배열.
		arrays04[1] = new int[4]; //원소 4개를 갖는 1차원 배열.
		arrays04[2] = new int[3]; //원소 3개를 갖는 1차원 배열.
		
		
		
		// Method(메서드)
			//메서드 선언(정의) 방법:
			// [수식어] 리턴타입 메서드이름([파라미터 선언, ...]){ code; ... }  => 대괄호로 표시한 부분은 생략이 가능.
		
//		public static double add(double x, double y) {
//			return x + y; // return 문: 메서드를 호출한 곳으로 값을 반환하는 문장.
		
//		}
		
			//메서드 호출 방법
		//리턴값이 있는 경우
		//변수타입 변수이름 = 메서드이름(아규먼트, 아규먼트)
		//double result = add(x, y);
		
			// 메서드 오버로딩(method overloading)
		// 메서드의 파라미터가 다르면 같은 이름으로 메서드를 여러개 선언(정의)할 수 있다.
		// (주의) 메서드의 파라미터는 동일하고 리턴 타임만 다르게는 오버로딩할 수 없음.
		System.out.println("안녕하세요"); // println (String)
		System.out.println(100); // println(int x)
		System.out.println(); // println()
		System.out.println(true); // println(boolean)
		
				// 메서드 오버로딩 만들어보기
		/**
		 * 콘솔에 빈 줄 하나를 출력하는 메서드.
		 */
//		public static void newLine( ) {
//			System.out.println();
//		}
		
		/**
		 * 콘솔에 n개의 빈 줄을 출력하는 메서드.
		 * @param n 콘솔에 출력할 빈 줄의 개수. 0 또는 양의 정수 만약 0 또는 음수이면 아무것도 출력하지 않음
		 */
//		public static void newLine(int n) {
//			for(int i = 1; i <= n; i++) {
//				System.out.println();
//			}
//		}
		
			// 가변길이 인수(variable-length argument)
		// 메서드의 아규먼트 개수가 미리 정해져 있지 않은 경우.
		// 메서드를 호출할 때마다 아규먼트 개수가 달라질 수 있음.
		// - 대표적으로 "printf"
		System.out.printf("Hello\n"); // argument 1개
		System.out.printf("안녕하세요, %s\n", "오쌤"); // argument 2개
		System.err.printf("%d x %d = %d \n", 5, 2, 10); // argument 4개
		
			// 가변길이 인수를 갖는 메서드를 선언하는 방법:
		// 가변길이 인수를 저장하는 파라미터는 "변수타입... 변수이름" 형식으로선언.
		// 가변길이 인수는 메서드안에서 배열처럼 취급. ****************************
		// -가변길이 인수는 length 속성을 가지고 있음.
		// -for 문, 향상된 for 문에서 사용할 수 있음.
		// 가변길이 인수를 저장하는 파라미터는 반드시 마지막 파라미터여야 함!
		// 가변길이 인수를 저장하는 파라미터는 2개 이상 있을 수 없음!
		// 가변길이 인수를 갖는 메서드를 호출할 때는 아규먼트 개수의 제한이 없음.
		// - 아규먼트를 전달하지 않아도 됨.
				
//		public static int addAll(int... args) {		//배열로 취급하기 때문에 each-for문이 사용 가능
//			int result = 0;
//			System.out.println("length = " + args.length);
//			for (int x : args) {
//				result += x;
//			}
//
//			return result;
//		}
		
		
		//클래스(class)
//		 * 객체(Object): 대상. 프로그램에서 사용하려고 하는 대상.
//		 * 클래스(Class): 객체 설계도. 객체를 만들기 위해서 필요한 코드.
//		 * - 객체가 가져야 하는 "데이터"를 변수("필드")로 선언하고,
//		 * - 객체가 가져야 하는 "기능"을 "메서드"로 선언하는 코드
//		 * - 변수를 선언할 때 사용할 수 있는 데이터 타입.
//		 * 인스턴스(Instance): 실제로 생성된 객체.
		
//		// 클래스(class): 객체 설계도. 데이터(필드)  + 생성자 + 기능(메서드) => 변수 타입.
//		public class Score {//점수합계, 평균 등을 구하기 위한 변수들을 선언하는 공간.
//			
//			// 필드(field). 멤버 변수. 
//			int java;
//			int sql;
//			int javascript;
//			
//			// 생성자(constructor): 필드를 초기화하는 역할
//			// 객체를 생성하고, 객체의 필드들을 초기화하는 역할.
//			// 생성자의 이름은 반드시 클래스의 이름과 같아야함!
//			// 생성자를 작성하는 방법은 메서드 작성방법과 비슷하지만, 리턴 타입이 없음! 리턴타입이 있으면 메서드 => public int Score
//			// 클래스를 선언할 때 생성자를 하나도 작성(정의)하지 않으면 
//			// 자바 컴파일러가 "기본 생성자"를 자동으로 작성해 줌.
//			// 클래스를 선언할 때 생성자를 직접 정의한 경우에는,
//			// 자바 컴파일러가 기본 생성자를 자동으로 만들어 주지 않음!
//			// 생성자 오버로딩: 파라미터가 다른 생성자를 여러개 만들 수 있음.
//			
//			
//			// 기본 생성자(default constructor): 아규먼트를 갖지 않는 생성자.
//			public Score() {
//				// 아무런 코드를 작성하지 않아도 됨.
//				// 코드가 없어도 모든 필드들을 그 필드 타입의 기본값으로 초기화를 해 줌.
//			}
//			
//			// 아규먼트를 갖는 생성자.
//			public Score(int java, int sql, int js) {
//				this.java = java;	//필드와 파라미터 이름이 같으면 필드 앞에 this.을 붙여 구분
//				this.sql = sql;
//				javascript = js;	//필드와 파라미터 이름이 다르면 생략 가능
//			}
//			
//			// 메서드(method).
//			public int getTotal() {
//				return java + sql + javascript;
//			}
//			
//			public double getMean() {
//				return (double) getTotal() / 3;
//			}
		
//		public static void main(String[] args) {
//			// 기본 생성자를 이용하여 Score객체를 생성:
//			Score score1 = new Score(); //-> 모든 필드는 기본값으로 생성됨.
//			System.out.println("java = " + score1.java);
//			
//			// score1 인스턴스의 필드 값 변경:
//			score1.java = 100;
//			score1.sql = 90;
//			score1.javascript = 80;
//			
//			// score1 인스턴스의 메서드 호출:
//			System.out.println("총점: "+score1.getTotal());
//			System.out.println("평균: "+score1.getMean());
//			
//			//아규먼트를 갖는 생성자를 이용한 Score객체 생성:
//			Score score2 = new Score(100,90,80);
//			System.out.println("score2 java = "+score2.java);
//			System.out.println("총점: "+score2.getTotal());
//			System.out.println("평균: "+score2.getMean());
//
//		}

	
	
	
	
	}
	
}
