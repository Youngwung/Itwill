package com.itwill.ver02;

import java.util.Scanner;

import com.itwill.ver01.Contact;

// MVC 아키텍쳐에서 View 역할. 입력과 출력을 담당.
public class ContactMain02 {

	Scanner sc = new Scanner(System.in);			//메서드마다 스캐너를 선언하지 않고 사용하기 위한 필드 선언.

	ContactDao dao = ContactDaoImpl.getInstance(); // 싱글턴 디자인 패턴, ConstactDao클래스의 객체는 단 한개만 생성 가능.
	
	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.2 ***");

		ContactMain02 app = new ContactMain02();	// 메서드를 사용하기 위한 메인 클래스 선언.
		boolean run = true;

		while (run) {
			
			int menu = app.selectMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveContact();
				break;
			case 2:
				app.readAllList();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.updateContact();
				break;
			default:
				System.out.println("0~4까지의 숫자를 입력해주세요."); // 0~4이외의 "정수"를 입력 받았을 때 실행되는 문장.
				break;
			}

		}
		System.out.println(">>> 프로그램 종료 >>>");
	}

	private void updateContact() {
		System.out.println("\n --- 수정 --- ");
		System.out.print("수정할 인덱스 입력>>> ");
		try { // NumberFormetException 해결을 위한 try-catch문
			int index = Integer.parseInt(sc.nextLine());
			ContactDaoImpl daoImpl = (ContactDaoImpl) dao; // 다형성으로 선언했기 때문에 isVarIndex 메서드를 보기 위한 casting

			if (daoImpl.isVarIndex(index)) {
				
				System.out.println("수정 전 정보: " + dao.read(index));
				System.out.print("수정할 이름 입력>>> ");
				String name = sc.nextLine();
				
				System.out.print("수정할 전화번호 입력>>> ");
				String phone = sc.nextLine();
				
				System.out.print("수정할 이메일 입력>>> ");
				String email = sc.nextLine();
				
				Contact contact = new Contact(name, phone, email); // 수정할 정보를 아규먼트로 제공하기 위한 객체 생성
				
				int isSuc = dao.update(index, contact);
				
				if (isSuc == 1) {
					System.out.println("수정 후 정보: " + dao.read(index));
				} else {
					System.out.println("수정에 실패했습니다.");
				}
			} else {
				System.out.println("저장된 정보가 없습니다."); // 배열의 인덱스가 null일 때 출력하는 문장.
			}
			
		} catch (Exception e) {
			System.out.println("정수를 입력해주세요....."); // 입력받은 문자열이 정수가 아닐 때 출력하는 문장
		}

	}

	private void readContactByIndex() {
		System.out.println("\n --- 인덱스 검색 ---");
		System.out.print("인덱스 입력>>> ");
		try { // NumberFormetException 해결을 위한 try-catch문
			int index = Integer.parseInt(sc.nextLine());
			ContactDaoImpl daoImpl = (ContactDaoImpl) dao; // // 다형성으로 선언했기 때문에 isVarIndex 메서드를 보기 위한 casting
			if (daoImpl.isVarIndex(index)) {
				
				System.out.println("[" + index + "] " + dao.read(index));
			} else {
				System.out.println("저장된 정보가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println("정수를 입력해주세요..."); // 입력받은 문자열이 정수가 아닐 때 출력하는 문장
		}

	}

	private void readAllList() {
		System.out.println("\n ---- 연락처 목록 ----");
		Contact[] contacts = dao.read();
		ContactDaoImpl daoImpl = (ContactDaoImpl) dao; // 다형성으로 선언했기 때문에 getCount 메서드를 보기 위한 casting
		for (int i = 0; i < daoImpl.getCount(); i++) {// 저장되지 않은 인덱스는 출력하지 않기 위해 getCount 사용.
			System.out.println("[" + i + "] " + contacts[i]);
		}
		
	}

	private void saveContact() {
		ContactDaoImpl daoImpl = (ContactDaoImpl) dao;	// 다형성으로 선언했기 때문에 getCount 메서드를 보기 위한 casting

		if (daoImpl.getCount() == ContactDao.MAX_LENGTH) { // 배열이 꽉찼을 때 정보를 입력받기 전에 문구를 출력하기 위한 조건문.

			System.out.println("배열에 더 이상 저장할 공간이 없습니다.");

		} else {
			System.out.println(" ----- 연락처 저장 -----");
			System.out.print("이름 입력>>> ");
			String name = sc.nextLine();
			System.out.print("전화번호 입력>>> ");
			String phone = sc.nextLine();
			System.out.print("이메일 입력>>> ");
			String email = sc.nextLine();

			Contact contact = new Contact(name, phone, email);
			int isSuc = dao.create(contact);
			if (isSuc == 1) {
				System.out.println("연락처 저장에 성공했습니다.");
			} else {
				System.out.println("연락처 저장에 실패했습니다.");
			}
		}
	}

	private int selectMenu() {
		try { // NumberFormetException 해결을 위한 try-catch문
			System.out.println("\n[0] 종료 [1] 저장 [2] 목록 [3] 인덱스로 검색 [4] 수정");
			int menu = Integer.parseInt(sc.nextLine());
			return menu;
		} catch (Exception e) { 
			System.out.println("정수를 입력해주세요...."); // 입력받은 문자열이 정수가 아닐 때 출력하는 문장
			return selectMenu(); // 재귀함수 ->간단한 루프.
		}
	}

}
