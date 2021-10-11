package com.SW.d3;

import java.util.Scanner;

public class Solution_2806_NQueen {

	static int N, ans;
	static int[][] map;
	static int[] queens;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			queens = new int[N]; // row마다 하나씩 놓기 col을 저장하자.
			ans = 0;
			setQueen(0);
			System.out.println("#"+t+" "+ ans);
		}
		sc.close();
	}
	
	private static void setQueen(int cnt) {
		if(cnt == N) {
			ans++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			queens[cnt] = i;
			
			if(check(cnt)) {
				
				setQueen(cnt+1);
			}
			
		}
	}

	private static boolean check(int cnt) {
		for(int j = 0; j < cnt; j++) {
			// 같은 열
			if(queens[cnt] == queens[j]) return false;
			// 대각선
			if(Math.abs(cnt-j) == Math.abs(queens[cnt]-queens[j])) return false ;
		}
		
		return true;
	}

}
