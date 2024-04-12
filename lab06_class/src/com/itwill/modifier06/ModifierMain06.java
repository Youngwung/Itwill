package com.itwill.modifier06;

/*
 * 접근 수식어(access modifier)는 지역 변수에는 사용할 수 없음!
 * 
 * final 수식어
 *  - 클래스, 클래스의 멤버 중 [필드, 메서드], 지역 변수에서 사용 가능
 *  - final 의미: 바꿀 수 없는. (결정된 최종 결과 느낌)
 *  - final 필드/지역변수: 한 번 초기화가 되면 더 이상 값을 변경할 수 없음. 상수(constant)
 *  - final 필드는 "반드시"
 *  (1) 선언과 동시에 초기화하거나
 *  (2) 또는 아규먼트를 갖는 생성자를 선언해서 명시적으로 초기화 해야 함.
 *  
 *  인스턴스 멤버(필드, 메서드) vs 정적(static) 멤버 (필드, 메서드)  //=> 생성자는 일단 제외
 *  1. 인스턴스 멤버(필드, 메서드)
 *   (1) static 수식어가 없는 멤버.
 *   (2) 객체를 생성한 후에 참조 변수를 이용해서 사용하는 멤버(필드, 메서드).
 *   (3) 인스턴스 필드는 JRE(Java Runtime Environment)가 사용하는 메모리 영역 중에 힙에 생성.
 *   
 *  2. 정적 멤버 (필드, 메서드).
 *   (1) static 수식어가 사용된 멤버(필드, 메서드)
 *   (2) 객체를 생성하지 않아도 사용할 수 있는 멤버(필드, 메서드).
 *   (3) 클래스 이름을 이용해서 사용하는 멤버(필드, 메서드). (예) Math.PI, Math.random(), System.in, System.out , ...
 *   (4) 정적 필드는 JRE가 사용하는 메모리 영역 중에 메서드 영역에 생성
 *   (5) 정적 멤버들은 프로그램의 main() 메서드가 호출되기 전에, 프로그램 로딩 시점에 메모리에 생성됨.
 *   (6) static(정적) 메서드는 static 필드와 메서드만 사용 가능. ******
 *  
 */

public class ModifierMain06 {
	
	private static final int version = 1; //fianl으로 선언된 필드

	private final String message; //fianl으로 선언하고 초기화 하지 않는 필드 =>단일사용 시 에러남 
	
	
					
	//해결 방법은? 
	// 선언과 동시에 초기화 하거나 초기화하는 생성자를 만들어준다
	// 생성자가 없으면 기본생성자가 있는 것과 마찬가지이므로 
	// 기본값으로 초기화돼버려 더이상 변경할 수 없어짐.
	
	public ModifierMain06(String message) { 	
		this.message = message;	//final 필드를 명시적으로 초기화하는 생성자	
	}										

	
	public static void main(String[] args) {

		// 지역 변수 선언 & 초기화
		int n1 = 10;
		n1 = 100;	//값 변경 가능.
		
		final int n2 = 10;
		//n2 = 100;  //-> can't be assigned 저장할 수 없음 에러.
		
		final int n3;
		n3 = 10;  //=> 선언하고 나서 첫번째 초기화는 에러없이 됨.
//		n3 = 100; // =>두번째 초기화는 에러
		
		// version = 2; //-> 클래스에서 선언된 필드도 메인에서 바꾸려 해도 안됨.
		
		
		// ModifierMain06 타입의 객체를 생성:
		ModifierMain06 app = new ModifierMain06("버스 파업");
//		app.message = ""; => final 필드는 객체 생성 이후에 값을 변경할 수 없음.
		System.out.println(app.message);
		
		
		// Test 클래스의 정적(static) 멤버 사용:
		System.out.println("Test.y = " +Test.y);
		Test.y = 100; // static 필드는 객체 생성과 관계없이 사용할 수 있음.
		System.out.println("Test.y = " +Test.y);
		Test.printFields2();
		
		// Test 클래스의 인스턴스(static이 아닌) 멤버 사용: 먼저 객체를 생성 해야 됨.
		Test test = new Test();
		System.out.println(test.x);
		test.x = 100;
		test.printFields();
		
		

	}

}
