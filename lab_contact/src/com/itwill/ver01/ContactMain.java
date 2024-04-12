package com.itwill.ver01;

import java.util.Scanner;

public class ContactMain {
	private static final int MAX_LENGTH = 3; // 연락처 배열의 최대 길이

	private Scanner scanner = new Scanner(System.in);
	private Contact[] contacts = new Contact[MAX_LENGTH]; // 연락처를 저장하기 위한 배열
	private int count = 0; // 현재까지 연락처 배열에 저장된 개수.
	// 배열의 새로운 연락처가 저장될 때마다 count++을 실행. 인덱스 관리를 위한 변수.

	public static void main(String[] args) {
		System.out.println("*** 연락처 프로그램 v0.1");

		ContactMain app = new ContactMain(); // static이 아닌 클래스에 있는 메서드를 가져오기 위해서는 메인 메서드 안에 클래스 객체를 선언해야한다.

		// 프로그램을 계속 실행(run = true) 또는 종료(run = false) 여부를 저장하기위한 변수
		boolean run = true;
		while (run) {
			int menu = app.showMainMenu(); // 클래스 메서드 사용법.
			switch (menu) {
			case 0:
				run = false;
				break;

			case 1:
				// TODO 새로운 연락처를 저장
				app.saveNewContact();
				break;
			case 2:
				// TODO 목록 보기
				app.readAllContacts();
				break;
			case 3:
				// TODO 인덱스검색
				app.readContactByIndex();
				break;
			case 4:
				app.updateContactByIndex();
				break;
			default:
				System.out.println("메뉴 번호를 확인하세요.[0 ~ 4]");
				break;

			}

		}

		System.out.println("*** 프로그램 종료 ***");
	}

	private void updateContactByIndex() {
		// TODO 수정 기능 메서드
		System.out.println("\n --- 연락처 수정 --- ");
		System.out.print("수정할 인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());

		if (index < 0 || index >= count) {
			System.out.println("해당 인덱스에 저장된 연락처가 없습니다.");
			return;
		}

		System.out.println("수정전: " + contacts[index].toString());

		System.out.print("이름 수정>> ");
		String name = scanner.nextLine();

		System.out.print("전화번호 수정>> ");
		String phone = scanner.nextLine();

		System.out.print("이메일 수정>> ");
		String email = scanner.nextLine();

		// 입력한 내용으로 배열의 내용을 업데이트.
		contacts[index] = new Contact(name, phone, email);
		System.out.println("연락처 수정 성공!");
		System.out.println("수정후: " + contacts[index].toString());
	}

	private void readContactByIndex() {
		System.out.println("\n --- 인덱스 검색 ---");
		System.out.print("인덱스 입력>> ");
		int index = Integer.parseInt(scanner.nextLine());
		if (index >= 0 && index < count) {
			System.out.println(contacts[index].toString());
		} else {
			System.out.println("해당 인덱스에 저장된 연락처가 없습니다.");

		}
	}

	private void readAllContacts() {
		System.out.println("\n--- 연락처 목록 ---");
		for (int i = 0; i < count; i++) {
			System.out.println(contacts[i].toString());
		}
	}

	private void saveNewContact() {
		if (MAX_LENGTH == count) {
			System.out.println("배열에 남은 자리가 없습니다.");
			return;
		}
		System.out.println("\n---새 연락처 저장---");
		System.out.print("이름 입력>> ");
		String name = scanner.nextLine();
		System.out.print("전화번호 입력>> ");
		String phone = scanner.nextLine();
		System.out.print("이메일 입력>>");
		String email = scanner.nextLine();

		Contact contact = new Contact(name, phone, email);

		// Contact 타입 객체를 연락처 배열 인덱스 count에 저장
		contacts[count] = contact;
		// 배열에 저장 후에는 연락처 저장 개수(인덱스) 증가
		count++;
		System.out.println("연락처 저장 성공!");
	}

	private int showMainMenu() {
		System.out.println("\n---------------------------------------------");
		System.out.println("[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정");
		System.out.println("---------------------------------------------");
		System.out.print("선택>>");

		int menu = Integer.parseInt(scanner.nextLine());

		return menu;
	}

}
