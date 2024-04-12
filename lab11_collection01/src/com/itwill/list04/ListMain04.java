package com.itwill.list04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMain04 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("java", "sql", "html", "css", "javascript",
                "servlet", "jsp", "spring");
        
        // 1. names에서 5글자 이상인 문자열을 대문자로 변환해서 저장하는 ArrayList를 만들고 출력.
        // -> [JAVASCRIPT, SERVLET, SPRING]
        ArrayList<String> upperFive = new ArrayList<>();
//        for(int i = 0; i < names.size();i++) {
//        	if (names.get(i).length() > 4) {
//        		upperFive.add(names.get(i).toUpperCase());
//        	}
//        }
        for (String x : names) {
        	if (x.length()>4) {
        		upperFive.add(x.toUpperCase());
        	}
        }
        
        System.out.println(upperFive);

        // 2. names에 저장된 문자열의 글자수들을 저장하는 ArrayList를 만들고 출력.
        // -> [4, 3, 4, 3, 10, 7, 3, 6]
        ArrayList<Integer> toLength = new ArrayList<Integer>();
//        for (int i = 0; i < names.size(); i++ ) {
//        	toLength.add(names.get(i).length());
//        }
        
        for (String x: names) {
        	toLength.add(x.length());
        }
        
        System.out.println(toLength);
        
        
        // 3. codes의 원소가 0이면 "남성", 1이면 "여성"을 저장하는 ArrayList를 만들고 출력.
        List<Integer> codes = Arrays.asList(0, 1, 0, 1, 1, 0);
        ArrayList<String> gender= new ArrayList<>();
        
//        for (int i  = 0; i < codes.size(); i++) {
//        	if (codes.get(i) == 0) {
//        		gender.add("남성");
//        	} else if (codes.get(i) == 1) {
//        		gender.add("여성");        	}
//        }
        
        for (int x : codes) {
        	if (x == 0) {
        		gender.add("남성");
        	} else if (x == 1) {
        		gender.add("여성");
        	}
        }
        
        System.out.println(gender);
        
    }

}