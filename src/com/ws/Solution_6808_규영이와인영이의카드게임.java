package com.ws;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_6808_규영이와인영이의카드게임 {

	static int[] A, B, seq;
	static boolean[] sel, pick;
	static int ans, Awin, Alose;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
			Awin = 0;
			Alose = 0;
			A = new int[9];
			B = new int[9];
			seq = new int[9];
			pick = new boolean[19];
			for(int i = 0; i < 9; i++) {
				A[i] = sc.nextInt();
				pick[A[i]] = true;
			}
			int j = 0;
			for(int i = 1; i <= 18; i++) {
				if(pick[i] == false) B[j++] = i;
			}
			
			//순열
			sel = new boolean[9];
			perm(0);
			
			System.out.println("#"+t+" "+Awin+" "+Alose);
		}
		sc.close();
	}

	private static void perm(int cnt) {
		
		if(cnt == 9) {//다뽑았을때
			int a = 0;
			int b = 0;
			for(int i = 0; i < 9; i++) {
				int score = A[i]+seq[i];
				if(A[i] > seq[i]) a += score;
				else if(A[i] < seq[i]) b += score;
			}
			
			if(a > b) Awin++;
			else if(a < b) Alose++;
			return ;
		}
		
		for(int i = 0; i < 9; i++) {
			if(sel[i]) continue;
			sel[i] = true;
			seq[cnt] = B[i];
			perm(cnt+1);
			sel[i] = false;
		}
	}
}
