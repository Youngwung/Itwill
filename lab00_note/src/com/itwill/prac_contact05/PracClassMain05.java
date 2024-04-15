package com.itwill.prac_contact05;

import java.util.Scanner;

public class PracClassMain05 {
	Scanner scanner = new Scanner(System.in);
	private int count = 0;
	static final int MAX_LENGTH = 3;
	Contact[] contacts = new Contact[MAX_LENGTH];
	
	public static void main(String[] args) {
		boolean run = true;
		PracClassMain05 app = new PracClassMain05();
		
		while (run) {
			int menu = app.selectMenu();
			switch (menu) {
			case 0://종료
				run = false;
				break;				
			case 1://저장
				app.saveContact();
				break;
			case 2://목록
				app.readAllList();
				break;
			case 3://인덱스로검색
				app.readContactByIndex();
				break;
			case 4:// 인덱스로 수정
				app.updateContactByIndex();
				break;
			default://재입력 요청
				System.out.println("[1 - 4] 숫자를 입력해주세요");
				break;
			}
			
		}
	}

	private void updateContactByIndex() {
		// TODO 인덱스를 입력받아 해당하는 객체를 출력하고 정보를 입력받아 객체를 수정.
		System.out.println("\n *****인덱스로 수정 *****");
		System.out.print("수정할 인덱스 입력 >>>>");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.println("수정 전: "+contacts[index].toString());
		System.out.print("이름 입력 >>");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력 >>");
		String phone = scanner.nextLine();
		System.out.print("이름 입력 >>");
		String email = scanner.nextLine();
		contacts[index] = new Contact(name, phone, email);
		System.out.println("수정 후: "+contacts[index].toString());
		
	}

	private void readContactByIndex() {
		// 인덱스를 입력받아 해당하는 인덱스를 출력하는 메서드
		System.out.println("\n **** 인덱스 검색 ****");
		System.out.print("인덱스 입력 >>");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.println(contacts[index].toString());
		
		
	}

	private void readAllList() {
		for (int i = 0; i < count; i++) {
			System.out.println(contacts[i].toString());
		
	}

	}
	private void saveContact() {
		System.out.println("\n ------연락처 저장 -----");
		System.out.print("이름 입력 >>");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력 >>");
		String phone = scanner.nextLine();
		System.out.print("이메일 입력 >>");
		String email = scanner.nextLine();
		Contact contact = new Contact(name, phone, email);
		contacts[count] = contact;
		count++;
	}
	public int selectMenu() {
		System.out.println("\n**** 연락처 저장 프로그램 v0.1 *****");
		System.out.println("[0] 종료 [1] 저장 [2] 목록 [3] 인덱스로 검색 [4] 인덱스로 수정");
		return Integer.parseInt(scanner.nextLine());
	}

}
