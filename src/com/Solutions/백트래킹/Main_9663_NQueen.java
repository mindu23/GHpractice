package com.Solutions.백트래킹;

import java.util.Scanner;

/*
	NxN 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
 */
public class Main_9663_NQueen {

	static int N, cnt;
	static int[] queen;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		queen = new int[N+1];
		
		setQueens(1);
		System.out.println(cnt);
		sc.close();
	}
	
	private static void setQueens(int n) {
		
		if(n > N) {
			cnt++;
			return ;
		}
		
		for(int i = 1; i <= N; i++) {
			queen[n] = i;
			
			if(isAvailable(n)) {
				setQueens(n+1);
			}
		}
	}

	private static boolean isAvailable(int cnt) {
		
		for(int i = 1; i < cnt; i++) {
			if(queen[cnt] == queen[i] || Math.abs(i-cnt) == Math.abs(queen[i]-queen[cnt]))
				return false;
		}
		return true;
	}

}
