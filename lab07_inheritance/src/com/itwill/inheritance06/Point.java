package com.itwill.inheritance06;



// 2차원 평면의 점의 좌표를 표현
public class Point {
	// field
	private int x;
	private int y;
	
	// construct
	public Point() {}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	@Override // Object의 클래스에서 상속받은 toString() 재정의
	public String toString() {
		// TODO Auto-generated method stub
		return "Point(x ="+x+", y = "+y+")";
	}
	
	@Override // Object에서 상속받은 equals를 재정의
	public boolean equals (Object obj) {
		boolean result = false;
		if (obj instanceof Point) { // 아규먼트로 받은 obj의 타입이 Point인지 검사.
			
			Point pt = (Point) obj; 
			// 안전한 casting => 주소값을 같게 만들기 위해 obj를 Point타입으로 강제변환(casting)
			// Object타입으로 선언했으므로 Point 로 변환하지 않으면 아규먼트의 x와 y를 읽을 수 없음.
			// - if문으로 Point인지 검사했으므로 100% 성공.
			
			result = (this.x == pt.x) && (this.y == pt.y); // 필드의 값이 같은 지 검사
		}				
		return result;
	}

	@Override // Object 클래스의 hashCode() 메서드를 재정의
	public int hashCode() {
		// TODO Auto-generated method stub
		return x + y; 	// 메서드 내부에서 hashCode()를 사용하는 메서드를 사용할 때에 생기는 문제를 방지하기 위해 항상 같은 hashCode를 갖게함. 
						// f(x,y)의 형태면 가능한듯? 필드값을 포함하는 함수로 만들면 되는 것 같음.
	}
}
