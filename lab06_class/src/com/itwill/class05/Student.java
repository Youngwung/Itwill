package com.itwill.class05;

public class Student {
	// field
	int id; // 학생 번호
	String name ; // 학생 이름
	Subject subject; // 수강 과목

	// TODO 생성자: (1)기본 생성자.
	public Student() {

	}
	// (2)아규먼트를 갖는 생성자.
	public Student(int id, String name, Subject subject) {
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	// (3) 점수를 받아주는 생성자
	public Student(int id, String name, int korean, int english, int math, int science) {
		this.id = id;
		this.name = name;
//		this.subject.english = english;		//이렇게 만들면 subject의 객체가 생성되지 않았으므로 널포인트익셉션에러가 뜸
//		this.subject.korean = korean;
//		this.subject.math = math;
//		this.subject.science = science;
		this.subject = new Subject(subject.korean,subject.english, subject.math, subject.science);
	}
	
	// TODO 메서드: 학생의 정보(번호, 이름, 각 과목의 점수, 총점, 평균)를 출력.
	public void info() {

		System.out.println("번호: " + id);
		System.out.println("이름: " + name);
		
		if (subject != null) {// Nullpointexception 해결법 중 1, 객체가 없을 때 호출하지 않게 하고, 호출하려할 때 안내문구 작성
		System.out.printf("국어: %d점, 영어: %d점, 수학: %d점, 과학: %d점\n", subject.korean, subject.english, subject.math,
				subject.science);
		System.out.println("총점: " + subject.getSum());
		System.out.println("평균: " + subject.getAver());
		} else {
			System.out.println("Subject: null");
		}
	}
}