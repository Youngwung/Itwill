package com.itwill.loop04;

public class LoopMain04 {

	public static void main(String[] args) {
	       /* 369게임: 아래와 같이 출력하세요.
        1   2   *   4   5   *   7   8   *   10
        11  12  *   14  15  *   17  18  *   20
        21  22  *   24  25  *   27  28  *   *
        *   *   *   *   *   *   *   *   *   40
        41  42  *   44  45  *   47  48  *   50
        51  52  *   54  55  *   57  58  *   *
        *   *   *   *   *   *   *   *   *   70
        71  72  *   74  75  *   77  78  *   80
        81  82  *   84  85  *   87  88  *   *
        *   *   *   *   *   *   *   *   *   100
    */
		

		for (int i = 1; i <= 100; i++) {
			int x = i % 10; //n을 10으로 나눈 나머지 => 1의 자릿수
			int y = i / 10; //n을 10으로 나눈 몫 => 10의 자릿수
			boolean tsn1 = (x == 3) || (x == 6) || (x == 9); // 1의 자릿수가 3, 6, 9
			boolean tsn2 = (y == 3) || (y == 6) || (y == 9); // 10의 자릿수가 3, 6, 9
			if (tsn1 || tsn2) {	
				if (tsn1 && tsn2) {
					System.out.print("*");
				}
				
				System.out.print("*\t");
			}
			
			else {
				System.out.print(i + "\t");
			}
			if (i % 10 == 0) {
				System.out.println();
			}
		}

	}

}
