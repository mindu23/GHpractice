package com.practice.순조부;

import java.util.Arrays;

public class CombinationTest {
	static int N = 3, R = 2;
	static int[] input, numbers;
	
	public static void main(String[] args) {
		input = new int[] {1,4,7};
		numbers = new int[R];
		
		comb(0,0);
		
	}
	private static void comb(int cnt, int start) {
		
		//R개를 다 뽑았다면 돌아가지
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return ;
		}
		
		//순서가 없는 조합으로 겹치지 않게 start위치부터 고려하기
		for(int i = start; i < N; i++) {
			numbers[cnt] = input[i];
			comb(cnt+1, i+1);
		}
	}
}
