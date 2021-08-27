package com.IM;
/**
	이차원 배열 input에 차례대로 색종이를 붙여주자.
 */
import java.util.Scanner;

public class Main_10163_색종이 {

	static int[][] input;
	static int[] cnt;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		input = new int[1001][1001];
		for(int i = 1; i <= N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			int h = sc.nextInt();
			int w = sc.nextInt();
			
			painting(r, c, h, w, i);
		}
		
		cnt = new int[N+1];
		result();
		
		for(int i = 1; i <= N; i++) {
			System.out.println(cnt[i]);
		}

		sc.close();
	}
	
	private static void result() {
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) {
				cnt[input[i][j]]++;
			}
		}
	}
	
	private static void painting(int r, int c, int h, int w, int color) {
		for(int i = r; i < r+h; i++) {
			for(int j = c; j < c+w; j++) {
				input[i][j] = color;
			}
		}
	}

}
