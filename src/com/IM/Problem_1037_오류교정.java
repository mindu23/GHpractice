package com.IM;

import java.util.Scanner;

public class Problem_1037_오류교정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] input = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				input[i][j] = sc.nextInt();
			}
		}//setting
		
		boolean isP = false;
		int r = 0, c = 0;
		//행검사
		for(int i = 1; i <= N; i++) {
			int p = 0;
			for(int j = 1; j <= N; j++) {
				if(input[i][j] == 1)p++;
			}
			if(p%2!=0) {
				if(isP) {
					System.out.println("Corrupt");
					System.exit(1);
				}
				isP = true;
				r = i;
			}
		}
		//열검사
		isP = false;
		for(int i = 1; i <= N; i++) {
			int p = 0;
			for(int j = 1; j <= N; j++) {
				if(input[j][i] == 1)p++;
			}
			if(p%2!=0) {
				if(isP) {
					System.out.println("Corrupt");
					System.exit(1);
				}
				isP = true;
				c = i;
			}
		}
		
		if(c == 0 && r == 0) {
			System.out.println("OK");
		}else {
			System.out.printf("Change bit (%d,%d)\n", r, c);
		}
		
		sc.close();
	}

}
