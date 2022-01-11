package com.ws;

import java.util.Scanner;

public class Main_9663_NQeen {

	
	static int N, ans;
	static int[] queens;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 한 row에 한개씩
		queens = new int[N];
		
		setQueen(0);
		
		System.out.println(ans);
		sc.close();

	}
	private static void setQueen(int n) {
		if(n == N) {
			ans++;
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			queens[n] = i;
			
			if(available(n)) {
				setQueen(n+1);
			}
		}
		
	}
	
//	0 1 0 0 1
//	0 0 1 0 2
//	0 0 0 1 3
	private static boolean available(int n) {
		for(int i = 0; i < n; i++) {
			// 같은 열 또는 대각선
			if(queens[n] == queens[i] || Math.abs(n-i) == Math.abs(queens[n]-queens[i])) return false;
		}
		return true;
	}

}
