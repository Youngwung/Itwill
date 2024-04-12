package com.itwill.file02;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMain02 {

	public static void main(String[] args) throws Exception{
		// 대용량 파일 복사:
		// data/ratings.dat 파일을 읽고, data/ratings_copy.dat 파일에 복사
		// (1) read(), write(int b) 메서드를 사용할 때 시간 측정.(1바이트 씩 옮김)
		// (2) 다른 read/write 메서드를 사용할 때 시간 측정.
		
		String origin = "data/ratings.dat"; // 원본 파일
		String dest = "data/ratings_copy.dat"; // 복사할 파일
		
		FileInputStream in = new FileInputStream(origin);
		FileOutputStream out = new FileOutputStream(dest);
		long start = System.currentTimeMillis(); // 파일 복사 시작 시간 측정.
		while(true) {
			//(1) read() 메서드 사용
//			int b = in.read(); // 파일에서 1바이트 읽음
			
			//(2) read(byte[] b) 메서드 사용
			byte[] buffer = new byte[4 * 1024]; // 4,096바이트(4KB) 크기의 빈 배열 생성
			int b = in.read(buffer);
			// -> buffer: 파일에서 읽은 내용을 저장하기 위한 바이트 배열.
			// -> 리턴 값: 파일에서 실제로 읽은 바이트 수. (4096바이트 씩 읽다보면 마지막 부분은 4096이하임.) 
			// buffer의 내용은 루프가 실행될 때마다 바뀜.
			
			if (b == -1) { // EOF 파일 끝에 도달함.
				// 종료 조건은 byte[]을 받는 메서드도 동일함.
				break; // 무한 루프 종료
			} 
			//(1) write(int b) 메서드 사용.
//			out.write(b); // 파일에 1바이트를 씀
			//(2) write(byte[] b) 메서드 사용: 
//			out.write(buffer); // -> 바이트 배열의 내용을 그대로 파일에 씀. 4KB를 파일에 씀. => 원본 파일보다 무조건 크거나 같음.
			// 예제 파일은 약 2KB차이가 남. 2KB는 데이터가없이 용량만차지함.
			
			//(3) write(byte[] buffer, in off, int len) 메서드 사용:
			out.write(buffer, 0, b);
			//-> byte[] buffer: 파일에 쓸 데이터를 가지고 있는 바이트 배열.
			//-> int off: 배열 b에서 읽기 시작할 인덱스. offset.
			//-> int len: length. 배열에서 실제로 파일에 쓸 바이트 길이.
			
		}
		long end = System.currentTimeMillis(); // 파일 복사 종료 시간 측정.
		System.out.println("걸린 시간(ms): "+(end - start)); // (종료시간 - 시작시간)으로 걸린 시간 계산 후 출력.
		in.close(); // FIS 리소스 해제(닫기)
		out.close(); // FOS 리소스 해제(닫기)

	}

}
