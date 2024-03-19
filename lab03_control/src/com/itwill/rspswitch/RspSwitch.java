package com.itwill.rspswitch;

import java.util.Random;
import java.util.Scanner;

public class RspSwitch {

    public static void main(String[] args) {
        // 가위/바위/보 (Rock-Scissors-Paper) 게임:
        // 가위 - 0, 바위 - 1, 보 - 2
        
        // TODO: Random 타입 변수를 선언, 초기화.
    	Random r = new Random();

        // TODO: Scanner 타입 변수를 선언, 초기화.
    	Scanner sc = new Scanner(System.in);
    	
        System.out.println("가위바위보 게임");
        System.out.println("---------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("---------------");
        System.out.print("선택>>> ");
        
        // TODO: 사용자가 콘솔창에서 입력한 정수를 변수(user)에 저장.
        int user = sc.nextInt();
        // TODO: 0 이상 3 미만의 정수 난수 1개를 변수(computer)에 저장.
    	int computer = r.nextInt(3);
        System.out.println("난수 = " +computer);
        
        // TODO: 가위바위보 게임 결과(User win/Computer win/Tie)를 출력.
    	switch (computer) {
    	
    	case 0:
    		System.out.println("컴퓨터는 가위를 냈습니다.");
    		switch (user) {
    		case 0:
     			System.out.println("당신은 가위를 냈습니다");
    			System.out.println("Tie");
    			break;
    		case 1:
    			System.out.println("당신은 바위를 냈습니다");
    			System.out.println("User Win");
    			break;
    		case 2:
    			System.out.println("당신은 보를 냈습니다");
    			System.out.println("Computer Win");
    	
    		}
    		break;
    	case 1:
    		System.out.println("컴퓨터는 바위를 냈습니다.");
    		switch (user) {
    		case 0:
     			System.out.println("당신은 가위를 냈습니다");
     			System.out.println("Computer Win");
    			break;
    		case 1:
    			System.out.println("당신은 바위를 냈습니다");
    			System.out.println("Tie");
    			break;
    		case 2:
    			System.out.println("당신은 보를 냈습니다");
    			System.out.println("User Win");
    			
    		}
    		break;
    	case 2:
    		System.out.println("컴퓨터는 보를 냈습니다.");
    		switch (user) {
    		case 0:
     			System.out.println("당신은 가위를 냈습니다");
     			System.out.println("User Win");
    			break;
    		case 1:
    			System.out.println("당신은 바위를 냈습니다");
    			System.out.println("Computer Win");
    			break;
    		case 2:
    			System.out.println("당신은 보를 냈습니다");
    			System.out.println("Tie");
    			
        
    		}

    	}
    }
}