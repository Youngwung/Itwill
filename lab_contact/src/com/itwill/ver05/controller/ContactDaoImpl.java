package com.itwill.ver05.controller;

import java.util.ArrayList;
import java.util.List;

import com.itwill.ver05.model.Contact;
//import com.itwill.ver05.util.FileUtil;

// import static 문장: 클래스에서 public static으로 선언된 멤버(필드, 메서드)의 이름 가져오기.
//import static com.itwill.ver04.util.FileUtil.initializeData;
import static com.itwill.ver05.util.FileUtil.*; // 이 클래스에 있는 모든 스태틱 멤버(필드, 메서드)를 가져옴.
// 효과: 이 클래스에서 FileUtil.~~~하고 사용했던 모든 필드와 메서드를 FileUtil없이 그냥 사용할 수 있음.

// MVC 아키텍쳐에서 Controller 역할 담당 클래스. DAO(Data Access Object).
public class ContactDaoImpl implements ContactDao{
	// --------singleton-------------
	private static ContactDaoImpl INSTANCE = null;
	private ContactDaoImpl() {
//		FileUtil.initializeDataDir();		  //=> import static 문장 선언으로 [FileUtil] 생략 가능.
//		contacts = FileUtil.initializeData(); //=> import static 문장 선언으로 [FileUtil] 생략 가능.
		
		// 데이터 폴더 초기화: 폴더가 없으면 새로 만듦.
		initializeDataDir();		 // 메인에서 DaoImpl 객체를 생성하면 기본생성자에서 자동으로 폴더를 생성
		// 연락처 데이터 초기화: 데이터 파일에서 리스트를 읽어오거나, 빈 리스트를 생성.
		contacts = initializeData();// 객체 생성 시 파일이 존재하면 파일을 불러오고, 파일이 없으면 contacts를 빈 리스트로 초기화.
	}
	public static ContactDaoImpl getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new ContactDaoImpl();
		}
		return INSTANCE;
	}
	// --------singleton-------------
	
	private List<Contact> contacts; // contacts 선언문. ->필드이므로 아래에서 선언하고 위에서 초기화해도 상관 없음.
	
	/**
	 * 인덱스가 연락처 리스트의 유효한 범위 안에 있는 지를 리턴.
	 * @param index 검사할 인덱스
	 * @return 유효한 인덱스이면 true, 그렇지 않으면 false.
	 */
	public boolean isvalidIndex(int index) {
		return (index >= 0) && (index < contacts.size());
	}
	
	@Override
	public int create(Contact contact) {
		contacts.add(contact); // contacts리스트에 전달받은 contact를 추가.
		writeDataToFile(contacts); // contacts 리스트를 파일에 쓰기. 리스트의 내용이 변경될 때마다 파일에 써줘야함.
		return 1;
	}

	@Override
	public List<Contact> read() {
		// 프로그램 실행 중에는 항상 파일과 contacts는 같으므로(같게 만들어야함) 그냥 contacts를 리턴하면 됨.
		return contacts;
	}

	@Override
	public Contact read(int index) {
		if (isvalidIndex(index)) {
			return contacts.get(index);
		}
			return null;
	}

	@Override
	public int update(int index, Contact contact) {
		if(!isvalidIndex(index)) {
			return 0;
		}
		
		contacts.set(index, contact);
		writeDataToFile(contacts); // 리스트의 내용이 변경될 때마다 파일에 써줘야함.
		
		return 1;
	}

	@Override
	public int delete(int index) {
		if (!isvalidIndex(index)) {
		return 0;
		}
		contacts.remove(index);
		writeDataToFile(contacts); // 리스트의 내용이 변경될 때마다 파일에 써줘야함.
		return 1;
	}
	@Override
	public List<Contact> search(String keyword) {
		List<Contact> result = new ArrayList<Contact>();
		for (Contact x : contacts) {
			if (
				x.getName().toLowerCase().contains(keyword.toLowerCase()) || 
				x.getPhone().toLowerCase().contains(keyword.toLowerCase()) || 
				x.getEmail().toLowerCase().contains(keyword.toLowerCase())
				) 
			{
				result.add(x);
			}
		}
		return result;
	}

}
