package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2001_파리퇴치 {

	static int N, M, ans;
	static int[][] paris;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			paris = new int[N][N];
			ans = 0;
			
			for(int i = 0; i < N; i++) {
				String[] s2 = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					paris[i][j] = Integer.parseInt(s2[j]);
				}
			}//setting
			
			for(int i = 0; i <= N-M; i++) {
				for(int j = 0; j <= N-M; j++) {
					smash(i,j);
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
	private static void smash(int r, int c) {
		int sum = 0;
		for(int i=r; i < r+M; i++) {
			for(int j = c; j < c+M; j++) {
				sum += paris[i][j];
			}
		}
		ans = Math.max(ans, sum);
	}

}
