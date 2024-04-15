package com.itwill.thread02;

/*
 * 자바는 다중상속을 허용하지 않음: class A extends B, C {} -> 문법오류 
 * 	-사용법1에서 이미 다른 클래스를 상속하고 있으면 
 * 	-Thread를 상속할 수 없기 때문에 다른 사용법이 필요하다.
 * 
 * 다른 클래스를 이미 상속하는 클래스는 Thread 클래스를 상속할 수 없음.
 * 자바는 인터페이스 구현 개수는 제한이 없음: class A extends B implements C, D, E {}
 * 
 * 쓰레드 사용법 2:
 * (1) Runnalbe 인터페이스를 구현하는 클래스를 선언. => 1방법과의 차이점.
 * (2) (1)에서 선언한 클래스에서 run 메서드를 재정의(override) -> 쓰레드가 할일
 * (3) Tread 객체 생성 -> Thread 생성자 아규먼트로 (2)에서 작성한 클래스의 객체를 넘김.
 * (4) (3)에서 생성된 쓰레드 객체의 start() 메서드를 호출 -> 쓰레드 실행.
 */

public class ThreadMain02 {

	public static void main(String[] args) {
		// (1) Runnable 구현 클래스
		class MyRunnable implements Runnable{
			private String name;
			public MyRunnable (String name) {
				this.name = name;
			}

			// (2) Runnable 인터페이스의 run 메서드 구현
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i + " - " + name);
					try {
						Thread.sleep(10); // Thread를 상속받지 않기 때문에 static 메서드 호출로 불러준다.(sleep은 static메서드)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			
		}
		// (3) Thread 객체 생성 - Runnable 인터페이스 구현 객체를 아규먼트로 전달.
		Thread th1 = new Thread(new MyRunnable("지역 클래스"));
		
		//  익명 클래스 객체를 사용한 쓰레드 생성
		Thread th2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					System.out.println(i + " - 익명(Anoonymous) 클래스");
					try {
						Thread.sleep(10); // Thread를 상속받지 않기 때문에 static 메서드 호출로 불러준다.(sleep은 static메서드)
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		});
		
		// 람다 표현식을 사용한 쓰레드 객체 생성
		
		Thread th3 = new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i +" - 람다 표현식 ");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
			
		
		// (4) Thread 실행
		long start = System.currentTimeMillis();
		th1.start();
		th2.start();
		th3.start();
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간: "+ (end - start) + "[ms]");
		System.out.println("**** main 프로세스 종료 ****");
	}



}
