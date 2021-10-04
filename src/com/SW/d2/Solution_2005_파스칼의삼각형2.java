package com.SW.d2;

import java.util.Scanner;

public class Solution_2005_파스칼의삼각형2 {

	static int[][] D;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			
			int N = sc.nextInt();
			D = new int[N+1][N];
			
			for(int i = 1; i <= N; i++) {
				D[i][0] = 1;
				for(int j = 1; j < i; j++) {
					D[i][j] = D[i-1][j-1]+D[i-1][j];
				}
			}
			
			System.out.print("#"+t);
			for(int i = 0; i <= N; i++) {
				for(int j = 0; j < i; j++)
					System.out.print(D[i][j]+" ");
				System.out.println();
			}
			sc.close();
		}
		

	}

}
