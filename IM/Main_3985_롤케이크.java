package com.IM;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3985_롤케이크 {

	static int L, N, P, K;
	static int[] cake, cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		N = sc.nextInt();
		int maxLen = 0;
		int maxIdx = 0;
		
		cake = new int[L+1];
		for(int i = 1; i <= N; i++) {
			P = sc.nextInt(); //P
			K = sc.nextInt(); //K
			
			//가장 많이 받을 것 같은 사람
			if(maxLen < K-P) {
				maxLen = K-P;
				maxIdx = i;
			}
			
			for(int j = P; j <= K; j++) {
				if(cake[j] == 0) {
					cake[j] = i;
				}
			}
			
		}
		
//		System.out.println(Arrays.toString(cake));
		
		System.out.println(maxIdx);
		
		cnt = new int[N+1];
		for(int i = 1; i <= L; i++) {
			cnt[cake[i]]++;
		}
		
//		System.out.println(Arrays.toString(cnt));
//		
		int maxTake = 0;
		int idxTake = 0;
		for(int i = 1; i <= N; i++) {
			if(maxTake < cnt[i]) {
				maxTake = cnt[i];
				idxTake = i;
			}
		}
		
		System.out.println(idxTake);
		
	}

}
