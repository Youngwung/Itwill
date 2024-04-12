package com.itwill.print;

public class PrintMain {

	public static void main(String[] args) {
		// 여러가지 콘솔 출력 방법:

		System.out.println("한 줄 출력(print line)");
		System.out.println("1 + 2"); // "1 + 2" 문자열(string)을 출력
		System.out.println(1 + 2); // 1 + 2 덧셈 결과를 출력
		System.out.println("1 + 2 = " + 3);
		System.out.println("1 + 2 = " + 1 + 2); // -> 1 + 2 = 12
		System.out.println("1 + 2 = " + (1 + 2)); // -> 1 + 2 = 3

		System.out.print("안녕하세요~");
		System.out.println(" 반갑습니다.");

		// printf => formatted printing: 형식을 갖는 출력문
		// \n: 줄바꿈(new line)
		// \t: 탭(tap)
		System.out.printf("문자열 포맷: 정수(%d), 실수(%.2f), 문자열(%s)\n", 123, 3.14, "ㅎㅇ");
		System.out.printf("%d + %d = %d\n", 1, 2, (1 + 2));
	}
}


















