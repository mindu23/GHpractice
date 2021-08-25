package com.IM;
/**
 * 색종이의 크기는 10
 * 왼쪽 아래 좌표값만 주어진다.
 */
import java.util.Scanner;

public class Main_2567_색종이2 {

	static int[][] map;
	static int ans;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner("4\r\n" + 
				"3 7\r\n" + 
				"5 2\r\n" + 
				"15 7\r\n" + 
				"13 14");
		int K = sc.nextInt();
		map = new int[103][103];
		for(int k = 0; k < K; k++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			for(int i = r+1; i < r+11; i++) {
				for(int j = c+1; j < c+11; j++) {
					map[i][j] = 1;
				}
			}
		}
		
		//1을 찾는데 사방이 1이면 안쪽 
		for(int i = 1; i < 103; i++) {
			for(int j = 1; j < 103; j++) {
				if(map[i][j] == 0) continue;
				int k = 0;
				for(int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if(map[nr][nc] == 1) k++;
				}
				if(k != 4) ans += 4-k;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}

}
