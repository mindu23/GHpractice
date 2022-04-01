package com.Solutions.백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {

	static int N, result;
	static int[][] S;
	static boolean[] sel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sel = new boolean[N];
		result = Integer.MAX_VALUE;
		//N개 중에서 N/2를 뽑아 -> 조합
		// Sij + Sji해서 두 그룹의 차의 최솟값
		comb(0,0);
		System.out.println(result);
	}
	private static void comb(int cnt, int start) {
		if(cnt == N/2) {
			int[] s = new int[N/2];
			int[] l = new int[N/2];
			int startT = 0, linkT = 0;
			int i = 0, j = 0;
			for(int k = 0; k < N; k++) {
				if(sel[k])
					s[i++] = k;
				else
					l[j++] = k;
			}
			
			for(int k = 0; k < N/2-1; k++) {
				for(int m = k+1; m < N/2; m++) {
					startT += S[s[k]][s[m]];
					startT += S[s[m]][s[k]];
					linkT += S[l[m]][l[k]];
					linkT += S[l[k]][l[m]];
				}
			}
			
			if(Math.abs(startT-linkT) < result)
				result = Math.abs(startT-linkT);

			return ;
		}
		
		for(int i = start; i < N; i++) {
			sel[i] = true;
			comb(cnt+1, i+1);
			sel[i] = false;
		}
	}
	
	

}
