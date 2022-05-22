package com.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
	가운데 0,0부터 한칸씩 멀어지는 탐색하기
 */
public class Solution_2805_농작물수확하기 {
	static int profit;
	static int[][] farm;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			profit = 0;
			for(int i = 0; i < N; i++) {
				char[] c = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					farm[i][j] = c[j]-'0';
				}
			}
			
			int a = N/2;
			// 상단 삼각형
			for(int i = 0; i < N/2; i++) {
				for(int j = N/2 - i; j <= N/2 + i; j++) {
					profit += farm[i][j];
				}
			}
			
			// 하단 삼각형
			for(int i = N/2; i < N; i++) {
				for(int j = i - N/2  ; j < N+N/2-i; j++) {
					profit += farm[i][j];
				}
			}
			
			System.out.println("#"+t + " "+ profit);
		}
	}

}
