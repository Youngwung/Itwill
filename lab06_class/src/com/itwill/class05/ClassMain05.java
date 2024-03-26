package com.itwill.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // TODO: Subject, Student 클래스 객체 생성과 메서드 호출 결과 테스트.
    	Subject sub = new Subject(90,85,85,80);
        Student std = new Student(1601698, "김영웅",sub);
        
        std.info();
    }
    
}