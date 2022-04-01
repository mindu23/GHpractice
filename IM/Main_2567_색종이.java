package com.IM;
/**
 * 색종이의 크기는 10
 * 왼쪽 아래 좌표값만 주어진다.
 */
import java.util.Scanner;

public class Main_2567_색종이 {

	static int[][] map;
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner("3\r\n" + 
				"3 7\r\n" + 
				"15 7\r\n" + 
				"5 2");
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
		
		for(int i = 0; i < 103; i++) {
			for(int j = 0; j < 103; j++) {
				if(map[i][j] == 1) ans++; 
			}
		}
		System.out.println(ans);
	}

}
