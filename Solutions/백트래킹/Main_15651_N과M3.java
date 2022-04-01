package com.Solutions.백트래킹;

import java.util.Scanner;

/*
	1부터 N까지 자연수 중에서 M개를 고른 수열
	중복 가능
 */
public class Main_15651_N과M3 {

	static int N, M;
	static int[] numbers;
	static boolean[] sel;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M+1];
		perm(1);
		System.out.println(sb);
		sc.close();
	}
	
	private static void perm(int cnt) {
		
		if(cnt > M) {
			for(int i = 1; i <= M; i++) {
				sb.append(numbers[i] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			numbers[cnt] = i;
			perm(cnt+1);
		}
	}

}
