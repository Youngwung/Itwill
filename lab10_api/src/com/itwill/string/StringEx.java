package com.itwill.string;

public class StringEx {
	
	public static void main(String[] args) {
		// jave.lang.String 클래스의 메서드 사용법
		
		// ex1. 주민번호에서 성별을 표시하는 위치의 문자열 찾기
		String ssn = "970728-2345678";
		System.out.println(ssn.charAt(7));
		if (ssn.charAt(7) == '1' || ssn.charAt(7) == '3') { // 작은 따옴표 ' 로 감싸면 String타입을 char타입으로 바꿀 수 있다.
			System.out.println("남성");
		} else if (ssn.charAt(7) == '2' || ssn.charAt(7) == '4') {
			System.out.println("여성");
		} else {
			System.out.println("???");
		}
		
		// ex2. 문자열 자르기
		String date = "2024-04-05";
		String[] array = date.split("-");
		System.out.println(array[0]); // 2024 출력
		System.out.println(array[1]); // 04 출력
		System.out.println(array[2]); // 05 출력
		
        // ex3. 아래의 문자열 배열에서 5글자 이상인 문자열들만 출력.
        // 결과: JavaScript Servlet Spring
        String[] languages = {"Java", "SQL", "JavaScript", "HTML", "CSS", "Servlet", "Spring"};
        // TODO        
        for (int i = 0; i < languages.length; i++) {
        	if (languages[i].length() >= 5) {
        		System.out.println(languages[i]);
        	}
        }
        
        // ex4. 아래의 문자열 배열에서 "홍길동" 문자열이 처음 등장하는 인덱스를 출력.
        // 만약에 "홍길동"이 배열에 없는 경우에는 -1을 출력.
        // 결과: 2
        String[] names = {"오쌤", "John", "홍길동", "Gildong", "홍길동"};
        // TODO
        for (int i = 0; i < names.length; i++) {
        	if (names[i].equals("홍길동")) {
        		System.out.println(i);
        		break;
        	}else if (i == names.length-1) {
        		System.out.println("-1");
        	}
        		
        	
        	 
        }
        
        // ex5. 아래의 문자열 배열에서 대소문자 구별없이 "est"를 포함하는 문자열들을 출력.
        // 결과: TEST test TeSt tEsT
        String[] tests = {"TEST", "test", "TeSt", "tEsT", "테스트"};
        // TODO
        for (int i = 0; i < tests.length; i++) {
        	if (tests[i].toUpperCase().contains("EST")) { //tests배열의 원소를 대문자로 변환 후 EST를 포함하면 true를 리턴.
        		System.out.print(tests[i]+" ");
        	}
        }
        System.out.println();
        
        // ex6. 아래의 "YYYY-MM-DD" 형식의 문자열에서 년/월/일 정보를 "int" 타입 변수에 저장하고 출력.
        // 결과: year=2023, month=10, day=4
        String today = "2024-04-05";
        // TODO
		String[] array1 = today.split("-"); // -를 기준으로 배열을 생성, array1 = {2024, 04, 05} 
		int[] dateArray = new int[array1.length];
		for (int i = 0; i < array1.length; i++) {
			dateArray[i] = Integer.parseInt(array1[i]);
		}
		System.out.printf("year=%d, month=%d, day=%d\n", dateArray[0], dateArray[1], dateArray[2]);
		
	}

}
