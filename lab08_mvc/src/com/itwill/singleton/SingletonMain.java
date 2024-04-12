package com.itwill.singleton;

public class SingletonMain {

	public static void main(String[] args) {
		System.out.println("\n-----아래는 일반적인 Singleton-----\n");
		// Captain 타입의 객체 생성
//		Captain captain = new Captain();  => 생성자를 private으로 만들었기 때문에 메인에서 호출할 수 없음.
		Captain captain = Captain.getInstance();
		System.out.println(captain);
		System.out.println(captain.getName());
		captain.setName("아이언맨");
		System.out.println(captain.getName());
		
		Captain captain2 = Captain.getInstance();// 새로운 객체를 생성하려고 해도 주소값이 바뀌지 않음.
		System.out.println(captain2); // getInstance 메서드의 필드인  intance가 더 이상 null이 아니기 때문에 새로운 객체를 만들지 않음.
		System.out.println(captain2.getName()); // captain에서만 바꾸었던 "아이언맨"이 새로운 객체로 만들었던 captain2에도 똑같이 출력됨.
		// captain 객체와 captain2는 같은 객체 => 새로운 객체가 생성되지 않았음 => 싱글턴 디자인 패턴.
		
		System.out.println("\n-----아래는 enum을 이용한 Singleton-----\n");
		
		// Singleton 타입의 객체 생성
		Singleton s1 = Singleton.INSTANCE;
//		Singleton s2 = new Singleton(); => private 으로 감춰져있기 때문에 생성자로 직접 객체를 만들 수 없다.
		System.out.println(s1);
		System.out.println(s1.getName());
		s1.setName("블랙 위도우");
		System.out.println(s1.getName());
		
		
	}

}
