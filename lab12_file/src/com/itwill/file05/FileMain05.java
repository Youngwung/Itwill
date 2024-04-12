package com.itwill.file05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.itwill.file04.Product;

public class FileMain05 {

	public static void main(String[] args){
		// 파일에 쓸(write) 더미 데이터
		ArrayList<Product> list = new ArrayList<>();
		for (int i = 0; i < 1_000_000; i++) {
			list.add(new Product(i, "name_"+i, i));
		}
		System.out.println("size = " + list.size());
		
		// ArrayList를 저장하는 파일 이름
		String fileName = "data/product_list.dat";
		long start = System.currentTimeMillis();
		// 1. Product 타입 객체 1,000,000개를 저장하는 ArryList를 파일에 쓰기
		// FOS, BOS, OOS을 이용.
		try (
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				ObjectOutputStream oout = new ObjectOutputStream(bout);
		) {
			oout.writeObject(list);
			System.out.println("파일 저장 성공.");
		} catch (Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("[쓰기] 걸린 시간: " + (end-start) + "[ms]");
		// 2. 파일에서 객체를 읽어서 ArryList<Product>로 변환하기.
		// FIS, BIS, OIS
		ArrayList<Product> readList = new ArrayList<Product>();
		long start2 = System.currentTimeMillis();
		try (
				FileInputStream in = new FileInputStream(fileName);
				BufferedInputStream bin = new BufferedInputStream(in);
				ObjectInputStream oin = new ObjectInputStream(bin);
		) {
				
			readList = (ArrayList<Product>) oin.readObject();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		long end2 = System.currentTimeMillis();
		System.out.println("[읽기] 걸린 시간: " + (end2-start2) + "[ms]");
		System.out.println(readList.get(100));
		System.out.println(readList.get(1000));
		System.out.println(readList.get(5000));
		System.out.println(	readList.get(999999));

		
	}

}
