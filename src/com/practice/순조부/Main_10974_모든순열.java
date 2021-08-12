package com.practice.순조부;

import java.util.Scanner;

public class Main_10974_모든순열 {

	static int[] numbers;
	static boolean[] isSelected;
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		isSelected = new boolean[N+1];
		numbers = new int[N];
		
		permutation(0);
	}
	
	private static void permutation(int cnt) {
		
		if(cnt == N) {
			for(int i = 0; i < N; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return ;
		}
		
		for(int i = 1; i <= N; i++) {
			if(isSelected[i] == true) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	

}
