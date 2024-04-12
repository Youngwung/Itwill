package com.itwill.inheritance01;

public class InheritanceMain01 {

	public static void main(String[] args) {
		//BasicTv 타입의 객체 생성
		BasicTv tv1 = new BasicTv();
		System.out.println("--------power--------");
		tv1.powerOnOff();
		tv1.powerOnOff();
		tv1.powerOnOff();
		
		
		System.out.println("------channelup------");
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
		tv1.channelUp();
		
		System.out.println("------channeldown----");
		tv1.channelDown();
		tv1.channelDown();
		tv1.channelDown();
		tv1.channelDown();
		tv1.channelDown();
		
		
		
		System.out.println("-------volumeup------");
		tv1.volumeUp();
		tv1.volumeUp();
		tv1.volumeUp();
		tv1.volumeUp();

		System.out.println("-----volumedown------");
		tv1.volumeDown();
		tv1.volumeDown();
		tv1.volumeDown();
		tv1.volumeDown();
		System.out.println("---------------------");
		tv1.powerOnOff();
		System.out.println("---Basic Tv end------");
		
		//SmartTv 타입 객체 생성
		SmartTv tv2 = new SmartTv();
		tv2.powerOnOff(); //상위 클래스에서 상속받은 메서드를 호출.
		tv2.webBrowsing();
		
	}

}
