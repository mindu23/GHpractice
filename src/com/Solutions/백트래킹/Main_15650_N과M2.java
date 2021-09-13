package com.Solutions.백트래킹;
/*
	1부터 N까지의 자연수 중에서 중복 없이 M개를 고른 수열
	고른 수열은 오름차순
	-> 조합?
 */

import java.util.Scanner;

public class Main_15650_N과M2 {

	static int N, M;
	static boolean[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		sel = new boolean[N+1];
		comp(1, 1);
		sc.close();
	}
	
	private static void comp(int cnt, int start) {
		
		if(cnt > M) {
			for(int i = 1; i <= N; i++) {
				if(sel[i])
					System.out.print(i + " ");
			}
			System.out.println();
			return ;
		}
		
		for(int i = start; i <= N; i++) {
			if(sel[i]) continue;
			sel[i] = true;
			comp(cnt+1, i+1);
			sel[i] = false;
		}
	}

}
