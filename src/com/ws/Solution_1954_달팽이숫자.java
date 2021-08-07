package com.ws;
/**
	오른쪽으로 상승하다가 벽만나면 아래로 반복
 */
import java.util.Scanner;

public class Solution_1954_달팽이숫자 {

	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int nr = 0, nc = 0;
			int k = 1, m = 0;
			while(true) {
				if(k == 1) {
					snail[nr][nc] = k++; 
					continue;
				}
				if(k > N*N)
					break;
				nr += dr[m%4];
				nc += dc[m%4];
				
				if(nr >= N || nc >= N || nr < 0 || nc < 0 || snail[nr][nc] != 0) {
					nr -= dr[m%4];
					nc -= dc[m%4];
					m++;
					nr += dr[m%4];
					nc += dc[m%4];
					snail[nr][nc] = k++;
					continue;
				}
				snail[nr][nc] = k++;
			}
			System.out.println("#"+t);
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.printf(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}
