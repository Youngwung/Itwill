package com.itwill.rspif;

import java.util.Random;

import java.util.Scanner;

public class RspIf {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
				
        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
		
		int computer = r.nextInt(3);
		int user = sc.nextInt();
        
		System.out.println("난수: " +computer);
		System.out.println("");
		switch (computer) {
		case 0:
			System.out.println("컴퓨터는 가위를 냈습니다.");
			break;
		case 1:
			System.out.println("컴퓨터는 바위를 냈습니다.");
			break;
		case 2:
			System.out.println("컴퓨터는 보를 냈습니다.");
		}
		
		switch (user) {
		case 0:
			System.out.println("유저는 가위를 냈습니다.");
			break;
		case 1:
			System.out.println("유저는 바위를 냈습니다.");
			break;
		case 2:
			System.out.println("유저는 보를 냈습니다.");
			break;
		default :
			System.out.println("잘못된 입력입니다.");
		}
		
		System.out.println("");
		
		boolean comWin = (computer == 0 && user == 2) || (computer == 1 && user == 0 ) || (computer == 2 && user == 1);
		boolean tie = (computer == 0 && user == 0) || (computer == 1 && user == 1 ) || (computer == 2 && user == 2);
		//tie = computer = user로 간소화 가능
		
		boolean userWin =  (computer == 2 && user == 0) || (computer == 0 && user == 1 ) || (computer == 1 && user == 2);
				
		if (comWin) {
			System.out.println("컴퓨터가 승리했습니다.");
		} else if(tie) {
			System.out.println("무승부입니다.");
		} else if(userWin) {
			System.out.println("유저가 승리했습니다.");
		} else {
			System.out.println("승부가 무효처리 되었습니다.");
		}
		
		

	}

}
