package com.itwill.lambda04;

import java.util.Arrays;
import java.util.List;

public class LambdaMain04 {

	public static void main(String[] args) {
		// 사원(Employee)들의 리스트
		List<Employee> employees = Arrays.asList(new Employee(101, "김지현", "개발1팀", "과장", 700),
				new Employee(102, "이동준", "개발2팀", "부장", 800), new Employee(103, "이승행", "개발1팀", "대리", 500),
				new Employee(104, "정윤정", "개발2팀", "부장", 1000), new Employee(105, "김동환", "인사팀", "회장", 30_000),
				new Employee(106, "노형진", "인사팀", "차장", 900), new Employee(107, "오쌤", "총무", "대리", 300));

		// Ex1. 모든 직원들의 정보를 한 줄에 한 명씩 출력
		System.out.println("--- Ex1. ---");
//		for (Employee x : employees) {
//			System.out.println(x);
//		}
		employees.forEach(System.out::println);
		// Ex2. 개발(1, 2)팀에서 일하는 직원들의 급여 합계
		System.out.println("--- Ex2. ---");
		double sum = 0;
		int count = 0; // "개발"이 포함된 직원 수.

		for (Employee x : employees) {
			if (x.getDept().contains("개발")) {
				sum += x.getSalary();
				count++;
			}
		}
		System.out.println("개발팀의 급여 합계: " + sum);

		// 람다 표현식으로 코딩하기.
		sum = employees.stream().filter(x -> x.getDept().contains("개발"))
//				.mapToDouble((x) -> x.getSalary()) // 객체타입을 더블스트림타입으로 바꿔서 리턴해줌. sum()메서드를 사용하기 위함.
				.mapToDouble(Employee::getSalary) // 메서드 참조 람다표현식
				.sum(); // 필터와 맵을 통과한 원소들을 합침.
		System.out.println("개발팀의 급여 합계: " + sum);
		// Ex3. 개발팀에서 일하는 직원들의 급여 평균
		System.out.println("--- Ex3. ---");
		System.out.println("개발팀의 급여 평균: " + sum / count);

		double average = employees.stream() // 람다 표현식으로 코딩하기.
				.filter(x -> x.getDept().contains("개발")).mapToDouble((x) -> x.getSalary()).average()
				// optionalDolble타입=> 평균을 구할 때 0으로 나눠야할 경우가 생기기 때문에 sum()과 다름.
				.orElseThrow(); // 평균을 계산할 수 있으면 double 값을 리턴, 그렇지 않으면 예외를 발생.
		
		System.out.println("개발팀의 급여 평균: " + average);
		
		
		// Ex4. 직급이 부장인 직원들의 급여 합계
		System.out.println("--- Ex4. ---");
		sum = 0;
		count = 0;
		for (Employee x : employees) {
			if (x.getJopTitle().equals("부장")) {
				sum += x.getSalary();
				count++;
			}
		}
		System.out.println("부장의 급여 합계: " + sum);

		// ----------람다 표현식
		sum = employees.stream().filter(x -> x.getJopTitle().contains("부장")).mapToDouble(x -> x.getSalary()).sum();
		System.out.println("부장의 급여 합계: " + sum);

		// Ex5. 직급이 부장인 직원들의 급여 평균
		System.out.println("--- Ex5. ---");

		System.out.println("부장의 급여 평균: " + sum / count);

		// 람다 표현식

		average = employees.stream().filter((x) -> x.getJopTitle().contains("부장")).mapToDouble((x) -> x.getSalary())
				.average().orElseThrow();
		System.out.println("부장의 급여 평균: " + average);
		// Ex6. 급여가 1,000 이상인 직원들의 정보를 한 줄에 한 명씩 출력
		System.out.println("--- Ex6. ---");
		employees.stream().filter(t -> t.getSalary() >= 1000).forEach(x -> System.out.println(x));

		// Ex7. 개발1팀 직원들의 급여를 10% 인상하고, 인상된 급여의 평균.
		System.out.println("--- Ex7. ---");
		sum = 0;
		count = 0;
		for (Employee x : employees) {
			if (x.getDept().equals("개발1팀")) {
				count++;
				sum += x.getSalary() * 1.1;
			}
		}
		System.out.println("개발1팀 인상된 급여의 합: " + sum);
		average = sum / count;
		System.out.println("개발1팀 인상된 급여의 평균: " + average);
		
		// 람다 표현식
		sum = employees.stream().filter((x) -> x.getDept().contains("개발1팀")).mapToDouble((x) -> x.getSalary() * 1.1)
				.sum();
		System.out.println("개발1팀 인상된 급여의 합: " + sum);
		average = employees.stream().filter((x) -> x.getDept().contains("개발1팀")).mapToDouble((x) -> x.getSalary() * 1.1)
				.average().orElseThrow();
		System.out.println("개발1팀 인상된 급여의 평균: " + average);
		
		// Ex8. 직원들 중 대리는 몇 명?
		System.out.println("--- Ex8. ---");
		count = 0;
		
		for (Employee x: employees) {
			if (x.getJopTitle().equals("대리")) {
				count++;
			}
		}
		System.out.println("count: "+count);
		
		
		long count2 = employees
				.stream().filter((x) -> x.getJopTitle()
				.contains("대리"))
				.count();
		System.out.println("count: "+count2);
		
	}

}
