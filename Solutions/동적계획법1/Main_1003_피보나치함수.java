package com.Solutions.동적계획법1;

import java.util.Scanner;

public class Main_1003_피보나치함수 {

	static int call1, call0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int[][] d = new int[40+1][2];
			d[0][0] = 1;
			d[0][1] = 0;
			d[1][0] = 0;
			d[1][1] = 1;
			
			for(int i = 2; i <= N; i++) {
				d[i][0] = d[i-1][0]+d[i-2][0];
				d[i][1] = d[i-1][1]+d[i-2][1];
			}
			
			System.out.println(d[N][0]+" "+d[N][1]);
		}
		sc.close();
	}

}
