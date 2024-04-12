package com.itwill.list05;

import java.util.ArrayList;

public class ListMain05 {

	public static void main(String[] args) {
		// Member 타입 객체들을 저장하는 ArrayList를 선언, 초기화
//		Member[] a = new Member[Length]; //=> 배열
		ArrayList<Member> members = new ArrayList<>();
		
		// members에 원소들을 저장
		members.add(new Member("admin", "1111"));
		members.add(new Member("guest", "guest"));
		members.add(new Member("itwill", "0410"));
		members.add(new Member("TEST", "test"));
		members.add(new Member("guest", "0000"));
		
		
//		System.out.println(members);
		// 향상된 for 문장을 사용해서 members의 원소들을 출력.
		
		// 회원 아이디에 "est"가 포함된 회원 정보를 다른 리스트에 저장하고, 출력.
		// 영문자의 대/소문자는 구분하지 않음.
		
		ArrayList<Member> includeEst = new ArrayList<Member>();
		for (Member m : members) {
			System.out.println(m);
			if (m.getId().toLowerCase().contains("est")) {
				includeEst.add(m);
			}
		}
		System.out.println();
		for (Member m : includeEst) {
			System.out.println(m);
		}
		
		// members에서 첫번째로 등장하는 id가 "guest"인 회원 삭제
//		ArrayList<Member> removeFirstGuest = new ArrayList<Member>();
		
//		members.remove(new Member("guest", null"));  // => equls를 재정의 했을 때 사용 가능한 방법.
		
		for (Member m : members) {
			
			if (m.getId().toLowerCase().contains("guest")) {
				
				members.remove(m);
				break;
			}
			
		}
		System.out.println(members);
		

	}

}
