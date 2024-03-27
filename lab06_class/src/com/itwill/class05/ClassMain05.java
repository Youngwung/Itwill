package com.itwill.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // TODO: Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
    	Subject sub1 = new Subject();
    	Student std1 = new Student();
    	
    	Subject sub2 = new Subject(90,85,85,80);
        Student std2 = new Student(1601698, "김영웅",sub2);
        std1.info();
        std2.info();
    }
    
}