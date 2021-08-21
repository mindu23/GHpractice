package com.practice.순조부;

import java.util.Arrays;

public class NextPermutationTest {

	public static void main(String[] args) {

		int[] input = {7,1,4};
		
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		}while(np(input));
	}

	//다음 큰 순열이 있으면 true, 없으면 false
	private static boolean np(int[] numbers) {
		int N = numbers.length;
		//1.꼭대기 찾기
		int i = N-1;
		while(i > 0 && numbers[i-1] >= numbers[i]) --i;
		
		if(i == 0) return false;
		
		//j 찾고 i-1와 swap
		int j = N-1;
		while(i > 0 && numbers[i-1] >= numbers[j]) --j;
		
		swap(numbers, i-1, j);
		
		//꼭대기부터 맨뒤까지 내림차순
		int k = N-1;
		while(i < k) {
			swap(numbers, i++, k--);
		}
		
		return true;
	}

	
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
