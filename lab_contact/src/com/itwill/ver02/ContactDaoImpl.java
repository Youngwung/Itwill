package com.itwill.ver02;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	// --- 싱글턴 구현 시작
	private static ContactDaoImpl instance = null;
	private ContactDaoImpl () {};
	public static ContactDaoImpl getInstance() {
		if (instance != null) {
		return instance = new ContactDaoImpl();
		} else {
			return instance;
		}
	}
	// --- 싱글턴 구현 끝
	
	Contact[] contacts = new Contact[MAX_LENGTH];
	private int count = 0;
	
	public int getCount() {// 메인에서 count를 이용하기 위한 getter
		return count;
	}
	
	public boolean isVarIndex(int index) { // 자주 쓰이는 조건 식 메서드로 만들어두기.
		return  index >= 0 && index < getCount() && contacts[index] != null;
	}
	
	@Override
	public int create(Contact contact) {
		if (count == MAX_LENGTH) { // 배열이 꽉차있으면 0을 리턴
			return 0;
		}
		contacts[count] = contact; // 전달받은 아규먼트를 배열에 저장.
		count++;	// 현재 저장한 배열 개수 +1
		return 1;
	}

	@Override
	public Contact[] read() {
		return contacts; // 현재 배열을 리턴
	}

	@Override
	public Contact read(int index) {
		return contacts[index]; // 전달받은 인덱스에 해당하는 배열의 객체를 리턴
	}

	@Override
	public int update(int index, Contact contact) {
		contacts[index] = contact; // 전달받은 인덱스에 해당하는 위치에 전달받은 객체를 배열에 저장.
		return 1;
	
	}
	
}
