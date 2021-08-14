package com.ssafy.d2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
	NxN 크기의 농장 N은 항상 홀수
	정사각형 마름모 형태로 수확하기
	총 수익을 구해라
	
	1. tc만큼 반복
	2. N
	3. NxN
	4. 마름모 수익 구하기
 */
public class Solution_2805_농작물수확하기 {

	static int[][] farm;
	static int N, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_2805.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			farm = new int[N][N];
			ans = 0;
			
			for(int n = 0; n < N; n++) {
				char[] c = br.readLine().toCharArray();
				for(int i = 0; i < N; i++) {
					farm[n][i] = c[i]-'0';
				}
			}//setting
			
			 harvest();
			 System.out.println("#"+t + " "+ ans);
		}
	}
	
	private static void harvest() {
		int x = N/2, y = N/2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int dis = Math.abs(i-x)+Math.abs(j-y);
				if(dis <= N/2) ans += farm[i][j];
			}
		}
	}

}
