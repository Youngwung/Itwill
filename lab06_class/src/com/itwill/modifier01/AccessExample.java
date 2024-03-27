package com.itwill.modifier01;

public class AccessExample {
	// field
	private int a;
	int b;
	protected int c;
	public int d;

	// construct
	public AccessExample(int a, int b, int c, int d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	// method
	public void info() {
		System.out.printf("a = %d, b = %d, c = %d, d = %d\n", a, b, c, d);
		//a를 출력하려면 클래스파일에 메소드를 public으로 만들어 출력 가능.
		// a값을 메인에서 변경하는 것은 현재로서는 불가능.
	}

}
