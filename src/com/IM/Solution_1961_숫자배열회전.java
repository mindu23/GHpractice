package com.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1961_숫자배열회전 {

	static int N;
	static int[][] input;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			input = new int[N][N];
			for(int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					input[i][j] = Integer.parseInt(s[j]);
				}
			}//setting
			
			System.out.println("#"+t);
			for(int i = 0; i < N; i++) {
				print90(i);
				System.out.print(" ");
				print180(i);
				System.out.print(" ");
				print270(i);
				System.out.println();
			}
		}
	}
	private static void print90(int k) {
		for(int j = N-1; j >= 0; j--) {
			System.out.print(input[j][k]);
		}
	}
	private static void print180(int k) {
		for(int j = N-1; j >= 0; j--) {
			System.out.print(input[N-1-k][j]);
		}
	}
	private static void print270(int k) {
		for(int i = 0; i < N ; i++) {
			System.out.print(input[i][N-1-k]);
		}
	}
	
	

}
