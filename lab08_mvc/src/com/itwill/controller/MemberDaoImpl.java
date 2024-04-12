package com.itwill.controller;

import com.itwill.model.Member;

// MVC 아키텍쳐에서 컨트롤러 역할을 담당할 클래스 -> 싱글턴으로 구현.
public class MemberDaoImpl implements MemberDao {


	// ----------- singleton 구현---------------
	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {}
	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	// ----------- singleton 구현---------------

	// 회원 정보를 저장할 배열 선언.
	private Member[] members = new Member[MAX_LENGTH];

	// 회원 배열에 현재까지 저장된 원소의 개수 -> 새로운 회원 정보를 저장할 위치(배열 인덱스)
	private int count = 0; // 배열에 원소를 저장할 때 마다 1씩 증가 (count++;)
	
	

	public int getCount() {
		return count;
	}

	@Override
	public int create(Member member) {
		if (count != MAX_LENGTH) {
			members[count] = member;
			count++;
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Member[] read() {
		// TODO 배열 members의 원소들 중 null이 아닌 원소들로만 이루어진 배열을 리턴하는건 어떰?
		// TODO 원본 배열이 1개면 1개짜리 배열을 하나 만들어서 원본배열을 넣으면 어떰?
		
		
		Member[] members2 = new Member[count];
		for (int i = 0; i < count; i++) {
			members2[i] = members[i];
		}
		return members2;
	}

	@Override
	public Member read(int index) {
		// TODO 인덱스 범위가 잘못되면 null을 리턴.
		if (index >= 0 && index < MAX_LENGTH) {
			return members[index];
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, String password) {
		if (index >= 0 && index < MAX_LENGTH) {
			members[index].setPassword(password);
			return 1;
		} else {
			return 0;
		}
	}

}
