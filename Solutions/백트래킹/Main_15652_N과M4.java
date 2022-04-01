package com.Solutions.백트래킹;

import java.util.Scanner;

/*
	1뷰터 N까지 자연수 중에서 M개를 고른 수열
	중복가능
	비 내림차순 = 오름차순(중복가능)
 */
public class Main_15652_N과M4 {

	static int N, M;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		numbers = new int[M+1];
		comp(1,1);
		System.out.println(sb);
		sc.close();
	}

	private static void comp(int cnt, int start) {
		if(cnt > M) {
			for(int i = 1; i <= M; i++) {
				sb.append(numbers[i]+" ");
			}
			sb.append("\n");
			return ;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comp(cnt+1, i);
		}
	}
}
