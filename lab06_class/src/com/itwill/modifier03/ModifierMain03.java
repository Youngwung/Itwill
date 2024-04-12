package com.itwill.modifier03;

/*
 * 데이터 캡슐화(encapsulation)
 * 필드들을 private으로 선언해서 클래스 외부에서는 보이지 않도록(직접 접근할 수 없도록) 감추고,
 * 대신에 필요한 경우에 한해서 public으로 공개한 메서드를 제공해서
 * 간접적으로 필드들의 값을 읽거나 수정하는 것을 허용하는 객체지향 프로그램밍 기법.
 * 데이터의 보안과 무결성을 유지하기 위해서 캡슐화를 사용.
 *  -무결성: 아이디나 비밀번호가 null값이 될 수 없는 것.
 * getter 메서드: private 필드의 값을 리턴하는 메서드.
 * setter 메서드: private 필드의 값을 변경하는 메서드.
 */

public class ModifierMain03 {

	public static void main(String[] args) {
		// Member 타입 객체 생성
		Member member = new Member("guest","1234");
		//필드들이 private으로 선언되었기 때문에 아이디와 비밀번호를 출력할 방법이 없음.
		//System.out.println("id: "+member.memberId); =>컴파일 에러 /not visible
		
		//함수제공
		System.out.println("ID: "+member.getMemberId());
		System.out.println("password: "+member.getMemberPassword());
		member.setMemberPassword("5678");
		System.out.println("changed password: "+member.getMemberPassword());
		
//		Person person1 = new Person();		//무결성검사
		Person person1 = new Person("김영웅", 28);		
		System.out.println("이름: "+ person1.getterName());
		System.out.println("나이: "+ person1.getterAge());
		person1.setterAge(30);
		System.out.println("2년 뒤의 나이: "+ person1.getterAge());
		
		
	}

}
