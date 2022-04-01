package com.Solutions.dp.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {

	static int N, K;
//	static int[][] D;
	static int[] D;
	static int[] W, V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		W = new int[N+1];
		V = new int[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		
//		D = new int[N+1][K+1];
//		for(int i = 1; i <= N; i++) {
//			for(int w = 1; w <= K; w++) {
//				if(w < W[i]) // 안들어감
//					D[i][w] = D[i-1][w];
//				else
//					D[i][w] = Math.max(D[i-1][w], D[i-1][w-W[i]]+V[i]);
//			}
//		}
//		
//		System.out.println(D[N][K]);
		
		D = new int[K+1];
		for(int i = 1; i <= N; i++) {
			for(int w = K; w >= W[i]; w--) {
				D[w] = Math.max(D[w], D[w-W[i]]+V[i]);
			}
		}
		System.out.println(D[K]);
	}

}
