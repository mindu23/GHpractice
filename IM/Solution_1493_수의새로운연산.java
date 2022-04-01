package com.IM;

import java.util.Scanner;

public class Solution_1493_수의새로운연산 {

	static int[] d = {1,-1}; // r c
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[300][300];
		int k = 1;
		for(int i = 1; i < 300; i++) {
			int nr = 1, nc = i;
			while(true) {
				arr[nr][nc] = k++;
				nr += d[0];
				nc += d[1];
				
				if(nr >= 300 || nc < 1) break;
			}
		}
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			System.out.print("#"+t+" ");
			findPos(p, q);
		}
		
		sc.close();
	}
	
	private static void findPos(int p, int q) {
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		
		outer: for(int i = 1; i < 300; i++) {
			for(int j = 1; j < 300; j++) {
				if(arr[i][j] == p) {
					x1 = i;
					y1 = j;
				}
				if(arr[i][j] == q) {
					x2 = i;
					y2 = j;
				}
				
				if(x1 != 0 && x2 != 0) break outer;
			}
		}
		
		System.out.println(arr[x1+x2][y1+y2]);
		
		
	}

}
