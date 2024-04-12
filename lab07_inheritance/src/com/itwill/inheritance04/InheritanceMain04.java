package com.itwill.inheritance04;

/*
 * final: 변경할 수 없는.
 * final 지역변수: 값을 초기화한 이후에 그 값을 변경할 수 없는(재할당할 수 없는) 지역변수.
 * final 필드(field): 반드시 한 번은 명시적으로 초기화해야 하고, 이후에는 값을 변경할 수 없는 필드. 
 *  (1) field 필드를 선언과 동시에 초기화 
 *  (2) or field 필드를 초기화할 수 있는 야규먼트를 갖는 생성자를 작성.  => 둘 중에 하나는 반드시 해야함.
 *  field 메서드: 변경할 수 없는 메서드. => 재정의(override)할 수 없는 메서드.
 *  field 클래스: 변경할 수 없는 클래스. => 상속받을 수 없는 클래스.
 *  (ex) java.lang.System, java.lang.String, ... 상속받을 수 없음
 */


//class MyString extends String {}  => final 클래스를 상속하는 새로운 클래스는 선언할 수 없음.

class C{}
final class D {}

class E extends C {}
//class F extends D {} //=>final 로 선언된 클래스는 상속해줄 수 없다.
final class G extends C {} //final로 선언된 클래스도 상속 받을 수 있다.

class A {
	public void test1() {
		System.out.println("test1");
	}
	
	public final void test2() {
		System.out.println("test2");
	}
	
}

class B extends A {
	@Override // 상위 클래스의 field이 아닌 메서드는 override할 수 있음.
	public void test1() {
		System.out.println("B overrides test1");
	}
	
	//상위 클래스에서 final로 선언된 메서드는 하위 클래스에서 override할 수 없음.
//	public void test2() {
//		System.out.println("B test2");
//	} => 재정의 할수 없다는 에러메세지.
	
}

public class InheritanceMain04 extends A{
	final int x = 1;

	public static void main(String[] args) {
		

	}
	

}
