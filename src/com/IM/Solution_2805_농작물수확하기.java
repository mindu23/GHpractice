package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2805_농작물수확하기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					map[i][j] = c[j]-'0';
				}
			}//setting
			
			int centerR = N/2;
			int centerC	= N/2;
			int half = N/2;
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(Math.abs(centerR - i) + Math.abs(centerC-j) <= half) {
						sum+= map[i][j];
					}
				}
			}
			System.out.println("#"+t+" "+sum);
		}
	}

}
