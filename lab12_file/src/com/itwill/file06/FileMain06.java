package com.itwill.file06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;


public class FileMain06 {

	public static void main(String[] args){
		// TODO Student 1,000,000개를 저장하는 더미 데이터(ArrayList)를 만듦.
		ArrayList<Student> students = new ArrayList<Student>();
		
		Random r = new Random();
		
		for (int i = 0; i < 1_000_000; i++) {
//			students.add(new Student(i,"name_"+i, new Score(r.nextInt(101), r.nextInt(101), r.nextInt(101))));// 한 줄에 쓰기
			Score score = new Score(r.nextInt(101), r.nextInt(101), r.nextInt(101));
			students.add(new Student(i,"name_"+i,score));// 나눠쓰기
		}
		
		// 더미 데이터를 파일에 씀. 파일에 쓰는 데 걸린 시간 측정.
		final String fileName = "data/student_list.dat";
		try (
				FileOutputStream out = new FileOutputStream(fileName);
				BufferedOutputStream bout = new BufferedOutputStream(out);
				ObjectOutputStream oout = new ObjectOutputStream(bout);
		){
			System.out.println("쓰기 중....");
			long start = System.currentTimeMillis();
			oout.writeObject(students);
			long end = System.currentTimeMillis();
			System.out.println(students.getFirst());
			System.out.println(students.getLast());
			System.out.println("쓰기 걸린 시간: "+(end-start)+"[ms]\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 파일에서 데이터를 읽음. 읽는 데 걸린 시간 측정.
		try (
			FileInputStream in = new FileInputStream(fileName);
			BufferedInputStream bin = new BufferedInputStream(in);
			ObjectInputStream oin = new ObjectInputStream(bin);
		) {
			System.out.println("읽기 중...");
			long start = System.currentTimeMillis();
			ArrayList<Student> readStudent = (ArrayList<Student>) oin.readObject();
			long end = System.currentTimeMillis();
			System.out.println(readStudent.getFirst());
			System.out.println(readStudent.getLast());
			System.out.println("읽기 걸린 시간: "+(end-start)+"[ms]");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
