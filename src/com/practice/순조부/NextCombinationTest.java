package com.practice.순조부;

import java.util.Arrays;

public class NextCombinationTest {

	public static void main(String[] args) {

		int[] input = {7,1,4,2,3};
		int N = input.length;
		int R = 3;
		
		int[] p = new int[N]; //뽑혔나 아니냐
		
		//뒤쪽부터 R개만큼 1채우기
		int cnt = 0;
		while(++cnt <= R) p[N-cnt] = 1;
		
		do {
			for(int i = 0; i < N; i++) {
				if(p[i] == 1) System.out.print(input[i]+" ");
			}
			System.out.println();
		}while(np(p));
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
