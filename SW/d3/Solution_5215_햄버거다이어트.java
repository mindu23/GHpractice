package com.SW.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {

	static int N, L, max;
	static int[][] hamburger;
	static int[] T, K;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= Tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			hamburger = new int[N+1][L+1];
			T = new int[N+1];
			K = new int[N+1];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 1 ; i <= N; i++) {
				for(int k = 1; k <= L; k++) {
					if(k < K[i]) {
						//포함 풀가
						hamburger[i][k] = hamburger[i-1][k];
					}else {
						hamburger[i][k] = Math.max(hamburger[i-1][k-K[i]]+T[i], hamburger[i-1][k]);
					}
				}
			}
			
			System.out.println(hamburger[N][L]);
		}

	}

}
