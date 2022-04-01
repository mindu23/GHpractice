package com.Solutions.백트래킹;

import java.util.Scanner;

/*
	길이가 M인 수열
	1부터 N까지의 자연수 중 중복없이 M개를 고른 수열
 */
public class Main_15649_N과M {

	static int N, M;
	static boolean[] sel;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M+1];
		sel = new boolean[N+1];
		
		perm(1);
		sc.close();
	}
	
	private static void perm(int cnt) {
		if(cnt > M) {
			for(int i = 1; i <= M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return ;
		}
		
		for(int i = 1; i <= N; i++) {
			if(sel[i]) continue;
			sel[i] = true;
			numbers[cnt] = i;
			perm(cnt+1);
			sel[i] = false;
		}
	}

}
