package com.itwill.method05;

import java.util.Random;

public class MethodMain05 {

	public static void main(String[] args) {
		//TODO 메서드 호출, 그 결과를 출력:
		Random random = new Random();
		int leng = 10;
		int[] array = new int[leng];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(101);
			System.out.print(array[i]+" ");
		}
		System.out.println();
		
		int arraySum = sum(array);
		System.out.println("합계: "+arraySum);
		
		double arrayMean = mean(array);
		System.out.println("평균: "+arrayMean);
		
		int arrayMax = max(array);
		System.out.println("최댓값: "+arrayMax);
		
		int arrayMin = min(array);
		System.out.println("최솟값: "+arrayMin);
		
		
	}
	/**
	 * sum.
	 * 아규먼트로 전달받은 정수들의 1차원 배열의 모든 원소들의 합을 구하는 메서드.
	 * @param array 정수들의 배열(int[])
	 * @return 배열의 모든 원소들의 합을 리턴
	 */
	public static int sum(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result+=array[i];
		}
		return result;
	}
	
	
	
	/**
	 * mean.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들의 평균을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return array 원소들의 평균을 double 타입으로 리턴 
	 */
	
	public static double mean(int[] array) {		
		double result = (double) sum(array)/array.length;
		
		return result;
	}
	
	/**
	 * max.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최댓값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return 배열 원소들 중 최댓값.
	 */
	
	public static int max(int[] array) {
		int result = array[0];
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > result) {
				result = array[i];
			}
		}
		
		return result;
	}
	
	/**
	 * min.
	 * 아규먼트로 전달받은 정수들의 1차원 배열 원소들 중 최솟값을 리턴.
	 * @param array 정수들의 1차원 배열.
	 * @return 배열 원소들 중 최솟값.
	 */
	
	public static int min(int[] array) {
		int result = array[0];
		
		for(int i = 0; i < array.length; i++) {
			if(array[i] < result) {
				result = array[i];
			}
		}
		
		return result;
	}

}
