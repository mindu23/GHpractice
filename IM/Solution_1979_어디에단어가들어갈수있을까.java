package com.IM;

import java.util.Scanner;

public class Solution_1979_어디에단어가들어갈수있을까 {

	static int N, K, ans;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t<=T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			map = new int[N][N];
			ans = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}//setting
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 0) continue;
					findLen(i,j);
				}
			}
			System.out.println("#"+t+" "+ ans);
		}
		sc.close();
	}
	
	private static void findLen(int r, int c) {
		
		for(int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			int cnt = 0;
			if(i%2==0 && (r > 0 &&map[r-1][c] == 1)) continue;
			if(i%2!=0 && (c > 0 &&map[r][c-1] == 1)) continue;
			while(map[nr][nc] == 1) {
				cnt++;
				nr += dr[i];
				nc += dc[i];
				if(nr >= N || nc >= N || nr < 0 || nc < 0) break;
			}
			if(cnt == K) ans++;
		}
	}

}
