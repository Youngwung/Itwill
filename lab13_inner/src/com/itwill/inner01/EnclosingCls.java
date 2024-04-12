package com.itwill.inner01;

public class EnclosingCls {
	public static int var = 1; // static field
	private int x; // instance field
	public EnclosingCls(int x) {
		this.x = x;
	}
	
	// static method
	public static void test() {
		System.out.println("var = "+ var);
//		System.out.println(x); // static메서드 안에서 static이 아닌 멤버는 사용이 불가능하다
		// => static 메서드는 객체 생성 없이 사용이 가능하기 때문에, 객체 생성 후에 선언 및 초기화되는 x를 사용할 수 없는 것.
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("EnclosingCls(x = %d, var = %d)", x, var);
	}
	
	// static 내부 클래스 (중첩 클래스)
	public static class NestedCls {
		private int x;
		
		public NestedCls(int x) {
			this.x = x;
		}
		
		public void info() {
			System.out.println("------NestedCls------");
			System.out.println("x = "+x); // 내부(중첩)클래스의 필드 x
			System.out.println("var = " + var); // 외부 클래스의 static 필드
//			System.out.println(EnclosingCls.this.x); // static클래스는 외부 객체를 선언하지 않고도 객체를 생성할 수 있다.
			// 객체 생성 후 초기화되는 외부클래스의 필드 x는 중첩클래스에서 사용이 불가능한 것.
			// => 중첩 클래스 안에서는 외부 클래스의 static 멤버만 사용 가능하다.
			// 외부 클래스의 non-static 멤버들은 사용할 수 없다.
			
		}
		
		
	}// end class NestedCls
	
} // end class EnclosingCls
