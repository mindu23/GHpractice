package com.practice;

import java.util.Arrays;

public class DiceTest {

	static boolean[] isSelected;
	static int[] dice, numbers;
	static int N = 6, R = 3;
	public static void main(String[] args) {
		
		dice = new int[] {1,2,3,4,5,6};
		isSelected = new boolean[N];
		numbers = new int[R];
//		dice1(0);
//		dice2(0);
//		dice3(0,0);
		dice4(0,0);
	}
	
	//조합
	private static void dice4(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return ;
		}
		for(int i = start; i < N; i++) {
			numbers[cnt] = dice[i];
			dice4(cnt+1, i+1);
		}
	}
	
	//중복조합
	private static void dice3(int cnt, int start) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return ;
		}
		for(int i = start; i < N; i++) {
			numbers[cnt] = dice[i];
			dice3(cnt+1, i);
		}
	}
	
	//순열
	private static void dice2(int cnt) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return ;
		}
		
		for(int i = 1; i < N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = dice[i];
			isSelected[i] = true;
			dice2(cnt+1);
			isSelected[i] = false;
		}
	}

	//중복 순열
	private static void dice1(int cnt) {
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return ;
		}
		for(int i = 0; i < N; i++) {
			numbers[cnt] = dice[i];
			dice1(cnt+1);
		}
	}
}
