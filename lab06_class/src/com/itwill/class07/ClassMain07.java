package com.itwill.class07;

public class ClassMain07 {

	public static void main(String[] args) {
		ThisTest th1 = new ThisTest();
		th1.info();
		
		ThisTest th2 = new ThisTest(1);	
		th2.info();
		
		ThisTest th3 = new ThisTest(1,1);
		th3.info();
		
		ThisTest th4 = new ThisTest(1,1,1);
		th4.info();

	}

}
