package com.practice;

import java.util.Scanner;

public class DP3_KnapsackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = new int[N+1];
		int[] profits = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

//		2차원
//		int[][] D = new int[N+1][W+1];
//		
//		//i == 0 || w == 0이면 D[i][w] = 0
//		for(int i = 1; i <= N; i++) {
//			for(int w = 1; w <= W; w++) {
//				if(weights[i] > w) D[i][w] = D[i-1][w];
//				else D[i][w] = Math.max(D[i-1][w-weights[i]]+profits[i], D[i-1][w]);
//			}
//		}
//		
//		System.out.println(D[N][W]);
		
//		1차원
		int D[] = new int[W+1];
		for(int i = 1; i <= N; i++) {
			//weights[i]까지만 보자. 그 전까지는 변화 없다.
			for(int w = W; w >= weights[i]; w--) {
				D[w] = Math.max(D[w-weights[i]]+profits[i], D[w]);
			}
		}
		
		System.out.println(D[W]);
		sc.close();
	}

}
