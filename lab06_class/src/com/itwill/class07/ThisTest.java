package com.itwill.class07;

public class ThisTest {
	//field
	int x;
	int y;
	int z;
	
	//construct
	public ThisTest() {}
	
	public ThisTest(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		//->this: ThisTest 타입으로 생성된 객체(인스턴스)
	}
	
	public ThisTest(int x) {
		//this.x = x;
		this(x, 0, 0); //-> this( ... ): ThisTest 클래스의 다른 생성자
		// (주의) this(...) 생성자를 호출하는 코드는 다른 실행문들보다 먼저 실행되어야 함.
		// -> 중괄호 블럭 안에서 가장 위에 위치해야함.
	}
	
	public ThisTest(int x, int y) {
		this(); // 현재 클래스의 다른 생성자를 호출하는 문장.
		this.x = x;
		this.y = y;
	}
	
	//method
	public void info() {
		System.out.printf("x = %d, y = %d, z = %d\n",x,y,z);
	}

}
