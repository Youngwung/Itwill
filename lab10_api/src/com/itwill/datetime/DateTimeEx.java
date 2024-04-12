package com.itwill.datetime;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeEx {

	public static void main(String[] args) {
		// Java 8 버전부터 새로 생긴 java.time 패키지의 날짜/시간 클래스
		
		LocalDate today = LocalDate.now(); // 현재 윈도우의 시스템 시간을 리턴
		System.out.println(today);			// 2024-04-05
		System.out.println(today.getYear()); // 현재 시스템 시간의 연도를 리턴
		System.out.println(today.getMonth()); // 현재 시스템 시간이 몇 월인지를 ENUM타입으로 리턴 ex.APRIL
		System.out.println(today.getMonthValue()); // 현재 시스템 시간이 몇 월인지를 숫자로 리턴
		System.out.println(today.getDayOfMonth()); // 이번 달이 며칠인 지를 리턴
		System.out.println(today.getDayOfWeek()); // 무슨 요일인 지 ENUM타입으로 리턴 ex.FRIDAY
		System.out.println(today.plusDays(1)); // 현재 시스템 시간 기준으로 1일 후의 시간을 리턴 2024-04-06
		System.out.println(today.minusWeeks(1)); // 현재 시스템 시간 기준으로 7일 전의 시간을 리턴 2024-03-29

		LocalDate birthday = LocalDate.of(2000, 12, 31); // 입력한 날짜를 리턴
		System.out.println(birthday); 					// 2000-12-31
		System.out.println(LocalDate.of(1997, Month.JULY, 28)); // ENUM형태로도 입력이 가능.
		LocalDateTime now = LocalDateTime.now(); // 현재 시간을 연월일시분초 형태로 리턴, 초를 소수점단위도 알려줌.
		System.out.println(now); 				// 2024-04-05T18:09:59.224787100 
		
		LocalDateTime time = LocalDateTime.of(2024,03,14,9,30); // 입력한 시간을 리턴
		System.out.println(time);								// 2024-03-14T09:30
		// Timestamp: 1970-01-01 00:00:00를 기준으로 해서 1/1000초 (milli-second)마다
		// 1씩 증가하는 정수(long 타입)를 기반으로 날짜와 시간 정보를 저장하는 클래스(타입)
		Timestamp ts = Timestamp.valueOf(now);  // LocalDate와 다르게 윈도우 시간이 아닌, 실제 시간을 리턴.
		System.out.println(ts); 				//2024-04-05 18:15:00.6725419
		System.out.println(ts.getTime());		// 기준시간으로부터 지난 시간을 ms단위로 리턴, 1712308500672
		// Timestamp --> LocalDateTime 변환
		LocalDateTime dt = ts.toLocalDateTime(); // LocalDateTime타입으로 변환하는 메서드
		System.out.println(dt);					 // 2024-04-05T18:15:00.672541900
	}

}
