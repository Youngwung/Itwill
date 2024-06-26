package com.itwill.file03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 파일 === FileInputStream ==> BufferedInputStream ==> 프로그램
 * FIS: 하드디스크에 있는 파일을 직접 접근해서 데이터를 읽고, 메모리(RAM)에 적재.
 * BIS: 메모리(RAM)에 있는 파일 내용을 읽는(read) 메서드를 제공.
 * 
 * 파일 <=== BufferedOutputStream <=== FileOutputStream<=== 프로그램
 * FOS: 하드디스크의 파일에 데이터를 씀.
 * BIS: 메모리(RAM)에 데이터를 쓰는(write)하는 메서드를 제공.
 * 
 */

public class FileMain03 {

	public static void main(String[] args){
		// BIS, BOS을 사용한 파일 읽기, 쓰기.
		String origin = "data/ratings.dat";
		String dest = "data/ratings_copy2.dat";
		FileInputStream in = null;
		BufferedInputStream bin = null;
		
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		try {
			in = new FileInputStream(origin);
			bin = new BufferedInputStream(in);
			// bin = new BufferedInputStream(new FileInputStream(origin));
			
			out = new FileOutputStream(dest);
			bout = new BufferedOutputStream(out);
			
			long start = System.currentTimeMillis(); // 복사 시작 시간
			while (true) {
				byte[] buffer = new byte[4 * 1024]; // 파일에서 읽을 내용을 저장할 배열
				int b = bin.read(buffer);
				if (b == -1) { //EOF (End-Of-File) 파일 끝.
					break;
				}
				bout.write(buffer, 0, b);
			}
			long end = System.currentTimeMillis();
			System.out.println("걸린 시간(ms): " +(end - start));
			
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			
			try {
				// 리소스 해제: (1)나중에 만들어진 스트림 객체를 먼저 close하고,
				// 먼저 만들어진 스트림 객체를 나중에 close 한다.
				// (2)Stream 객체들은 생성된 순서의 반대로(역순으로) close 메서드를 호출해야 함.
				// (3)가장 마지막에 생성된 스트림 객체만 close하면 나머지는 자동으로 close됨.
			
			  	// bin = new BufferedInputStream(in);
				bin.close(); // (3) => bin은 in을 아규먼트로 가지고 있기 때문에 bin을 닫으면 in은 자동으로 닫아줌.
				
//				in.close(); 
				
				bout.close(); // Input이 먼저인지 output이 먼저인지는 상관 없음.
//				out.close(); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
