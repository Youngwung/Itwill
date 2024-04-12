package com.itwill.ver03;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver01.Contact;

public class ContactDaoImpl implements ContactDao {
	// -------싱글턴 디자인 패턴----------
	private static ContactDaoImpl INSTANCE = null;
	private ContactDaoImpl() {};
	public static ContactDaoImpl getInstance () {
		if (INSTANCE == null) {
			return INSTANCE = new ContactDaoImpl();
		} else {
			return INSTANCE;
		}
	}
	// -------싱글턴 디자인 패턴----------
	

	private List<Contact> contacts = new ArrayList<Contact>(); //배열 생성, creat메서드로만 생성 가능하도록 private
	
	boolean isVarIndex(int index) { // 유효한 인덱스인지 검사하는 메서드
		return (index >= 0) && (index < contacts.size());
	}
	
	@Override
	public int create(Contact contact) {
//		boolean result = contacts.add(contact); // Contact 타입을 저장하는 리스트 contacts에 전달받은 contact객체를 저장.
//		if (result == true) { // add메서드는 리스트에 저장이 성공하면 1, 실패하면 0을 리턴해줌. 실패하는 경우보다 exception이 많음
//			return 1;
//		} else {
//			return 0;
//		}
		try { // try-catch를 활용해서 exception이 발생했을 때 0을 리턴해주는 방법.
			contacts.add(contact); // Contact 타입을 저장하는 리스트 contacts에 전달받은 contact객체를 저장.
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public List<Contact> read() {
		return contacts; // 현재까지 저장된 리스트를 리턴.
	}

	@Override
	public Contact read(int index) {
		if (isVarIndex(index)) {
		return contacts.get(index); // 전달받은 인덱스에 해당하는 contact 객체를 리턴해줌.
		} else {
			return null;
		}
	}

	@Override
	public int update(int index, Contact contact) {
		if (isVarIndex(index) && contact == null) { //전달받은 객체가 null이거나 인덱스가 유효하지 않으면 0을 리턴.
			return 0;
		}
		contacts.set(index, contact); // 전달받은 인덱스에 해당하는 contact객체를 전달받은 contact객체로 변경.
		return 1;
	}

	@Override
	public int delete(int index) {
		contacts.remove(index); // 전달받은 인덱스에 해당하는 객체를 제거.
		if (isVarIndex(index)) {
			return 1;
		} else {
			return 0;
		}
	}

}
