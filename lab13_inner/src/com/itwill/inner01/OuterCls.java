package com.itwill.inner01;

public class OuterCls {
	// field
	private int x;
	private int y;
	private String s;
	
	// constructor
	public OuterCls(int x,int y, String s) {
		this.x = x;
		this.s = s;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("OuterCls(x = %d, s = %s)", x, s);
	}
	
	// static이 아닌 멤버 내부 클래스
	public class InnerCls {
		//field
		private int y;
		
		//constructor
		public InnerCls(int y) {
			this.y = y;
		}
		
		//method
		public void info() {
			System.out.println("----- InnerCls -----");
			System.out.printf("y = %d\n",y); // InnerCls 인스턴스의 필드.필드 이름이 겹쳤을 때 그냥 사용하면 내부클래스의 변수를 가져옴
			System.out.printf("OuterCls y = %d\n",OuterCls.this.y); 
			// -> 내부 클래스의 필드 이름과 외부 클래스의 필드 이름이 같은 경우,
			// 외부 클래스 인스턴스의 필드를 사용하는 방법.
			System.out.printf("x = %d\n",x); // OuterCls 인스턴스의 필드.
			System.out.printf("s = %s\n",s); // OuterCls 인스턴스의 필드.
			
		}
		
	} // end class InnerCls
	
} // end class OuterCls
