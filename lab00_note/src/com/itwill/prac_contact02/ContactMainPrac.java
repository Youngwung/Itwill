package com.itwill.prac_contact02;

import java.util.Scanner;

public class ContactMainPrac {
		private Scanner scanner = new Scanner(System.in);
		static final int MAX_LENGTH = 3;
		private int count = 0;
		private Contact[] contacts = new Contact[MAX_LENGTH];
		
		


	public static void main(String[] args) {
		
		ContactMainPrac app = new ContactMainPrac();
		
		boolean run = true;
		
		while (run) {
			int menu = app.selectMenu();
			
			switch (menu) {
			case 0: //종료
				run = false;
				break;
			case 1://저장
				app.saveContact();			
				break;
			case 2://목록
				app.readListAll();
				break;
			case 3://인덱스검색
				app.readListIndex();
				break;
			case 4://인덱스 수정
				app.editListIndex();
				break;
				
			default://재입력요청
					
				break;
			}
		}
		
	
	
	}

	private void editListIndex() {
		// TODO 인덱스 검색 후 수정
		System.out.println("\n --- 수정 ---");
		System.out.print("수정할 인덱스 입력 >>");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.println("수정 전: " + contacts[index].toString());
		System.out.print("수정할 이름 입력 >>");
		String name = scanner.nextLine();
		System.out.print("수정할 전화번호 입력 >>");
		String phone = scanner.nextLine();
		System.out.print("수정할 이메일 입력 >>");
		String email = scanner.nextLine();
		
		Contact contact = new Contact(name, phone, email);
		contacts[index] = contact;
		System.out.println("수정 후: " + contacts[index].toString());
		
		
	}

	private void readListIndex() {
		// TODO 인덱스로 검색
		System.out.println("\n --- 인덱스로 검색 ---");
		System.out.print("검색할 인덱스 입력 >>");
		int index = Integer.parseInt(scanner.nextLine());
		System.out.println(contacts[index].toString());
	}

	private void readListAll() {
		// TODO 목록
		for (int i = 0; i < count; i++) {
			System.out.println(contacts[i].toString());
		}
		
	}

	private void saveContact() {
		// TODO 연락처 저장
		System.out.println("\n --- 연락처 저장 ---");
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

	private int selectMenu() {
		// TODO 메뉴설명, 입력받고 리턴
		System.out.println("\n *** 연락처 저장 프로그램 v0.1");
		System.out.println("[0] 종료 [1] 저장 [2] 목록 [3] 인덱스검색 [4] 인덱스수정");
		System.out.print("[0 - 4] 숫자 입력 >>");
		return Integer.parseInt(scanner.nextLine());
	}
}
