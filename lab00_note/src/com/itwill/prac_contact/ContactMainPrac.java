package com.itwill.prac_contact;

import java.util.Scanner;

public class ContactMainPrac {
	
	private Scanner scanner  = new Scanner(System.in);
	
	static final int MAX_LENGTH = 3;
	
	private Contact[] contacts = new Contact[MAX_LENGTH];
	
	private int count = 0;
	

	public static void main(String[] args) {
		ContactMainPrac app = new ContactMainPrac();
		boolean run = true;		
		while (run) {
			int menu = app.menuUi();
			switch (menu) {
			
			case 0:
				System.out.println("프로그램을 종료합니다");
				run = false;
				break;
			case 1: //저장
				app.saveContactByIndex();
				break;
			case 2: // 목록
				app.readList();
				break;
			case 3: // 인덱스로 검색
				app.readListByIndex();
				
				break;
			case 4: // 수정
				app.editByIndex();
				
				break;
			default:
				System.out.println("[0 ~ 4]의 숫자를 입력해주세요");
			
			}
			
			
		}

	}

	private void editByIndex() {
		// TODO 수정
		System.out.println("\n ---연락처 수정 ---");
		System.out.print("수정할 인덱스 입력 >>");
		int index = Integer.parseInt(scanner.nextLine());
		if (index >= 0 && index < count) {
		System.out.println("수정 전: "+contacts[index].toString());
		System.out.print("수정할 이름 입력 >>");
		String name = scanner.nextLine();
		System.out.print("수정할 전화번호 입력 >>");
		String phone = scanner.nextLine();
		System.out.print("수정할 이메일 입력 >>");
		String email = scanner.nextLine();
		
		Contact contact = new Contact(name, phone, email);
		contacts[index] = contact;
		System.out.println("수정 후: "+contacts[index].toString());
		} else {
			System.out.println("해당하는 인덱스가 없습니다.");
		}
		
	}

	private void readListByIndex() {
		// TODO 인덱스로 검색
		System.out.println("\n---인덱스로 검색---");
		System.out.print("검색할 인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index >= 0 && index < count) {
		System.out.println(contacts[index].toString());
		} else {
			System.out.println("해당하는 인덱스가 없습니다.");
		}
	}

	private void readList() {
		// TODO 목록
		for (int i = 0; i < count ; i++) {
			System.out.println(contacts[i].toString());
		}
		
	}

	private void saveContactByIndex() {
		// TODO 저장
		if (count == MAX_LENGTH) {
		System.out.println("배열에 자리가 없습니다.");
		} else {
		System.out.println("\n --- 연락처 저장 ---");
		System.out.print("이름 입력 >>");
		String name =scanner.nextLine();
		System.out.print("전화번호 입력 >>");
		String phone =scanner.nextLine();
		System.out.print("이메일 입력 >>");
		String email =scanner.nextLine();
		Contact contact = new Contact(name, phone, email);
		contacts[count] = contact;
		count++;
		}
		
		
		
	}

	private int menuUi() {
		// 0. 종료 1. 저장 2. 목록 3. 인덱스로 검색 4. 수정
		System.out.println("\n[0]종료, [1]저장, [2]목록, [3] 인덱스로 검색, [4] 수정");
		System.out.print("숫자 입력 >>");
		return Integer.parseInt(scanner.nextLine());
		
	}
	
	

}
