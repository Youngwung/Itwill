package com.itwill.thread01;

/*
 * 쓰레드 사용법 1:
 * (1) Thread 상속하는 클래스 선언
 * (2) (1)에서 선언한 클래스에서 run 메서드를 재정의(override) -> 쓰레드가 할 일.
 * (3) (2)에서 작성한 클래스의 객체를 생성.
 * (4) (3)에서 생성된 객체의 start() 메서드를 호출. -> 쓰레드가 실행됨. (run을 재정의했는데 start로 실행하네?)
 * (주의) 쓰레드 객체의 run 메서드를 직접 호출하면 안됨.
 * 이유: start() 호출 -> JRE에서 쓰레드를 초기화(메모리 할당, 스케쥴링, ...) 
 * -------------------->run() 메서드가 호출됨. 
 */

public class ThreadMain01 {

	public static void main(String[] args) {
		//(1) Tread를 상속하는 클래스를 선언
		class MyTread extends Thread {
			private String name;
			
			public MyTread(String name) {
				this.name = name;
			}
			
			// (2) run override
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i + " : " + name);
					
					try {
						sleep(100); // Thread 클래스의 static 메서드를 호출
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
				}
			}
			
		} // end of MyTread Class
		
		// (3) MyThread 객체 생성
		MyTread th1 = new MyTread("쓰레드");
		MyTread th2 = new MyTread("Hello");
		MyTread th3 = new MyTread("안녕하세요");
		
		// (4) MyThread 객체의 start() 메서드 호출
		long start = System.currentTimeMillis();
		th1.start();
		th2.start();
		th3.start();
		
		// main 프로세스가 실행시킨 다른 프로세스(쓰레드)들이 모두 종료될 때 까지 기다림.
		try {
			th1.join(); // th1 쓰레드가 코드를 모두 실행될 때까지 메인 메서드의 진행을 멈춤.
			th2.join(); // th2 쓰레드가 코드를 모두 실행될 때까지 메인 메서드의 진행을 멈춤.
			th3.join(); // th3 쓰레드가 코드를 모두 실행될 때까지 메인 메서드의 진행을 멈춤.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간: " + (end - start)+"[ms]");
		
		System.out.println("***** main 메서드 종료 *****"); 
		// 이 문장이 실행되고 나서 쓰레드를 실행함.
		// 쓰레드는 메인이 종료된 후 실행된다.
		
	}

}
