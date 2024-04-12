package com.itwill.prac_contact03;

import java.util.Scanner;



public class PracClassMain03 {
	
	Scanner sc = new Scanner(System.in);
	static final int MAX_LENGTH = 3;
	Contact[] contacts = new Contact[MAX_LENGTH];
	private int count = 0;

	public static void main(String[] args) {
		PracClassMain03 app = new PracClassMain03();
		boolean run = true;
		
		while (run) {
			int menu = app.selectMenu();
			switch (menu) {
			case 0:
				System.out.println("\n프로그램을 종료합니다.");
				run = false;
				break;
			case 1:
				app.saveContact();
				break;
			case 2:
				app.readListAll();
				break;
			case 3:
				app.readContactByIndex();
				break;
			case 4:
				app.updateContactByIndex();
				break;
			default:
				System.out.println("0~4까지의 숫자를 입력해주세요.");
				break;
			}
			
			
		}
	}

	public  void updateContactByIndex() { //인덱스로 수정
		System.out.print("수정할 인덱스 입력 >>");
		int index = Integer.parseInt(sc.nextLine());
		System.out.println("수정 전:"+contacts[index].toString());
		System.out.print("이름 입력 >>");
		String name = sc.nextLine();
		System.out.print("전화번호 입력 >>");
		String phone =sc.nextLine();
		System.out.print("이메일 입력 >>");
		String email = sc.nextLine();
		contacts[index] = new Contact(name, phone, email);
		System.out.println("수정 후:"+contacts[index].toString());
	}

	public  void readContactByIndex() { //인덱스로 검색
		System.out.print("검색할 인덱스 입력 >>");
		int index = Integer.parseInt(sc.nextLine());
		System.out.println(contacts[index].toString());
	}

	public  void readListAll() { //목록
		for (int i = 0; i < count; i++) {
			 System.out.println(contacts[i].toString());
		}
		
	}

	public void saveContact() { //저장
		System.out.print("이름 입력 >>");
		String name = sc.nextLine();
		System.out.print("전화번호 입력 >>");
		String phone =sc.nextLine();
		System.out.print("이메일 입력 >>");
		String email = sc.nextLine();
		Contact contact = new Contact(name, phone, email);
		contacts[count] = contact;
		count++;
		System.out.println("------저장 완료!------");
	}

	public int selectMenu() {
		System.out.println("\n *** 연락처프로그램 v0.1");
		System.out.println("\n[0] 종료 [1] 저장 [2] 목록 [3] 인덱스로 검색 [4] 인덱스로 수정");
		return Integer.parseInt(sc.nextLine());
	}

}
