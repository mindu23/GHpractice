package com.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;

/**
	비슷한 맛의 음식을 만들자
	N개의 식재료 중 각각 N/2개씩 나누어 요리를 한다.
	A와 B음식 맛의 차이가 최소가 되도록 재료를 배분하자.
	i와 j가 같이 요리하면 시너지 Sij가 발생한다.
	Sij의 정보가 주어지고 음식의 맛은 Sij의 합으로 정해진다.
 */
public class Solution_4012_요리사 {

	static int N, ans;
	static int[][] S;
	static int[] A, B;
	static boolean[] sel;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			
			ans = Integer.MAX_VALUE;
			A = new int[N/2];
			B = new int[N/2];
			for(int i = 0; i < N; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			sel = new boolean[N];
			//조합
			comp(0,0);
			System.out.println("#"+t+" "+ ans);
		}
	}
	
	private static void comp(int cnt, int start) {
		if(cnt == N/2) {
			int n = 0;
			for(int i = 0; i < N; i++) {
				if(!sel[i]) B[n++] = i; 
			}
			
			int tasteA = 0, tasteB = 0;
			for(int i = 0; i < N/2; i++) {
				for(int j = i+1; j < N/2; j++) {
					tasteA += S[A[i]][A[j]]+ S[A[j]][A[i]]; 
					tasteB += S[B[i]][B[j]]+ S[B[j]][B[i]]; 
				}
			}
			
			
			ans = Math.min(ans, Math.abs(tasteA-tasteB));
			return ;
		}
		
		for(int i = start; i < N; i++) {
			sel[i] = true;
			A[cnt] = i;
			comp(cnt+1, i+1);
			sel[i] = false;
		}
	}
}
