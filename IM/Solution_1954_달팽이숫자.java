package com.IM;

import java.util.Scanner;

public class Solution_1954_달팽이숫자 {

	static int N;
	static int[][] arr;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			
			int r = 0;
			int c = 0;
			int k = 0;
			int n = 1;
			arr[r][c] = n++;
			while(true) {
				int nr = r + dr[k%4];
				int nc = c + dc[k%4];
				if(nr >= N || nc >= N || nr < 0 || nc < 0 || arr[nr][nc] != 0) {
					r = nr - dr[k%4];
					c = nc - dc[k%4];
					k++;
				}else {
					arr[nr][nc] = n++;
					r = nr;
					c = nc;
				}
				
				if(n > N*N) break;
			}
			
			System.out.println("#"+t);
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
