package com.practice.순조부;

import java.util.Arrays;

public class PermutationTest2 {
	
	static int[] numbers, input;
	static int N = 3, R = 2;
	
	public static void main(String[] args) {
		input = new int[] {1,4,7};
		numbers = new int[R];
		perm(0, 0);
	}
	
	private static void perm(int cnt, int flag) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return ;
		}
		
		for(int i = 0; i < N; i++) {
			//이미 선택된 수라면 다른 수 선택하기
			if((flag & 1<<i) != 0) continue;
			numbers[cnt] = input[i];
			perm(cnt+1, flag | 1<<i);
			
		}
	}
}
