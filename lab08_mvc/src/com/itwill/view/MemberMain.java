package com.itwill.view;

import java.util.Scanner;

import com.itwill.controller.MemberDao;
import com.itwill.controller.MemberDaoImpl;
import com.itwill.model.Member;

// MVC 아키텍쳐에서 뷰(UI: User Interface) 역할을 담당하는 클래스.
public class MemberMain {

	private final Scanner sc = new Scanner(System.in);
	private MemberDao dao = MemberDaoImpl.getInstance(); // 컨트롤러(controller)

	public static void main(String[] args) {
		System.out.println("*** 회원 관리 프로그램 ***");
		
		// MemberMain 타입 객체의 인스턴스 멤버(필드, 메서드)를 사용하기 위해서.
		MemberMain app = new MemberMain();
		boolean run = true; // 프로그램을 종료할 때 false로 변경.
		while (run) {
			int menu = app.selectMainMenu();
			switch (menu) {
			case 0:
				run = false;
				break;
			case 1:
				app.saveNewMember();
				break;
			case 2:
				app.readAllMembers();
				break;
			case 3:
				app.readMemberByIndex();
				break;
			case 4:
				app.updateMember();
				break;
			default:
				System.out.println("0~4 범위의 정수로 입력해주세요...");
			}
		}
		System.out.println();

		System.out.println(">>>> 프로그램 종료 >>>>");
	}

	private void updateMember() {
		System.out.println("");
		System.out.println("\n--- 수정 ---");
		System.out.print("수정할 인덱스 입력>>> ");
		int index = Integer.parseInt(sc.nextLine());

		Member member = dao.read(index);
		if (member != null) {
			System.out.println("수정 전: " + member);

			System.out.print("새 비밀번호 입력>>> ");
			String password = sc.nextLine();

			// View에서 Controller의 기능을 사용해서 비밀번호를 업데이트
			int result = dao.update(index, password);
			if (result == 1) {
				System.out.println("비밀번호 업데이트 성공");
			} else {
				System.out.println("비밀번호 업데이트 성공");
			}
		} else {
			System.out.println("해당 인덱스에는 회원 정보 없습니다.");
		}

	}

	private void readMemberByIndex() {
		System.out.println("");
		System.out.println("\n--- 인덱스 검색 ---");
		System.out.print("검색할 인덱스 입력>> ");
		int index = Integer.parseInt(sc.nextLine());

		// View에서 Controller의 기능을 사용해서 해당 인덱스의 회원 정보를 가져옴.
		Member member = dao.read(index);
		if (member != null) {
			System.out.println(member);
		} else {
			System.out.println("해당 인덱스에는 회원 정보 없습니다.");
		}

	}

	private void readAllMembers() {
		System.out.println();
		System.out.println("──────────────회원목록─────────────");
		Member[] members = dao.read();
		int index = 0;
		for (Member m : members) {
			System.out.println("["+index+"] "+m);
			index++;
		}
	}

	private void saveNewMember() {
		MemberDaoImpl dao1 = (MemberDaoImpl) dao;
		if (MemberDao.MAX_LENGTH != dao1.getCount()) {
			System.out.println();
			System.out.println("──────────────새 회원 정보 저장───────────────");
			System.out.print("아이디 입력>>> ");
			String id = sc.nextLine();
			System.out.print("비밀번호 입력>>> ");
			String password = sc.nextLine();
			Member member = new Member(id, password);
			int result = dao.create(member); // View 객체에서 Controller 객체의 기능을 사용.
			if (result == 1) {
				System.out.println("회원 정보 저장 성공");
			} else {
				System.out.println("회원 정보 저장 실패...");
			}
		} else {
			System.out.println("회원 정보 저장 실패...");
		}

	}

	private int selectMainMenu() {
		System.out.println("┌─────────────────────────────────────────────┐");
		System.out.println("│[0]종료 [1]저장 [2]목록 [3]인덱스검색 [4]수정│");
		System.out.println("└─────────────────────────────────────────────┘");
		System.out.print("선택>>> ");
		return Integer.parseInt(sc.nextLine());
	}

}
