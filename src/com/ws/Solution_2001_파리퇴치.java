package com.ws;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution_2001_파리퇴치 {
	static int[][] paris;
	static int N, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("src//inputFile//input_2001.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			paris = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					paris[i][j] = sc.nextInt();
				}
			}
			
			int max = Integer.MIN_VALUE;
			int k = N - M + 1; //반복 횟수
			for(int i = 0; i < k; i++) {
				for(int j = 0; j < k; j++) {
					max = Math.max(smash(i, j),max);   
				}
			}
			System.out.println("#"+t+" "+max);
			
		}
		sc.close();
	}
	
	private static int smash(int i, int j) {
		int sum = 0;
		for(int a = i; a < i+M; a++) {
			for(int b = j; b < j+M; b++) {
				sum += paris[a][b];
			}
		}
		return sum;
	}

}
