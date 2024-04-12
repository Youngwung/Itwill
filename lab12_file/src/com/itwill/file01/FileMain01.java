package com.itwill.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램에서 값을 입력받거나 출력하는 "통로"
 * 		(예) System.in: (콘솔) 입력 스트림 객체.
 * 		(예) System.out: (콘솔) 출력 스트림 객체.
 * 프로그램 <=== InputStream(클래스) === 입력장치(키보드, 콘솔, 파일, ...)
 * 프로그램 === OutputStream(클래스) ===> 출력장치(모니터, 프린터, 파일, ...)
 * 
 * 프로그램 <=== FileInputStream === 파일
 * 프로그램 === FileOutputStream ===> 파일
 * 
 * java.io.InputStream: 프로그램이 데이터를 읽어들이는 통로.
 * |__ FileInputStream: 프로그램이 파일에서 데이터를 읽어들이는 통로.
 * 		(1) FileInputStream 객체 생성.
 * 		(2) FIS 객체의 read 관련 메서드를 호출.
 * 		(3) FIS 객체를 닫음(close).
 * 
 * java.io.OutputStream: 프로그램에서 데이터를 쓰는(출력하는) 통로.
 * |__ FileOutputStream: 프로그램에서 파일에 데이터를 쓰는(출력하는) 통로.
 * 		(1) FileOutputStream 객체 생성.
 * 		(2) FOS 객체의 write 관련 메서드를 호출.
 * 		(3) FOS 객체를 닫음(close). 
 */

public class FileMain01 {

	public static void main(String[] args) {
		String origin = "data/hello.txt"; // 원본 파일(읽을 파일) 경로, 이름.
		String destination = "data/hello_copy.txt"; // 복사할 파일 이름 경로, 이름.
		
		
		FileInputStream in = null; // [3] 선언을 try-문 안에서 하면 finally 문에서 닫을 수 없기 때문에 밖에서 기본값으로 초기화.
		
		//-------------------out
		FileOutputStream out = null;
		try {
			in = new FileInputStream(origin); // 객체 생성을 try문 안에서. => filenotfoundexception 발생 가능. 밖에서 객체생성 안됨.
			out = new FileOutputStream(destination);
			while (true) { 
				int read = in.read(); //read는 1byte 씩 문자를 int로 읽음(가져옴).
				if (read == -1) { // 파일 끝(EOF: End-Of-File)에 도달했을 때 멈춤.
					// 파일을 끝까지 읽으면 -1을 리턴해줌. 아스키코드에서 -1에 해당하는 문자가 없기 때문에 끝을 알려줌.
					break;
				}
//				System.out.print((char) read); // 입력한 문자열을 출력하는 방법.
				
				//----------------------out
				out.write(read); // 파일에 읽은 1바이트를 씀.
					
			}
			System.out.println("파일 복사 성공.");
			// [1] in.close(); => in.read 메서드에서 exception발생 시 객체를 닫을 수 없게됨.
			// => 해결하기 위해 반드시 실행하는 문장인 finally 에 close를 작성해야함.
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close(); // [2] in은 지역변수기 때문에 in을 사용할 수 없음.
				// [4] close는 exception 발생 가능. -try-catch문장이 필요함.
				// FIS 객체를 닫음(리소스 해제).
				
				
				//-----------------------out
				out.close(); // FOS 객체를 닫음(리소스 해제).
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}

}
